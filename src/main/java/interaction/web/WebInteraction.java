package interaction.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static config.ConfigurationManager.config;

public class WebInteraction extends SelectElementByType {
    private static final int longTimeout = config().longTimeout();
    private static final int shortTimeout = config().shortTimeout();

    /**
     * Interact with browser
     */
    public static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }


    /**
     * Override implicit wait timeout
     */
    private static void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    private static void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for element ready to take action
     */
    public static void waitForElementPresent(WebDriver driver, SelectorType type, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(getBy(type, locator)));
    }

    public static void waitForElementPresent(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(getBy(type, locator)));
    }

    public static void waitForAllElementsPresent(WebDriver driver, SelectorType type, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getBy(type, locator)));
    }

    public static void waitForElementVisible(WebDriver driver, SelectorType type, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(getBy(type, locator))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void waitForElementVisible(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(getBy(type, locator))));
        } catch (Exception ignored) {
        }
    }

    public static void waitForElementInvisible(WebDriver driver, SelectorType type, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        overrideGlobalTimeout(driver, shortTimeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy(type, locator)));
        overrideGlobalTimeout(driver, longTimeout);
    }

    public static void waitForElementInvisible(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        overrideGlobalTimeout(driver, shortTimeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy(type, locator)));
        overrideGlobalTimeout(driver, longTimeout);
    }

    public static void waitForElementClickable(WebDriver driver, SelectorType type, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getBy(type, locator))));
    }

    public static void waitForElementClickable(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebDriverWait wait = new WebDriverWait(driver, longTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getBy(type, locator))));
    }

    /**
     * Click on element
     */
    public static void clickOnElement(WebDriver driver, SelectorType type, String locator) {
        WebElement element = driver.findElement(getBy(type, locator));
        element.click();
    }

    public static void clickOnElement(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebElement element = driver.findElement(getBy(type, locator));
        element.click();
    }

    public static void clickOnElementInList(WebDriver driver, SelectorType type, String locator, int number) {
        List<WebElement> listElement = driver.findElements(getBy(type, locator));
        listElement.get(number).click();
    }

    /**
     * Enter text to element
     */
    public static void enterToElement(WebDriver driver, SelectorType type, String locator, String valueToSend) {
        WebElement element = driver.findElement(getBy(type, locator));
        element.clear();
        element.sendKeys(valueToSend);
    }

    public static void enterToElement(WebDriver driver, SelectorType type, String locator, String valueToSend, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebElement element = driver.findElement(getBy(type, locator));
        element.clear();
        element.sendKeys(valueToSend);
    }

    /**
     * Get text of Element
     */
    public static String getTextOfElement(WebDriver driver, SelectorType type, String locator) {
        WebElement element = driver.findElement(getBy(type, locator));
        return element.getText();
    }

    public static String getTextOfElement(WebDriver driver, SelectorType type, String locator, String... dynamicValue) {
        locator = String.format(locator, (Object) dynamicValue);
        WebElement element = driver.findElement(getBy(type, locator));
        return element.getText();
    }

    public static List<String> getTextOfElements(WebDriver driver, SelectorType type, String locator) {
        List<WebElement> elementList = driver.findElements(getBy(type, locator));
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Get value of Element's attribute
     */

    public static String getAttributeValue(WebDriver driver, SelectorType type, String locator, String attribute) {
        WebElement element = driver.findElement(getBy(type, locator));
        return element.getAttribute(attribute);
    }

    /**
     * Keyboard action
     */
    public static void sendFunctionKeyToElement(WebDriver driver, SelectorType type, String locator, Keys key) {
        WebElement element = driver.findElement(getBy(type, locator));
        Actions action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    public static void pressKey(WebDriver driver, Keys key) {
        Actions action = new Actions(driver);
        action.keyDown(key).perform();
        action.keyUp(key).perform();
    }

    public static void holdKey(WebDriver driver, Keys key) {
        Actions action = new Actions(driver);
        action.keyDown(key).perform();
    }

    public static void releaseKey(WebDriver driver, Keys key) {
        Actions action = new Actions(driver);
        action.keyUp(key).perform();
    }

    /**
     * Select value in drop down
     */
    public static void selectDropdownValue(WebDriver driver, SelectorType type, String locator, String value) {
        WebElement element = driver.findElement(getBy(type, locator));
        Select select = new Select(element);
        select.selectByValue(value);

    }

    /**
     * Check to check box
     */
    public static void checkToElement(WebDriver driver, SelectorType type, String locator) {
        WebElement element = driver.findElement(getBy(type, locator));

        if (!element.isSelected()) {
            element.click();
        }
    }

    public static boolean isElementDisplayed(WebDriver driver, SelectorType type, String locator) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> elements = driver.findElements(getBy(type, locator));
        if (elements.size() == 0) {
            overrideGlobalTimeout(driver, longTimeout);
            return false;
        } else if (elements.get(0).isDisplayed()) {
            overrideGlobalTimeout(driver, shortTimeout);
            return true;
        } else {
            overrideGlobalTimeout(driver, longTimeout);
            return false;
        }
    }
}
