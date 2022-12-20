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

public class PaymentPage 
{
	WebDriver driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public PaymentPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(how=How.ID,using="cardNumber")
	public WebElement cardNumber;

	@FindBy(how=How.XPATH,using="//input[@placeholder='MM']")
	public WebElement mm;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='YY']")
	public WebElement yy;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='CV']")
	public WebElement cv;
	
	@FindBy(how=How.XPATH,using="//a/span[@class='badge pull-right']")
	public WebElement finalPayment;
	
	@FindBy(how=How.XPATH,using="//a[text()='Pay']")
	public WebElement Pay;
	
	@FindBy(how=How.XPATH,using="//div[@class='text-right']/h3")
	public List<WebElement> GrandTotalList;
	
	public void enterPaymentDetails(List<List<String>> data)
	{
		cardNumber.sendKeys(data.get(0).get(1));
		mm.sendKeys(data.get(1).get(1));
		yy.sendKeys(data.get(2).get(1));
		cv.sendKeys(data.get(3).get(1));
		log1.info("Payment Details are Entered");
		test1.info("Payment Details are Entered");
	}
	public void clickPay()
	{
		Pay.click();
		log1.info("Clicked on Pay");
		test1.info("Clicked on Pay");
	}
	
	public void validateFinalPayment(float total)
	{
		float Price,sumTotal,FinalPayment;
		sumTotal = 0;
		for(WebElement g : GrandTotalList)
		{
			Price = Float.parseFloat((((g.getText()).split("₹")[1]).replaceAll(" ", "")).split("/")[0]);
			sumTotal = sumTotal + Price;
		}
		FinalPayment = Float.parseFloat((((finalPayment.getText()).split("₹")[1]).replaceAll(" ", "")).split("/")[0]);
		
		//System.out.println(sumTotal == FinalPayment);
		//System.out.println(total == FinalPayment);
		//System.out.println("-"+sumTotal+"-"+total+"-"+FinalPayment+"-");
		if(sumTotal == FinalPayment && total == FinalPayment)
		{
			log1.info("Total Amount is correct: "+FinalPayment);
			test1.info("Total Amount is correct: "+FinalPayment);
		}
	
		
	}
}
