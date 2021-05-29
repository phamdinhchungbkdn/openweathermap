@searchWeather

Feature: Search weather in a city

  Scenario: Verify weather forecast is correctly shown for the given city
    Given go to OpenWeatherMap URL
    When enter text into Search
    And press Enter key
    And click the item in result
    Then shown weather forecast for the given city
