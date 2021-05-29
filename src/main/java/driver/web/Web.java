package driver.web;

import org.openqa.selenium.WebDriver;

public class Web {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Web() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        Web.driver.set(driver);
    }

    public static void quitDriver() {
        Web.driver.get().quit();
        driver.remove();
    }

}
