package com.prac.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/com/prac/features"},format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = "com.prac.steps")
public class AddUserTestRunnerTestNG extends AbstractTestNGCucumberTests {

}
