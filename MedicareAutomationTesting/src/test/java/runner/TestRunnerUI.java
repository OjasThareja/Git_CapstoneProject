package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import reporting.GenerateReport;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="features/MedicareUITesting.feature",
        glue="steps",
        plugin={"json:target/cucumber.json","pretty","html:target/cucumber-reports"},
        //tags= {"@tag1,@tag2"},
        dryRun=false,
        monochrome=true
)
//com.cucumber.listener.ExtentCucumberFormatter:target/report2/test_report.html
//
@Test(priority = 1)
public class TestRunnerUI extends AbstractTestNGCucumberTests
{
	public ExtentReports extent;
	GenerateReport  generateReport;
	@BeforeSuite
	public void before()
	{
		generateReport = new GenerateReport();
		extent=GenerateReport.extent;
	}
	@AfterSuite
	public void after()
	{
		extent.flush();
	}
	
}
