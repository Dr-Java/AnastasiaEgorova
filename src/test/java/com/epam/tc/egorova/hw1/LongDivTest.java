package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongDivTest extends CalculatorBaseTests {

    @Test(dataProvider = "longDivTestDataProvider", groups = {"multdiv"})
    public void testLongDiv(long a, long b, long expectedResult) {
        long actualResult = calculator.div(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected division result")
                               .isEqualTo(expectedResult);
    }
 
    @DataProvider(name = "longDivTestDataProvider")
    public Object[][] longDivTestDataProvider() {
        return new Object[][]{
            {60, 2, 30},
            {-10, 5, -2},
            {5, 20, 0},
            {-5, -5, 1}
        };
    }
}
