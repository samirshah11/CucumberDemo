package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPO {

    private final By searchEd = By.cssSelector("div #search-field");
    private final By searchResult = By.cssSelector("tr td:nth-child(1)");
    private final WebDriver driver;
    public OffersPO(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String searchKeyword) {
        this.driver.findElement(searchEd).sendKeys(searchKeyword);
    }

    public String getSearchResult() {
        String productName = this.driver.findElement(searchResult).getText();
        return productName;
    }
}
