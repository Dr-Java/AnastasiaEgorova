package com.epam.tc.egorova.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com/epam/tc/egorova/hw5/cucumber/first.feature",
    "src/test/resources/com/epam/tc/egorova/hw5/cucumber/second.feature",
    "src/test/resources/com/epam/tc/egorova/hw5/cucumber/third.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
