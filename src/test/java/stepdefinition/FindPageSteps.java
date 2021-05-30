package stepdefinition;

import io.cucumber.java.en.Then;
import object.FindPage;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class FindPageSteps {
    private FindPage findPage;
    private List<String> expectedResult = Arrays.asList("Ha Noi, VN", "Thủ Ðô Hà Nội, VN");

    @Then("show results match with the given city")
    public void showResultsMatchWithTheGivenCity() {
        findPage = new FindPage();
        List<String> cityList = findPage.getCityList();
        Assert.assertEquals(cityList, expectedResult);
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
