package com.epam.tc.hw5.entityutils;

import com.epam.tc.hw5.entity.User;
import com.epam.tc.hw5.entityproperty.UserProperties;

public class UserBuilder {

    public static User returnNewUser() {
        return new User(UserProperties.getUsername(), UserProperties.getPassword());
    }
}
