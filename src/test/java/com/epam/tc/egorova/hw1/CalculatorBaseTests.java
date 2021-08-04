package com.epam.tc.egorova.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;


public class CalculatorBaseTests {

    Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void prepareCalculator() {
        calculator = new Calculator();
    }
}
