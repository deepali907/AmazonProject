package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class LoginPage extends BaseClass {


	@FindBy(id ="ap_email")
	WebElement mobileTextBox;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement passwordBox;
	
	@FindBy(id="signInSubmit")
	WebElement signIn;
	
	
	 public LoginPage(){
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void login(String mobile, String password ){
	        mobileTextBox.sendKeys(mobile);
	        continueBtn.click();
	        passwordBox.sendKeys(password);	        
	    }

	public void signIn() {
		signIn.click();
		
	}	
	
}
