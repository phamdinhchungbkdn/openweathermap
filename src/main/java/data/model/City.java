package data.model;

import java.util.List;

public class City {
    public String input;
    public List<Expected> expected;

    public static class Expected {
        public String name;
    }
}