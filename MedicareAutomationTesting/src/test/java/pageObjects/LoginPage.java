package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class LoginPage 
{
	
	WebDriver driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public LoginPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//h4[text()='Login']")
	public WebElement loginHeader;
	
	@FindBy(how=How.ID,using="username")
	public WebElement emailbox;
	
	@FindBy(how=How.ID,using="password")
	public WebElement passwordbox;
	
	@FindBy(how=How.XPATH,using="//input[@value='Login']")
	public WebElement loginButton;
	
	public void validatetHeader()
	{
		if(loginHeader.isDisplayed())
		{
			log1.info("Login Page is Displayed");
			test1.info("Login Page is Displayed");
		}
	}
	public void enterEmail(String email)
	{
		emailbox.sendKeys(email);
		log1.info("Email is entered: "+email);
		test1.info("Email is entered: "+email);
	}
	
	public void enterPassword(String password)
	{
		passwordbox.sendKeys(password);
		log1.info("Email is entered: "+password);
		test1.info("Email is entered: "+password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
		log1.info("Clicked on Login");
		test1.info("Clicked on Login");
	}
	
	
}
