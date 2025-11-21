package com.mycompany.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            prop.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) { return prop.getProperty(key); }
    public static int getInt(String key) { return Integer.parseInt(prop.getProperty(key)); }
    public static boolean getBoolean(String key) { return Boolean.parseBoolean(prop.getProperty(key)); }
}
