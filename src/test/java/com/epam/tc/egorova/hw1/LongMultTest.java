package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongMultTest extends CalculatorBaseTests {

    @Test(dataProvider = "longMultTestDataProvider", groups = {"multdiv"})
    public void testLongMult(long a, long b, long expectedResult) {
        long actualResult = calculator.mult(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected multiplication result")
                               .isEqualTo(expectedResult);
    }

    @DataProvider(name = "longMultTestDataProvider")
    public Object[][] longMultTestDataProvider() {
        return new Object[][]{
            {4, 6, 24},
            {5, 0, 0},
            {-20, 4, -80},
            {-3, -6, 18}
        };
    }
}

