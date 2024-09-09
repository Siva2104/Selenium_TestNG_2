package maven_project;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.gson.Gson;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class AKB_Login {

	
	
	WebDriver driver;
	String parentWindowHandle;
	public Random r = new Random();
	JavascriptExecutor js ;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	AKB_Login() {
		js = (JavascriptExecutor)driver;
	}
	
	 public String downloadFilePath = "C:\\Users\\1925566\\Downloads\\UserData.xlsx";
	
	public  String baseFileName = "userData"; // Base name for the file
	 public   String fileExtension = ".excel"; // File extension
	 @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
		 return new Object[][] {
	           "ID":"password"
	           
	        };
	
     }
	 
	 
	@Test(alwaysRun = true, description = "Lauching the Browser", groups = "browser", priority = 1,dataProvider = "data-provider")
	// @Parameters("url")
	public void browser(String uname, String pswd) throws InterruptedException, AWTException, IOException {
/////////////////////////////////////////////////////
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1925566\\Downloads\\selenium_automation_Browsers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		/*DownloadFile*/	  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-popup-blocking");
	       options.addArguments("start-maximized");
	       options.addArguments("disable-infobars");
	       options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
	           put("download.default_directory", downloadFilePath);
	           put("download.prompt_for_download", false);
	           put("download.directory_upgrade", true);
	           put("safebrowsing.enabled", true);
	       }});
		driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		'application link'
		
		WebElement user = driver.findElement(By.id("eud"));
		user.sendKeys(uname);
		driver.findElement(By.id("epd")).sendKeys(pswd);
		driver.findElement(By.id("login")).click();
		user.clear();
		driver.findElement(By.id("epd")).clear();
	
		driver.findElement(By.id("login")).click();
		
		
		
		//Thread.sleep(20000);
		/*
		String url = driver.getCurrentUrl();
		String expectedURL = "https://testautomationpractice.blogspot.com/";
		System.out.println(url);
		//Assert.assertEquals(url, expectedURL);
		driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button")).click();
		Set<String> windows=driver.getWindowHandles();
		List<String> win = new ArrayList<String>(windows);
		String win_1 = win.get(0);
		String win_2 = win.get(1);
		System.out.println(driver.getCurrentUrl());
		System.out.println(win_1); 	System.out.println(win_2);
		
		
		driver.switchTo().defaultContent();
		/*
		 * DropDowns and Types of dropdown
		 * 
		 
		
		WebElement dropDown = driver.findElement(By.cssSelector("#country"));
		Select optslt = new Select(dropDown);
		
		optslt.selectByVisibleText("Germany");
		List<WebElement> counties =optslt.getOptions();
		System.out.println(counties.size());
		* */
		
		//////
		
		
		
		/*
		 * 
		 * Alert windows and Alert message
		 * 
		 
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HTML9\"]//button[1]")));
		
		List<WebElement> AlertBtn = 	driver.findElements(By.xpath("//*[@id=\"HTML9\"]/div[1]/button"));
		System.out.println(AlertBtn.size());
		
		for(int i = 1; i <=AlertBtn.size();i++) {
	
			driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button["+i+"]")).click();
			Thread.sleep(1000);
			Alert alt = driver.switchTo().alert();
			alt.accept();
			System.out.println("Button:"+" "+ i);
		}
		//driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[1]")).click(); //1
		* *//*
		 * 
		 * Alert windows and Alert message
		
		
		
		
		
		
		/*	
		//check boxes
	List<WebElement> check=	driver.findElements(By.xpath("//div[@class=\"form-check form-check-inline\"]//input[ @type=\"checkbox\"]"));
	
	System.out.println(check.size());
	
	for(WebElement c : check) {
		c.click();
	}
	

		driver.findElement(By.cssSelector("div#windowButtonWrapper")).click();
		
		Set<String> windows = driver.getWindowHandles();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		
		
		
		driver.manage().window().maximize();
		System.out.println("Lauching Browser");

		
		driver.findElement(By.id("eud")).sendKeys("1925566");
		driver.findElement(By.id("epd")).sendKeys("TCS#1234");
		driver.findElement(By.id("login")).click();

		
		 */
		/*
		 * User@TopRight
		 * 
		 */
