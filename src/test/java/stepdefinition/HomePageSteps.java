package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import object.HomePage;

import static config.ConfigurationManager.config;

public class HomePageSteps {
    private HomePage homePage;

    @Given("go to OpenWeatherMap URL")
    public void goToOpenWeatherMapURL() {
        homePage = new HomePage();
        homePage.goToHomePage(config().url());
    }

    @When("enter {string} into Search")
    public void enterIntoSearch(String city) {
        homePage.enterIntoSearch(city);
    }

    @When("press Enter key")
    public void pressEnterKey() {
        homePage.pressEnterKey();
    }
}
