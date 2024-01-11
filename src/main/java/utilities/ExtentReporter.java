package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports extentreport;
	
	public static ExtentReports getExtentReport() {
		
		String extentreportPath = System.getProperty("user dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentreportPath);
		reporter.config().setReportName("TutorialNinja automation results");
		reporter.config().setDocumentTitle("Test results");
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Operating System","Window 10");
		extentreport.setSystemInfo("Tested by","Dattatray Sutar");
		
		return extentreport;
	}
}
