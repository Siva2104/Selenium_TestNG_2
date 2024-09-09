package maven_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class annotations {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1925566\\Downloads\\selenium_automation_Browsers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-popup-blocking");
	       options.addArguments("start-maximized");
	       options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		System.out.println("BeforeTest Executed");
	}
 
	@BeforeClass
	public void titleTest(){
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
		System.out.println("BeforeClass Executed");
	}
	@Test
	@Parameters({"username","password"})
	public void logintest(String uname, String pswd) throws InterruptedException {
		driver.findElement(By.id("eud")).sendKeys(uname);
		driver.findElement(By.id("epd")).sendKeys(pswd);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		System.out.println("Login Passed");
	}

}
