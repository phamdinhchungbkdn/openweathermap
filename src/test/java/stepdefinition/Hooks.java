package stepdefinition;

import driver.web.BrowserFactory;
import driver.web.Web;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static config.ConfigurationManager.config;

public class Hooks {
    private WebDriver driver;

    @Before
    public void startBrowser() {
        String browser = config().browser();

        driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        Web.setDriver(driver);

        driver.manage().timeouts().implicitlyWait(config().longTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        Web.quitDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}
