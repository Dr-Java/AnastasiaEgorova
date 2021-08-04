package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class LongDivByZeroTest extends CalculatorBaseTests {

    @Test(dataProviderClass = LongDivByZeroTestDataProvider.class,
          dataProvider = "longDivByZeroTestDataProvider",
          expectedExceptions = NumberFormatException.class,
          groups = {"multdiv"})
    public void testDivByZero(long a, long b, NumberFormatException expectedResult) {
        long actualResult = calculator.div(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Attempt to divide by zero")
                               .isEqualTo(expectedResult);
    }
}
