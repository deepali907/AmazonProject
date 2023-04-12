package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import testBase.BaseClass;


public class HomePage extends BaseClass{

	@FindBy(id = "nav-link-accountList")
	WebElement signIn;
	
	@FindBy(xpath = "//*[text()='EN']")
	WebElement hover;
	
	@FindBy(id = "searchDropdownBox")
	WebElement dropdown;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() {
		signIn.click();
		
	}

	 public void mouseHover(){
	       mouseHover(driver,hover);
	    }
	 public static void mouseHover(WebDriver driver, WebElement element){
	        Actions action=new Actions(driver);
	        action.moveToElement(element)
	                .build()
	                .perform();
	    }
	 
	 public void selectDropDown() {
		 Select d = new Select(dropdown);  
		 d.selectByVisibleText("Beauty");
		 String s = d.getFirstSelectedOption().getText();
	      System.out.println("Value selected: : " + s);
	 }
	 
}
