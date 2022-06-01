package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPO;
import utils.TestContextSetup;

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

}
