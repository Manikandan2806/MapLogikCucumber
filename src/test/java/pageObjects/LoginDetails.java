package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDetails {
	public WebDriver driver;

	
		@FindBy (xpath = "//input[@id='login-email']")
		@CacheLookup
		public WebElement adminEmail;
		
		@FindBy (xpath = "//input[@id='login-password']")
		@CacheLookup
		public WebElement adminPassword;
		
		@FindBy (xpath = "//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light']")
		@CacheLookup
		public WebElement loginButton;
		
		@FindBy(linkText = "Log out")
		@CacheLookup
		public WebElement logout;
	
		public LoginDetails(WebDriver rdriver) {
			driver = rdriver;
			PageFactory.initElements(rdriver, this); 
		}

		public void adminLogin(String eMail, String passWord) {
			adminEmail.sendKeys(eMail);
			adminPassword.sendKeys(passWord);
			
		}
		
		public void clickLogin() {
			loginButton.click();
		}
		
		public void clickLogout() {
			logout.click();
		}
	
	
}
