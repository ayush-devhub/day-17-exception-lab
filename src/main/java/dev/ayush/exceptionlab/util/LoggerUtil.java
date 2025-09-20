package dev.ayush.exceptionlab.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger("BankLogger");

    static {
        try {
            FileHandler handler = new FileHandler("logs/app.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logException(Exception e) {
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
}