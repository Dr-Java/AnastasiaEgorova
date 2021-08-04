package com.epam.tc.egorova.hw1;

import org.testng.annotations.DataProvider;

public class LongSumTestDataProvider {

    @DataProvider(name = "longSumTestDataProvider")
    public static Object[][] longSumTestDataProvider() {
        return new Object[][] {
            {10, 20, 30},
            {2, 2, 4},
            {-150, 150, 0},
            {0, -200, -200}
        };
    }
}
