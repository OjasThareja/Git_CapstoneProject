package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class Cart 
{
	WebDriver driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public Cart(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()=' Continue Shopping']")
	public WebElement continueShoppingButton;
	
	@FindBy(how=How.XPATH,using="//a[text()='Checkout ']")
	public WebElement checkoutButton;
	
	@FindBy(how=How.XPATH,using="//tbody/tr")
	public List<WebElement> medicineList;
	
	@FindBy(how=How.XPATH,using="//tfoot/tr[2]/td[3]/strong")
	public WebElement Total;
	
	public String price=null,quantity=null,subtotal=null,total = null;
	public float p,q,s,t,sum = 0;
	
	public void clickContinueShopping()
	{
		continueShoppingButton.click();
		log1.info("Clicked On Continue Shopping");	
		test1.info("Clicked On Continue Shopping");
	}
	
	public void clickCheckout()
	{
		checkoutButton.click();
		log1.info("Clicked On Checkout");	
		test1.info("Clicked On Checkout");
	}
	
	public void updateQuantity() throws InterruptedException
	{
		System.out.println(medicineList.size());
		
		for(int i=0;i<medicineList.size();i++)
		{
			WebElement quant = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[3]/input"));
			WebElement ref   = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[5]/button"));
			Thread.sleep(2000);
			quant.clear();
			Thread.sleep(1000);
			quant.sendKeys("2");
			Thread.sleep(1000);
			ref.click();
			Thread.sleep(4000);
		}
		log1.info("Quantity is updated");
		log1.info("Refresh is clicked for all items");
		test1.info("Quantity is updated");
		test1.info("Refresh is clicked for all items");
		
	}
	
	public void validateAmount() throws InterruptedException
	{
		//System.out.println(medicineList.size());
		total = Total.getText();
		total = (total.split("₹")[1]).replace(" ", "");
		//System.out.println(total);
		total = total.split("/")[0];
		t = Float.parseFloat(total);
		//System.out.println(total);
		for(int i=0;i<medicineList.size();i++)
		{
			price = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[2]")).getText();
			quantity = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[3]/input")).getAttribute("value");
			subtotal = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[4]")).getText();

			p = Float.parseFloat(price.split(" ")[1]);
			q = Float.parseFloat(quantity);
			s = Float.parseFloat(subtotal.split(" ")[1]);
			sum = sum + s;
			//System.out.println("-"+p+"-"+q+"-"+s+"-");
			//p = Float.parseFloat( (price.split(" ")[1]).split(" ")[1]);
			//System.out.println(p);
			//System.out.println(s==(p*q));
			
		}
		//System.out.println(sum==t);
		if(sum==t)
		{
			log1.info("Total Amount is updated :"+sum);
			test1.info("Total Amount is updated :"+sum);
		}
		
	}
	
	public float getTotal()
	{

		
		for(int i=0;i<medicineList.size();i++)
		{
			price = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[2]")).getText();
			quantity = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[3]/input")).getAttribute("value");
			subtotal = driver.findElement(By.xpath("//tbody/tr["+String.valueOf(i+1)+"]/td[4]")).getText();
	
			p = Float.parseFloat(price.split(" ")[1]);
			q = Float.parseFloat(quantity);
			s = Float.parseFloat(subtotal.split(" ")[1]);
			sum = sum + s;
		}
		log1.info("Total Amount is :"+sum);
		test1.info("Total Amount is :"+sum);
		
		return sum;
		
	}
	
	
	
}
