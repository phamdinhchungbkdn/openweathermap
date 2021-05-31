package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Coord {

    public Double lon;
    public Double lat;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coord() {
    }

    /**
     *
     * @param lon
     * @param lat
     */
    public Coord(Double lon, Double lat) {
        super();
        this.lon = lon;
        this.lat = lat;
    }

}