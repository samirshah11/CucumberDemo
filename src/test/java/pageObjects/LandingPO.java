package pageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ProductInformation;

import java.util.ArrayList;
import java.util.List;

public class LandingPO {

    private final By searchEd = By.xpath("//input[@class='search-keyword']");
    private final By searchResult = By.cssSelector("h4.product-name");
    private final By offersLnk = By.xpath("//*[text()='Top Deals']");
    private final By incrementLnk = By.cssSelector("div .increment");
    public final By addToCartBtn = By.xpath("//*[text()='ADD TO CART']");
    public final By cartIconLink= By.xpath("//*[@alt='Cart']");
    public final By proceedToCartPage=By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public WebDriver driver;

    public LandingPO(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String searchKeyword) {
        this.driver.findElement(searchEd).clear();
        this.driver.findElement(searchEd).sendKeys(searchKeyword);
    }

    public String getSearchResult() {
        return this.driver.findElement(searchResult).getText().split("-")[0].trim();
    }

    public void clickOnDealsLnk() {
        this.driver.findElement(offersLnk).click();
    }

    public void enterQuantity(int qty){
        int i=1;
        while (i<qty) {
            this.driver.findElement(incrementLnk).click();
          i++ ;
        }
    }

    public void addTocart() {
        this.driver.findElement(addToCartBtn).click();
    }

    public ProductInformation addProductsToCart(DataTable dt){
        ProductInformation productInformation;
        List<String> product=new ArrayList<>();
        List<Integer> qty =new ArrayList<>();
        List<List<String>> dataset= dt.asLists();
        for (List<String> row: dataset) {
            product.add(row.get(0));
            qty.add(Integer.parseInt(row.get(1).replace("KG","")));
            searchProduct(row.get(0));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enterQuantity(Integer.parseInt(row.get(1).replace("KG","")));
            addTocart();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new ProductInformation(product,qty);
    }

    public void clickOnCartIcon() {
        this.driver.findElement(cartIconLink).click();
    }

    public void navigateToCartPage(){
        this.driver.findElement(proceedToCartPage).click();
    }

}
