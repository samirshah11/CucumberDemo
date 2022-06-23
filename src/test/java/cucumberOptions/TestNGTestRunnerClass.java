package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features", glue = {"stepDefinitions"}, monochrome = true,
        plugin={"html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},tags = "@Regression")
public class TestNGTestRunnerClass extends AbstractTestNGCucumberTests {

}
