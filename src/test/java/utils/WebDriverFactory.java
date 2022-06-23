package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public WebDriver driver;

    public WebDriver getWebDriver() {
        String url = "";
        try {
            url = GenericUtil.getPropertyValue("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver == null) {
            String browserType = "", executionMode = "";
            try {
                browserType = System.getProperty("browser") != null ? System.getProperty("browser") : GenericUtil.getPropertyValue("browserType");
                executionMode = System.getProperty("executionMode") != null ? System.getProperty("executionMode") : GenericUtil.getPropertyValue("executionMode");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (executionMode.equalsIgnoreCase("local")) driver = this.getLocalDriver(browserType);
            else {
                String hubURL = "";
                try {

                    String hubMachine = System.getProperty("hubMachine") != null ? System.getProperty("hubMachine") : GenericUtil.getPropertyValue("hubMachine");
                    String hubMachinePort = System.getProperty("hubMachinePort") != null ? System.getProperty("hubMachinePort") : GenericUtil.getPropertyValue("hubMachinePort");
                    hubURL = "http://" + hubMachine + ":" + hubMachinePort + "/wd/hub";
                } catch (IOException e) {
                    e.printStackTrace();
                }
                driver = this.getRemoteDriver(browserType, hubURL);

            }
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public WebDriver getLocalDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriver getRemoteDriver(String browserType, String hubURL) {
        //MutableCapabilities mutableCapabilities;
        DesiredCapabilities mutableCapabilities= new DesiredCapabilities();
        mutableCapabilities.setBrowserName(browserType);
        try {
            driver = new RemoteWebDriver(new URL(hubURL), mutableCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
