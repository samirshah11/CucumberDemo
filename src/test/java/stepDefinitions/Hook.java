package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hook {
    public TestContextSetup contextSetup;

    public Hook(TestContextSetup contextSetup) {
        this.contextSetup = contextSetup;
    }

    @After
    public void closeBrowser() {
        contextSetup.driverFactory.getWebDriver().quit();
    }
}
