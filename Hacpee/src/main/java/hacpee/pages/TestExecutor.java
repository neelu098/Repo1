package hacpee.pages;

	import java.io.File;
    import java.io.FileInputStream;
	import java.io.IOException;
import java.net.Socket;
import java.net.URL;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReporter;
	import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.utils.DataUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import TestUtills.DataUtils;

import cucumber.api.java.Before;


	public class TestExecutor {
		
	public static WebDriver driver = null;
	public static String userDir=System.getProperty("user.dir");
	public static DesiredCapabilities cap =null;
	public static Properties prop= new Properties();
	public  Map<String, String> map= new HashMap<String, String>();
	/*public static ExtentReports report;
	public static com.aventstack.extentreports.ExtentTest logger;*/
	public static  Common common=new Common(driver);
	public DataFormatter formatter = new DataFormatter();
	DateFormat dFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
	public String parent_window=null;	
	public static ExtentReports report;
	//public static ExtentReports report;
	public static ExtentTest logger;
	public static DataUtils dataUtils;
	public static DataUtils dataUtilsSheet;
	//public static Utills dataUtils;
	public FileInputStream file;
	public XSSFWorkbook book;
	public XSSFSheet sheet;  	
	public static String filePath;	
	
	
		
	
	
	
	public static void loadPropertiesFile() throws IOException
		{
			FileInputStream fn=null;
			fn= new FileInputStream( userDir + "/src/main/java/hacpee/config/Config.properties");		
			prop.load(fn);				
		}		
	
	public static void initialize() throws IOException, InterruptedException {
			
			loadPropertiesFile();
					
			if( prop.getProperty("browser", "Firefox").equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver","Broswer_Drivers\\geckodriver.exe");							
				driver = new FirefoxDriver();	
				 driver.manage().window().maximize();	
			 }
			
			else if(prop.getProperty("browser", "ie").equalsIgnoreCase("ie")){					
				 System.setProperty("webdriver.ie.driver","Broswer_Drivers\\IEDriverServer.exe");
		 	     driver=new InternetExplorerDriver();	
		 	     driver.manage().window().maximize();	
			 } 
			
			else if(prop.getProperty("browser", "edge").equalsIgnoreCase("edge")){					
				System.setProperty("webdriver.edge.driver","Broswer_Drivers\\MicrosoftWebDriver.exe"); 
				WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();	
			 } 
			
			
			else if(prop.getProperty("browser", "chrome").equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");
				 driver=new ChromeDriver();			 
				 driver.manage().deleteAllCookies();
				 driver.manage().window().maximize();			 			
			}
			else{
				System.out.println("No Run Environment Provided to Run The Scenarios");
			}
		
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);					
		 dataUtils = new DataUtils();	
	}	
		
		@SuppressWarnings("deprecation")
		public static void Oldinitialize() throws IOException, InterruptedException {
			
		//	if(driver ==null){   
				
				loadPropertiesFile();
				
				if( prop.getProperty("runEnv", "Local").equals("Local")){
					
				
				
				if( prop.getProperty("browser", "Firefox").equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.gecko.driver","Broswer_Drivers\\geckodriver.exe");
					//FirefoxProfile profile = new FirefoxProfile();
					//cap=DesiredCapabilities.firefox();						
					/*profile.setPreference("browser.download.dir", "C:\\Users\\EJ86026\\Desktop\\Project\\CASIS\\DataExportFromCAS");					
					profile.setPreference("browser.download.folderList", 2);
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 			 
					profile.setPreference( "browser.download.manager.showWhenStarting", false );
					profile.setPreference( "pdfjs.disabled", true );			*/
				//	cap.setCapability(FirefoxDriver.PROFILE, profile);			
					driver = new FirefoxDriver();
				//	cap.setBrowserName("firefox");
					//driver=new FirefoxDriver(cap);	
					//cap.setPlatform(Platform.ANY);
					//driver=new FirefoxDriver();														
				 }
				
				else if(prop.getProperty("browser", "ie").equalsIgnoreCase("ie")){					
					 System.setProperty("webdriver.ie.driver","Broswer_Drivers\\IEDriverServer.exe");
				     cap=DesiredCapabilities.internetExplorer();
			         cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				     cap.setCapability("nativeEvents", false);  
		             cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true); 		      
			         cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true); 					    
			         cap.setCapability("ignoreProtectedModeSettings", true); 
	         	     cap.setCapability("disable-popup-blocking", true); 
				     cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true); 
				     cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				     cap.setCapability("ignoreZoomSetting ", true);   
				     cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		             
		             cap.setJavascriptEnabled(true);
		             cap.setBrowserName("ie");
			 	     driver=new InternetExplorerDriver(cap);				    
				     cap.setPlatform(Platform.ANY);
				    // driver = new RemoteWebDriver(new URL("http://10.37.233.124:4444/wd/hub"), cap);							     
				 } 
				
				else if(prop.getProperty("browser", "chrome").equalsIgnoreCase("chrome")) {
					 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					//Add the WebDriver proxy capability.
					Proxy proxy = new Proxy();
					proxy.setHttpProxy("myhttpproxy:3337");
					capabilities.setCapability("proxy", proxy);
					//Add ChromeDriver-specific capabilities through ChromeOptions.
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-extensions");
				   //  options.addExtensions(new File("/path/to/extension.crx"));
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					//options.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension"));
					//ChromeDriver driver = new ChromeDriver(capabilities);
					 Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
				     System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	

					 	
					 cap=DesiredCapabilities.chrome();
					 cap.setBrowserName("chrome");
					 //ChromeDriver driver = new ChromeDriver(capabilities);
					 //driver.manage().window().maximize();
					 driver=new ChromeDriver(options);
					 //driver=new ChromeDriver();
					 cap.setPlatform(Platform.ANY);
					 driver.manage().deleteAllCookies();
					 driver.manage().window().maximize();
					 /*	driver.get("chrome://settings/clearBrowserData");
				 		try {
						Thread.sleep(2000);
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					 
					 driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
					 Thread.sleep(2000);*/
				} 
				}
				
				else if(prop.getProperty("runEnv", "Hub").equals("Hub")){
				     
				
		/// Use for Grid		
				
				if( prop.getProperty("browser", "Firefox").equalsIgnoreCase("Firefox")){
					FirefoxProfile profile = new FirefoxProfile();
					cap=DesiredCapabilities.firefox();						
					profile.setPreference("browser.download.dir", "C:\\Users\\EJ86026\\Desktop\\Project\\CASIS\\DataExportFromCAS");					
					profile.setPreference("browser.download.folderList", 2);
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 			 
					profile.setPreference( "browser.download.manager.showWhenStarting", false );
					profile.setPreference( "pdfjs.disabled", true );			
					cap.setCapability(FirefoxDriver.PROFILE, profile);			
					cap.setBrowserName("firefox");			
					cap.setPlatform(Platform.ANY);
					driver = new RemoteWebDriver(new URL("http://1plprdctsl01.main.usfood.com:4444/wd/hub"), cap);
					((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
					
				 } else if(prop.getProperty("browser", "ie").equalsIgnoreCase("ie")){	
				       cap=DesiredCapabilities.internetExplorer();			
				       cap.setPlatform(Platform.ANY);
				       driver = new RemoteWebDriver(new URL("http://1plprdctsl01.main.usfood.com:4444/wd/hub"), cap);
				       //((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				     
				 } else if(prop.getProperty("browser", "chrome").equalsIgnoreCase("chrome")) {				   		   
					 cap=DesiredCapabilities.chrome();
					 cap.setBrowserName("chrome");		
					 cap.setPlatform(Platform.LINUX);		
					 driver = new RemoteWebDriver(new URL("http://1plprdctsl01.main.usfood.com:4444/wd/hub"), cap);
					 //((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
					
					 
				}  
		
				    				     
					
			}
				
				else{
					System.out.println("No Run Environment Provided to Run The Scenarios");
				}
			
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);					
			 dataUtils = new DataUtils();	
		}	
		
		public String getData(String columnName) {
            return dataUtils.getMapValue(columnName);
     
		}
		
		
		
	}
	
	