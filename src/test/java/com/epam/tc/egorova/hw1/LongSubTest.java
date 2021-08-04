package com.epam.tc.egorova.hw1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class LongSubTest extends CalculatorBaseTests {

    @Test(dataProviderClass = LongSubTestDataProvider.class,
          dataProvider = "longSubTestDataProvider", groups = {"sumsub"})
    public void testLongSub(long a, long b, long expectedResult) {
        long actualResult = calculator.sub(a, b);
        AssertionsForClassTypes.assertThat(actualResult)
                               .as("Unexpected subtraction result")
                               .isEqualTo(expectedResult);
    }
}
