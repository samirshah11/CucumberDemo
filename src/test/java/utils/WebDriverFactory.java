package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

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
            String browserType="";
            try {
                browserType = System.getProperty("browser")!=null ? System.getProperty("browser"): GenericUtil.getPropertyValue("browserType");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (browserType.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if (browserType.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            else
            {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }
}
