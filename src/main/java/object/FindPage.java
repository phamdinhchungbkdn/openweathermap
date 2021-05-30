package object;

import interaction.web.WebInteraction;

import java.util.List;

import static interaction.web.SelectorType.*;

public class FindPage extends CommonPage {

    private static final String ID_SEARCH_TEXT_BOX = "search_str";
    private static final String CSS_CITY_LIST = "div#forecast_list_ul b a";
    private static final String XPATH_NOT_FOUND = "//div[@class='alert alert-warning']/a[@class='close']";

    public List<String> getCityList(){
        WebInteraction.waitForElementVisible(driver, CSS, CSS_CITY_LIST);
        return WebInteraction.getTextOfElements(driver, CSS, CSS_CITY_LIST);
    }

    public boolean isResultNotFound() {
        WebInteraction.waitForElementVisible(driver, XPATH, XPATH_NOT_FOUND);
        return WebInteraction.isElementDisplayed(driver, XPATH, XPATH_NOT_FOUND);
    }

    public String getValueOfSearch() {
        WebInteraction.waitForElementVisible(driver, ID, ID_SEARCH_TEXT_BOX);
        return WebInteraction.getAttributeValue(driver, ID, ID_SEARCH_TEXT_BOX, "value");
    }
}
