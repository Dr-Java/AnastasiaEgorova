package com.epam.tc.egorova.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com/epam/tc/egorova/hw5/cucumber/second.feature"})
public class RunAcceptanceTestTwo extends AbstractTestNGCucumberTests {
}
