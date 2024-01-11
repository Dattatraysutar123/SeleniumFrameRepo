package tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.AccountPage;

import resources.Base;
 public class LoginTest extends Base {
	 Logger log;
	public WebDriver driver;
@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws InterruptedException {
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on my account dropdown");
		landingpage.loginOption().click();
		log.debug("Clicked on login OPtion");
		
		Thread.sleep(3000);
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.emailAddressfield().sendKeys(prop.getProperty("email"));
		log.debug("emailAddress got entered");
		loginpage.passwordfield().sendKeys(prop.getProperty("password"));
		log.debug("password got entered");
		loginpage.loginfield().click();
		log.debug("Clicked on login button");
		
		AccountPage accountpage = new AccountPage(driver);
		//Assert.assertTrue(accountpage.editAccountInformationLink().isDisplayed());
		//System.out.println(accountpage.editAccountInformationLink().isDisplayed());
		
		String actualResult = null;
		try {
			if(accountpage.editAccountInformationLink().isDisplayed()) {
				actualResult="Successfull";
				log.debug("User got logged in");
         }
		}catch(Exception e) {
			System.out.println("Inside The Try Catch Block");
			log.debug("User didn't log in");
			String actaulResult = "Failure";
		}
		
		if(actualResult.equals(expectedResult)) {
		log.info("Loging test passed");
		}else {
			log.error("Login test got failed");
		}
	 }

       @BeforeMethod
        public void openApplectaion() throws IOException {
    	   
       log = LogManager.getLogger(LoginTest.class.getName());
	   driver = initializeDriver();
	   log.debug("Browser got launched");
	   driver.get(prop.getProperty("url"));
	   log.debug("Navigate to application URl");
	
        }

		@AfterMethod
		public void closure() {
		driver.close();
		log.debug("Browser got closed");
		}
		
		@DataProvider
	    public Object getLoginData() {
		Object[][] data = {{"arun.selenium@gmail.com","Second@123","Successfull"},{"dummy@test.com","dummy","Failure"}};
        return data;
	   }

}
