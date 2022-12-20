package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DB_UpdateUI 
{
	WebDriver driver;
	public DB_UpdateUI(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public void AddItemToCart(String Item)
	{
		WebElement CartButtonForItem = driver.findElement(By.xpath("//td[text()='"+Item+"']/parent::tr/td[6]/a[2]"));
		CartButtonForItem.click();
	}

}
