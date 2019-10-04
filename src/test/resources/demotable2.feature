Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: validating the promocode of booking details
    Given User launch the browser with URL of webpage
    When User enter the details of user
      | sathiyamoorthi | p | sathiyamoorthi438@gmail.com  | chennai | 9943207467 |
      | mithran        | p | sathiyamoorthi4077@gmail.com | chennai | 8248252733 |
    Then User get the promocode of booking
