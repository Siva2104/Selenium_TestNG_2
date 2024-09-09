package maven_project;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class BaseTest {
	 public WebDriver driver;
   
 
	@SuppressWarnings("deprecation")
	
	public void BaseTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\1925566\\Downloads\\selenium_automation_Browsers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-popup-blocking");
	       options.addArguments("start-maximized");
	       options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		Thread.sleep(10000);
		driver.get("https://www.cs.cmu.edu/~rdriley/121/resources/exporting/");
		driver.manage().window().maximize();
		
		
	}
}

