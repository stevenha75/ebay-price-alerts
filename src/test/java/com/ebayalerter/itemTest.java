/*
 * To do:
 * Go through each class and create tests after finishing V1.0
 */

package com.ebayalerter;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for item class.
 */
public class itemTest 
{
    @Test
    public void testCheckPrice_False()
    {
        item tempItem = new item("tempItem", "tempLink", 100, 90);
        Boolean tempBool = tempItem.checkPrice();
        assertEquals(false, tempBool);

    }

    @Test
    public void testCheckPrice_True(){
        item tempItem = new item("tempItem", "tempLink", 80, 90);
        Boolean tempBool = tempItem.checkPrice();
        assertEquals(true, tempBool);
    }
}
