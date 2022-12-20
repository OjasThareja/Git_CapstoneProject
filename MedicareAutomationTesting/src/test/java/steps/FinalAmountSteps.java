package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import pageObjects.Cart;
import pageObjects.PaymentPage;

public class FinalAmountSteps 
{
	WebDriver driver=CommonSteps.driver;
	Cart cart = CommonSteps.cart;
	PaymentPage payment;
	float total;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	@Then("^Get detials and click on checkout$")
	public void get_detials_and_click_on_checkout()  throws Throwable 
	{
		payment = new PaymentPage(driver);
		Thread.sleep(2000);
		total = cart.getTotal();
		Thread.sleep(2000);
		cart.clickCheckout();
	}
	
	@Then("^Validate Final Payment Amount, Subtotal in the Payment Details Section$")
	public void validate_Final_Payment_Amount_Subtotal_in_the_Payment_Details_Section() throws Throwable 
	{
	    Thread.sleep(2000);
	    payment.validateFinalPayment(total);
	    log1.info(CommonSteps.TestName+" -  Test Case Passed");
		test1.pass(CommonSteps.TestName+" -  Test Case Passed");
	}
	

}
