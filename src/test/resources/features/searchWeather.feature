@searchWeather

Feature: Search weather in a city

  Scenario Outline: Verify results return when search with a valid city name
    Given go to OpenWeatherMap URL
    When enter "<city>" into Search
    And press Enter key
    Then show results match with the given city
    Examples:
      | city        |
      | hanoi       |
      | ho chi minh |


#  Scenario Outline: Verify results not found when search with a invalid city name
#    Given go to OpenWeatherMap URL
#    When enter "<city>" into Search
#    And press Enter key
#    Then show not found with the invalid city
#    Examples:
#      | city    |
#      | abc xyz |
