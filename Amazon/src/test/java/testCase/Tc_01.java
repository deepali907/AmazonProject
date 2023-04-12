package testCase;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testBase.BaseClass;

public class Tc_01  extends BaseClass
{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	
//Loading the config file
    public Tc_01(){
        super();
    }
    
    @BeforeMethod
	public void BeforeMethod()
	{
		//Loading the driver file and eatablishing the connection ,loading the url
	     initialization();
		
	 homePage = new HomePage();
     loginPage = new LoginPage(); 
     myAccountPage= new MyAccountPage();
 }
	@Test(priority = 1)
	public void verifyLoginWithValidCredential(){
	     SoftAssert softAssert = new SoftAssert();
	     homePage.clickSignIn();
	     loginPage.login(prop.getProperty("mobile"), prop.getProperty("password"));
	     loginPage.signIn();
	     myAccountPage.getTitle();
	     softAssert.assertAll();
	  
	 }
	
	@Test(priority = 7)
	public void verifyNewTabWindow() throws InterruptedException {
		Actions action = new Actions(driver);
		
		WebElement firstlink=driver.findElement(By.xpath("//a[text()='Sell']"));
		action.keyDown(Keys.CONTROL).moveToElement(firstlink).click().perform();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void verifySearchBar() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		myAccountPage.search();
		softAssert.assertAll();
		Thread.sleep(3000);
	}
	
    @Test(priority = 2)
	public void verifyScrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
	
	@Test(priority = 3)
	public void verifyScrollUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,4000)");
		js.executeScript("window.scrollBy(0,-800)");
		
	}
	
	@Test(priority = 4)
	 public void verifyMouseHover(){
	     SoftAssert softAssert = new SoftAssert();
	     homePage.mouseHover();
	     softAssert.assertAll();
	 }
	
	@Test(priority = 5)
	public void verifyDropDown() {
		SoftAssert softAssert = new SoftAssert();
		homePage.selectDropDown();
		softAssert.assertAll();
	}
	
	@Test(priority = 9)
	public static void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c);
        }
    }
	
	@Test(priority = 8)
	public void verifyCheckBox(){
        
		myAccountPage.checkbox();
        }
	
	 @AfterMethod
	 public void afterMethod(){
	     driver.close();
	 }

}
