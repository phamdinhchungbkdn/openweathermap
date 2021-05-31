package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.HomePage;
import org.testng.Assert;

import static config.ConfigurationManager.config;

public class HomePageSteps {
    private HomePage homePage;

    @Given("go to OpenWeatherMap URL")
    public void goToOpenWeatherMapURL() {
        homePage = new HomePage();
        homePage.goToHomePage(config().url());
        homePage.waitForLoaderToDisappear();
    }

    @When("enter {string} into Search")
    public void enterIntoSearch(String city) {
        homePage.enterIntoSearch(city);
    }

    @When("press Enter key")
    public void pressEnterKey() {
        homePage.pressEnterKey();
    }

    @Then("place holder of Search tex box should be {string}")
    public void placeHolderOfSearchTexBoxShouldBe(String placeHolder) {
        Assert.assertEquals(homePage.getPlaceHolderValueOfSearch(), placeHolder);
    }
}
