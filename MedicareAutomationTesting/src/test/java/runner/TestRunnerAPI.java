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
        features="features/MedicareAPITesting.feature",
        glue="steps",
        plugin={"json:target/cucumber.json","pretty","html:target/cucumber-reports3"},
        //tags= {"@tag9"},
        dryRun=false,
        monochrome=true
)
//com.cucumber.listener.ExtentCucumberFormatter:target/report2/test_report.html
//
@Test(priority = 3)
public class TestRunnerAPI extends AbstractTestNGCucumberTests
{
	
}
