package com.bookmarkapp.entities;

import com.bookmarkapp.constants.MovieGenre;
import com.bookmarkapp.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sadiq on 11/03/20.
 */
public class MovieTest {

    @Test
    public void testIsKidFriendlyEligible() throws Exception {

        // Test 1 : Return false if Horror Genre

        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
                new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"},
                MovieGenre.HORROR, 8.5);

        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

        assertFalse("For Horror Genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);


        // Test 2 : Return false if Thrillers Genre

        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
                new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"},
                MovieGenre.THRILLERS, 8.5);

        isKidFriendlyEligible = movie.isKidFriendlyEligible();

        assertFalse("For Thrillers Genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);

    }

}