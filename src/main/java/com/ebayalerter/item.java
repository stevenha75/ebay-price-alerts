package com.ebayalerter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class item {
    private String name;
    private String link;
    private double price;
    private double limit; // If price is less than or equal to limit -> send notification

    public item(String link, double limit){
        this.link = link;
        this.limit = limit;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public double getLimit(){
        return this.limit;
    }

    public String getLink(){
        return this.link;
    }

    public boolean checkPrice(){
        return price <= limit;
    }

    public void scrape(){
        try {
            Document doc = Jsoup.connect(this.link).get();
            Elements items = doc.select("div#LeftSummaryPanel");

            for (Element item : items) {
                this.name = item.select("h1.x-item-title__mainTitle span.ux-textspans.ux-textspans--BOLD").text();
                String tempPrice = item.select("span[itemprop=price]").text();
                this.price = Double.parseDouble(tempPrice.replaceAll("[^0-9\\.]+", ""));
            }
    
        } catch (IOException e) {
            this.name = "UNABLE TO CONNECT";
            this.price = 0;
        }

    }
}
