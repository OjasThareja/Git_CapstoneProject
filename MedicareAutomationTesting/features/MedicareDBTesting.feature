@tag
Feature: Medicare DB Testing Scenario

  @tag6
  Scenario: Validate that records updated in DB are updated on UI as well
    Given Medicare web appliation homepage is opened
    |  TestCase   |   TC6_DB_AlterDB_ValidateUI   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
    Then Click on view Products
    Then Setup JDBC Connection and update following records
    |    Name     |  Diclofenac |
    |   Quantity  |      15     |    
   	Then Refresh Medicare URL
   	And Validate records are updated on UI
 		
 	@tag7
 	Scenario: Validate that changes or transaction made on UI are updated in DB as well
	 	Given Medicare web appliation homepage is opened
    |  TestCase   |   TC7_DB_AlterUI_ValidateDB   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
    Then Check the Cart Lines from Database
    Then Click on view Products
    And Add following items to cart
    |    Name     |     Combiflame   |
    Then Validate whether Cart Lines are updated in database
       
  
