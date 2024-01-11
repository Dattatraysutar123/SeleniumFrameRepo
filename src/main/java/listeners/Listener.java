package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import resources.Base;
import utilities.ExtentReporter;

public class Listener extends Base implements ITestListener {
	
	WebDriver driver =null;
    ExtentReports extentreport=ExtentReporter.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
    
	@Override
	public void onTestStart(ITestResult result) {
	
        String testName = result.getName();
	    extentTest = extentreport.createTest(testName+"excuted started");
		extentTestThread.set(extentTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		//extentTest.log(Status.PASS,testName+"Test got passed");
	    extentTestThread.get().log(Status.PASS, testName+"Test got passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		try {
			
		  driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		  
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}try {
			
         String ScreenshotFilePath = takeScreenShot(testName,driver);
         extentTestThread.get().addScreenCaptureFromPath(ScreenshotFilePath,testName);
          
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
	}

	public void itTestListeners() {
		
	}

}
