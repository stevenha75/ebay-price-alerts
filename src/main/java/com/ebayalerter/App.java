package com.ebayalerter;

public class App 
{
    public static void main( String[] args )
    {
        item funkoTest = new item("https://www.ebay.com/itm/125793875856?_trkparms=amclksrc%3DITM%26aid%3D777008%26algo%3DPERSONAL.TOPIC%26ao%3D1%26asc%3D20221102144100%26meid%3D5e4e9e2530a8411790ea6276d76f05d8%26pid%3D101259%26rk%3D1%26rkt%3D1%26itm%3D125793875856%26pmt%3D1%26noa%3D1%26pg%3D2380057%26algv%3DPersonalizedTopicsV2WithWatchlistFeaturesAndTopicMLR%26brand%3DFunko&_trksid=p2380057.c101259.m47269&_trkparms=pageci%3A603f3b03-c9df-11ed-b483-d26a5386da31%7Cparentrq%3A112252481870ab9718bd2a6cfff8ea85%7Ciid%3A2", 10);
        funkoTest.scrape();
        System.out.println(funkoTest.getPrice());
    }
}
