package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties",
        "classpath:local.properties",
        "classpath:endpoint.properties"})
public interface Configuration extends Config {

    @Key("target")
    String target();

    @Key("browser")
    String browser();

    @Key("headless")
    Boolean headless();

    @Key("url")
    String url();

    @Key("long.timeout")
    int longTimeout();

    @Key("short.timeout")
    int shortTimeout();

    @Key("base.uri")
    String baseUri();

    @Key("search.weather")
    String searchWeather();

    @Key("test.data")
    String testData();

    @Key("app.id")
    String appId();

}
