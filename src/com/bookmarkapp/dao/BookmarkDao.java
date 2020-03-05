package com.bookmarkapp.dao;

import com.bookmarkapp.DataStore;
import com.bookmarkapp.entities.Bookmark;

/**
 * Created by sadiq on 05/03/20.
 */
public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
}
