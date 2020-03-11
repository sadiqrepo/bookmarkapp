package com.bookmarkapp.entities;

import com.bookmarkapp.constants.BookGenre;
import com.bookmarkapp.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sadiq on 11/03/20.
 */
public class BookTest {

    @Test
    public void testIsKidFriendlyEligible() throws Exception {

        // Test 1 : Return false if Philosophy genre

        Book book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",
                new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);

        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

        assertFalse("For Philosophy genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);



        // Test 2: Return false if Self help genre

        book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",
                new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);

        isKidFriendlyEligible = book.isKidFriendlyEligible();

        assertFalse("For Philosophy genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);

    }
}