package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class WebDriverFactory {

    public WebDriver driver;

    public WebDriver getWebDriver() {
        String url="";
        try {
           url= GenericUtil.getPropertyValue("url");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (driver==null) {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
        }
        return driver;
    }
}
