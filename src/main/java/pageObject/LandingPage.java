package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	private static final WebElement LoginOption = null;
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	WebElement loginOption;
	
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	public WebElement loginOption() {
		return loginOption;
		
		
	}
}
