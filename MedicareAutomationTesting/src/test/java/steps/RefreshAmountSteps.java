package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import pageObjects.Cart;

public class RefreshAmountSteps 
{
	WebDriver driver=CommonSteps.driver;
	Cart cart;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	@Then("^Update the quantity and click on refresh$")
	public void update_the_quantity_and_click_on_refresh() throws Throwable 
	{
		Thread.sleep(2000);
		cart = new Cart(driver);
		cart.updateQuantity();
	}
	@Then("^Validate whether Amount, Subtotal is updated$")
	public void validate_whether_Amount_Subtotal_is_updated() throws Throwable 
	{
		cart.validateAmount();   
		log1.info(CommonSteps.TestName+" -  Test Case Passed");
		test1.pass(CommonSteps.TestName+" -  Test Case Passed");
	}



}
