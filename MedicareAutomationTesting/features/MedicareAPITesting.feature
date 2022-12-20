@tag
Feature: Medicare UI Testing Scenario

  @tag8
  Scenario: GET List of All Products using Rest
    Then Get List of All Products
    |   TestCase   |      TC8_Rest_GETAll     |
 		
 	@tag9
 	Scenario: GET Products of a particular Category using Rest
 	  Then Get List of Products of a particular Category
		|  TestCase   |     TC9_Rest_GETCategoryProducts      |
  	