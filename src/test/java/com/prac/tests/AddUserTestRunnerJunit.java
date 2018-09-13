package com.prac.tests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/prac/features"},glue = "com.prac.steps")
public class AddUserTestRunnerJunit {

}
