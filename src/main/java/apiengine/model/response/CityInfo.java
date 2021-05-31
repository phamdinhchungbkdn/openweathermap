package apiengine.model.response;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CityInfo {

    public Coord coord;
    public List<Weather> weather = null;
    public String base;
    public Main main;
    public Integer visibility;
    public Wind wind;
    public Clouds clouds;
    public Integer dt;
    public Sys sys;
    public Integer timezone;
    public Integer id;
    public String name;
    public Integer cod;

    /**
     * No args constructor for use in serialization
     */
    public CityInfo() {
    }

    /**
     * @param visibility
     * @param timezone
     * @param main
     * @param clouds
     * @param sys
     * @param dt
     * @param coord
     * @param weather
     * @param name
     * @param cod
     * @param id
     * @param base
     * @param wind
     */
    public CityInfo(Coord coord, List<Weather> weather, String base, Main main, Integer visibility, Wind wind, Clouds clouds, Integer dt, Sys sys, Integer timezone, Integer id, String name, Integer cod) {
        super();
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

}