Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: validating the promocode  
    Given Customer launch the browser 
    When Customer enter the details 
     |fname|lname|email|address|phno|
     |sathiyamoorthi|mithran|sathiyamoorthi438@gmail.com|chennai|8248252777|
     |sathya|mithu|sathiyamoorthi4077@gmail.com|erode|9943207467|
    Then Customer get the promocode 

