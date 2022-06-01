package stepDefinitions;


import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPO;
import pageObjects.OffersPO;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
    public TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^It should be match with product search on offer page$")
    public void it_should_be_match_with_product_search_on_offer_page() {
        LandingPO landingPO= this.testContextSetup.pageObjectManager.getLandingPO();
        OffersPO offersPO= this.testContextSetup.pageObjectManager.getOfferPO();
        landingPO.clickOnDealsLnk();
        this.testContextSetup.util.switchToWindow();
        offersPO.searchProduct(testContextSetup.shortName);
        String searchProductName = offersPO.getSearchResult();
        Assert.assertTrue(searchProductName.toLowerCase().contains(testContextSetup.shortName));
        Assert.assertEquals(searchProductName, testContextSetup.productName);
        //testContextSetup.driverFactory.getWebDriver().quit();

    }
}
