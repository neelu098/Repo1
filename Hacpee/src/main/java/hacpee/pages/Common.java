package hacpee.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import TestUtills.DataUtils;
import cucumber.api.Scenario;

public class Common extends TestExecutor {

	/*
	 * public static Common common; public static ExtentReports report; public
	 * static com.aventstack.extentreports.ExtentTest logger; public static
	 * String userDir=System.getProperty("user.dir"); public static WebDriver
	 * driver = null;
	 */

	// WebDriver driver=null;
	WebElement element = null;
	List<WebElement> rows = null;
	Select select = null;

	public Common(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * @param xPath
	 * @throws InterruptedException
	 * Scrolls up to a certain element
	 */
	public void scrollIntoViewJS(WebElement xPath) throws InterruptedException
	{
	//element = driver.findElement(By.xpath(xPath));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", xPath);
	Thread.sleep(2000);
	}

		/**
	 * @param locator
	 * @param msg
	 * @return
	 * Finds whether an element is present
	 */
	public boolean isElementPresent(WebElement locator, String msg)
    {
           try
           {
                  locator.isDisplayed();
                  logger.log(LogStatus.PASS,"<span style='color:green;'>Error message got displayed as: </span>" + "<span class='label success'>" + msg+ "</span>");
          
                  return true;
           }
           catch (Exception NoSuchElementException)
           {
                        
                  logger.log(LogStatus.FAIL,"<span style='color:red;'>Element is not present for error message: </span>" + "<span class='label success'>" + msg+ " </span>");
                 
                  
                  return false;
           }
    }
	
		
	/**
	 * @param locator
	 * @param msg
	 * @return
	 * Finds whether an element is not present
	 */
	public boolean isElementNotPresent(WebElement locator, String msg)
    {
           try
           {
                  locator.isDisplayed();
                  logger.log(LogStatus.FAIL,"<span style='color:red;'>Element is present : </span>" + "<span class='label success'>" + msg+ "</span>");
          
                  return false;
           }
           catch (Exception NoSuchElementException)
           {
                        
                  logger.log(LogStatus.PASS,"<span style='color:green;'>Element is not present : </span>" + "<span class='label success'>" + msg+ " </span>");
                 
                  
                  return true;
           }
    }

	public void SelectByIndex(String xpath,int value, String msg) throws InterruptedException
	{
		try{
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByIndex(value);
		//logger.log(LogStatus.PASS,msg);
		}
		 catch (Throwable t) {
				String screenshot_path= CaptureScreenShot(driver, msg);
				  String image= logger.addScreenCapture(screenshot_path);
				//logger.log(LogStatus.FAIL, "Webelementnotfound",image);
				
				//Reporter.log("Object having Xpath as " + xpath + " not found.");
				Assert.assertTrue(false, "Object having Xpath as " + xpath + " not found.");
				
		 }	
	}
	
	public static boolean checkStringUpperCase(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = false;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	        	
	    }
	    logger.log(LogStatus.PASS, "<span style='color:green;'>Value has changed to Upper Case : </span>" + "<span class='label success'>"+ str + "</span>");
		   
	    return false;
	    
	}
	

	// Method to Capture screenshot
	
		public static String CaptureScreenShot(WebDriver driver, String imageName) throws InterruptedException {
		      Thread.sleep(3000);
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String encodedBase64 = null;
			FileInputStream fileInputStreamReader = null;
			try {
			fileInputStreamReader = new FileInputStream(sourceFile);
			byte[] bytes = new byte[(int)sourceFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));

			      //  String screenShotDestination = createScreeshotFolderStructure() +"/"+ imageName.trim().replace(" ","_") + ".png";

			String screenShotDestination = userDir + "\\test-output\\extentreports\\Screenshots\\" +"/"+ imageName.trim().replace(" ","_") + ".png";

			
			        File destination = new File(screenShotDestination);
			        FileUtils.copyFile(sourceFile, destination);

			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    return "data:image/png;base64,"+encodedBase64;
	}

	/*			
		
		public static String CaptureScreenShot(WebDriver driver, String screenName) {
			
			String Shared = "./test-output/extentreports/Screenshots/";  //".\\test-output\\extentreports\\Screenshots\\Screen.png" ; //".\\test-output\\extentreports"; // .\\screenshot\\fullimage.jpg
			TakesScreenshot efwd = ((TakesScreenshot) driver);
			File srcFile = efwd.getScreenshotAs(OutputType.FILE);
			//String fileDest = userDir + "\\ScreenShotLib\\" + screenName + getTimeStamp() + ".png";
			//String fileDest = Shared + screenName + getTimeStamp() + ".png";
			String fileDest =  Shared + screenName + ".png";
			try { 
				FileUtils.copyFile(srcFile, new File(fileDest));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileDest;
		}
		
	*/
		
		public static String getScreenshot(String screenshotName) throws IOException {
			
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String imgPath = "./test-output/extentreports/Screenshots/"+ screenshotName + ".png";
			File path = new File(imgPath);
			FileUtils.copyFile(sourceFile, path);
			
			return imgPath;
			
		}
		
		
		public static Object screenCapture(String imgPath) throws IOException {
			
			MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build();
			return imgPath;
		}
		
		public String CaptureScreen(WebDriver driver, String imageName)
		{
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
		fileInputStreamReader = new FileInputStream(sourceFile);
		byte[] bytes = new byte[(int)sourceFile.length()];
		fileInputStreamReader.read(bytes);
		encodedBase64 = new String(Base64.encodeBase64(bytes));

		      //  String screenShotDestination = createScreeshotFolderStructure() +"/"+ imageName.trim().replace(" ","_") + ".png";

		String screenShotDestination = userDir + "\\test-output\\extentreports\\Screenshots\\" +"/"+ imageName.trim().replace(" ","_") + ".png";

		
		        File destination = new File(screenShotDestination);
		        FileUtils.copyFile(sourceFile, destination);

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return "data:image/png;base64,"+encodedBase64;
		}
		
	

