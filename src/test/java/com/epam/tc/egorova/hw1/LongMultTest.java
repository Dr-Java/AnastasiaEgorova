package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class LongMultTest extends CalculatorBaseTests {

    @Test(dataProviderClass = LongMultTestDataProvider.class,
          dataProvider = "longMultTestDataProvider", groups = {"multdiv"})
    public void testLongMult(long a, long b, long expectedResult) {
        long actualResult = calculator.mult(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected multiplication result")
                               .isEqualTo(expectedResult);
    }
}

