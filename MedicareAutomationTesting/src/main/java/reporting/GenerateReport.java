package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReport 
{
	public static ExtentReports extent;
	public static String path; 
	public static ExtentSparkReporter reporter;
	
	public GenerateReport()
	{
		path = System.getProperty("user.dir")+"\\reports\\MedicareTesting.html";
		reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
}
