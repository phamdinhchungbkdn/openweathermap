package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Sys {

    public Integer type;
    public Integer id;
    public String country;
    public Integer sunrise;
    public Integer sunset;

    /**
     * No args constructor for use in serialization
     *
     */
    public Sys() {
    }

    /**
     *
     * @param country
     * @param sunrise
     * @param sunset
     * @param id
     * @param type
     */
    public Sys(Integer type, Integer id, String country, Integer sunrise, Integer sunset) {
        super();
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

}