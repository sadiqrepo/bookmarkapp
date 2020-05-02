package com.bookmarkapp.managers;

import com.bookmarkapp.dao.BookmarkDao;
import com.bookmarkapp.entities.*;
import com.bookmarkapp.util.HttpConnect;
import com.bookmarkapp.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Created by sadiq on 05/03/20.
 */
public class BookmarkManager {

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao bookmarkDao = new BookmarkDao();

    private BookmarkManager() {}

    public static BookmarkManager getInstance() {
        return instance;
    }

    public WebLink createWebLink(long id, String title, String url, String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }

    public Book createBook(
            long id,
            String title,
            int publicationYear,
            String publisher,
            String[] authors,
            String genre,
            double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;
    }

    public Movie createMovie(
            long id,
            String title,
            String profileUrl,
            int releaseYear,
            String[] cast,
            String[] directors,
            String genre,
            double imdbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);

        return movie;
    }

    public Bookmark[][] getBookmarks(){
        return bookmarkDao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        if( bookmark instanceof WebLink){
            try{
                String url = ((WebLink)bookmark).getUrl();
                if(!url.endsWith(".pdf")){
                    String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
                    if(webpage != null){
                        IOUtil.write(webpage,bookmark.getId());
                    }
                }
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        bookmarkDao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid-friendly status: "+kidFriendlyStatus + ", Marked by: "+user.getEmail()+", "+bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);

        System.out.println("\nData to be shared: ");
        if (bookmark instanceof Book) {
            System.out.println(((Book) bookmark).getItemData());
            System.out.println();
        } else if(bookmark instanceof WebLink){
            System.out.println(((WebLink) bookmark).getItemData());
            System.out.println();
        }
    }
}

