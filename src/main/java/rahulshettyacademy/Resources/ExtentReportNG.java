package rahulshettyacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
		
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\newApp.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Web Automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Venkat");
		return extent;
	}

}
