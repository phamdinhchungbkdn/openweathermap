package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Wind {

    public Double speed;
    public Integer deg;
    public Double gust;

    /**
     * No args constructor for use in serialization
     *
     */
    public Wind() {
    }

    /**
     *
     * @param deg
     * @param speed
     * @param gust
     */
    public Wind(Double speed, Integer deg, Double gust) {
        super();
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

}