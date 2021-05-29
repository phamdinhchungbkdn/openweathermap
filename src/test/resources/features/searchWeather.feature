@searchWeather

Feature: Search weather in a city

  Scenario: Verify results return when search with a valid city name
    Given go to OpenWeatherMap URL
    When enter text into Search
    And press Enter key
    Then show results match with the given city
