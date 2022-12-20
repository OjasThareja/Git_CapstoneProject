package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class ViewProducts 
{
	WebDriver driver;
	Cart cart;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public static List<Integer> li = new ArrayList<Integer>();
	public static List<Integer> initialQuantity = new ArrayList<Integer>();
	public static List<Integer> newQuantity = new ArrayList<Integer>();
	public static List<String>  medicines = new ArrayList<String>();
	public static int dataSize;
	JavascriptExecutor js;
	public ViewProducts(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
		cart = new Cart(driver);
		js=(JavascriptExecutor) driver;
	}
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='0']")
	public WebElement previousTab;
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='1']")
	public WebElement _1stpage;
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='2']")
	public WebElement _2ndpage;
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='3']")
	public WebElement nextTab;

	
	public void addProducts(List<List<String>> data) throws InterruptedException
	{
		js=(JavascriptExecutor) driver;
		int temp2=0,temp=0;
		dataSize = data.size();
		for(int i=0;i<data.size();i++)
		{
			li.add(i, 0);
			medicines.add(i, data.get(i).get(0));
		}
		for(int i=0;i<data.size();i++)
		{
			js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
			Thread.sleep(2000);
			_1stpage.click();
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//td[text()='"+data.get(i).get(0)+"']")).size()!=0)
			{
				temp2 = Integer.parseInt(driver.findElement(By.xpath("//td[text()='"+data.get(i).get(0)+"']/parent::tr/td[5]")).getText());
				initialQuantity.add(i, temp2);
			}
			else 
			{
				js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
				Thread.sleep(2000);
				_2ndpage.click();
				Thread.sleep(1000);
				if(driver.findElements(By.xpath("//td[text()='"+data.get(i).get(0)+"']")).size()!=0)
				{
					temp2 = Integer.parseInt(driver.findElement(By.xpath("//td[text()='"+data.get(i).get(0)+"']/parent::tr/td[5]")).getText());
					initialQuantity.add(i, temp2);
				}
			}
		}
		for(int i=0;i<data.size();i++)
		{
			
			System.out.println(data.get(i).get(0));
			js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
			Thread.sleep(2000);
			_1stpage.click();
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//td[text()='"+data.get(i).get(0)+"']")).size()!=0)
			{
				driver.findElement(By.xpath("//td[text()='"+data.get(i).get(0)+"']/parent::tr/td[6]/a[2]")).click();
				temp = li.get(i);
				temp = temp+1;
				li.set(i, temp);
				Thread.sleep(1000);
				if(i!=data.size()-1)
				{
					cart.clickContinueShopping();
				}
			}
			else 
			{
				js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
				Thread.sleep(2000);
				_2ndpage.click();
				Thread.sleep(1000);
				if(driver.findElements(By.xpath("//td[text()='"+data.get(i).get(0)+"']")).size()!=0)
				{
					driver.findElement(By.xpath("//td[text()='"+data.get(i).get(0)+"']/parent::tr/td[6]/a[2]")).click();
					temp = li.get(i);
					temp = temp+1;
					li.set(i, temp);
					Thread.sleep(1000);
					if(i!=data.size()-1)
					{
						cart.clickContinueShopping();
					}
				}	
			}
		}
		log1.info("Products are successfully added to CART");
		test1.info("Products are successfully added to CART");
		for(int i=0;i<data.size();i++)
		{
			newQuantity.add(i, initialQuantity.get(i)-li.get(i));
		}
	}
	public void validateUpdatedQuantity() throws InterruptedException
	{
		js=(JavascriptExecutor) driver;
		for(int i=0;i<dataSize;i++)
		{
			int newQuant=0;
			js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
			Thread.sleep(2000);
			_1stpage.click();
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//td[text()='"+medicines.get(i)+"']")).size()!=0)
			{
				newQuant = Integer.parseInt( driver.findElement(By.xpath("//td[text()='"+medicines.get(i)+"']/parent::tr/td[5]")).getText() );
				if(newQuant==newQuantity.get(i))
				{
					System.out.println("Quantity updated for "+medicines.get(i)+". Quantity bought - "+li.get(i) +". Initial Quantity - "+ initialQuantity.get(i)+". New Quantity - "+newQuantity.get(i));
					log1.info("Quantity updated for "+medicines.get(i)+". Quantity bought - "+li.get(i) +". Initial Quantity - "+ initialQuantity.get(i)+". New Quantity - "+newQuantity.get(i));
					test1.info("Quantity updated for "+medicines.get(i)+". Quantity bought - "+li.get(i) +". Initial Quantity - "+ initialQuantity.get(i)+". New Quantity - "+newQuantity.get(i));
				}
			}
			else 
			{
				js.executeScript(" window.scrollTo(0,document.body.scrollHeight);  ");
				Thread.sleep(2000);
				_2ndpage.click();
				Thread.sleep(1000);
				if(driver.findElements(By.xpath("//td[text()='"+medicines.get(i)+"']")).size()!=0)
				{
					newQuant = Integer.parseInt( driver.findElement(By.xpath("//td[text()='"+medicines.get(i)+"']/parent::tr/td[5]")).getText() );
					if(newQuant==newQuantity.get(i))
					{
						System.out.println("Quantity updated for "+medicines.get(i)+". Quantity bought - "+li.get(i) +". Initial Quantity - "+ initialQuantity.get(i)+". New Quantity - "+newQuantity.get(i));
					}
				}
			}
			
		}
	}
	
}
