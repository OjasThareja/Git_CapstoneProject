package steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import database.DB_Update;
import pageObjects.DB_UpdateDB;

public class DB_UpdateDBSteps
{
	public WebDriver driver=CommonSteps.driver;
	public Logger log1=CommonSteps.log;
	public ExtentTest test1=CommonSteps.test;
	public String name;
	public String quantity;
	public int quant;
	public DB_UpdateDB updatedb;
	public DB_Update dbupdate;
	public Boolean update=false;
	@Then("^Setup JDBC Connection and update following records$")
	public void setup_JDBC_Connection_and_update_following_records(DataTable arg1) throws Throwable 
	{
		List<List<String>> data = arg1.raw();
		name = data.get(0).get(1);
	    quantity =  data.get(1).get(1);
	    quant = Integer.parseInt(quantity);
	    updatedb = new  DB_UpdateDB(driver);
	    dbupdate = new DB_Update();
	    Thread.sleep(2000);
	    dbupdate.updateDB(name, quant);
	   
	    log1.info("Database connection successful. Updated following records in DB: For Item-"+name+" update quantity to-"+quantity);
		test1.info("Database connection successful. Updated following records in DB: For Item-"+name+" update quantity to-"+quantity);
	  
	}

	@Then("^Refresh Medicare URL$")
	public void refresh_Medicare_URL() throws Throwable 
	{
		 Thread.sleep(2000);
	    updatedb.refresh();
	    log1.info("MEDICARE URL refreshed after executing query");	
		test1.info("MEDICARE URL refreshed after executing query");
	}

	@Then("^Validate records are updated on UI$")
	public void validate_records_are_updated_on_UI() throws Throwable 
	{
		 Thread.sleep(2000);
	    update=updatedb.validateUIUpdated(name, quantity);
	    if(update==true)
	    {
	    	log1.info("Item Name: "+name+", New Quantity on UI: "+quantity);
			test1.pass("Item Name: "+name+", New Quantity on UI: "+quantity);
	    	log1.info(CommonSteps.TestName+" -  Test Case Passed. Changes done in DB are correctly reflecting on UI");
			test1.pass(CommonSteps.TestName+" -  Test Case Passed. Changes done in DB are correctly reflecting on UI");
	    }
	    else
	    {
	    	log1.error(CommonSteps.TestName+" -  Test Case Failed");
			test1.fail(CommonSteps.TestName+" -  Test Case Failed");
	    }
	}



}
