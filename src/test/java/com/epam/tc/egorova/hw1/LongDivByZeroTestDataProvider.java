package com.epam.tc.egorova.hw1;

import org.testng.annotations.DataProvider;

public class LongDivByZeroTestDataProvider {

    @DataProvider(name = "longDivByZeroTestDataProvider")
    public static Object[][] longDivByZeroTestDataProvider() {
        return new Object[][] {
            {10, 0, new NumberFormatException()},
            {-50, 0, new NumberFormatException()},
            {0, 0, new NumberFormatException()}
        };
    }
}
