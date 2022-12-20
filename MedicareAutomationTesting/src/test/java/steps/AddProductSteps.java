package steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductManagementPage;

public class AddProductSteps 
{
	WebDriver driver=CommonSteps.driver;
	HomePage homepage=CommonSteps.homepage;
	ProductManagementPage product;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	@Then("^Click on Manage Product$")
	public void click_on_Manage_Product() throws Throwable 
	{   
		product = new ProductManagementPage(driver);
	    Thread.sleep(2000);
	    homepage.clickManageProduct();
	}

	@Then("^Enter Product Details$")
	public void enter_Product_Details(DataTable arg1) throws Throwable 
	{
		List<List<String>> data = arg1.raw(); 
		Thread.sleep(2000);
		product.enterDetails(data);
	}

	@Then("^Click on Save$")
	public void click_on_Save() throws Throwable 
	{
	    product.clickSave();
	}

	@When("^Click on View Products$")
	public void click_on_View_Products() throws Throwable 
	{
	    product.clickViewProducts();
	}
	
	@Then("^Validate new product is added$")
	public void validate_new_product_is_added() throws Throwable 
	{
		product.validateNewProduct();
		log1.info(CommonSteps.TestName+" -  Test Case Passed");
		test1.pass(CommonSteps.TestName+" -  Test Case Passed");
	}

}
