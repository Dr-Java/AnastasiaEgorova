package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongSubTest extends CalculatorBaseTests {

    @Test(dataProvider = "longSubTestDataProvider", groups = {"default"})
    public void testLongSub(long a, long b, long expectedResult) {
        long actualResult = calculator.sub(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected subtraction result")
                               .isEqualTo(expectedResult);
    }

    @DataProvider(name = "longSubTestDataProvider")
    public Object[][] longSubTestDataProvider() {
        return new Object[][] {
            {50, 26, 24},
            {-100, -50, -50},
            {-150, 150, -300},
            {400, 400, 0}
        };
    }
}
