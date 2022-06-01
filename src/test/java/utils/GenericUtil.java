package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class GenericUtil {
    public WebDriver driver;
    public GenericUtil(WebDriver driver){
        this.driver=driver;
    }

    public void switchToWindow() {
        Set<String> windows = this.driver.getWindowHandles();
        String parentWindow = this.driver.getWindowHandle();
        String childWindow = null;
        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()) {
            childWindow = itr.next();
            if (!childWindow.equalsIgnoreCase(parentWindow))
                break;
        }
        this.driver.switchTo().window(childWindow);
    }

    public static String getPropertyValue(String key) throws IOException {
        FileInputStream fileInputStream= new FileInputStream("src/test/resources/globalconfig.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.getProperty(key));
       return properties.getProperty("url");
    }
}
