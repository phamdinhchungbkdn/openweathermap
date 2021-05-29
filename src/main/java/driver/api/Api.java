package driver.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static config.ConfigurationManager.config;

public class Api {

    private static final String BASE_URI = config().baseUri();

    @BeforeClass
    public void setApi() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.useRelaxedHTTPSValidation();
    }

}
