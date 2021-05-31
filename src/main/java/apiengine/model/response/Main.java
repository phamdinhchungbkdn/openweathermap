package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Main {

    public Double temp;
    public Double feels_like;
    public Double temp_min;
    public Double temp_max;
    public Integer pressure;
    public Integer humidity;
    public Integer sea_level;
    public Integer grnd_level;

    /**
     * No args constructor for use in serialization
     *
     */
    public Main() {
    }

    /**
     *
     * @param feelsLike
     * @param tempMax
     * @param temp
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMin
     */
    public Main(Double temp, Double feels_like, Double temp_min, Double temp_max, Integer pressure, Integer humidity, Integer sea_level, Integer grnd_level) {
        super();
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }

}