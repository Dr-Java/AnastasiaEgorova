package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class LongDivTest extends CalculatorBaseTests {

    @Test(dataProviderClass = LongDivTestDataProvider.class,
          dataProvider = "longDivTestDataProvider", groups = {"multdiv"})
    public void testLongDiv(long a, long b, long expectedResult) {
        long actualResult = calculator.div(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected division result")
                               .isEqualTo(expectedResult);
    }
}
