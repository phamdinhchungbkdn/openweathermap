package driver.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static config.ConfigurationManager.config;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.setHeadless(config().headless());

            return new ChromeDriver(chromeOptions);
        }

    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(config().headless());

            return new FirefoxDriver(firefoxOptions);
        }

    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();

            return new EdgeDriver();
        }

    },
    SAFARI {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);

            if (config().headless().equals(true)) {
                try {
                    throw new Exception("Headless mode does not support "+ safariOptions.getBrowserName() +" browser");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return new SafariDriver(safariOptions);
        }

    },
    OPERA {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.OPERA).setup();
            OperaOptions operaOptions = new OperaOptions();
            operaOptions.addArguments("--disable-infobars");
            operaOptions.addArguments("--disable-notifications");

            if (config().headless().equals(true)) {
                try {
                    throw new Exception("Headless mode does not support "+ operaOptions.getBrowserName() +" browser");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return new OperaDriver(operaOptions);
        }

    },
    IE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            internetExplorerOptions.ignoreZoomSettings();
            internetExplorerOptions.takeFullPageScreenshot();
            internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();

            if (config().headless().equals(true)) {
                try {
                    throw new Exception("Headless mode does not support "+ internetExplorerOptions.getBrowserName() +" browser");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return new InternetExplorerDriver(internetExplorerOptions);
        }

    };

    public abstract WebDriver createDriver();

}
