package stepdefinition;

import data.model.City;
import data.reader.FileReaderManager;
import io.cucumber.java.en.Then;
import object.FindPage;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FindPageSteps {
    private FindPage findPage;

    @Then("show results match with the given {string}")
    public void showResultsMatchWithTheGivenCity(String city) {
        findPage = new FindPage();
        List<String> actualList = findPage.getCityList();

        City cityData = FileReaderManager.getInstance().getJsonReader().getCity(city);
        List<String> expectedResult = cityData.expected.stream().map(n -> n.name).collect(Collectors.toList());

        Assert.assertEquals(actualList, expectedResult);
    }

    @Then("show not found with the invalid city")
    public void showNotFoundWithTheInvalidCity() {
        findPage = new FindPage();
        Assert.assertTrue(findPage.isResultNotFound());
    }

    @Then("input data should be populated as {string}")
    public void inputDataShouldBePopulatedAs(String city) {
        findPage = new FindPage();
        Assert.assertEquals(findPage.getValueOfSearch(), city);
    }
}
