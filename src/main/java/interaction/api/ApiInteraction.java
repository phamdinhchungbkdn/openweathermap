package interaction.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiInteraction {

    /** Send GET request by body or parameters */
    public static Response sendGetRequest(String endpoint, Object body) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(body)
                .when().get(endpoint)
                .andReturn();

        return response;
    }

    public static Response sendGetRequest(String endpoint, String key, String value) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).pathParam(key, value)
                .when().get(endpoint)
                .andReturn();

        return response;
    }

    /** Send POST Request by body or parameters */
    public static Response sendPostRequest(String endpoint, Object body) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(body)
                .when().post(endpoint)
                .andReturn();

        return response;
    }

    public static Response sendPostRequest(String endpoint, String key, String value) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).pathParam(key, value)
                .when().post(endpoint)
                .andReturn();

        return response;
    }

    /** Send PUT Request by body or parameters */
    public static Response sendPutRequest(String endpoint, Object body) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(body)
                .when().put(endpoint)
                .andReturn();

        return response;
    }

    public static Response sendPutRequest(String endpoint, String key, String value){
        Response response = RestAssured
                .given().contentType(ContentType.JSON).pathParam(key, value)
                .when().put(endpoint)
                .andReturn();

        return response;
    }

    /** Send DELETE Request by body or parameters */
    public static Response sendDeleteRequest(String endpoint, Object body) {
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(body)
                .when().delete(endpoint)
                .andReturn();

        return response;
    }

    public static Response sendDeleteRequest(String endpoint, String key, String value){
        Response response = RestAssured
                .given().contentType(ContentType.JSON).pathParam(key, value)
                .when().delete(endpoint)
                .andReturn();

        return response;
    }

    /** Get from response */
    public static int getResponseStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static String getResponseHeader(Response response, String header) {
        return response.getHeader(header);
    }

    public static JsonObject getResponseBody(Response response, String key) {
        return response.jsonPath().getJsonObject(key);
    }

    public static int getResponseBodySize(Response response, String key) {
        return response.jsonPath().getList(key).size();
    }
}
