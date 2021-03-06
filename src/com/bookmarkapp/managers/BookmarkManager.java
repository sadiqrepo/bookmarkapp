package com.bookmarkapp.managers;

import com.bookmarkapp.dao.BookmarkDao;
import com.bookmarkapp.entities.Book;
import com.bookmarkapp.entities.Bookmark;
import com.bookmarkapp.entities.Movie;
import com.bookmarkapp.entities.WebLink;

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
}

