package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hook {
    public TestContextSetup contextSetup;

    public Hook(TestContextSetup contextSetup) {
        this.contextSetup = contextSetup;
    }

    @After
    public void closeBrowser() {
        contextSetup.driverFactory.getWebDriver().quit();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
       WebDriver driver = contextSetup.driverFactory.getWebDriver();
       if(scenario.isFailed()){
           File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent,"image/png","image");
       }

    }
}
