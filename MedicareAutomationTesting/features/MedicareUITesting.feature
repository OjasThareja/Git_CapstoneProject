@tag
Feature: Medicare UI Testing Scenario

  @tag1
  Scenario: Validate Normal User can purchase desired medicines from Medicare Web Application
    Given Medicare web appliation homepage is opened
    |  TestCase   |   TC1_UI_ValidateOrder  |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
 		Then Click on view Products
 		Then From all the available products select medicines that are to be bought
 		| Amoxicillin |
 		| Aceclofenac |
 		| Ciprofloxacin |
 		Then Click on Checkout
 		Then Enter Shipping Address
 		| Address Line one |    Street 7    |
 		| Address Line two | Northern Block |
 		|       City       |      Delhi     |	
 		|    Postal Code   |      14511     |
 		|      State       |      Delhi     |
 		|     Country      |      India     |	
 		And Click on Add Address 
		Then Enter Payment Details
 		| Card Number |  12345  |
 		|     YY      |    18   |
 		|     MM      |    10   |
 		|     CV      |    22   |
		And  Click on Pay Button
		Then Validate whether order is confirmed
		
  @tag2
  Scenario: Validate Admin User can create/add a new product
    Given Medicare web appliation homepage is opened
    |  TestCase   |       TC2_UI_ValidateAdminCreateProduct   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | vk@gmail.com | admin      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
    Then Click on Manage Product
    Then Enter Product Details
    |      Name       |   Nimamicin  |
    |      Brand      |     Atrof    |
    |   Description   |  Pain Killer |
    |     Unit Price  |      10      |
    |     Quantity    |      20      |
    |    Upload File  |  C:\\Nimamicin.jpg  |
    |     Category    |   Analgesics  |
    And Click on Save
    When Click on View Products
    Then Validate new product is added
    
    @tag3
 		Scenario: Available Quantity of a Product is reduced after its purchase
 		 Given Medicare web appliation homepage is opened
    |  TestCase   |   TC3_UI_ValidateQuantReduceAfterBuy   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
 		Then Click on view Products
 		Then From all the available products select medicines that are to be bought
 		| Amoxicillin |
 		| Aceclofenac |
 		| Ciprofloxacin |
 		Then Click on Checkout
 		Then Enter Shipping Address
 		| Address Line one |    Street 7    |
 		| Address Line two | Northern Block |
 		|       City       |      Delhi     |	
 		|    Postal Code   |      14511     |
 		|      State       |      Delhi     |
 		|     Country      |      India     |	
 		And Click on Add Address 
		Then Enter Payment Details
		| Card Number |  12345  |
 		|     YY      |    18   |
 		|     MM      |    10   |
 		|     CV      |    22   |
		And  Click on Pay Button
		Then Validate whether order is confirmed
		Then Click on Continue Shopping
		Then Validate whether permissible quantity is reduced after buying
		
   @tag4
   Scenario: Quantity, Subtotal amount is updated after clicking refresh
  	Given Medicare web appliation homepage is opened
     |  TestCase   |   TC4_UI_ValidateQuanityUpdated   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
    Then Click on view Products
 		Then From all the available products select medicines that are to be bought
 	| Amoxicillin |
 		| Aceclofenac |
 		| Ciprofloxacin |
 		Then Update the quantity and click on refresh
 		And Validate whether Amount, Subtotal is updated
 		
	 @tag5
   Scenario: Validate Amount, Grand Total
    Given Medicare web appliation homepage is opened
    |  TestCase   |   TC5_UI_ValidateAmountTotalUpdated   |
    When Click on Login Tab
    Then Enter Login Credentials  
    | kn@gmail.com | 12345      |
    And Click on Login Button
    When Reached to Home Page After Successful Login
 		Then Click on view Products
 		Then From all the available products select medicines that are to be bought
 		| Amoxicillin |
 		| Aceclofenac |
 		| Ciprofloxacin |
 		Then Get detials and click on checkout
 		Then Enter Shipping Address
 		| Address Line one |    Street 7    |
 		| Address Line two | Northern Block |
 		|       City       |      Delhi     |	
 		|    Postal Code   |      14511     |
 		|      State       |      Delhi     |
 		|     Country      |      India     |		
 		And Click on Add Address
 		Then Validate Final Payment Amount, Subtotal in the Payment Details Section
 		
 		