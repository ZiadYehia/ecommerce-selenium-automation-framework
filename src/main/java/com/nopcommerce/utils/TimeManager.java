package com.nopcommerce.utils;

public class TimeManager {
    //screenshots - logs - reports

    /**
     * Get current timestamp in format yyyy-MM-dd_hh-mm-ss
     * @return String
     */
    public static String getTimestamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new java.util.Date());
    }

    // unique timestamp for each data
    /**
     * Get current timestamp in numbers only
     * @return String
     */
    public static String getSimpleTimestamp() {
        //return a timestamp in numbers only
        return Long.toString(System.currentTimeMillis());
    }

}
