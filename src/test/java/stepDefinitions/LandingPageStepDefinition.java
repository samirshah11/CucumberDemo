package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPO;
import utils.ProductInformation;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.List;

public class LandingPageStepDefinition {

    TestContextSetup contextSetup;

    public LandingPageStepDefinition(TestContextSetup contextSetup) {
        this.contextSetup = contextSetup;
    }

    @Given("User is on shopping landing page")
    public void user_is_on_shopping_landing_page() {
    }

    @When("User search with shortname {string} and extract actual product")
    public void user_search_with_shortname_and_extract_actual_product(String shortName) throws InterruptedException {
        LandingPO landingPO= this.contextSetup.pageObjectManager.getLandingPO();
        contextSetup.shortName = shortName;
        landingPO.searchProduct(shortName);
        Thread.sleep(5000);
        contextSetup.productName=landingPO.getSearchResult();
    }

    @Then("Relevant product should be searched")
    public void relevant_product_should_be_searched() {
        Assert.assertTrue(contextSetup.productName.toLowerCase().contains(contextSetup.shortName));
    }

    @When("^User add few products in cart$")
    public void user_add_few_products_in_cart(DataTable dt){

        LandingPO landingPO= this.contextSetup.pageObjectManager.getLandingPO();
        ProductInformation prodInfo = landingPO.addProductsToCart(dt);
        this.contextSetup.productInformation=prodInfo;
        landingPO.clickOnCartIcon();
        landingPO.navigateToCartPage();
    }

    @Then("^On cart page product should be appear with defined quantity and amount$")
    public void on_cart_page_product_should_be_appear_with_defined_quantity_and_amount() {
        Assert.assertTrue(false);
    }

}
