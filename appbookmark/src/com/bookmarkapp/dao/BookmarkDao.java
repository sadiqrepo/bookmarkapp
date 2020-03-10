package com.bookmarkapp.dao;

import com.bookmarkapp.DataStore;
import com.bookmarkapp.entities.Bookmark;
import com.bookmarkapp.entities.UserBookmark;

/**
 * Created by sadiq on 05/03/20.
 */
public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark){
        DataStore.add(userBookmark);
    }
}
