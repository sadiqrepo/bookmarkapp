package com.bookmarkapp.dao;

import com.bookmarkapp.DataStore;
import com.bookmarkapp.entities.User;

/**
 * Created by sadiq on 05/03/20.
 */
public class UserDao {

    public User[] getUsers(){
        return DataStore.getUsers();
    }
}