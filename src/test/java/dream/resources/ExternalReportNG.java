package dream.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExternalReportNG {
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "//report//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Huyen Mo");
		extent.createTest(path);
		return extent;

		
		
	}

}
