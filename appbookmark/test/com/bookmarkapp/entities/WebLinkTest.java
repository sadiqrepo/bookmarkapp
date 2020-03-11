package com.bookmarkapp.entities;

import com.bookmarkapp.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sadiq on 10/03/20.
 */
public class WebLinkTest {

    @Test
    public void testIsKidFriendlyEligible() throws Exception {

        // Test 1 : porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","http://www" +
                ".javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");

        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

        // Test 2: porn in title -- false

        webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming porn, Part 2","http://www" +
                ".javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

        // Test 3: adult in host -- false

        webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","http://www" +
                ".javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

        // Test 4: adult in url, but not in host part -- true

        webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","http://www" +
                ".javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue("For adult in url but not host part - isKidFriendlyEligible() must return true",
                isKidFriendlyEligible);

        // Test 5: adult in title only -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000,"Taming adult, Part 2","http://www" +
                ".javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue("For adult in title only - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
    }
}