package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AccountPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class Login extends Base {
WebDriver driver;
LoginPage loginpage;
LandingPage landingpage;
AccountPage accountpage;
@Given("^Open any browsers$")
    public void open_any_browsers() throws IOException, InterruptedException{
	 
	driver = initializeDriver();

	
	}

@And ("^Navigat to Login page$")
   public void navigate_to_Login_page() throws InterruptedException{
			  
	   driver.get(prop.getProperty("url"));
       landingpage = new LandingPage(driver);
	   landingpage.myAccountDropdown().click();
	   landingpage.loginOption().click();
	   Thread.sleep(2000);

   }
@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the fields$")
   public void I_enter_Username_as_someusername_and_Password_as_somepassword_into_the_fields(String email,String password){
	
	loginpage = new LoginPage(driver);
	loginpage.emailAddressfield().sendKeys(prop.getProperty("email"));
	loginpage.passwordfield().sendKeys(prop.getProperty("password"));
	loginpage.loginfield().click();

}

@And ("^User click on Login button$")
   public void user_click_on_Login_button() {
	  
	loginpage.loginfield().click();

   }
@Then("^Verify user is able to successfully login$")
public void verify_user_is_able_to_successfully_login(){
	   
	accountpage = new AccountPage(driver);
	accountpage.editAccountInformationLink().isDisplayed();

}

@After
public void closeBrowser() {
	
	driver.close();
}
  
}
