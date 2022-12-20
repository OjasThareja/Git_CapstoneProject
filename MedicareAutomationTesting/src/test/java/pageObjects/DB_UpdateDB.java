package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DB_UpdateDB 
{
	WebDriver driver;
	Boolean update=false;
	public DB_UpdateDB(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public void refresh()
	{
		driver.navigate().refresh();
	}
	
	public Boolean validateUIUpdated(String name, String quantity)
	{
		WebElement quant;
		quant = driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td[5]"));
		if(quant.getText().equalsIgnoreCase(quantity))
		{
			update=true;
		}
		return update;
	}

}
