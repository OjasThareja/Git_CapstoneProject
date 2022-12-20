package apiRest;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import reporting.GenerateReport;
import steps.APIsteps;
import io.restassured.response.Response;
public class GETAllProducts 
{
	public Logger log;
	public ExtentTest test;
	public void getAllProducts()
	{
		log= APIsteps.log1;
		test = APIsteps.test1;
		
		RestAssured
		.given()
			.contentType("application/json")
		.when()	
			.get("http://localhost:8090/medicare/json/data/all/products")
		.then()
			.statusCode(200)
			.log().all()
			.contentType(ContentType.JSON).extract().response();
		
		log.info("Response Captured");	
		test.info("Response Captured");
		
	}

}
