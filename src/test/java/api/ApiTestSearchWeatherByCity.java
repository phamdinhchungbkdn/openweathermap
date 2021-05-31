package api;

import apiengine.ApiMethods;
import apiengine.model.response.CityInfo;
import apiengine.model.response.Error;
import driver.api.Api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static report.ExtentTestManager.startTest;

public class ApiTestSearchWeatherByCity extends Api {
    private static CityInfo cityInfo;
    private static Error error;

    @Test
    public void API001_Verify_SuccessfulResponse_When_Passed_ValidCity_ValidAppId(Method method) {
        startTest(method.getName(), "Verify successful response when passed valid city name and app Id");

        Response response = ApiMethods.getWeather("ho chi minh", "987934a0c9428b08392a40ced7f46105");

        Assert.assertEquals(response.getStatusCode(), 200);
        cityInfo = response.getBody().as(CityInfo.class);

    }

    @Test
    public void API002_Verify_FailureResponse_When_Passed_ValidCity_EmptyAppId(Method method) {
        startTest(method.getName(), "Verify successful response when passed valid city name and app Id is empty");

        Response response = ApiMethods.getWeather("ho chi minh", "");

        Assert.assertEquals(response.getStatusCode(), 401);
        error = response.getBody().as(Error.class);

        Assert.assertEquals(error.message,
                "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");
    }

    @Test
    public void API003_Verify_FailureResponse_When_Passed_EmptyCity_ValidAppId(Method method) {
        startTest(method.getName(), "Verify successful response when passed empty city name and valid app Id");

        Response response = ApiMethods.getWeather("", "987934a0c9428b08392a40ced7f46105");

        Assert.assertEquals(response.getStatusCode(), 400);
        error = response.getBody().as(Error.class);

        Assert.assertEquals(error.message,
                "Nothing to geocode");
    }

    @Test
    public void API004_Verify_FailureResponse_When_Passed_EmptyCity_EmptyAppId(Method method) {
        startTest(method.getName(), "Verify successful response when passed city name and app Id are empty");

        Response response = ApiMethods.getWeather("", "");

        Assert.assertEquals(response.getStatusCode(), 401);
        error = response.getBody().as(Error.class);

        Assert.assertEquals(error.message,
                "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");
    }

    @Test
    public void API005_Verify_FailureResponse_When_Passed_InvalidCity_ValidAppId(Method method) {
        startTest(method.getName(), "Verify successful response when passed valid city name is invalid and valid app Id");

        Response response = ApiMethods.getWeather("abc xyz", "987934a0c9428b08392a40ced7f46105");

        Assert.assertEquals(response.getStatusCode(), 404);
        error = response.getBody().as(Error.class);

        Assert.assertEquals(error.message,
                "city not found");
    }
}
