package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class LongSumTest extends CalculatorBaseTests {

    @Test(dataProviderClass = LongSumTestDataProvider.class,
          dataProvider = "longSumTestDataProvider", groups = {"sumsub"})
    public void testLongSum(long a, long b, long expectedResult) {
        long actualResult = calculator.sum(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected summation result")
                               .isEqualTo(expectedResult);
    }
}
