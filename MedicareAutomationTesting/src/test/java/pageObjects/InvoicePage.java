package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class InvoicePage 
{
	WebDriver driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public InvoicePage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	//Your Order is Confirmed!!
	@FindBy(how=How.XPATH,using="//h3[text()='Your Order is Confirmed!!']")
	public WebElement orderConfirmation;
	
	@FindBy(how=How.XPATH,using="//a[text()='Continue Shopping']")
	public WebElement continueShoppingButton;
	
	public void validateOrderConfirmed()
	{
		System.out.println(orderConfirmation.isDisplayed());
		log1.info("Order is Confirmed");	
		test1.info("Order is Confirmed");
	}
	
	public void clickContiuneShopping() throws InterruptedException
	{
		Thread.sleep(2000);
		continueShoppingButton.click();
		log1.info("Clicked On Continue Shopping");	
		test1.info("Clicked On Continue Shopping");
	}

}
