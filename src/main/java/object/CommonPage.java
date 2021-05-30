package object;

import driver.web.Web;
import interaction.web.WebInteraction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static interaction.web.SelectorType.XPATH;

public class CommonPage {
    protected WebDriver driver;

    private static final String XPATH_SEARCH_ON_MENU = "//div[@id='desktop-menu']//input[@name='q']";

    public CommonPage() {
        this.driver = Web.getDriver();
    }

    public void enterIntoSearch(String data) {
        WebInteraction.waitForElementClickable(driver, XPATH, XPATH_SEARCH_ON_MENU);
        WebInteraction.enterToElement(driver, XPATH, XPATH_SEARCH_ON_MENU, data);
    }

    public void pressEnterKey() {
        WebInteraction.waitForElementClickable(driver, XPATH, XPATH_SEARCH_ON_MENU);
        WebInteraction.sendFunctionKeyToElement(driver, XPATH, XPATH_SEARCH_ON_MENU, Keys.ENTER);
    }

    public String getPlaceHolderValueOfSearch() {
        WebInteraction.waitForElementVisible(driver, XPATH, XPATH_SEARCH_ON_MENU);
        return WebInteraction.getAttributeValue(driver, XPATH, XPATH_SEARCH_ON_MENU, "placeholder");
    }
}
