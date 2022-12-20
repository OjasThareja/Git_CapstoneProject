package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class HomePage 
{
	//initialize constructors
	WebDriver driver;
	public Logger log1 = CommonSteps.log;
	public ExtentTest test1 = CommonSteps.test;
	public HomePage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//a[text()='Medicare']")
	public WebElement homeicon;
	
	@FindBy(how=How.XPATH,using="//a[text()='About']")
	public WebElement aboutTab;
	
	@FindBy(how=How.XPATH,using="//a[text()='Contact']")
	public WebElement contactTab;
	
	@FindBy(how=How.XPATH,using="//a[text()='View Products']")
	public WebElement viewProductsTab;
	
	@FindBy(how=How.XPATH,using="//a[text()='Login']")
	public WebElement loginTab;
	
	@FindBy(how=How.XPATH,using="//li[@id='logout']/a")
	public WebElement logout;
	
	@FindBy(how=How.XPATH,using="//li[@id='cart']/a")
	public WebElement cart;
	//dropdownMenu1
	
	@FindBy(how=How.XPATH,using="//a[@id='dropdownMenu1']/span")
	public WebElement userDropDown;
	
	@FindBy(how=How.XPATH,using="//a[@id='dropdownMenu1']")
	public WebElement userName;
	
	@FindBy(how=How.XPATH,using="//a[text()='Manage Product']")
	public WebElement manageProductTab;
	public Logger log=CommonSteps.log;
	//
	public void clickLoginTab()
	{
		loginTab.click();
		log1.info("Clicked On Login Tab");	
		test1.info("Clicked On Login Tab");
	}
	
	public void validateUserName()
	{
		System.out.println(userName.getText().replaceAll(" ", "").equalsIgnoreCase("KavitaNigam"));
		log1.info("Login Successful");	
		test1.info("Login Successful");
	}
	
	public void clickViewProducts()
	{
		viewProductsTab.click();
		log1.info("Clicked On View Products");	
		test1.info("Clicked On View Products");
	}
	
	public void clickManageProduct()
	{
		manageProductTab.click();
		log1.info("Clicked On Manage Products");	
		test1.info("Clicked On Manage Products");
	}
	
}
