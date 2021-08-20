package com.epam.tc.hw5.entityproperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserProperties {

    private static final String USER_PROPERTY = "src/test/resources/user.properties";

    public static Map<String, String> getUserData() {
        Map<String, String> userData = new HashMap<>();
        Properties userProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(USER_PROPERTY)) {
            userProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : userProperties.stringPropertyNames()) {
            String value = userProperties.getProperty(key);
            userData.put(key, String.valueOf(value));
        }
        return userData;
    }

    public static String getUsername() {
        return getUserData().get("siteusername");
    }

    public static String getPassword() {
        return getUserData().get("sitepassword");
    }

    public static String getExpectedUsername() {
        return getUserData().get("expectedusername");
    }
}
