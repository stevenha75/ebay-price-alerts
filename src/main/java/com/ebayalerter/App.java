package com.ebayalerter;

import java.util.Timer;
import java.util.TimerTask;

public class App {
    // Default is set to 10 minutes
    private static int refreshTime = 600;
    private static Timer timer;

    public static void main(String[] args) {
        new gui();
        startAutoRefresh();
    }

    public static int getRefreshTime(){
        return refreshTime;
    }

    public static void setRefreshTime(int newRefreshTime){
        refreshTime = newRefreshTime;
    }

    public static void startAutoRefresh(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                gui.refreshTable();
                System.out.println("Table refreshed!");
            }
        }, 0, refreshTime * 1000);
    }

    public static void stopAutoRefresh() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