/*
		WebElement userName = driver.findElement(By.cssSelector("span.userName"));
		System.out.println("welcome" + "  " + userName.getText());
		userName.click();
		Thread.sleep(1000);
		List<String> expectedValues = Arrays.asList("Welcome Back..!", "Logout", "Privacy notice");
		List<WebElement> AdminDropDown = driver.findElements(By.xpath("//div[@class=\"actionListBody active\"]//p"));
		for (WebElement ele : AdminDropDown) {
			System.out.println(ele.getText());
		}
		System.out.println("In the dropdwon we have" + " " + AdminDropDown.size() + "\n");

		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		 WebElement table = driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
		 table.isDisplayed();
		  List<WebElement> headers = table.findElements(By.xpath("//*[@id=\"wrapper\"]/section/div[1]/table/tbody/tr[1]/th"));
	       List<String> headerNames = new ArrayList<String>();
	       for (WebElement header : headers) {
	           headerNames.add(header.getText().trim());
	       }
	       //System.out.println(headerNames);
	       
	       
	       // Extract rows
	    
	       List<WebElement> rows = table.findElements(By.xpath("//div[@class=\"data-container\"]//tr"));
	       List<Map<String, String>> tableData = new ArrayList<Map<String, String>>();
	       for (WebElement row : rows) {
	           List<WebElement> cells = row.findElements(By.tagName("td"));
	           Map<String, String> rowData = new HashMap<String, String>();
	           for (int i = 0; i < Math.min(headerNames.size(), cells.size()); i++) {
	               rowData.put(headerNames.get(i), cells.get(i).getText().trim());
	           }
	           tableData.add(rowData);
	           
	       }
	       // Convert to JSON
	       Gson gson = new Gson();
	       String json = gson.toJson(tableData);
	       // Print JSON to console
	       System.out.println(driver.findElement(By.cssSelector("div#user-count")).getText());
	      
	       for (Map<String, String> user : tableData) {
	           System.out.println("User Details:");
	           for (Map.Entry<String, String> entry : user.entrySet()) {
	               System.out.println(entry.getKey() + ": " + entry.getValue());
	           }
	           System.out.println("-----------");
	       }
	       */
	       /*Forecasting*/
	       
	      // Forecaseting();
