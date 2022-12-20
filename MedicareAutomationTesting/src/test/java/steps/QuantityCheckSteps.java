package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import pageObjects.InvoicePage;
import pageObjects.ViewProducts;
import steps.PaymentSteps;
public class QuantityCheckSteps
{
	WebDriver driver=CommonSteps.driver;
	ViewProducts viewproducts=CommonSteps.viewproducts;
	InvoicePage invoice= PaymentSteps.invoice;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	@Then("^Click on Continue Shopping$")
	public void click_on_Continue_Shopping() throws Throwable 
	{
		Thread.sleep(2000);
	    invoice.clickContiuneShopping();
	}



	@Then("^Validate whether permissible quantity is reduced after buying$")
	public void validate_whether_permissible_quantity_is_reduced_after_buying() throws Throwable 
	{
		Thread.sleep(3000);
	    viewproducts.validateUpdatedQuantity();
	    log1.info(CommonSteps.TestName+" -  Test Case Passed");
		test1.pass(CommonSteps.TestName+" -  Test Case Passed");
	}



}
