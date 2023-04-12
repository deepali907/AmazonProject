package testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() 
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
			prop = new Properties();
			prop.load(fileInputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	  
	public void initialization() {
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			  
			  driver=new ChromeDriver(options);
			  driver.navigate().to(prop.getProperty("url"));
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			  driver.manage().deleteAllCookies();
			  
		}
	}
}
