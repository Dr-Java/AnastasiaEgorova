package com.epam.tc.hw7jdi.entities;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User extends DataClass<User> {

    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String username;
    private String password;
    private String fullName;

}