//	      DownloadExcel();
			
	       /*
	        * 
	        * Adding User in User Management
	        * 
	        * */
			/*
			for (int i = 0; i <= 10; i++) {
				WebElement adduser = driver.findElement(By.id("addUsers"));
				Assert.assertTrue(adduser.isDisplayed());
				driver.findElement(By.id("addUsers")).click();
				driver.findElement(By.id("user-actual-idOne")).sendKeys("Id" + 1 + r.nextInt(2) * 10000 + r.nextInt(10000));

				driver.findElement(By.id("ud")).sendKeys( 1 + r.nextInt(2) * 10000 + r.nextInt(10000) + "@tcs.com");
				
				
				//random name
				
				String randomString1 = randomAlphanumericString(10);
				System.out.println("Random String #1: " + randomString1);
				String randomString2 = randomAlphanumericString(10);
				System.out.println("Random String #2: " + randomString2);
				 
				driver.findElement(By.id("fn")).sendKeys(randomString1);
				driver.findElement(By.id("ln")).sendKeys(randomString2);
				
				driver.findElement(By.id("roleForUserAutoCompleteOne")).sendKeys("a");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//li[@class=\"ui-menu-item\"][1]")).click();  //Return AdminRole        
		        Thread.sleep(1000);
		        
				WebElement location = driver.findElement(By.xpath("//div[@data-drp=\"locations\"]"));	
				location.click();
				Thread.sleep(2000);
				WebElement location_chennai = driver.findElement(By.xpath("//*[@id=\"user-role-grant\"]/div/div/div[3]/div[2]/div/div/ul[2]/li[2]"));
				List <WebElement> location_dropdown = driver.findElements(By.xpath("//*[@id=\"user-role-grant\"]/div/div/div[3]/div[2]/div/div/ul[2]"));
				
				for(WebElement loc : location_dropdown) {
					String name = loc.getText().trim();
					System.out.println(name);
					if(name.contains("Chennai") || name.contains("Mumbai") )  {
						Thread.sleep(1000);
						JavascriptExecutor js1 = (JavascriptExecutor)driver;
						Thread.sleep(1000);
						js1.executeScript("arguments[0].click();", location_chennai);
						break;		
					}
				}
				
				WebElement Units = driver.findElement(By.xpath("//div[@data-drp=\"Units\"]"));
				WebElement Units_AZUnit = driver.findElement(By.xpath("//div[@data-drp=\"Units\"]//li[2]"));
				Units.click();
				Thread.sleep(3000);
				Units_AZUnit.click();
				Thread.sleep(3000);
				WebElement Teams = driver.findElement(By.xpath("//div[@data-drp=\"Teams\"]"));
				WebElement Teams_AZTeam = driver.findElement(By.xpath("//div[@data-drp=\"Teams\"]//li[2]"));
				Teams.click();
				Thread.sleep(3000);
				Teams_AZTeam.click();
				Thread.sleep(3000);
				
				
				driver.findElement(By.cssSelector("button#registerBtn")).click();
				
				//clear();
				Thread.sleep(5000);
				
				//successMessage
				
				WebElement success = driver.findElement(By.cssSelector("div[id='errorModal'] h4[class='modal-title']"));
				if(success.isDisplayed()) {
					System.out.println("User is added" +" "+ i);
					driver.findElement(By.cssSelector("span[data-errorokbtn='true']")).click();
				}
				else {
					System.out.println("Yet to add");
				}
			}
			
			
			*/
			
			
	       
	       /*
	        * 
	        * Download 
	        * */
		 
	}

	/*
	 * 
	 * 
	 * 
	 * Thread.sleep(2000); System.out.println(driver.getTitle() +
	 * driver.getCurrentUrl());
	 * driver.findElement(By.xpath("//a[@title=\"User Management\"]")).click();
	 * 
	 * 
	 * 
	 * //driver.findElement(By.id("addUsers")).click();
	 * 
	 * WebElement col =
	 * driver.findElement(By.xpath("//div[@class=\"actionItem\"]"));
	 * 
	 * List<WebElement> name =
	 * col.findElements(By.xpath("//div[@class=\"actionItem\"]//span"));
	 * System.out.println(name.size());
	 * 
	 * for(WebElement n : name) { System.out.println(n.getText());
	 * executor.executeScript("arguments[0].click();", n); }
	 * 
	 * 
	 * for(int i = 0; i<=7;i++) { int num = r.nextInt(100000);
	 * System.out.println(num + "@tcs.com"); }
	 */
	
	
	
	public void Authenticator() throws InterruptedException {
		
		driver.findElement(By.cssSelector("div.placeholderContainer")).sendKeys("1925566@tcs.com");
		driver.findElement(By.cssSelector("input#idSIButton9")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.placeholderContainer")).sendKeys("Copyright@2024");
		
		
	}	public void clear() {
		driver.findElement(By.id("user-actual-idOne")).clear();
		driver.findElement(By.id("ud")).clear();
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("roleForUserAutoCompleteOne")).clear();
		
	}
	
	public void DownloadExcel() {
		
		WebElement download = driver.findElement(By.xpath("//div[@class=\"col-sm-2\"]//img"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(download));
		Assert.assertTrue(true, "Download is seen");
		JavascriptExecutor js = (JavascriptExecutor )driver;
		js.executeScript("arguments[0].click();", download);
		
		
		 File downloadedFile = waitForDownloadToComplete(downloadFilePath, baseFileName, fileExtension, 30);
	       if (downloadedFile != null) {
	           System.out.println("Downloaded file name: " + downloadedFile.getName());
	       } else {
	           System.out.println("File download failed or file not found.");
	       }
	     
	       
	
	}
	private File waitForDownloadToComplete(String downloadDir, String baseFileName, String fileExtension, int timeoutInSeconds) {
		   File dir = new File(downloadDir);
		   File[] matchingFiles;
		   int timeElapsed = 0;
		   int fileCounter = 1;
		   while (timeElapsed < timeoutInSeconds) {
		       // Construct the expected file name
		       final String expectedFileName = (fileCounter == 1) ? baseFileName + fileExtension : baseFileName + fileCounter + fileExtension;
		       final String tempFileName = expectedFileName + ".crdownload"; // Temporary file extension used by Chrome
		       // Print the current contents of the directory (for debugging)
		       printDirectoryContents(dir);
		       // Check for the expected file or a temporary file
		       matchingFiles = dir.listFiles(new FilenameFilter() {
		           public boolean accept(File dir, String name) {
		               return name.equals(expectedFileName) || name.equals(tempFileName);
		           }
		       });
		       if (matchingFiles != null && matchingFiles.length > 0) {
		           File detectedFile = matchingFiles[0];
		           // Wait a bit to ensure the file has finished downloading
		           try {
		               Thread.sleep(2000); // Wait for 2 seconds
		           } catch (InterruptedException e) {
		               e.printStackTrace();
		           }
		           // Check if the file still has a temporary extension
		           if (detectedFile.getName().endsWith(".crdownload")) {
		               System.out.println("Download still in progress: " + detectedFile.getName());
		               continue;
		           }
		           System.out.println("Downloaded file found: " + detectedFile.getName());
		           return detectedFile;
		       }
		       try {
		           Thread.sleep(1000); // Wait for 1 second before checking again
		       } catch (InterruptedException e) {
		           e.printStackTrace();
		       }
		       System.out.println("Waiting for file: " + expectedFileName); // Debug output
		       timeElapsed++;
		       fileCounter++; // Increment the file counter for the next iteration
		   }
		   System.out.println("File not found within the specified timeout."); // Debug output
		   return null; // Return null if file not found within the timeout
		}
		private void printDirectoryContents(File dir) {
		   File[] files = dir.listFiles();
		   if (files != null) {
		       System.out.println("Current directory contents:");
		       for (File file : files) {
		           System.out.println(file.getName());
		       }
		   } else {
		       System.out.println("Directory not found or no access: " + dir.getAbsolutePath());
		   }
		}
	
	
		public void BrokenLinks() {
		
				/*Brokenlinks*/ 
		
				List<WebElement> links = driver.findElements(By.tagName("a"));
				System.out.println(links.size());

				for (WebElement link : links) {
					String url = link.getAttribute("href");
					verifyLink(url);
				}
				System.out.println();
				System.out.println("All Links Checked");
		
		
	}	
	
	public static String randomAlphanumericString(int length) {
	    String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";
	 
	    StringBuffer randomString = new StringBuffer(length);
	    Random random = new Random();
	 
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(alphanumericCharacters.length());
	        char randomChar = alphanumericCharacters.charAt(randomIndex);
	        randomString.append(randomChar);
	    }
	 
	    return randomString.toString();
	}

	public static void verifyLink(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else if (httpURLConnection.getResponseCode() == 400) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url);
		}
	}

	public void Forecaseting() throws InterruptedException {
		
		WebElement foreCasting_Estimation = driver.findElement(By.xpath("//a[@title=\"Forecasting & Estimation\"]"));
		Thread.sleep(3000);
		foreCasting_Estimation.click();
		WebElement foreCasting = driver.findElement(By.xpath("//ul[@id=\"worklistSubmenu\"]//a"));
		foreCasting.isDisplayed();
		foreCasting.click();
		
		
		
	}
	
	
	
	
	//@Test(dependsOnGroups = "browser", priority = 2)
	// @Parameters("url")
	public void Locator() throws InterruptedException, AWTException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement id = driver.findElement(By.id("user-actual-idOne"));

		wait.until(ExpectedConditions.visibilityOf(id));
		id.sendKeys("19191");

		// xpathEx

		driver.findElement(By.xpath("//*[@id=\"ud\"]")).sendKeys("199898@tcs.com");

		// classname

		driver.findElement(By.className("inputField")).click();

		// LinkedText

		// Name

		// TagName

	}

	
	//@Test(dependsOnGroups = "browser", priority = 3)
	// @Parameters("url")
	public void Assertion() throws InterruptedException, AWTException, IOException {

		String title = driver.getTitle();

		Assert.assertEquals(title, "Admin - WFI_AZ");

		System.out.println("Welocome to" + title);

		// Usr managemnet

		List<WebElement> anme = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/span"));

		for (WebElement n : anme) {
			System.out.println("\nName:" + n.getText() + "\n");
		}

		WebElement adduser = driver.findElement(By.id("addUsers"));
		Assert.assertTrue(adduser.isDisplayed());
		driver.findElement(By.id("addUsers")).click();
		for (int i = 0; i <= 10; i++) {
			driver.findElement(By.id("user-actual-idOne")).sendKeys("Id" + 1 + r.nextInt(2) * 10000 + r.nextInt(10000));

			driver.findElement(By.id("user-actual-idOne")).clear();
			Thread.sleep(2000);
		}
	}

	/*
	 * 
	 * @DataProvider(name = "login")
	 * 
	 * public Object[][] test (){
	 * 
	 * Object [][] data = { {"192929", "tcs@tcs.com"}, {"192929", "tcs@tcs.com"},
	 * {"38393", "tcs@tcs.com"}, {"39393", "tcs@tcs.com"}, {"192949",
	 * "tcs@tcs.com"}, {"1925566", "TCS#1234"} }; return data; }
	 * 
	 */

	//@Test(dependsOnGroups = "browser", priority = 4)
	// @Parameters("url")
	public void  ExcelRead() throws InterruptedException, AWTException, IOException {

		FileInputStream fs = new FileInputStream("C:\\BFSI_test\\automation\\login_test.xlsx");
		// Creating a workbook (String.valueOf(version))
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= 6; i++) {

			String username2 = sheet.getRow(i).getCell(0).getStringCellValue();
			;
			System.out.println(username2);

			String password1 = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(password1);
			driver.findElement(By.id("eud")).sendKeys(String.valueOf(username2));
			driver.findElement(By.id("epd")).sendKeys(password1);
			driver.findElement(By.id("login")).click();

			Thread.sleep(4000);

			System.out.println(username2 + " " + password1);

			driver.findElement(By.id("eud")).clear();
			driver.findElement(By.id("epd")).clear();
		}

		int username2 = (int) sheet.getRow(7).getCell(0).getNumericCellValue();
		System.out.println(username2);
		String password1 = sheet.getRow(7).getCell(1).getStringCellValue();
		System.out.println(password1);
		driver.findElement(By.id("eud")).sendKeys(String.valueOf(username2));
		driver.findElement(By.id("epd")).sendKeys(password1);
		driver.findElement(By.id("login")).click();

		System.out.println("Entering the valid credentials" + username2 + "and" + password1);

	}



}
