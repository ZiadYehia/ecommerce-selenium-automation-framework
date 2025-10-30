package com.nopcommerce.utils.logs;

import org.apache.logging.log4j.Logger;

public class LogsManager {

    //private static Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    public static Logger logger() {
        return org.apache.logging.log4j.LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    //this will print info as ("errorMsg"+" "+e.getMessage()) -> info("errorMsg", e.getMessage());
    public static void info(String... message) {
        logger().info(String.join(" ", message));
    }

    public static void error(String... message) {
        logger().error(String.join(" ", message));
    }

    public static void debug(String... message) {
        logger().debug(String.join(" ", message));
    }

    public static void warn(String... message) {
        logger().warn(String.join(" ", message));
    }

    public static void trace(String... message) {
        logger().trace(String.join(" ", message));
    }

    public static void fatal(String... message) {
        logger().fatal(String.join(" ", message));
    }

}
