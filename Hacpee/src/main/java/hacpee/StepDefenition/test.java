package hacpee.StepDefenition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;



import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.comparison.ImageDiff;
//import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import org.openqa.selenium.remote.RemoteWebDriver;

public class test {

	public static void main(String[] args) throws InterruptedException, IOException  {
		

		WebDriver driver = null;
		
		 System.setProperty("webdriver.chrome.driver", "Broswer_Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		  String browserName = caps.getBrowserName();
		  String browserVersion = caps.getVersion();
		  
		  String os = System.getProperty("os.name").toLowerCase();
		  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
		
		
		  System.setProperty("webdriver.gecko.driver","Broswer_Drivers\\geckodriver.exe");							
		  driver = new FirefoxDriver();
		
		  
		  Capabilities caps_1 = ((RemoteWebDriver) driver).getCapabilities();
		  String browserName_1 = caps_1.getBrowserName();
		  String browserVersion_1 = caps_1.getVersion();
		  
		  String os1 = System.getProperty("os.name").toLowerCase();
		  System.out.println("OS = " + os1 + ", Browser = " + browserName_1 + " "+ browserVersion_1);
		  
		  System.setProperty("webdriver.ie.driver","Broswer_Drivers\\IEDriverServer.exe");
	 	  driver=new InternetExplorerDriver();	
		  
	 	  Capabilities caps_2= ((RemoteWebDriver) driver).getCapabilities();
		  String browserName_2 = caps_2.getBrowserName();
		  String browserVersion_2 = caps_2.getVersion();
		  
		  String os2 = System.getProperty("os.name").toLowerCase();
		  System.out.println("OS = " + os2 + ", Browser = " + browserName_2 + " "+ browserVersion_2);
		  
		  System.out.println("All Properties: "+System.getProperties().toString());
		  
			
			  System.setProperty("webdriver.edge.driver",
			  "Broswer_Drivers\\MicrosoftWebDriver.exe"); driver = new EdgeDriver();
			  
			  Capabilities caps_3= ((RemoteWebDriver) driver).getCapabilities(); String
			  browserName_3 = caps_3.getBrowserName(); String browserVersion_3 =
			  caps_3.getVersion();
			  
			  String os3 = System.getProperty("os.name").toLowerCase();
			  System.out.println("OS = " + os3 + ", Browser = " + browserName_3 + " "+
			  browserVersion_3);
			 
		  
		
		/*  // Image verification by Sikuli and Ashot 
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "Broswer_Drivers\\chromedriver.exe"); driver = new ChromeDriver();
		 * driver.get("https://www.inviul.com");
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 * 
		 * //Get WebElement reference of logo WebElement logoElement =
		 * driver.findElement(By.xpath("//h1[@id='logo']//a//img"));
		 * 
		 * Thread.sleep(3000);
		 * 
		 * //Capture and store logo image Screenshot shot = new
		 * AShot().takeScreenshot(driver, logoElement); File file = new
		 * File(System.getProperty("user.dir")+"\\ImageFolder\\logo.png");
		 * System.out.println(file); ImageIO.write(shot.getImage(), "PNG", file);
		 * 
		 * 
		 * //Getting Expected Image BufferedImage expectedImg = ImageIO.read(file);
		 * 
		 * //Getting Actual Image BufferedImage actualImg = shot.getImage();
		 * 
		 * //Image Comparison ImageDiffer imgDiff = new ImageDiffer(); ImageDiff dif =
		 * imgDiff.makeDiff(expectedImg, actualImg); if(dif.hasDiff()){
		 * System.out.println("Both images are different"); }else {
		 * System.out.println("Both images are same"); }
		 * 
		 * driver.close(); driver.quit();
		 */
	}

}
