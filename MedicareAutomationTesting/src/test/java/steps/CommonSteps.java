package steps;

import java.util.List;


import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSetup;
import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShippingAddressPage;
import pageObjects.ViewProducts;
import reporting.GenerateReport;

public class CommonSteps 
{
	public static WebDriver driver;
	DriverSetup setup = new DriverSetup();
	public static Logger log;
	public static HomePage homepage;
	public static LoginPage loginpage;
	public static ViewProducts viewproducts;
	public static Cart cart;
	public static ShippingAddressPage addressPage;
	//GenerateReport  generateReport;
	public static String TestName;
	
	public static ExtentTest test;
	public static ExtentReports extent;
	@Given("^Medicare web appliation homepage is opened$")
	public void medicare_web_appliation_homepage_is_opened(DataTable arg1) throws Throwable 
	{
		
		List<List<String>> data = arg1.raw();
		//generateReport = new GenerateReport();
		
		TestName = data.get(0).get(1);
		log = Logger.getLogger("MEDICARE-"+TestName);
		extent = GenerateReport.extent;
		test = extent.createTest(TestName);
		System.out.println(System.getProperty("user.dir"));
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
	    driver = setup.getDriver();
	    log.info("MEDICARE Server Successfully Started");
	    test.info("Test Execution Started");
	    Thread.sleep(6000);
	    
	    homepage = new HomePage(driver);
	    loginpage = new LoginPage(driver);
	    viewproducts = new ViewProducts(driver);
	    cart = new Cart(driver);
	    addressPage = new ShippingAddressPage(driver);
	}

	@When("^Click on Login Tab$")
	public void click_on_Login_Tab() throws Throwable 
	{
		Thread.sleep(1000);
		homepage.clickLoginTab();   
	}

	@Then("^Enter Login Credentials$")
	public void enter_Login_Credentials(DataTable arg1) throws Throwable 
	{
		Thread.sleep(2000);
		List<List<String>> data = arg1.raw();  
		System.out.println(data.get(0).get(0));
		System.out.println(data.get(0).get(1));
		System.out.println(data.get(0).get(1).getClass());
		String username= data.get(0).get(0);
		String password= data.get(0).get(1);
		loginpage.validatetHeader();
		Thread.sleep(2000);
		loginpage.enterEmail(username);
		loginpage.enterPassword(password);
	}

	@Then("^Click on Login Button$")
	public void click_on_Login_Button() throws Throwable 
	{
		Thread.sleep(2000);
		loginpage.clickLoginButton();	    
	}

	@When("^Reached to Home Page After Successful Login$")
	public void reached_to_Home_Page_After_Successful_Login() throws Throwable 
	{
		Thread.sleep(2000);
	    homepage.validateUserName();
	}

	@Then("^Click on view Products$")
	public void click_on_view_Products() throws Throwable 
	{
		Thread.sleep(2000);
	    homepage.clickViewProducts();
	}

	@Then("^From all the available products select medicines that are to be bought$")
	public void from_all_the_available_products_select_medicines_that_are_to_be_bought(DataTable arg1) throws Throwable 
	{
		Thread.sleep(2000);
		List<List<String>> data = arg1.raw();  
		viewproducts.addProducts(data);
	}

	@Then("^Click on Checkout$")
	public void click_on_Checkout() throws Throwable 
	{
	   cart = new Cart(driver);
	   Thread.sleep(2000);
	   cart.clickCheckout();
	}

	@Then("^Enter Shipping Address$")
	public void enter_Shipping_Address(DataTable arg1) throws Throwable 
	{
		Thread.sleep(2000);
		List<List<String>> data = arg1.raw();  
	    addressPage.enterDetails(data);
	}

	@Then("^Click on Add Address$")
	public void click_on_Add_Address() throws Throwable 
	{
	    Thread.sleep(2000);
	    addressPage.clickAddAddress();
	}

}
