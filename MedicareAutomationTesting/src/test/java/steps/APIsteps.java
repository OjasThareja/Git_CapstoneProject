package steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import apiRest.GETAllProducts;
import apiRest.GETProductsOfCategory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import reporting.GenerateReport;

public class APIsteps 
{
	public static Logger log1;
	public static Logger log2;
	public GETAllProducts getall;
	public GETProductsOfCategory getCProducts;
	public String testcase;
	public static ExtentTest test1;
	public static ExtentTest test2;
	public  ExtentReports extent ;
	@Then("^Get List of All Products$")
	public void get_List_of_All_Products(DataTable arg1) throws Throwable 
	{
		extent = GenerateReport.extent;
		List<List<String>> data = arg1.raw();
		getall = new GETAllProducts();
		testcase = data.get(0).get(1);
		
		log1 = Logger.getLogger("MEDICARE-"+testcase);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
		test1 = extent.createTest(testcase);
		
		getall.getAllProducts();
		Thread.sleep(4000);
		
		log1.info(testcase+" -  Test Case Passed");
		test1.pass(testcase+" -  Test Case Passed");
	}

	@Then("^Get List of Products of a particular Category$")
	public void get_List_of_Products_of_a_particular_Category(DataTable arg1) throws Throwable 
	{
		extent = GenerateReport.extent;
		List<List<String>> data = arg1.raw();
		getCProducts = new GETProductsOfCategory();
		testcase = data.get(0).get(1);
		
		log2 = Logger.getLogger("MEDICARE-"+testcase);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
		test2 = extent.createTest(testcase);
		
		getCProducts.getProductsOfCategory();
		Thread.sleep(4000);
		
		log2.info(testcase+" -  Test Case Passed");
		test2.pass(testcase+" -  Test Case Passed");
	}



}
