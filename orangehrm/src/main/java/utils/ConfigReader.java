package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties NOT found in classpath!");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("baseUrl"); // 🔴 IMPORTANT
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}