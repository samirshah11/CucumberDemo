package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPO {

    private final By searchEd = By.xpath("//input[@class='search-keyword']");
    private final By searchResult = By.cssSelector("h4.product-name");
    private final By offersLnk = By.xpath("//*[text()='Top Deals']");
    public WebDriver driver;

    public LandingPO(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String searchKeyword) {
        this.driver.findElement(searchEd).sendKeys(searchKeyword);
    }

    public String getSearchResult() {
        String productName = this.driver.findElement(searchResult).getText().split("-")[0].trim();
        return productName;
    }

    public void clickOnDealsLnk() {
        this.driver.findElement(offersLnk).click();
    }


}
