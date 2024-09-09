package maven_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

 

public class LoginPage extends BaseTest {

	

	WebDriver driver;
	public  LoginPage(WebDriver driver) {
		 this.driver = driver;
		    PageFactory.initElements(driver, this);
	}
	
	WebElement Username = driver.findElement(By.id("eud"));
	

	WebElement Password = driver.findElement(By.id("epd"));

	WebElement LoginBtn = driver.findElement(By.id("login"));
	@Test
	@Parameters({"user","psd"})
		public  void testcase( String user,String psd) {
			Username.sendKeys(user);
			Password.sendKeys(psd);
			LoginBtn.click();
		}

	
		
		  
		 
		 

		  
}
//			//Thread.sleep(5000);
//			//Username.clear();
//			Username.sendKeys("aaaa");
//			//Password.clear();
//			Password.sendKeys("pwd");
//			LoginBtn.click();
//			//Thread.sleep(5000);
