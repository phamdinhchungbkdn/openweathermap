package data.reader;

import com.google.gson.Gson;
import data.model.City;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static config.ConfigurationManager.config;

public class JsonReader {

    private final String dataPath = config().testData() + "city.json";
    private final List<City> cityList;

    public JsonReader() {
        cityList = getCityData();
    }

    private List<City> getCityData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(dataPath));
            City[] cities = gson.fromJson(bufferReader, City[].class);
            return Arrays.asList(cities);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + dataPath);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final City getCity(String city) {
        return cityList.stream().filter(x -> x.input.equalsIgnoreCase(city)).findAny().get();
    }

}
