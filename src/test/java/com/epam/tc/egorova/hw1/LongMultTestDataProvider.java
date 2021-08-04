package com.epam.tc.egorova.hw1;

import org.testng.annotations.DataProvider;

public class LongMultTestDataProvider {

    @DataProvider(name = "longMultTestDataProvider")
    public static Object[][] longMultTestDataProvider() {
        return new Object[][]{
            {4, 6, 24},
            {5, 0, 0},
            {-20, 4, -80},
            {-3, -6, 18}
        };
    }
}
