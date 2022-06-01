package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
   public WebDriver driver;
   public LandingPO landingPO;
   public OffersPO offersPO;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPO getLandingPO() {
        this.landingPO = new LandingPO(this.driver);
        return landingPO;
    }

    public OffersPO getOfferPO() {
        this.offersPO = new OffersPO(this.driver);
        return offersPO;
    }
}
