package com.epam.tc.egorova.hw1;

import org.testng.annotations.DataProvider;

public class LongSubTestDataProvider {

    @DataProvider(name = "longSubTestDataProvider")
    public static Object[][] longSubTestDataProvider() {
        return new Object[][] {
            {50, 26, 24},
            {-100, -50, -50},
            {-150, 150, -300},
            {400, 400, 0}
        };
    }
}
