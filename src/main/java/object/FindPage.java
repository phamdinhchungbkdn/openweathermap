package object;

import interaction.web.WebInteraction;

import java.util.List;

import static interaction.web.SelectorType.CSS;

public class FindPage extends CommonPage {

    private static final String CSS_CITY_LIST = "div#forecast_list_ul b a";

    public List<String> getCityList(){
        WebInteraction.waitForElementVisible(driver, CSS, CSS_CITY_LIST);
        return WebInteraction.getTextOfElements(driver, CSS, CSS_CITY_LIST);
    }

}
