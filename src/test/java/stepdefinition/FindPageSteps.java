package stepdefinition;

import io.cucumber.java.en.Then;
import object.FindPage;

import java.util.List;

public class FindPageSteps {
    private FindPage findPage;

    @Then("show results match with the given city")
    public void showResultsMatchWithTheGivenCity() {
        findPage = new FindPage();
        List<String> cityList = findPage.getCityList();
        System.out.println(cityList.get(0));
        System.out.println(cityList.get(1));
    }

    @Then("show not found with the invalid city")
    public void showNotFoundWithTheInvalidCity() {
    }
}
