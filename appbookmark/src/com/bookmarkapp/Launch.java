package com.bookmarkapp;

import com.bookmarkapp.entities.User;
import com.bookmarkapp.entities.Bookmark;
import com.bookmarkapp.managers.BookmarkManager;
import com.bookmarkapp.managers.UserManager;

/**
 * Created by sadiq on 05/03/20.
 */
public class Launch {

    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData(){
        System.out.println("1. Loading data ...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("Printing data . . . ");
        printUserData();
        printBookmarkData();
    }

    private static void printBookmarkData() {
        for(Bookmark[] bookmarkList : bookmarks){
            for (Bookmark bookmark : bookmarkList){
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {

        for(User user : users){
            System.out.println(user);
        }
    }

    private static void startBookmarking() {

        System.out.println("\n2. Bookmarking ... ");
        for(User user : users){
            View.bookmark(user, bookmarks);
        }
    }


    public static void main(String[] args){
        loadData();
        startBookmarking();
    }


}

