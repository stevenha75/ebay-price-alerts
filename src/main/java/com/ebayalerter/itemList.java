package com.ebayalerter;

import java.util.ArrayList;

public class itemList {
    private static ArrayList<item> itemList = new ArrayList<>();

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void refresh() {
        // Updates the prices
        for (int i = 0; i < itemList.size(); i++) {
            item tempItem = itemList.get(i);
            tempItem.scrape();
            itemList.set(i, tempItem);

            // Compares current price w/ limit and sends notification as needed
            if (tempItem.checkPrice()) {
                // Sends a notification & removes item from the list
                notification_handler
                        .sendDiscordNotification(":exclamation:The following product's price is <= to the limit: "
                                + itemList.get(i).getLink());
                removeItem(i + 1);
            }

        }
    }

    public static ArrayList<String[]> buildItemTable() {
        // Returns a 2D array in the same format as the following:
        // String[] header = {"name", "price", "price limit"};
        // String[][] tempData = {{"Shoes", "$50", "$25"}};
        ArrayList<String[]> finalArr = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            item tempItem = itemList.get(i);
            // Utilizing concatenation w/ an empty string to convert doubles into Strings
            String[] tempArr = { tempItem.getName(), "" + tempItem.getPrice(), "" + tempItem.getLimit() };
            finalArr.add(tempArr);

        }
        return finalArr;
    }

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void addItem(String link, double limit) {
        item tempItem = new item(link, limit);
        tempItem.scrape();
        itemList.add(tempItem);
    }

    public static void addItem(item Item) {
        itemList.add(Item);
    }

    // When this is called, the table needs to be rebuilt with buildItemTable()
    public static void removeItem(Integer index) {
        itemList.remove(index - 1);
    }

    // Table needs to be rebuilt
    public static void modifyLimit(int index, double newLimit) {
        item tempItem = itemList.get(index - 1);
        tempItem.setLimit(newLimit);
        itemList.set(index - 1, tempItem);
    }
}
