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

    @When("enter text into Search")
    public void enterTextIntoSearch() {
        homePage.enterIntoSearch("ha noi");
    }

    @When("press Enter key")
    public void pressEnterKey() {
        homePage.pressEnterKey();
    }

}
