package com.epam.tc.hw5.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserProperties {

    private static final String USER_PROPERTY = "src/test/resources/user.properties";
    protected String username;
    protected String password;
    protected String expectedUsername;

    public static String getUserData(String property) {
        Properties userProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(USER_PROPERTY)) {
            userProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userProperties.getProperty(property);
    }

    public static String getUsername() {
        return getUserData("siteusername");
    }

    public static String getPassword() {
        return getUserData("sitepassword");
    }

    public static String getExpectedUsername() {
        return getUserData("expectedusername");
    }
}
