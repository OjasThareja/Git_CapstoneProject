package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class ShippingAddressPage 
{
	//addressLineOne
	WebDriver driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public ShippingAddressPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	///
	
	@FindBy(how=How.ID,using="addressLineOne")
	public WebElement addressLineOne;
	
	@FindBy(how=How.ID,using="addressLineTwo")
	public WebElement addressLineTwo;
	
	@FindBy(how=How.ID,using="city")
	public WebElement city;
	
	@FindBy(how=How.ID,using="postalCode")
	public WebElement postalCode;
	
	@FindBy(how=How.ID,using="state")
	public WebElement state;
	
	@FindBy(how=How.ID,using="country")
	public WebElement country;
	
	@FindBy(how=How.NAME,using="_eventId_saveAddress")
	public WebElement addAddressButton;
	
	public void enterDetails(List<List<String>> data)
	{
		addressLineOne.sendKeys(data.get(0).get(1));
		addressLineTwo.sendKeys(data.get(1).get(1));
		city.sendKeys(data.get(2).get(1));
		postalCode.sendKeys(data.get(3).get(1));
		state.sendKeys(data.get(4).get(1));
		country.sendKeys(data.get(5).get(1));
		log1.info("Shipping Address is entered");
		test1.info("Shipping Address is entered");
	}
	
	public void clickAddAddress()
	{
		addAddressButton.click();
		log1.info("Clicked on Add Address");
		test1.info("Clicked on Add Address");
	}
	
	
}
