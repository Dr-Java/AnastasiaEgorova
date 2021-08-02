package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongSumTest extends CalculatorBaseTests {

    @Test(dataProvider = "longSumTestDataProvider", groups = {"default"})
    public void testLongSum(long a, long b, long expectedResult) {
        long actualResult = calculator.sum(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected summation result")
                               .isEqualTo(expectedResult);
    }

    @DataProvider(name = "longSumTestDataProvider")
    public Object[][] longSumTestDataProvider() {
        return new Object[][]{
            {10, 20, 30},
            {2, 2, 4},
            {-150, 150, 0},
            {0, -200, -200}
        };
    }
}
