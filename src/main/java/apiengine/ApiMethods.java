package apiengine;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static config.ConfigurationManager.config;

public class ApiMethods {

    public static Response getWeather(String city, String appId){
        RequestSpecification request = RestAssured.given();

        request.contentType(ContentType.JSON);
        request.queryParam("q", city).queryParam("appid", appId);

        Response response = request.get(config().searchWeather());

        return response;
    }
}
