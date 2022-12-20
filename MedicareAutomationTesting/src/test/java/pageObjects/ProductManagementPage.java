package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import steps.CommonSteps;

public class ProductManagementPage 
{
	WebDriver driver;
	public static String drugName;
	public static String brandName;
	public static String price;
	public static String quantity2;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public ProductManagementPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="name")
	public WebElement name;
	
	@FindBy(how=How.ID,using="brand")
	public WebElement brand;
	
	@FindBy(how=How.ID,using="description")
	public WebElement description;
	
	@FindBy(how=How.ID,using="unitPrice")
	public WebElement unitPrice;
	
	@FindBy(how=How.ID,using="quantity")
	public WebElement quantity;
	
	@FindBy(how=How.ID,using="file")
	public WebElement imageFile;
	
	
	@FindBy(how=How.ID,using="categoryId")
	public WebElement dropdown;
	
	Select category;
	
	@FindBy(how=How.NAME,using="submit")
	public WebElement saveButton;
	
	@FindBy(how=How.XPATH,using="//a[text()='View Products']")
	public WebElement viewProductsTab;
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='1']")
	public WebElement _1stpage;
	
	@FindBy(how=How.XPATH,using="//li/a[@data-dt-idx='2']")
	public WebElement _2ndpage;
	
	Boolean ItemAdded=false;
	public void enterDetails(List<List<String>> data) throws InterruptedException
	{
		category = new Select(dropdown);
		name.sendKeys(data.get(0).get(1));
		drugName = data.get(0).get(1);
		brand.sendKeys(data.get(1).get(1));
		brandName = data.get(1).get(1);
		description.sendKeys(data.get(2).get(1));
		
		unitPrice.clear();
		unitPrice.sendKeys(data.get(3).get(1));
		price = data.get(3).get(1);
		quantity.clear();
		quantity.sendKeys(data.get(4).get(1));
		quantity2 = data.get(4).get(1);
		//dropdown.click();
		Thread.sleep(1000);
		category.selectByVisibleText(data.get(6).get(1));
		//driver.findElement(By.xpath("//option[text()='"+data.get(6).get(1)+"']")).click();
		
		imageFile.sendKeys(data.get(5).get(1));
		
		log1.info("New Product Details are entered");
		test1.info("New Product Details are entered");
	}
	public void clickSave() throws InterruptedException
	{
		Thread.sleep(2000);
		saveButton.click();
		log1.info("Clicked on Save");
		test1.info("Clicked on Save");
	}
	public void clickViewProducts() throws InterruptedException
	{
		Thread.sleep(2000);
		viewProductsTab.click();
		log1.info("Clicked on View Products");
		test1.info("Clicked on View Products");
	
	}
	
	public void validateNewProduct() throws InterruptedException
	{
		String n,b,p,q;
		_1stpage.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//td[text()='"+drugName+"']")).size()!=0)
		{
			n=driver.findElement(By.xpath("//td[text()='"+drugName+"']")).getText();
			b=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[3]")).getText();
			p=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[4]")).getText();
			p=(p.replace("₹", "")).replaceAll(" ", "");
			q=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[5]")).getText();
			
			if(drugName.equalsIgnoreCase(n) && brandName.equalsIgnoreCase(b) && price.equalsIgnoreCase(p) &&  quantity2.equalsIgnoreCase(q))
			{
				ItemAdded = true;
			}
		}
		else 
		{
			_2ndpage.click();
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//td[text()='"+drugName+"']")).size()!=0)
			{
				
				n=driver.findElement(By.xpath("//td[text()='"+drugName+"']")).getText();
				b=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[3]")).getText();
				p=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[4]")).getText();
				p=(p.replace("₹", "")).replaceAll(" ", "");
				q=driver.findElement(By.xpath("//td[text()='"+drugName+"']/parent::tr/td[5]")).getText();
				
				if(drugName.equalsIgnoreCase(n) && brandName.equalsIgnoreCase(b) && price.equalsIgnoreCase(p) &&  quantity2.equalsIgnoreCase(q))
				{
					ItemAdded = true;
				}
			}
			
		}
		if(ItemAdded == true)
		{
			//System.out.println("Item successfully Added");
			log1.info("New Item successfully Added");
			test1.info("New Item successfully Added");
		}
		else
		{
			log1.error("New Item Not Added");
			test1.fail("New Item Not Added");
		}
		
	}
}
