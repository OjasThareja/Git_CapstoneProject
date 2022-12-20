package steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import pageObjects.InvoicePage;
import pageObjects.PaymentPage;
import reporting.GenerateReport;



public class PaymentSteps 
{
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	WebDriver driver=CommonSteps.driver;
	public static PaymentPage payment;
	public static InvoicePage invoice;
	@Then("^Enter Payment Details$")
	public void enter_Payment_Details(DataTable arg1) throws Throwable 
	{
		//this.driver=CommonSteps.driver;
		payment = new PaymentPage(driver);
		invoice = new InvoicePage(driver);
		
		Thread.sleep(2000);
		
		List<List<String>> data = arg1.raw(); 
		payment.enterPaymentDetails(data);
	}

	@Then("^Click on Pay Button$")
	public void click_on_Pay_Button() throws Throwable 
	{
		Thread.sleep(2000);
	    payment.clickPay();
	    
	}

	@Then("^Validate whether order is confirmed$")
	public void validate_whether_order_is_confirmed() throws Throwable 
	{
	    invoice.validateOrderConfirmed();
	    if(CommonSteps.TestName.equalsIgnoreCase("TC1_ValidatePurchaseCompletion"))
	    {
	    	log1.info(CommonSteps.TestName+" -  Test Case Passed");
			test1.pass(CommonSteps.TestName+" -  Test Case Passed");
	    	
	    }
	    
	}

}
