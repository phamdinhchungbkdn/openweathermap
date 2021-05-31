package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Weather {

    public Integer id;
    public String main;
    public String description;
    public String icon;

    /**
     * No args constructor for use in serialization
     *
     */
    public Weather() {
    }

    /**
     *
     * @param icon
     * @param description
     * @param main
     * @param id
     */
    public Weather(Integer id, String main, String description, String icon) {
        super();
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

}