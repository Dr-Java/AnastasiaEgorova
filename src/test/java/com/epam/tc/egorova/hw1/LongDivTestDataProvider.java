package com.epam.tc.egorova.hw1;

import org.testng.annotations.DataProvider;

public class LongDivTestDataProvider {

    @DataProvider(name = "longDivTestDataProvider")
    public static Object[][] longDivTestDataProvider() {
        return new Object[][]{
            {60, 2, 30},
            {-10, 5, -2},
            {5, 20, 0},
            {-5, -5, 1}
        };
    }
}
