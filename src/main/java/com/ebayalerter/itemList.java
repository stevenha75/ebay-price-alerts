/*
 * To do:
 * - Fix refresh implementation (need to utilize check price and send the notification accordingly)
 * - Add a way to load in multiple items using file path?
 * - Find a way to indefinitely run refresh on a timer & implement a way to modify the timer
 */

package com.ebayalerter;

import java.util.ArrayList;

public class itemList {
    private static ArrayList<item> itemList = new ArrayList<>();

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void refresh(){
        for (int i = 0; i < itemList.size(); i++){
            item tempItem = itemList.get(i);
            tempItem.scrape();
            itemList.set(i, tempItem);
        }
    }
    
    public static ArrayList<String[]> buildItemTable(){
        // Returns a 2D array in the same format as the following:
        // String[] header = {"name", "price", "price limit"};
        // String[][] tempData = {{"Shoes", "$50", "$25"}};
        ArrayList<String[]> finalArr = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++){
            item tempItem = itemList.get(i);
            // Utilizing concatenation w/ an empty string to convert doubles into Strings
            String[] tempArr = {tempItem.getName(), "" + tempItem.getPrice(), "" + tempItem.getLimit()};
            finalArr.add(tempArr);

        }
        return finalArr;
    }

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void addItem(String link, double limit){
        item tempItem = new item(link, limit);
        tempItem.scrape();
        itemList.add(tempItem);
    }

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void removeItem(int index){
        itemList.remove(index - 1);
    }

    // Table needs to be rebuilt
    public static void modifyLimit(int index, double newLimit){
        item tempItem = itemList.get(index - 1);
        tempItem.setLimit(newLimit);
        itemList.set(index - 1, tempItem);
    }
}
