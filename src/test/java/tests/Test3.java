package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Test3 extends Base{
	public WebDriver driver;
@Test
	public void testdata() throws IOException, InterruptedException {
	  driver = initializeDriver();
	  
	  driver.get("http://tutorialsninja.com/demo/");
	  
	  System.out.println("Test three data verify");
	  
	  Thread.sleep(2000);
	  
	  driver.close();
		  
		
	}
}
