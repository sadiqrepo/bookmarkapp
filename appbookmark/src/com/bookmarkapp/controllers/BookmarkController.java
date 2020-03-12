package com.bookmarkapp.controllers;

import com.bookmarkapp.entities.Bookmark;
import com.bookmarkapp.entities.User;
import com.bookmarkapp.managers.BookmarkManager;

/**
 * Created by sadiq on 10/03/20.
 */
public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController(){}
    public static BookmarkController getInstance(){
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus,bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }
}
