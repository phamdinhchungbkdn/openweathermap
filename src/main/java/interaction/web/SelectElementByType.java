package interaction.web;

import org.openqa.selenium.By;

public class SelectElementByType {

    public static By getBy(SelectorType selectorType, String selectorValue) {

        switch (selectorType) {
            case CSS:
                return By.cssSelector(selectorValue);
            case ID:
                return By.id(selectorValue);
            case CLASS:
                return By.className(selectorValue);
            case NAME:
                return By.name(selectorValue);
            case LINK_TEXT:
                return By.linkText(selectorValue);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(selectorValue);
            case XPATH:
            default:
                return By.xpath(selectorValue);
        }
    }
}
