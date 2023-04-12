package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass{

	 @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	    WebElement searchTextBox;
	
	   
	   @FindBy(xpath ="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[38]/div/div/div/div/div[2]/div[2]/h2/a/span")
	   WebElement add;

	   
	   @FindBy(xpath="//*[@id=\"nav-xshop\"]/a[4]")
	   WebElement mobile;
	   @FindBy(xpath = "//*[@id=\"s-refinements\"]/div[5]/ul/li[1]/span/a/span")
	    WebElement ckeckbox;
	   
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	   public void search(){
	        searchTextBox.click();
	        searchTextBox.sendKeys("Saree");
	        searchTextBox.sendKeys(Keys.ENTER);
	        add.click();
	    }
	   
	   public void getTitle() {
			System.out.println("Page title is : " + driver.getTitle());
		}

	public String getTextOfSearch() {
		String s=driver.getTitle();
		return s;
	}
	
	public void checkbox() {
		mobile.click();
		ckeckbox.click();
			System.out.println("Checkbox is checked");
	}

}
