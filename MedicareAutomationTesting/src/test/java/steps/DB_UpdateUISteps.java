package steps;

import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import database.DB_Select;
import pageObjects.DB_UpdateUI;
import pageObjects.HomePage;

public class DB_UpdateUISteps 
{
	public WebDriver driver=CommonSteps.driver;
	public DB_Select dbselect;
	public ResultSet initialCartLine;
	public String initialcartLine;
	public ResultSet finalCartLine;
	public String finalcartLineproduct="";
	public static HomePage homepage;
	public DB_UpdateUI updateui;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public String item;
	@Then("^Check the Cart Lines from Database$")
	public void check_the_Cart_Lines_from_Database() throws Throwable 
	{
		dbselect = new DB_Select();
		Thread.sleep(2000);
		//initialCartLine = dbselect.retrieveData("select cart_lines from cart;");
		initialcartLine = dbselect.retrieveData("select product.name from product,cart_line where product.id = cart_line.product_id AND cart_line.product_id=2;");
		if(!initialcartLine.equalsIgnoreCase("Combiflame"))
		{
			System.out.println("Database Cart-Line does not has following Item: Combiflame");
			log1.info("Database Cart-Line does not has following Item: Combiflame");	
			test1.info("Database Cart-Line does not has following Item: Combiflame");
		}
		else
		{
			System.out.println("Combifalme is present");
		}
		Thread.sleep(2000);
	}

	@Then("^Add following items to cart$")
	public void add_following_items_to_cart(DataTable arg1) throws Throwable 
	{
		List<List<String>> data = arg1.raw();
		updateui = new DB_UpdateUI(driver);
		homepage = CommonSteps.homepage;
		Thread.sleep(2000);
		homepage.clickViewProducts();
		log1.info("Clicked on View Products");	
		test1.info("Clicked on View Products");
		Thread.sleep(2000);
		updateui.AddItemToCart(data.get(0).get(1));
		Thread.sleep(2000);
		item = data.get(0).get(1);
		log1.info("Following Item Added to Cart on UI: "+data.get(0).get(1));	
		test1.info("Following Item Added to Cart on UI: "+data.get(0).get(1));
	    
	}

	@Then("^Validate whether Cart Lines are updated in database$")
	public void validate_whether_Cart_Lines_are_updated_in_database() throws Throwable 
	{
		
		finalcartLineproduct = dbselect.retrieveData("select product.name from product,cart_line where product.id = cart_line.product_id AND cart_line.product_id=2;");
		if(item.equalsIgnoreCase(finalcartLineproduct))
		{
			System.out.println("Database Cart-Line has following Item (after running query): Combiflame");
			log1.info("Database Cart-Line has following Item(after running query): Combiflame");
			test1.info("Database Cart-Line has following Item(after running query): Combiflame");
			log1.info(CommonSteps.TestName+" -  Test Case Passed. Changes done on UI are correctly reflecting in DB");
			test1.pass(CommonSteps.TestName+" -  Test Case Passed. Changes done on UI are correctly reflecting in DB");
		}
		else
		{
			System.out.println("Database Cart-Line does not have following Item (after running query): Combiflame");
			log1.info("Database Cart-Line does not have following Item(after running query): Combiflame");
			test1.info("Database Cart-Line does not have Item(after running query): Combiflame");
			log1.error(CommonSteps.TestName+" -  Test Case Failed");
			test1.fail(CommonSteps.TestName+" -  Test Case Failed");
		}
		
	}



}
