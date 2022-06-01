package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver;
    public String productName, shortName;
    public PageObjectManager pageObjectManager;
    public WebDriverFactory driverFactory;
    public GenericUtil util;

    public TestContextSetup(){
        driverFactory = new WebDriverFactory();
        pageObjectManager=new PageObjectManager(driverFactory.getWebDriver());
        util=new GenericUtil(driverFactory.getWebDriver());
    }
}
