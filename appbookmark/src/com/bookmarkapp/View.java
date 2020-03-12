package com.bookmarkapp;

import com.bookmarkapp.constants.KidFriendlyStatus;
import com.bookmarkapp.constants.UserType;
import com.bookmarkapp.controllers.BookmarkController;
import com.bookmarkapp.entities.Book;
import com.bookmarkapp.entities.Bookmark;
import com.bookmarkapp.entities.User;
import com.bookmarkapp.partner.Shareable;

/**
 * Created by sadiq on 10/03/20.
 */
public class View {

   /* public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
            BookmarkController.getInstance().saveUserBookmark(user, bookmark);

            System.out.println(bookmark);
        }
    }*/

    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n" + user.getEmail() + " is browsing items ...");
        int bookmarkCount = 0;

        for(Bookmark[] bookmarkList : bookmarks){
            for(Bookmark bookmark : bookmarkList){
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT){
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if(isBookmarked){
                        bookmarkCount++;

                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);

                        System.out.println("New item Bookmarked ... " +bookmark);
                    }
                }


                if(user.getUserType().equals(UserType.EDITOR)
                        || user.getUserType().equals(UserType.CHIEF_EDITOR)){

                    // Mark as kid - friendly
                    if(bookmark.isKidFriendlyEligible()
                            && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                           BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus,bookmark);

                        }
                    }


                    // Sharing the Bookmark with third party!!

                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookmark instanceof Shareable){
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user, bookmark);
                        }
                    }
                }


                }
        }
    }

    // TODO: Below methods simulate user input. After IO, we take input via console.
    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false ;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        return Math.random()< 0.4 ? KidFriendlyStatus.APPROVED:
                (Math.random() >=0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED :
                KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }


}
