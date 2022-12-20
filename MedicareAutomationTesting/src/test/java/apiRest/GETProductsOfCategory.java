package apiRest;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import steps.APIsteps;
import static org.hamcrest.Matchers.*;
public class GETProductsOfCategory 
{
	public Logger log;
	public ExtentTest test;
	public void getProductsOfCategory()
	{
		log= APIsteps.log2;
		test = APIsteps.test2;
		
		Response response = RestAssured
		.when()
			.get("http://localhost:8090/medicare/json/data/category/3/products")
		.then()
			.assertThat()
			.statusCode(200)
		.and()
			.body("[0].name",is("Amoxicillin"))
		.and()
			.body("[1].name",is("Ciprofloxacin"))
			.contentType(ContentType.JSON).extract().response();
		log.info("Response Captured");	
		test.info("Response Captured");	
		JsonPath jsonPath = response.jsonPath();
		log.info("Name of 1st element-API Response: "+jsonPath.get("name[0]").toString());
		log.info("Name of 2nd element-API Response: "+jsonPath.get("name[1]").toString());
		test.info("Name of 1st element-API Response: "+jsonPath.get("name[0]").toString());
		test.info("Name of 2nd element-API Response: "+jsonPath.get("name[1]").toString());
	}

}