	// Method for formatting Date
	public static String getTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		Date date = new Date();
		String DateTime = dateFormat.format(date);
		return DateTime.toString();
	}

	/**
	 * To Capture screenshot and store it at a specified location below method
	 * is used.
	 * 
	 * @return
	 */

	public void scrollDown() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

	}

	public void scrollUp() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);

	}

	public void clickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(TestExecutor.driver, 25);

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public static String CaptureScreenShots(WebDriver driver) throws IOException {

		SimpleDateFormat df = new SimpleDateFormat("hh_mm_ss_a");
		Date date = new Date();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String base64String = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		System.out.println(base64String);
		System.out.println(System.getProperty("user.dir"));
		// String workingdirectory = System.getProperty("user.dir");
		// File src = driver.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new
		// File(workingdirectory+"/ScreenShotsLib1/"+screenName+df.format(date)+".JPG"));
		// test1.log(LogStatus.INFO,
		// screenName+""+test1.addScreenCapture(workingdirectory+"/ScreenShotsLib/"+screenName+df.format(date)+".JPG"));
		logger.log(LogStatus.INFO, " " );
		// return workingdirectory;
		return base64String;

	}
	
	 public void sc() {
		 final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//Scenario.embed(screenshot, "image/png");
	 }

	public void UrlLaunch(String sheet, String url) throws IOException {
		/**
		 * To enter the url of the application in to the browser. Fetches the
		 * data from excel.
		 *
		 * @param Sheet
		 *            name is stored in string which gets changed for different
		 *            test data.
		 * @Param Url of the application in a string.
		 * 
		 */
		dataUtils = new DataUtils();
		dataUtils.setSheetName(sheet);
		try {
			System.out.println("Inside the try block of Login");
			int i = 1;
			while (i <= dataUtils.noOfRows()) {
				dataUtils.getRowData(i);
				if (getData("RunThis").toLowerCase().equals("yes")) {
					driver.get(getData(url));

				} else {
					System.out.println("Skipped scenario : " + getData("Error"));
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception occured during execution: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}

	public void Excelreader(String SheetName, WebElement element, String Data) throws IOException {
		/**
		 * To enter the test data from excel. Fetches the data from excel.
		 *
		 * @param Sheet
		 *            name is stored in string which gets changed for different
		 *            test data.
		 * @Param Element for the which the test data has to entered.
		 * @Param The actual test data that needs to be entered.
		 * 
		 */
		dataUtils = new DataUtils();
		dataUtils.setSheetName(SheetName);
		try {
			int i = 1;
			while (i <= dataUtils.noOfRows()) {
				dataUtils.getRowData(i);
				if (getData("RunThis").toLowerCase().equals("yes")) {
					element.clear();
					element.sendKeys(getData(Data));
				} else {
					System.out.println("Skipped scenario : " + getData("ScenarioDescription"));
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception occured during execution: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}

	
	public void CommonUploadFile(String UploadPath) throws AWTException, InterruptedException, IOException {

		/**
		 * To upload each document from the available invoices that are located
		 * in different path. Here the path of the document to be uploaded alone
		 * gets changed. Fetches the data from excel. Robot class is used for
		 * Windows GUI actions.
		 * 
		 * @param String
		 *            which shows the path of the given document
		 * 
		 */

		// Remote Machine

		Thread.sleep(3000);
		dataUtils = new DataUtils();
		dataUtils.setSheetName("Sheet1");
		int i = 1;
		while (i <= dataUtils.noOfRows()) {
			dataUtils.getRowData(i);
			if (getData("RunThis").toLowerCase().equals("yes")) {
				//StringSelection ss = new StringSelection(getData(UploadPath));
				StringSelection ss = new StringSelection("C:\\Users\\DS16026\\Downloads\\Honeywell.pdf");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			} else {
				System.out.println("Skipped scenario : " + getData("ScenarioDescription"));
			}
			i++;
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);

	}
		
	/*public String GenerateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}*/
	
	public void Wait5() throws InterruptedException {

		Thread.sleep(5000);

	}

	public void Wait(WebElement element) {

		/**
		 * To verify the visibility of an element. An expectation for checking
		 * that an element present on the page, is visible.
		 * 
		 * @param element
		 *            the WebElement
		 * 
		 */

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void Wait1(WebElement element) {

		/**
		 * To verify that an element is able to click. An expectation for
		 * checking that an element present on the page, is able to click.
		 * 
		 * @param element
		 *            the WebElement
		 * 
		 */

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void SelectByValue(WebElement element, String A) {

		/**
		 * To select the value present in the drop down. An expectation for
		 * selecting a value from the drop down of an element present on the
		 * page.
		 * 
		 * @param element
		 *            the WebElement
		 * @Param Value available to select is stored in a String
		 */

		Select s = new Select(element);
		s.selectByValue(A);

	}

	public void SelectByvisibleText(WebElement element, String text) {

		/**
		 * To select the text present in the drop down. An expectation for
		 * selecting the text from the drop down of an element present on the
		 * page.
		 * 
		 * @param element
		 *            the WebElement
		 * @Param text available to select is stored in a String
		 */

		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void ClearBrowserCache() throws InterruptedException {
		driver.manage().deleteAllCookies(); // delete all cookies
		Thread.sleep(5000); // wait 5 seconds to clear cookies.
	}

	public String checkTextValue(String Txtelement, String UIelement) {

		if (!(UIelement == Txtelement)) {

			String value = UIelement.trim().replaceFirst(UIelement, Txtelement);

			logger.log(LogStatus.PASS, value + "Values matched");
			return value;
		} else {
			logger.log(LogStatus.FAIL, Txtelement + "Values not matched");
			return UIelement;
		}
	}

	public static String convertStringDateToAnotherStringDate(String stringdate, String stringdateformat,
			String returndateformat) {

		try {
			Date date = new SimpleDateFormat(stringdateformat).parse(stringdate);
			String returndate = new SimpleDateFormat(returndateformat).format(date);
			return returndate;
		} catch (ParseException e) {

			e.printStackTrace();
			return "";
		}

	}
	
	public boolean selectOption(WebElement element, String optionToBeSelected) {

		int count = 0;
		select = new Select(element);
		// select.selectByVisibleText(optionToBeSelected);

		List<WebElement> options = select.getOptions();
		// System.out.println("Options size "+options.size());
		if (options.size() > 0) {
			for (WebElement option : options) {
				// System.out.println("selected options are :
				// "+option.getText());
				if (option.getText().equals(optionToBeSelected)) {
					option.click();
					return true;
				} else {
					count++;
				}
			}
			if (count == options.size()) {
				System.out.println(optionToBeSelected + " not available to select.");
				return false;
			}
		} else {
			System.out.println("No options available to select.");
		}
		return false;
	}
	
	

	/*
	 * @After public static void reportclosewindows() throws
	 * InterruptedException{
	 * 
	 * report.endTest(logger); report.flush(); Thread.sleep(2000);
	 * driver.quit();
	 * 
	 * }
	 */
	
	
	public String getValueFromExcel(String SheetName, String columnName) throws IOException {
		/**
		 * To get the test data from excel. Fetches the data from excel.
		 *
		 * @param Sheet
		 *            name is stored in string which gets changed for different
		 *            test data
		 * @Param The actual test data that needs to be retrieved.
		 * 
		 */
		String valueFromExcel= null;
		dataUtils = new DataUtils();
		dataUtils.setSheetName(SheetName);
		try {
			int i = 1;
			while (i <= dataUtils.noOfRows()) {
				dataUtils.getRowData(i);
				if (getData("RunThis").toLowerCase().equals("yes")) {
					valueFromExcel = (getData(columnName));
				} else {
					System.out.println("Skipped scenario : " + getData("ScenarioDescription"));
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("Exception occured during execution: " + e.getMessage());
			Assert.assertTrue(false);
		}
		
		return valueFromExcel;
	}


	public static void sleep(int timeInMillisecs) {
		try {
			Thread.sleep(timeInMillisecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Sleep in seconds
	public void sleepInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateObjectsDisplayedCount(String xPath, String msg) {
		try {
			
			int count=driver.findElements(By.xpath(xPath)).size();
			if (count!=0) {
				logger.log(LogStatus.PASS, msg + " is displayed");
				// Assert.assertTrue(true);
			}else{
				logger.log(LogStatus.PASS, msg + " is not displayed");
				System.out.println("Element found");
			}
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, msg + " is not displayed");
			/*String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
			String image = logger.addScreenCapture(Screenshotpath);
			logger.log(LogStatus.FAIL, image);*/
		}
	}
	
	
	

	public void select_submit(){
		WebElement element = Common.getObjectByXpath(".//*[@id='divC0_30']/span");
		try{
			if(element.isDisplayed()){
	            element.click();	
	            logger.log(LogStatus.INFO, "LOL:: Win Field: Selected submit from tool bar");
			}
			else{
				logger.log(LogStatus.INFO, "LOL:: Win Field: Submit not displayed in tool bar");
				
			}
		}
		catch(Exception e){
			logger.log(LogStatus.FAIL, "LOL:: Win Field: UNable To select Submit form in tool barr");
		}
		
	}
	
	
	public void validateObjectsNotDisplayed(String xPath, String msg) {
		try {
			if (getObjectByXpath(xPath).isDisplayed()) {
				logger.log(LogStatus.PASS, msg + " is not displayed");
				// Assert.assertTrue(true);
			}else{
				System.out.println("Element found");
			}
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, msg + " is displayed");
			/*String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
			String image = logger.addScreenCapture(Screenshotpath);
			logger.log(LogStatus.FAIL, image);*/
		}
	}
	
	

	// Check if alert exists
	public boolean ifAlertpresent() {
		try {
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}
	  public static boolean isAlertPresent() {
     	 
    	  boolean presentFlag = false;
    	 
    	  try {
    	 
    	   // Check the presence of alert
    	   Alert alert = driver.switchTo().alert();
    	   System.out.println("Alert present");
    	   // Alert present; set the flag
    	   presentFlag = true;
    	   String getAlert = alert.getText();
    	   logger.log(LogStatus.INFO, getAlert);
    	   System.out.println(getAlert);
    	   // if present consume the alert
    	   alert.accept();
    	 
    	  } catch (NoAlertPresentException ex) {
    		  System.out.println("Alert not present");
    	   // Alert not present
    	  // ex.printStackTrace();
    	  }
    	 
    	  return presentFlag;
    	 
    	 }
	// To Capture Screen Shot
	/*public static String CaptureScreenShot(WebDriver driver, String fileName) {
		// EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
		TakesScreenshot efwd = ((TakesScreenshot) driver);
		File src = efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./ScreenShotLib/" + fileName));
			// FileUtils.copyFile(src, new
			// File("./ScreenShotLib/"+System.currentTimeMillis()+fileName));
		} catch (Exception e) {

		}
		return screenshot+fileName+".jpg";
	}*/

	// TBD
	public void tableValue(String tableXpath, String keyFieldValue, String valueToCheck) throws InterruptedException 
	{
		element = driver.findElement(By.xpath(tableXpath));
		rows = element.findElements(By.tagName("tr"));
		for (int i = 2; i < rows.size(); i++) {
			if (getObjectByXpath(tableXpath, valueToCheck).equals(keyFieldValue)) {

			}
		}
	}

	// Check element present or not
	public boolean isExists(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isExists(String order_Confirmation_message) {
		
		try {
			return driver.findElement(By.xpath(order_Confirmation_message)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	// Handling alert to either accept or dismiss
	public boolean handleAlert(boolean acceptOrDismiss) {
		Alert alert = driver.switchTo().alert();
		if (acceptOrDismiss) {
			alert.accept();
			return true;
		}
		alert.dismiss();
		return false;
	}

	// Select the checkbox xpath
		public void selectCheckBoxx(String by) {

//			try {
//				
//				
//				if (driver.findElement(By.xpath(by)).getAttribute("checked").equals("true")) {
//					System.out.println("Checked already");
//					return true;
//				}
//			} catch (Exception e) {
				try {
					getObjectByXpath("//input[@name='"+by+"']","saveandSubmitButton").click();
					System.out.println("Checking now");
//					if (driver.findElement(By.xpath(by)).getAttribute("checked").equals("true")) {
//						System.out.println("Checking now");
//						return true;
//					}
				} catch (Exception e1) {
					System.out.println("Not Checking now");
				}
			//}
			//return false;
		}
	
	// Select the checkbox
	public boolean selectCheckBox(By by) {

		try {
			if (driver.findElement(by).getAttribute("checked").equals("true")) {
				System.out.println("Checked already");
				return true;
			}
		} catch (Exception e) {
			try {
				driver.findElement(by).click();
				if (driver.findElement(by).getAttribute("checked").equals("true")) {
					System.out.println("Checking now");
					return true;
				}
			} catch (Exception e1) {
				return false;
			}
		}
		return false;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public void waitForAlert(WebDriver driver) {
		int i = 0;
		while (i++ < 5) {
			try {
				// Alert alert = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}

	public String GenerateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}

	// Check if the Title.
	public boolean checkTitle(String title) {
		// System.out.println("Title is :"+driver.getTitle().trim());
		return driver.getTitle().trim().equals(title);
	}

	public boolean checkTitleContains(String title) {

		String pageTitle = this.getObjectById("PageTitleTop").getText().trim();
		System.out.println("Title is " + pageTitle);

		if (pageTitle == null || pageTitle.isEmpty())
			pageTitle = this.getObjectByName("PageTitleTop").getText().trim();

		if (pageTitle == null || !pageTitle.isEmpty())
			return pageTitle.toLowerCase().contains(title.toLowerCase());

		return pageTitle.toLowerCase().contains(title.toLowerCase());
	}

	// Save button in any page
	public void save() throws InterruptedException {
		WebElement saveButton = this.getObjectByXpath(".//*[@id='hc_OK']","saveButton");
		this.jsclick(saveButton);
	}

	// Save button in any page
	public void saveAS() throws InterruptedException {
		getObjectByXpath(".//*[@id='ibnSave']/span","saveAsButton").click();
	}

	// Click on Yes button of Warning dialogue box shown during the reboot of
	// device
	public void clickYes() throws InterruptedException {
		getObjectByXpath("//*[@id='warnDialog']/tbody/tr[2]/td[1]/input","ClickYesButton").click();

	}

	// Select button in any page
		public void select() {
			try{
			getObjectByXpath("//img[@name='hc_Select']","SelectButton").click();
			logger.log(LogStatus.PASS, "Clicked on Select button. ");
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "Clicked on Select button. Exception:"+e);
			}
		}

		

			// Form_Exit button in any page
				public void Form_Exit() {
					try{
					getObjectByXpath("//img[@id='FORM_EXIT_BUTTON']","FormExitButton").click();
					logger.log(LogStatus.PASS, "Clicked on FormExit button. ");
					}
					catch(Exception e)
					{
						logger.log(LogStatus.FAIL, "Clicked on Close button. Exception:"+e);
					}
				}
			
	// Search button in any page
	public void search() throws InterruptedException {
		getObjectByXpath("//input[@value='Search' and @class='FormButton']","SearchButton").click();
	}

	public void jsclick(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Find button in any page
		public void Find() {
			try{
			getObjectByXpath("//img[@name='hc_Find']","FindButton").click();
			logger.log(LogStatus.PASS, "Clicked on Find button.");
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "Clicked on Find button. Exception:"+e);
			}
		}
		// OK button in any page
				public void OK() {
					try{
					getObjectByXpath(".//img[@id='hc_OK']","OKButton").click();
					logger.log(LogStatus.PASS, "Clicked on OK button");
					}
					catch(Exception e)
					{
						logger.log(LogStatus.FAIL, "Clicked on OK button. Exception: "+e);
					}
				}
		
	// Cancel button in any page
	public void cancel() {
		try{
		getObjectByXpath("//img[@name='hc_Cancel']","CancelButton").click();
		logger.log(LogStatus.PASS, "Clicked on Cancel button.");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Clicked on Cancel button. Exception:"+e);
		}
	}

	
	
	// Back button in any page
	public void back() {
		try
		{
		getObjectByXpath("//a[@href='javascript:history.go(-1);']","BackButton").click();
		logger.log(LogStatus.PASS, "Clicked on Back button. ");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Clicked on Back button. Exception:"+e);
		}
	}

	// NA Home page
	public void home() {
		try{
			
		getObjectByLinkText("Home").click();
		logger.log(LogStatus.PASS, "Clicked on Home button. ");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Clicked on Home button. Exception:"+e);
		}
	}

	// Save and Acquire
	public void saveAndAcquire() throws InterruptedException {
		getObjectByXpath("//input[@value='Save & Acquire']","SaveandacquireButton").click();
	}
	
	// Save and Submit
	
	// Save and Release
	public void saveAndRelease() throws InterruptedException {
		getObjectByXpath("//input[@value='Save & Release']","saveandReleaseButton").click();
	}

	// Help Link
	public void help() {
		getObjectByLinkText("Help").click();
	}

	//switch to frame
	
	// Returns true if the element is present.
	public boolean isElementExist(String xpath, String msg) {

		this.changeTimeOut(5);
		try {
			driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath(xpath));
			} catch (Exception e1) {
				this.changeTimeOut(50);
				logger.log(LogStatus.FAIL, msg +" element not Displayed");
				return false;
			}
		}
		this.changeTimeOut(50);
		logger.log(LogStatus.PASS, msg +" element Displayed");
		return true;
	}

	// Change overall timeout settings
	public void changeTimeOut(int timeToWait) {
		driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
	}

	// Info page message comparison
	public boolean pageInfoBoxContains(String str) {

		WebElement wb = driver.findElement(By.id("InfoBox"));
		if (wb == null || !wb.isDisplayed()) {
			wb = driver.findElement(By.name("InfoBox"));
		}
		// System.out.println("info message "+wb.getText());
		return wb.getText().toLowerCase().contains(str.toLowerCase());

	}

	// Alert message comparison

	public boolean pageAlertBoxContains(String str) {
		try {
			WebElement wb = driver.findElement(By.xpath("//div[@class='alert_1']"));
			if (wb == null || !wb.isDisplayed()) {
				wb = driver.findElement(By.xpath("//div[@class='alert_1']"));
			}
			System.out.println("info message " + wb.getText());
			return wb.getText().trim().toLowerCase().contains(str.toLowerCase());
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	// Alert 2 message comparision

	public boolean pageAlert2BoxContains(String str) {
		try {
			WebElement wb = driver.findElement(By.xpath("//div[@class='alert_2']"));
			if (wb == null || !wb.isDisplayed()) {
				wb = driver.findElement(By.xpath("//div[@class='alert_2']"));
			}
			System.out.println("info message " + wb.getText());
			return wb.getText().trim().toLowerCase().contains(str.toLowerCase());
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	// Alert 3 message comparision

	public boolean pageAlert3BoxContains(String str) {
		try {
			WebElement wb = driver.findElement(By.xpath("//div[@class='alert_3']"));
			if (wb == null || !wb.isDisplayed()) {
				wb = driver.findElement(By.xpath("//div[@class='alert_3']"));
			}
			System.out.println("info message " + wb.getText());
			return wb.getText().trim().toLowerCase().contains(str.toLowerCase());
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	// Deselect multiple items

	public boolean deselectOptions(String optionName, String[] optionsToBeDeselected) {

		int count = 0;
	
		select = new Select(driver.findElement(By.name(optionName)));
		for (int i = 0; i < optionsToBeDeselected.length; i++) {
			select.deselectByVisibleText(optionsToBeDeselected[i]);
			count++;
		}
		if (count == optionsToBeDeselected.length) {
			return true;
		}
		return false;
	}

	public String selectOptionsInADropDown(String text, String elementforDropdown) throws InterruptedException {
		this.getObjectByXpath(elementforDropdown).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement clictheobject = getObjectByXpath(".//li//a[text()='" + text + "']",text);
		action.moveToElement(clictheobject).perform();
		action.moveToElement(clictheobject).click();
		clictheobject.click();
		Thread.sleep(2000);
		return text;
	}

	// Select multiple items in a dropdown.
	public boolean selectOptions(String optionName, String[] optionsToBeSelected) {

		int count = 0;
		select = new Select(driver.findElement(By.name(optionName)));
		for (int i = 0; i < optionsToBeSelected.length; i++) {
			// System.out.println("Options are "+optionsToBeSelected[i]);
			select.selectByVisibleText(optionsToBeSelected[i]);
			count++;
		}
		if (count == optionsToBeSelected.length) {
			return true;
		} else {
			return false;
		}
	}

	// Select drop down option. Gets option name and option to be selected
	public boolean selectOption(String optionName, String optionToBeSelected) {

		int count = 0;
		select = new Select(driver.findElement(By.className(optionName)));
		// select.selectByVisibleText(optionToBeSelected);

		List<WebElement> options = select.getOptions();
		// System.out.println("Options size "+options.size());
		if (options.size() > 0) {
			for (WebElement option : options) {
				// System.out.println("selected options are :
				// "+option.getText());
				if (option.getText().trim().equals(optionToBeSelected)) {
					option.click();
					return true;
				} else {
					count++;
				}
			}
			if (count == options.size()) {
				System.out.println(optionToBeSelected + " not available to select.");
				return false;
			}
		} else {
			System.out.println("No options available to select.");
		}
		return false;
	}

	
	// Select drop down option. Gets option name and option to be selected
		public void selectOptionXpath(String optionName, String optionToBeSelected) {

			int count = 0;
			select = new Select(driver.findElement(By.xpath(optionName)));
			// select.selectByVisibleText(optionToBeSelected);

			List<WebElement> options = select.getOptions();
			// System.out.println("Options size "+options.size());
			if (options.size() > 0) {
				for (WebElement option : options) {
					// System.out.println("selected options are :
					// "+option.getText());
					if (option.getText().trim().equals(optionToBeSelected)) {
						option.click();
						Common.sleep(2000);
						logger.log(LogStatus.PASS, "Option"+optionToBeSelected+"Selected");
					} else {
						count++;
					}
				}
				if (count == options.size()) {
					System.out.println(optionToBeSelected + " not available to select.");
					logger.log(LogStatus.FAIL, "Option"+optionToBeSelected+"not Selected");
				}
			} else {
				System.out.println("No options available to select.");
			}
			logger.log(LogStatus.FAIL, "Option"+optionToBeSelected+"not Selected");
		}
	
	// Get The count of options
	public int getOptionSize(String optionName) {

		select = new Select(driver.findElement(By.name(optionName)));
		// System.out.println("Option size is "+select.getOptions().size());
		return select.getOptions().size();
	}

	// page size option

	public void pageSizeOption(String number) {
		if (driver.findElements(By.name("pageSize")).size() > 0) {
			select = new Select(driver.findElement(By.name("pageSize")));
			select.selectByVisibleText(number);
		}
	}

	// Refresh current page
	public void refreshCurrentPage() {
		driver.navigate().refresh();
	}

	public WebElement emptyTaskNameField(WebElement fieldName) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", fieldName);

		return fieldName;

	}

	public int generateRandomNumber() {
		return generateRandomNumber(100, 1);
	}

	public int generateRandomNumber(int high, int low) {
		Random r = new Random();
		return r.nextInt(high - low) + low;
	}

	// Split a string
	public String[] splitSting(String toSplit) {
		return toSplit.trim().split("\\s*,\\s*");
	}

	// Return object with xpathKey. xpathKey is mentioned in the OR.properties
	public static WebElement getObjectByXpath(String xpathKey, String msg) throws InterruptedException {
		// Reporter.log("Trying to Find object having Xpath as :
		// "+xpathKey+"<br>");
		try {
			logger.log(LogStatus.PASS,msg);
			return driver.findElement(By.xpath(xpathKey));	
			
		} catch (Throwable t) {
			String screenshot_path= CaptureScreenShot(driver, msg);
			  String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Webelementnotfound",image);
			
			Reporter.log("Object having Xpath as " + xpathKey + " not found.");
			Assert.assertTrue(false, "Object having Xpath as " + xpathKey + " not found.");
			return null;
		}

	}
	
	public void xpathclick(String xpath, String msg)
	{
		driver.findElement(By.xpath(xpath)).click();
		logger.log(LogStatus.PASS, msg);
		
	}
	
	
	public void switchToframe(String framename) {
		driver.switchTo().frame(driver.findElement(By.id(framename)));
	}
	
	//switch out of frame
	public void switchOutframe() {
		driver.switchTo().defaultContent(); 
	}
	
	// Row_Exit button in any page
				public void Row_Exit() {
					try{
					getObjectByXpath("//img[@id='ROW_EXIT_BUTTON']").click();
					logger.log(LogStatus.PASS, "Clicked on Row_Exit");
					}
					catch(Exception e)
					{
						logger.log(LogStatus.FAIL, "RowExit - Object not Found"+e);
					}
				}
		

			
	
	// Save and Submit
			public void saveAndSubmit() {
				try{
				getObjectByXpath("//button[@name='0_136']").click();
				logger.log(LogStatus.PASS, "clicked on 'Save and Submit' button");
				}
				catch(Exception e)
				{
					logger.log(LogStatus.FAIL, "SaveandSubmit button - Object not Found"+e);
				}
			}

			// Close
					public void Close() {
						try{
						getObjectByXpath("//img[@name='hc_Close']").click();
						logger.log(LogStatus.PASS, "Clicked on Close button");
						}
						catch(Exception e)
						{
							logger.log(LogStatus.FAIL, "Close button - Object not Found"+e);
						}
					}
			
					//CloseOpenPage
					public void closeOpenPage() {
						try{
						getObjectByXpath(" .//*[@id='jdeclose_ena']").click();
						logger.log(LogStatus.PASS, "Clicked on Close button");
						}
						catch(Exception e)
						{
							logger.log(LogStatus.FAIL, "Close button - Object not Found"+e);
						}
					}
					
					// Save and close
					public void saveAndClose() {
						try{
						getObjectByXpath("//button[@id='C0_19']").click();
						logger.log(LogStatus.PASS, "Clicked on 'Save and closed' method");
						}
						catch(Exception e)
						{
							logger.log(LogStatus.FAIL, "SaveandClose button - Object not Found"+e);
						}
						
					}
					
			// Save and Continue
			public void saveAndContinue() {
				try {
				getObjectByXpath("//button[@name='0_20']").click();
				logger.log(LogStatus.PASS, "Clicked on 'Save and Continue' button");
				}
				catch(Exception e)
				{
					logger.log(LogStatus.FAIL, "SaveandContinue button - Object not Found"+e);
				}
			}
			// add button in any page
			public void add() {
				
				try{
				getObjectByXpath("//img[@name='hc_Add']").click();
				logger.log(LogStatus.PASS, "LOL::Selected: Add sign clicked");
				}
				catch(Exception e)
				{
					logger.log(LogStatus.FAIL, "Add button - Object not Found"+e);
				}
			}

	
	//Single Parameter getObjectByXpath
	public static WebElement getObjectByXpath(String xpathKey) {
		
		try {
			return driver.findElement(By.xpath(xpathKey));
			
		} catch (Throwable t) {
			Reporter.log("Object having Xpath as " + xpathKey + " not found.");
			Assert.assertTrue(false, "Object having Xpath as " + xpathKey + " not found.");
			return null;
		}

	}
	
	
	//compare
	  public void Compare(String str1,String msg,String Compstr){
	             
	              //String act_msg=driver.findElement(By.xpath(actual)).getText();
	              System.out.println(str1);
	            if(str1.equalsIgnoreCase(Compstr)){
	                    logger.log(LogStatus.PASS, msg + " is "+str1);
	                    System.out.println("Pass");
	              }
	              else{
	                    logger.log(LogStatus.FAIL, msg + " not displayed");
	                  /*  String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
	                    String image = logger.addScreenCapture(Screenshotpath);
	                    logger.log(LogStatus.FAIL, image);*/
	                   
	                    //logger.log(LogStatus.FAIL, Expected + "NoT Displayed ");     
	              }
	                                     
	        }
		
	

		
		//Verify the Section title
	    public void EqualIgnoreCase(String actual,String msg){
	                
	                String act_msg=driver.findElement(By.xpath(actual)).getText().trim();
	                System.out.println(act_msg);
	              if(act_msg.equalsIgnoreCase(msg)){
	                      logger.log(LogStatus.PASS, msg + " Page is Displayed ");
	                      System.out.println("Pass");
	                }
	                else{
	                      logger.log(LogStatus.FAIL, msg + " not displayed");
	                    /*  String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
	                      String image = logger.addScreenCapture(Screenshotpath);
	                      logger.log(LogStatus.FAIL, image);*/
	                      
	                      //logger.log(LogStatus.FAIL, Expected + "NoT Displayed ");      
	                }
	                                        
	          } 




	//clickbyxpath
	    public static void Clickbyxpath(String objects, String description,String testData){
	  try{
	        int count = driver.findElements(By.xpath(objects)).size();
	        if (count == 1) {
	                     driver.findElement(By.xpath(objects)).sendKeys(testData);;
	                     logger.log(LogStatus.PASS, "LOL:: Win Field: "+description);
	         } else {
	             logger.log(LogStatus.FAIL, description+"not displayed"); 
	     }        
	            } catch (AssertionError e ) {
	    logger.log(LogStatus.FAIL, description+"not displayed");
	   /* String Screenshotpath = ExtentReportNG.captureScreenshot(description);
	    String image = logger.addScreenCapture(Screenshotpath);
	    logger.log(LogStatus.FAIL, image);*/
	}
	}




	//Extract Text
	public static String ExtractText(String objects) {
	try {
	    
	  WebElement Exp_str=driver.findElement(By.xpath(objects));
	  String txt=Exp_str.getText();
	  System.out.println("id="+txt);
	  return txt;                            
	    
	    } catch (Exception e) {
	                  System.out.println(e);
	    }
	    return objects;
	}   
	

	//Inputbyxpath
	public void inputbyxpath(String objects, String description,String testData){
	try{
	  int count = driver.findElements(By.xpath(objects)).size();
	  if (count == 1) {
	               driver.findElement(By.xpath(objects)).sendKeys(testData);;
	               logger.log(LogStatus.PASS, "LOL:: Win Field: "+description);
	   } else {
	       logger.log(LogStatus.FAIL, " Add button is not displayed"); 
	}        
	      } catch (AssertionError e ) {
	logger.log(LogStatus.FAIL, " Add button is not displayed");
	/*String Screenshotpath = ExtentReportNG.captureScreenshot("AddButton");
	String image = logger.addScreenCapture(Screenshotpath);
	logger.log(LogStatus.FAIL, image);*/
	}
	}

	//Inputbyxpath Keys
	public static void inputbyxpath(String objects, String description,Keys testData){
	try{
	int count = driver.findElements(By.xpath(objects)).size();
	if (count == 1) {
	             driver.findElement(By.xpath(objects)).sendKeys(testData);;
	             logger.log(LogStatus.PASS, "LOL:: Win Field: "+description);
	 } else {
	     logger.log(LogStatus.FAIL, " Add button is not displayed"); 
	}        
	    } catch (AssertionError e ) {
	logger.log(LogStatus.FAIL, " Add button is not displayed");
	/*String Screenshotpath = ExtentReportNG.captureScreenshot("AddButton");
	String image = logger.addScreenCapture(Screenshotpath);
	logger.log(LogStatus.FAIL, image);*/
	}
	}



	//Extract attributevalue
	          public String ExtractAttributeValue(String objects) {
	           try {
	               
	                WebElement Exp_str=driver.findElement(By.xpath(objects));
	                String txt=Exp_str.getAttribute("value") ;
	              return txt;  
	                                         
	               
	                } catch (Exception e) {
	                              System.out.println(e);
	                }
	                return objects;
	    }   

public void ItemHelpwindow()
{
	java.util.Set<String> windows = driver.getWindowHandles();
	Iterator<String> itr = windows.iterator();

	//patName will provide you parent window
	String patName = itr.next();

	//chldName will provide you child window
	String chldName = itr.next();

	//Switch to child window
	driver.switchTo().window(chldName);
	String pagetitle = driver.getTitle();
	System.out.println(pagetitle);
	if(pagetitle.equalsIgnoreCase("Item Help"))
	{
		logger.log(LogStatus.PASS, "Item Help window is displayed");
	}
	else
	{
		logger.log(LogStatus.FAIL, "Item Help window is not displayed");
	}
	driver.close();
	//To come back to parent window
	driver.switchTo().window(patName);
}

	public void validatePageTitle(String pageName)
	{
		waitExplicitlyForPresence(".//span[text()='" + pageName + "']", 5);
		String title = driver.getTitle();
		if (title.contains(pageName)) {
			logger.log(LogStatus.PASS, title + " page is loaded successfully");
		} else {
			logger.log(LogStatus.FAIL, pageName + " page is not loaded instead user lands on "+title);
			captureSS("Page Navigation failed", LogStatus.FAIL);
		}
	}
	// Return object with class
	public WebElement getObjectByClass(String objectClass) {
		// Reporter.log("Trying to Find object having Class name as :
		// "+objectClass+"<br>");
		try {
			return driver.findElement(By.className(objectClass));
		} catch (Throwable t) {
			Reporter.log("Object having class name as " + objectClass + " not found." + "<br>");
			Assert.assertTrue(false, "Object having class name as " + objectClass + " not found.");
			return null;
		}
	}
	//validate the Pdf
	public boolean isFileDownloaded(String downloadPath, String fileName) {
	      boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    System.out.println(" Count :"+dir_contents.length);
	    System.out.println(dir_contents);
	          
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equalsIgnoreCase("fileName"))
	            System.out.println(dir_contents[i].getName());
	            return flag=true;
	            }
	 
	    return flag;
	}
	
	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	 
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}

public  static void ValidateTitle(String PageTitle)
{
	String title = driver.getTitle();
	if(title.contains(PageTitle))
	{
		System.out.println(PageTitle);
		logger.log(LogStatus.PASS,PageTitle+ "is displayed");
	}
	else
	{
		logger.log(LogStatus.FAIL,PageTitle+ "is not displayed");
	}
}
	// Return object with name
	public WebElement getObjectByName(String name) {
		// Reporter.log("Trying to Find object having name as : "+name+"<br>");
		try {
			return driver.findElement(By.name(name));
		} catch (Throwable t) {
			Reporter.log("Object having name as " + name + " not found." + "<br>");
			Assert.assertTrue(false, "Object having name as " + name + " not found.");
			return null;
		}
	}

	// Return object with id
	public WebElement getObjectById(String id) {
		// Reporter.log("Trying to Find object having ID as : "+id+"<br>");

		try {
			return driver.findElement(By.id(id));
		} catch (Throwable t) {
			Reporter.log("Object having id as " + id + " not found." + "<br>");
			Assert.assertTrue(false, "Object having id as " + id + " not found.");
			return null;
		}
	}

	// Return object with linkText
	public WebElement getObjectByLinkText(String linkText) {
		// Reporter.log("Trying to Find Link with the LinkText as :
		// "+linkText+"<br>");
		try {
			return driver.findElement(By.linkText(linkText));
		} catch (Throwable t) {
			Reporter.log("Link with the text " + linkText + " not found " + "<br>");
			Assert.assertTrue(false, "Link with the text " + linkText + " not found ");
			return null;
		}
	}

	// Return object with CSS selector
	public WebElement getObjectByCssSelector(String selector,String msg) {
		// Reporter.log("Trying to Find object having CssSelector as :
		// "+selector+"<br>");
		WebElement element;
		try {
		    element=driver.findElement(By.cssSelector(selector));
			logger.log(LogStatus.PASS, msg + " is displayed");
			return element;
		} catch (Throwable t) {
			Reporter.log("Object having CssSelector as " + selector + " not found" + "<br>");
			Assert.assertTrue(false, "Object having CssSelector as " + selector + " not found");
			return null;
		}
	}

	// Returns the default Password
	public String getDefaultPassword() {
		return "password";
	}

	// Returns the new password
	public String getNewPassword() {
		return "password1";
	}

	public void verifySortingOrder(String tableXpath, String columnName, boolean descOrder) throws InterruptedException {
		List<String> displayedNames = new ArrayList<String>();
		List<String> SortedNames = new ArrayList<String>();
		this.sleep(1000);
		WebElement tableType = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowElmt = tableType.findElements(By.xpath(tableXpath + "//tr"));

		String getData;
		this.sleep(1000);
		// System.out.println(rowElmt.size());

		List<WebElement> columnList = tableType.findElements(By.xpath(tableXpath + "//tr[1]/td"));
		// System.out.println(columnList);

		for (int j = 1; j <= columnList.size(); j++) {
			// System.out.println(common.getObjectByXpath(tableXpath+"//tr[1]/td["+j+"]").getText().trim());
			if (this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]",columnName).getText().trim().equals(columnName)) {
				for (int i = 3; i <= rowElmt.size(); i++) {

					getData = this.getObjectByXpath(tableXpath + "//tr[" + i + "]/td[" + j + "]",columnName).getText().trim();
					displayedNames.add(getData);
					SortedNames.add(getData);
					System.out.println(displayedNames);

				}
				break;
			} else {
				Reporter.log("column with the name " + columnName + " not found" + "<br>");
				Assert.fail("column with the name " + columnName + " not found");
			}

		}

		this.sleep(2000);
		List<String> sortingOperation = displayedNames;
		this.listSortEx(sortingOperation, descOrder);
		System.out.println(sortingOperation);
		try {
			Assert.assertEquals(SortedNames, sortingOperation);
			Reporter.log("Sort order is as expected" + "<br>");
		} catch (AssertionError e) {
			Reporter.log("Sort order is not as expected" + "<br>");
			Assert.fail("Sort order is not as expected", e);
			e.printStackTrace();
		}
	}

	public void listSortEx(List<String> list, final Boolean descOrder) {
		Collections.sort(list, new Comparator<String>() {

			public int compare(String o1, String o2) {
				if (descOrder) {
					return o2.compareTo(o1);
				} else {
					return o1.compareTo(o2);
				}
			}
		});
	}

	public boolean clickOnColumnNameToSort(String tableXpath, String columnName, boolean descOrder) throws InterruptedException {
		WebElement tableType = driver.findElement(By.xpath(tableXpath));
		// List<WebElement>
		// rowElmt=tableType.findElements(By.xpath(tableXpath+"//tr"));

		List<WebElement> columnList = tableType.findElements(By.xpath(tableXpath + "//tr[1]/td"));
		boolean Status = false;
		for (int j = 1; j <= columnList.size(); j++) {
			// System.out.println(common.getObjectByXpath(tableXpath+"//tr[1]/td["+j+"]").getText().trim());
			if (this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]",columnName).getText().trim().equals(columnName)) {
				if (descOrder && this.getObjectByXpath(tableXpath + "//tr[1]/td[1]//span//img[@ src='images/asc.gif']",columnName)
						.isDisplayed()) {
					this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]/a",columnName).click();
					Status = true;
				} else if (descOrder
						&& this.getObjectByXpath(tableXpath + "//tr[1]/td[1]//span//img[@ src='images/desc.gif']",columnName)
								.isDisplayed()) {
					Reporter.log(
							"column with the name " + columnName + " is already sorted in Descending order" + "<br>");
					Status = true;
				} else if (!descOrder
						&& this.getObjectByXpath(tableXpath + "//tr[1]/td[1]//span//img[@ src='images/desc.gif']",columnName)
								.isDisplayed()) {
					this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]/a",columnName).click();
					Status = true;
				} else if (!descOrder
						&& this.getObjectByXpath(tableXpath + "//tr[1]/td[1]//span//img[@ src='images/asc.gif']",columnName)
								.isDisplayed()) {
					Reporter.log(
							"column with the name " + columnName + " is already sorted in Ascending order" + "<br>");
					Status = true;
				}

				break;
			} else {
				Reporter.log("column with the name " + columnName + " not found" + "<br>");
				Status = false;
				Assert.fail("column with the name " + columnName + " not found");
			}

		}
		return Status;

	}

	public boolean checkExistenceOfOverridelink() {

		try {

			driver.findElement(By.id("overridelink")).isDisplayed();
			System.out.println(driver.findElement(By.id("overridelink")).isDisplayed());
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	public String GetRandomAlphaNumaricChar(int i) {

		String SALTCHARS = "AB123CDEFGHIJKLMNOPQRSTUVWXYZ8910";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < i) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		System.out.println(saltStr);
		return saltStr;

	}

	public String GetRandomNumarics(int i) {

		String SALTCHARS = "123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < i) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		System.out.println(saltStr);
		return saltStr;

	}

	public String GetRandomAlphaNumaricSpecialChar(int i) {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123.#@#@$$#";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < i) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		System.out.println(saltStr);
		return saltStr;

	}

	public String GetRandomIPv4(int min, int max) {
		StringBuilder sb = null;
		Random rand = new Random();

		int randomNum1 = rand.nextInt((max - 1) + 1) + min;
		int randomNum2 = rand.nextInt((max - 1) + 1) + min;
		int randomNum3 = rand.nextInt((max - 1) + 1) + min;
		int randomNum4 = rand.nextInt((max - 1) + 1) + min;

		String ip1 = Integer.toString(randomNum1);
		String ip2 = Integer.toString(randomNum2);
		String ip3 = Integer.toString(randomNum3);
		String ip4 = Integer.toString(randomNum4);
		sb = new StringBuilder();
		sb.append(ip1).append(".").append(ip2).append(".").append(ip3).append(".").append(ip4);
		return sb.toString();
	}

	public String GetRandomString() {
		// makes sure this method does not return
		// the same random string for successive
		// fast calls

		Random rand = new Random();
		char randChar1 = (char) (rand.nextInt(26) + 'a');
		char randChar2 = (char) (rand.nextInt(26) + 'a');
		int randNum1 = rand.nextInt(10000) + 1000;
		int randNum2 = rand.nextInt(10000) + 1000; // 1000-9999

		String TwoChar = new StringBuilder("").append(randChar1).append(randChar2).toString();

		String strRandom = TwoChar.toString() + "_" + randNum1 + "_" + randNum2;

		return strRandom;
	}

	public void uncheckAllCheckboxes(WebElement table) {

		// Find all the input tags inside the mainTable and save it to a list
		// List<WebElement> checkBoxes =
		// table.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> checkBoxes = table.findElements(By.xpath("//input[@type='checkbox']"));

		// iterate through the list of checkboxes and if checked, uncheck them
		for (WebElement checkbox : checkBoxes) {

			if (checkbox.isSelected()) {
				this.jsclick(checkbox);
				checkbox.click();
			}

		}
	}

	public void checkAllCheckboxes(WebElement table) {

		// Find all the input tags inside the mainTable and save it to a list
		List<WebElement> checkBoxes = table.findElements(By.xpath("//input[@type='checkbox']"));

		// iterate through the list of checkboxes and if uncheck , checked them
		for (WebElement checkbox : checkBoxes) {

			if (!checkbox.isSelected()) {
				// checkbox.click();
				this.jsclick(checkbox);
			}

		}
	}

	public boolean checkForExistenceOfAnElementInTable(String tableXpath, String columnName, String element) {

		WebElement tableType;
		try {
			this.pageSizeOption("All");
			this.sleep(3000);
			tableType = driver.findElement(By.xpath(tableXpath));

			List<WebElement> rowElmt = tableType.findElements(By.xpath(tableXpath + "//tr"));

			this.sleep(1000);
			// System.out.println(rowElmt.size());

			List<WebElement> columnList = tableType.findElements(By.xpath(tableXpath + "//tr[1]/td"));

			System.out.println(columnList);

			for (int j = 2; j <= columnList.size(); j++) {
				System.out.println(this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]",columnName).getText().trim());
				if (this.getObjectByXpath(tableXpath + "//tr[1]/td[" + j + "]",columnName).getText().trim().equals(columnName)) {
					for (int i = 2; i <= rowElmt.size(); i++) {

						System.out.println(this.getObjectByXpath(tableXpath + "//tbody//tr[" + i + "]/td[" + j + "]/a",columnName)
								.getText().trim());
						String actual = this.getObjectByXpath(tableXpath + "//tbody//tr[" + i + "]/td[" + j + "]/a",columnName)
								.getText().trim();
						// int check = actual.compareToIgnoreCase(element);
						if (actual.equalsIgnoreCase(element)) {
							return true;
							// common.getObjectByXpath(tableXpath+"//tbody//tr["+i+"]/td["+j+"]/a").click();
						}

					}
					break;
				} else {
					System.out.println(("column with the name " + columnName + " not found" + "<br>"));
					// Assert.fail("column with the name "+columnName+" not
					// found");
				}

			}
		} catch (Exception e1) {
			return false;
		}
		return false;

	}

	public void zoomIn() {
		// To zoom In page 4 time using CTRL and + keys.
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		}
	}

	public void zoomOut() {
		// To zoom out page 4 time using CTRL and - keys.
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		}
	}

	public void zoomdefault() {
		// To set browser to default zoom level 100%
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
	}

	// public void visable(String name){
	// WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	// .until(ExpectedConditions.presenceOfElementLocated(By.xpath(name)));
	// }
	public void clickable(String name) {

		WebDriverWait wait = new WebDriverWait(driver, 25);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(name)));
		element.click();

	}

	public void waitExplicitlyForClickable(String xPath, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	}
	
	public void waitExplicitlyForPresence(String xPath, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
	}
	public void waitExplicitlyForPageToLoad(String title, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void chromzoomOut() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		Thread.sleep(2000);
	}

	public void chromzoomIn() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_PLUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_PLUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_PLUS);
		Thread.sleep(2000);
	}

	public boolean PDP_validateObjectsDisplayed(String xPath, String msg) throws InterruptedException {
		try {
			if (getObjectByXpath(xPath,msg).isDisplayed() == true) {
				logger.log(LogStatus.PASS, msg + " is available");
				return true;
				// Assert.assertTrue(true);
			}
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, msg + " is not available");
			/*String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
			String image = logger.addScreenCapture(Screenshotpath);
			logger.log(LogStatus.FAIL, image);*/
		}
		return false;
	}

	public void validateObjectsDisplayed(String xPath, String msg) throws InterruptedException {
		try {
			if (getObjectByXpath(xPath,msg).isDisplayed() == true) {
				logger.log(LogStatus.PASS, msg + " is displayed");
				// Assert.assertTrue(true);
			}
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, msg + " is not displayed");
			/*String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
			String image = logger.addScreenCapture(Screenshotpath);
			logger.log(LogStatus.FAIL, image);*/
		}
	}

	public void validateObjectsDisplayed(By by, String msg) {
		try {
			if (driver.findElement(by).isDisplayed() == true) {
				logger.log(LogStatus.PASS, msg + " is displayed");
				// Assert.assertTrue(true);
			}
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, msg + " is not displayed");
			/*String Screenshotpath = ExtentReportNG.captureScreenshot(msg);
			String image = logger.addScreenCapture(Screenshotpath);
			logger.log(LogStatus.FAIL, image);*/
		}
	}
	
	public boolean validateObjectsDisplayedWOReport(String xPath, String msg) throws InterruptedException {
		try {
			if (getObjectByXpath(xPath,msg).isDisplayed() == true) {
				return true;
			}
		} catch (AssertionError e) {
			return false;
		}
		return false;
	}

	public static int getSizeOfElementsSelected(String xPath) {
		List<WebElement> elementCount = driver.findElements(By.xpath(xPath));
		return elementCount.size();
	}

	

	public int getIntegerFromString(String str) {
		return Integer.parseInt(str.replaceAll("[^0-9]", ""));
	}
	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	

	public void signOut() {
		driver.findElement(By.xpath(".//*[text()='Sign Out']")).click();
	}

	

	public void iconCheck(String icon, String previousDiv) {
		if (!(icon.equals("Contracted"))) {
			if (driver.findElement(By.xpath(".//*[@id='" + previousDiv + "']//*[contains(@src, '" + icon + "')]"))
					.isDisplayed() == true) {
				logger.log(LogStatus.PASS, icon + " icon is displayed");
			} else {
				captureSS(icon + " icon validation", LogStatus.FAIL);
				logger.log(LogStatus.FAIL, icon + " icon is not displayed");
			}
		} else {
			if (driver.findElement(By.xpath(".//*[@id='" + previousDiv + "']//*[contains(@src, '" + icon + "')]"))
					.isDisplayed() == true) {
				logger.log(LogStatus.PASS, "Contracted product icon is displayed");
			} else {
				captureSS("Contracted icon validation", LogStatus.FAIL);
				logger.log(LogStatus.FAIL, "Contracted product icon is not displayed");
			}
		}

	}

	public static void captureSS(String titleImg, LogStatus status) {
		/*String Screenshotpath = ExtentReportNG.captureScreenshot(titleImg);
		String image = logger.addScreenCapture(Screenshotpath);
		logger.log(status, image);*/
	}

	public void clickPDLinkwithProductNo(String prodNo) {
		int noOfProd = getSizeOfElementsSelected(".//*[contains(@id,'r1:0:pt1:lv1:') and contains(@id, ':pgl0')]");
		String prodNbrs;
		for (int i = 0; i < noOfProd; i++) {
			if (driver.findElement(By.id("r1:0:pt1:lv1:" + i + ":pgl23")).getText().contains(" (Replace ")) {
				continue;
			} else {
				prodNbrs = driver.findElement(By.xpath(".//*[@id='r1:0:pt1:lv1:" + i + ":pgl125']/tbody/tr/td[1]/span"))
						.getText();
				if (prodNbrs.contains(prodNo)) {
					actionMoveJSClick(
							driver.findElement(By.xpath("//a[@id='r1:0:pt1:lv1:" + i + ":cl15']")));
					return;
				}
			}
		}
	}
	
	public void actionMoveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
		act.build().perform();
	}

	public void actionMoveJSClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Actions act = new Actions(driver);
		act.moveToElement(element);
		act.build().perform();
	}
	public void jsScrollWindowDown() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,500)", "");
	}
	public void jsScrollWindowUp() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,-500)", "");
	}
	public void jsScrollPanelRight(String scrollpath, int position) throws InterruptedException {
		
		WebElement scollpanel=Common.getObjectByXpath(scrollpath,"Scrollpanelpath");
		Actions action = new Actions(driver);
		action.moveToElement(scollpanel).perform();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy("+position+",0)", "");
	}
	
public void jsScrollPanelLeft(String scrollpath, int position) throws InterruptedException {
		
		WebElement scollpanel=Common.getObjectByXpath(scrollpath,"Scrollpanelpath");
		Actions action = new Actions(driver);
		action.moveToElement(scollpanel).perform();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(
			    "document.getElementById('gvLocationHorizontalRail').scrollLeft += "+position+"", "");
		//executor.executeScript("window.scrollBy("+position+",0)", "");
	}

public void jsScrolltillelementview(String scrollpath) throws InterruptedException
{
	WebElement element = Common.getObjectByXpath(scrollpath,"elementtrageted");
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//Thread.sleep(500); 
}
	
	public void jsScrollWindowRight() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(500,0)", "");
	}
	public void jsScrollWindowLeft() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(-500,0)", "");
	}
	
	
	public boolean equalList(ArrayList<String> a, ArrayList<String> b) {
		if (a == null && b == null) {
			return true;
		}
		if ((a == null) && !(b == null) || !(a == null) && b == null) {
			return false;

		}
		Collections.sort(a);
		Collections.sort(b);
		
		if(a.equals(b))
		{
			logger.log(LogStatus.PASS, "Both lists are Equal");
			return true;
		}
		else{
		/*	String Screenshotpath = ExtentReportNG
					.captureScreenshot("Lists are not equal");

			String image = logger.addScreenCapture(Screenshotpath);

			logger.log(LogStatus.FAIL, image);*/

			logger.log(LogStatus.FAIL, "The two lists are not equal");
			
			return false;
		}
		
	}

	public void getProductsOnOrderModule()
	{
		
	}
	
	
	
	public ArrayList<String> getProductsInOrderModuleDtls(String msg) throws InterruptedException {
		String str = driver.findElement(By.xpath(".//*[@id='r1:0:pt1:r1:0:pgl32']/div[1]/span")).getText();
		int TotallineNumber = getIntegerFromString(str);
		ArrayList<String> productIDs = new ArrayList<String>();
		for (int i = 0; i <= TotallineNumber - 1; i++) {
			String temp = Common.getObjectByXpath("//div[@id='r1:0:pt1:r1:0:i3:"+i+":pgl69']/div[2]/span",msg).getText();
			productIDs.add(temp.replaceAll("# ", ""));
		}
		logger.log(LogStatus.PASS, "Products displayed in Products in Order module are "+productIDs);	
		System.out.println("Captured Product ids products in order module");
		return productIDs;
	}
	
	public void clickButton(String buttonName) throws InterruptedException {
		element = Common.getObjectByXpath("//button[text()='" + buttonName + "']",buttonName);
		if (element.isDisplayed()) {
			element.click();
			logger.log(LogStatus.PASS, buttonName + "button is clicked");
		}

		else {
			logger.log(LogStatus.FAIL, buttonName + "button is not displayed");
			captureSS("Button not displayed", LogStatus.FAIL);
		}
	}
	
	
	
	
	

	public void clickLinkByLinkText(String linkText) {
		driver.findElement(By.xpath(".//a[contains(text(),'" + linkText + "')]")).click();
		logger.log(LogStatus.INFO, linkText + " is clicked");
	}

	public void clickLinkByXPath(String xPath, String msg) {
		driver.findElement(By.xpath(xPath)).click();
		logger.log(LogStatus.INFO, msg);
	}

	
	public void moveToElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
	}
	public void moveToXPath(String xPath)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(xPath)));
		actions.build().perform();
	}
	public void clickByXPath(String xPath, String msg)
	{
		driver.findElement(By.xpath(xPath)).click();
		logger.log(LogStatus.INFO, msg + " is clicked");
	}
	public void clickByXPath(String xPath)
	{
		driver.findElement(By.xpath(xPath)).click();
	}
	public void clickById(String Id, String msg)
	{
		driver.findElement(By.id(Id)).click();
		logger.log(LogStatus.INFO, msg + " is clicked");
	}
	public void checkIconMessage(String message)
	{
		if (driver.findElement(By.xpath(".//*[contains(text(),'"+ message +")]")).isDisplayed())
		{
			logger.log(LogStatus.PASS, "Icon message is displayed as: \""+message+"\" as expected");
		}
		else
		{
			logger.log(LogStatus.PASS, "Icon message is displayed as: \""+message+"\" which is not as expected");
			captureSS("Icon message validation", LogStatus.FAIL);
		}		
	}
	
	
	
	public void verifyTextExists(String xPath, String txtToCheck)
	{
		String txt = driver.findElement(By.xpath(xPath)).getText();
		if(txt.contains(txtToCheck))
		{
			logger.log(LogStatus.PASS, "\"" + txtToCheck + "\" is displayed");
			System.out.println(txtToCheck + " is verified");
		}			
		else
		{
			logger.log(LogStatus.FAIL,  "\"" + txtToCheck + "\" is not displayed");
			System.out.println(txtToCheck + " is failed");
		}			
	}
	public void verifyTextExist(String xPath, String txtToCheck)
	{
		String txt = driver.findElement(By.xpath(xPath)).getText();
		if(txt.contains(txtToCheck))
		{
			logger.log(LogStatus.PASS, "\"" + txtToCheck + "\" is displayed");
			System.out.println(txtToCheck + " is verified");
		}			
		else
		{
			logger.log(LogStatus.FAIL,  "\"" + txtToCheck + "\" is not displayed");
			System.out.println(txtToCheck + " is failed");
		}			
	}
	public void verifyTextExists(String xPath, String txtToCheck, String msg)
	{
		String txt = driver.findElement(By.xpath(xPath)).getText();
		if(txt.contains(txtToCheck))
		{
			logger.log(LogStatus.PASS, "\"" + txtToCheck + "\" is displayed " + msg);
			System.out.println(txtToCheck + " is verified");
		}			
		else
		{
			logger.log(LogStatus.FAIL,  "\"" + txtToCheck + "\" is not displayed " + msg);
			System.out.println(txtToCheck + " is failed");
		}			
	}
	public void verifyBreadCrumb(String xPath, String breadCrumbTxts)
	{
		String txt = driver.findElement(By.xpath(xPath)).getText();
		String splitTxt[] = breadCrumbTxts.split(">");
		for(String i:splitTxt)
		{
			if(txt.contains(i))
			{
				logger.log(LogStatus.PASS,  "\"" + i + "\" is displayed in bread crumb");
			}
			else
			{
				logger.log(LogStatus.FAIL,  "\"" + i + "\" is not displayed in bread crumb");
			}
		}
	}
	public void verifyLinkWithNameExists(String xPath, String linkToCheck)
	{
		String isDisabled = driver.findElement(By.xpath(xPath)).getAttribute("disabled");
		if(isDisabled==null || isDisabled.equals("disabled"))
		{
			logger.log(LogStatus.PASS, "\"" + linkToCheck + "\" is enabled as link");
			System.out.println(linkToCheck + " is verified");
		}			
		else
		{
			logger.log(LogStatus.FAIL,  "\"" + linkToCheck + "\" is not enabled as link");
			System.out.println(linkToCheck + " is failed");
		}
	}
	public void verifyLinksInDropdown(String xPathToHover, String xPath, String txtToCheck)
	{
		moveToElement(driver.findElement(By.xpath(xPathToHover)));
		String txt[] = txtToCheck.split(":");
		for(String str:txt)
		{
			sleep(250);
			verifyTextExists(xPath, str, "in global dropdown");
		}
	}
	
	public void dropdown(String xpath,String value, String msg) throws InterruptedException
	{
		try{
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByValue(value);
		logger.log(LogStatus.PASS,msg);
		}
		 catch (Throwable t) {
				String screenshot_path= CaptureScreenShot(driver, msg);
				  String image= logger.addScreenCapture(screenshot_path);
				  //test.log(LogStatus.FAIL, "Payment AP11 Failed", image);
				logger.log(LogStatus.FAIL, "Webelementnotfound",image);
				
				Reporter.log("Object having Xpath as " + xpath + " not found.");
				Assert.assertTrue(false, "Object having Xpath as " + xpath + " not found.");
				
		 }	
	}
	public void SelectByVisible(String xpath,String value, String msg) throws InterruptedException
	{
		try{
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByValue(value);
		logger.log(LogStatus.PASS,msg);
		}
		 catch (Throwable t) {
				String screenshot_path= CaptureScreenShot(driver, msg);
				  String image= logger.addScreenCapture(screenshot_path);
				  //test.log(LogStatus.FAIL, "Payment AP11 Failed", image);
				logger.log(LogStatus.FAIL, "Webelementnotfound",image);
				
				Reporter.log("Object having Xpath as " + xpath + " not found.");
				Assert.assertTrue(false, "Object having Xpath as " + xpath + " not found.");
				
		 }	
	}
	public void jsScrollToElement(String xPath)
	{
		WebElement element = driver.findElement(By.xpath(xPath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		sleep(500); 
	}
	public void noOfLinksForXPath(String xPath, int noOfLinksToBeVerified)
	{
		int noOfLinks = Common.getSizeOfElementsSelected(xPath);
		if (noOfLinks == noOfLinksToBeVerified)
			logger.log(LogStatus.PASS, "All the left side links are displayed");
		else
		{
			logger.log(LogStatus.FAIL, "Some links are not displayed in the left side");
			Common.captureSS("Left side links not displayed", LogStatus.FAIL);
		}
	}
	public void getAttribute( String xpath, String value)
	{
		String Attribute = driver.findElement(By.xpath(xpath)).getAttribute("value");
		if(Attribute.contains(Attribute))
		{
			System.out.println(value+"="+Attribute);
			logger.log(LogStatus.PASS, value+"is displayed and validated");
		}
		else
		{
			logger.log(LogStatus.FAIL, value+"is not displayed and validated");
			Common.captureSS(value+"is displayed and validated", LogStatus.FAIL);
			
		}
		
		
	}
	public void ValidateActiveFlag( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("A"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Active flag ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Active flag does not contains"+text);
			Common.captureSS("Active flag does not contains"+text, LogStatus.FAIL);
			
		}
		
		
	}
	
	public void ValidateProdGrp( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("02"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "ProdGrp  ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "ProdGrp does not contains"+text);
			Common.captureSS("ProdGrp does not contains"+text, LogStatus.FAIL);
			
		}
		
		
	}
	public void ValidateDateInactive( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains(""))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Date Inactive field contain blank value");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Date Inactive field does not contain blank value");
			Common.captureSS("Date Inactive field is not blank", LogStatus.FAIL);
			
		}
		
		
	}
	public void ValidateCentury( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("20"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Century ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Century does not contain"+text);
			Common.captureSS("Century does not contain"+text, LogStatus.FAIL);
			
		}
		
		
	}
	public void ValidateFy( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("12"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Current Rebate Program Year ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Current Rebate Program Year should contain 12");
			Common.captureSS("Current Rebate Program Year  not contain"+text, LogStatus.FAIL);
			}
}
	
	public void ValidateFD( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("F"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "F/D ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "F/D field should conatin F");
			Common.captureSS("F/D field not contain"+""+text, LogStatus.FAIL);
			}
}

	public void CPPValidateFD( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("D"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "F/D ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "F/D field not contain"+""+text);
			Common.captureSS("F/D field not contain"+""+text, LogStatus.FAIL);
			}
}
	public void ValidateBaseCur( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("USD"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Base Curr = "+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Base Curr  not contain"+text);
			Common.captureSS("Base Curr not contain"+text, LogStatus.FAIL);
			}
}
	public void ValidateShortIemNumber( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("1236921"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Short Item number ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Short Item number does not contain"+text);
			Common.captureSS("Short Item number contain does not contain"+text, LogStatus.FAIL);
			
		}
		
	}
	public void ValidateShortIemNumberCPP( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains("1253133"))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Short Item number ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Short Item number does not contain"+text);
			Common.captureSS("Short Item number contain does not contain"+text, LogStatus.FAIL);
			
		}
		
	}
	public void ValidateDate( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String getdate = dateFormat.format(date);
		System.out.println("current date"+getdate);
		
		if(text.contains(getdate))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "DateUpdatedLast ="+""+text);
		}
		else
		{
			logger.log(LogStatus.FAIL, "DateUpdatedLast is same as current date"+text);
			Common.captureSS("DateUpdatedLast is same as current date"+text, LogStatus.FAIL);
			
		}
		
		
	}
	
	public void LastSeasonRebate( String xpath, String Value)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains(".0000" ))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Last Season"+Value+"="+text);
		}
		else if (text.contains(""))
		{
			System.out.println(text);
			logger.log(LogStatus.PASS, "Last Season"+Value+"contains"+text);
		}
		
		
		else
		{
			logger.log(LogStatus.FAIL, "Last Season"+Value+"does not contain .000 or blank");
			Common.captureSS("Last Season"+Value+"does not contain .000 or blank", LogStatus.FAIL);
		
		}
		}
	
	public void getTextByxpath( String xpath)
	{
		String text = driver.findElement(By.xpath(xpath)).getText();
		if(text.contains(text))
		{
			System.out.println(text+""+"is displayed");
			logger.log(LogStatus.PASS, text);
		}
		else
		{
			logger.log(LogStatus.FAIL, text+"not found");
			Common.captureSS(text+"not found", LogStatus.FAIL);
			
		}
		
		
	}
	
	
	
	public void validateLinkNavigation(String xPath, String pageToNavigate)
	{
		String str = pageToNavigate;
		WebElement element = driver.findElement(By.xpath(xPath));
		pageToNavigate = pageToNavigate + " | US Foods";
		moveToElement(element);
		jsScrollWindowUp();
//		jsScrollToElement(xPath);		
		if (element.isDisplayed())
		{
//			common.jsclick(driver.findElement(By.xpath(xPath)));
//			click able(xPath);
//			noOfLinksForXPath(oe.OE_LeftSideLinksAll, 5);
			element.click();
			sleep(1500);
//			if(pageToNavigate.equals("Our Exclusives | US Foods"))
//				sleep(1500);
			waitExplicitlyForPresence(".//span[text()='"+str+"']", 10);
			String title = driver.getTitle();
			if(title.contains(pageToNavigate))
			{
				logger.log(LogStatus.PASS,  "User landed on to \"" + pageToNavigate + "\" page");
				System.out.println("Verified: "+pageToNavigate);
			}				
			else{
				logger.log(LogStatus.FAIL,  "User not landed on to \"" + pageToNavigate + "\" page instead landed to "+title);
				System.out.println("FAILED: "+pageToNavigate);
			}
		}				
	}
	
	public void checkLoadingBar() {

		try {

			System.out.println("Progress indicatior is displayed...... "+driver.findElement(By.xpath("//td[@class='af_progressIndicator_indeterminate']")).isDisplayed());
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingMessageText")));
			System.out.println("Found loading.....");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}catch(Exception e) {

			e.printStackTrace();


		}
	}
public void logout() throws InterruptedException
{
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath(".//*[@id='userSessionDropdownArrow']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='signOutLinkDiv']/div[2]")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
}
public void enter() {

	Actions action=new Actions(driver);
	action.sendKeys(Keys.ENTER);
	action.build().perform();

}
public void ClickEnter() throws AWTException 
{
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
}
public void ClickDown() throws AWTException 
{
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	
}
public void validate_condition(String str1, String str2,String Pass_msg,String Fail_msg)
{
	if(str1.equalsIgnoreCase(str2))
	{
		logger.log(LogStatus.PASS, Pass_msg);
	}
	else
	{
		logger.log(LogStatus.FAIL, Fail_msg);
	}
}

public void dropdownSelect(String xpath, String text){
	WebElement dropdown = driver.findElement(By.xpath(xpath));
    Select dropdwn = new Select(dropdown);
    dropdwn.selectByVisibleText(text);
}


	
		public void ClickTab() throws AWTException 
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
		}
		
	
}
