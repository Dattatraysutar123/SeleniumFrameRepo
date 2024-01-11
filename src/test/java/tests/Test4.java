package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Test4 extends Base{
	public WebDriver driver;
@Test
	public void testData() throws IOException, InterruptedException {
		
	  driver = initializeDriver();
	  
	  driver.get("http://tutorialsninja.com/demo/");
	  
	  System.out.println("Test two data verify");
	  
	  Thread.sleep(2000);
	  
	  Assert.assertTrue(false);
	  
	}

@AfterMethod
public void closure() {
	
	driver.close();
}
}
