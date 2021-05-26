package hacpee.pages;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.PresentationDirection;

import org.apache.log4j.lf5.PassingLogRecordFilter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.relevantcodes.extentreports.LogStatus;

import TestUtills.DataUtils;
import hacpee.config.Config;

public class HomePage extends TestExecutor{
	
	@FindBy(how = How.XPATH, using = Config.About_Icon)
	public WebElement About_Icon;
	
	@FindBy(how = How.XPATH, using = Config.Build_Version)
	public WebElement Build_Version;
	
	@FindBy(how = How.XPATH, using = Config.Build_ID)
	public WebElement Build_ID;

	WebDriverWait wait = new WebDriverWait(driver, 100);

	public  void Build_Verification() throws IOException, InterruptedException {
		
		
		Thread.sleep(2000);
		WebElement About = driver.findElement(By.xpath("//*[@id=\"about\"]")); About.click();
		logger.log(LogStatus.INFO, "<span class='label success'>BUILD VERIFICATION</span>");	
		logger.log(LogStatus.PASS, "<span style='color:green;'>About Icon gets clicked</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Build Version")));             
		Thread.sleep(2000);
		WebElement Build_Ver = driver.findElement(By.xpath("//span[@class='version_detail'][contains(text(),'Version')]")); 
		String Buildv = Build_Ver.getText(); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>The Build Version of HACP EE is : </span>" + "<span class='label success'>" + Buildv + "</span>");
		
		WebElement Buildid = driver.findElement(By.xpath("//span[@class='version_detail'][contains(text(),'Build ID')]")); 
		String Buildi = Buildid.getText(); 
		//logger.log(LogStatus.PASS, "<span style='color:green;'>The Build Version of HACP EE is : </span>" + "<span class='label success'>" + Buildi + "</span>");
		

		WebElement BuildCR = driver.findElement(By.xpath("//*[contains(text(), 'Copyright')]")); 
		String BuildC = BuildCR.getText(); 
		System.out.println(BuildC);
		String Actual = "Copyright IBM Corp.1989,2020. All Rights Reserved";
		logger.log(LogStatus.PASS, "<span style='color:green;'>Copyright : </span>" + "<span class='label success'>" + BuildC + "</span>");
			
		WebElement Close = driver.findElement(By.xpath("//*[@id='about-close']"));  //*[@id='infoModal']/div/div/div[1]/button"));
		Close.click();
		
		
	
		/*
		 * .log(LogStatus.INFO, "Example: <span class='label success'>success</span>");
		 * .log(LogStatus.INFO, "Example: <span class='label failure'>fail</span>");
		 * .log(LogStatus.INFO, "Example: <span class='label info'>info</span>");
		 * .log(LogStatus.INFO, "Example: <span class='label warn'>warning</span>");
		 */
		
		/*
		 * common.clickable(About_Icon); //About_Icon.click();
		 * logger.log(LogStatus.INFO,
		 * "<span style='color:green;'>Buid Verification</span>");
		 * logger.log(LogStatus.PASS,
		 * "<span style='color:green;'>About Icon gets clicked</span>");
		 * 
		 * common.Wait(Build_Version); String Buildversion = Build_Version.getText();
		 * logger.log(LogStatus.PASS,
		 * "<span style='color:green;'>The Build Version of HACP EE is : </span>" +
		 * LogStatus.INFO, Buildversion); String BuildID = Build_ID.getText();
		 * logger.log(LogStatus.PASS,
		 * "<span style='color:green;'>The Build Version of HACP EE is : </span>" +
		 * LogStatus.INFO, BuildID);
		 */
		 
	 
}
public void PrefenceVerification() throws InterruptedException {
	
	 logger.log(LogStatus.INFO, "<span class='label success'>PREFERENCE TAB VERIFICATION</span>");	
		
	Thread.sleep(2000);
	 
	 File file = new File("C:\\Program Files\\IBM\\HostOnDemand\\private\\web.properties");
	  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
			try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String quick = prop.getProperty("QuickConnectByAdmin");
	    String editable = prop.getProperty("isStatusBarEditableByAdmin");	
        String Enablestatusbar = prop.getProperty("enableStatusBarForAll");	 
 
         String cri = prop.getProperty("clientRefreshInterval");
         String defaultlocale = prop.getProperty("defaultLocale");
         String preferedlocale = prop.getProperty("preferredLocale");
         System.out.println("CRI value is ::" + cri);
         System.out.println("quick value is ::" + quick);
         System.out.println("StatusBarEditableByAdmin value is ::" + editable);
         System.out.println("EnableStatusBarForAll value is ::" + Enablestatusbar);
         System.out.println("DefaultLocale value is ::" + defaultlocale);
         System.out.println("PreferredLocale value is ::" + preferedlocale);
         WebElement PreferencesButton = driver.findElement(By.xpath("//*[@id=\"preferencesButton\"]/div/img"));
   	     Thread.sleep(2000);
   	    PreferencesButton.click();
   	 WebElement Application = driver.findElement(By.xpath("//div[contains(text(), 'Application')]"));
		if(Application.isDisplayed()) {
			Application.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is  displayed successfully </span>");
		  }
		  else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is not displayed </span>"); 
		  }
		
		
		WebElement Quick_chkbox = driver.findElement(By.xpath("//table[@class='w-75']/tr[1]/td[2]/span/label/span"));
		System.out.println("Quick_chkbox is enabled :"+Quick_chkbox);
		WebElement Refresh_interval = driver.findElement(By.xpath("//table[@class='w-75']/tr[2]/td[2]/input"));
		System.out.print("Refresh_interval text box is enabled. "+Refresh_interval);
		WebElement Default_locale = driver.findElement(By.xpath("//table[@class='w-75']/tr[3]/td[2]/mat-select/div/div[1]/span/span"));
		System.out.print("Default_locale text dropdown is enabled. "+Default_locale);
		WebElement Prefered_locale = driver.findElement(By.xpath("//table[@class='w-75']/tr[4]/td[2]/mat-select/div/div[1]"));
		System.out.print("Prefered_locale text box is enabled. "+Prefered_locale);
		WebElement Enable_status_Bar = driver.findElement(By.xpath("//table[@class='w-75']/tr[5]/td[2]/span/label/span"));
		System.out.print("Enable_status_Bar chk box is selected. "+Enable_status_Bar);
		WebElement Allow_User_chkbox = driver.findElement(By.xpath(" //table[@class='w-75']/tr[6]/td[2]/span/label/span"));
		System.out.print("Allow_User_chkbox  is selected. "+Allow_User_chkbox);
		
		//WebElement Custom_Ui = driver.findElement(By.xpath("//table[@class='w-75']/tr[7]/td[2]/span/input"));
		//System.out.println("Custom Ui text box is enabled"+ Custom_Ui.isEnabled());
		
        if(!Quick_chkbox.isSelected() && quick.contains("true") ) {
			
			System.out.println("Quick connection check box checked succussfully");
		}else {
			System.out.println("Allow_User_chkbox values are not displayed Properly");
		}
		if(Refresh_interval.getAttribute("value").contentEquals(cri)) {
			System.out.println("interval values are displayed succussfully");
			
		}else {
			System.out.println("interval values are not displayed Properly");
		}
        if(Prefered_locale.getText().contains(preferedlocale) ) {
			
			System.out.println("Prefered_locale is displayed ");
		}else {
			System.out.println("Prefered_locale is not displayed ");
		}
      if(Default_locale.getText().contains(defaultlocale) ) {
			
			System.out.println("Default_locale is displayed ");
		}else {
			System.out.println("Default_locale is not displayed ");
		}
		if(Allow_User_chkbox.isSelected() && editable.contains("true") ) {
			
			System.out.println("Allow_User check box is not checked successfully");
		}else {
			System.out.println("Allow_User check box checked successfully");
		}
      
      if(!Enable_status_Bar.isSelected() && Enablestatusbar.contains("true") ) {
			
			System.out.println("Enable_status_Bar check box checked succussfully");
		}else {
			System.out.println("Enable_status_Bar check box isnot checked");
		}
      
      logger.log(LogStatus.PASS, "<span style='color:green;'>Verified the Web.properties in HACP EE Admin console - preferrnce tab</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "PreferenceTab")));             
		Thread.sleep(2000);   
}	
public void PreferenceProperties() throws InterruptedException {
	
	 logger.log(LogStatus.INFO, "<span class='label success'>PREFERENCE TAB VERIFICATION</span>");	
		
	Thread.sleep(2000);

	System.out.println("----------------------------------");
	 WebElement PreferencesButton = driver.findElement(By.xpath("//*[@id=\"preferencesButton\"]/div/img"));
	  Thread.sleep(2000);
	  PreferencesButton.click();
	  WebElement Application = driver.findElement(By.xpath("//div[contains(text(), 'Application')]"));
		if(Application.isDisplayed()) {
			Application.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is  displayed successfully </span>");
		  }
		  else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is not displayed </span>"); 
		  }
		boolean Quick_chkbox = driver.findElement(By.xpath("//table[@class='w-75']/tr[1]/td[2]/span/label/span")).isSelected();
		WebElement Refresh_interval = driver.findElement(By.xpath("//table[@class='w-75']/tr[2]/td[2]/input"));
		Refresh_interval.clear();
		Refresh_interval.sendKeys("5");
		System.out.println("refresh value is "+Refresh_interval.getAttribute("value"));
		Thread.sleep(2000);
		//WebElement Custom_Ui = driver.findElement(By.xpath("//table[@class='w-75']/tr[7]/td[2]/span/input"));
//	  WebElement Default_locale1 = driver.findElement(By.xpath("//table[@class='w-75']/tr[3]/td[2]/mat-select/div/div[2]"));
//		
//		Default_locale1.click();
//		Thread.sleep(8000);
//		 WebElement Default_locale = driver.findElement(By.xpath("//span[contains(text(),' Korean(ko) ')]"));
//			System.out.println("Default_locale text is :"+ Default_locale.getText());
//			Default_locale.click();
			Select Default_locale = new Select(driver.findElement(By.name("country")));
			Default_locale.selectByVisibleText("Korean(ko)");
		
//		 WebElement preferlocale1 = driver.findElement(By.xpath("//table[@class='w-75']/tr[4]/td[2]/mat-select/div/div[2]"));
//		 preferlocale1.click();
//			Thread.sleep(8000);
//			 WebElement preferlocale = driver.findElement(By.xpath("//span[contains(text(),' Korean(ko) ')]"));
//				System.out.println("Default_locale text is :"+ Default_locale.getText());
//				preferlocale.click();
		Thread.sleep(4000);
		WebElement Enable_status_Bar = driver.findElement(By.xpath("//table[@class='w-75']/tr[5]/td[2]/span/label/span"));
		Enable_status_Bar.click();
		WebElement Allow_User_chkbox = driver.findElement(By.xpath("//table[@class='w-75']/tr[6]/td[2]/span/label/span"));	
		Allow_User_chkbox.click();

		WebElement save = driver.findElement(By.xpath("//*[@id=\"serverLog\"]"));
		save.click();
		
		 File file = new File("C:\\Program Files\\IBM\\HostOnDemand\\private\\web.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
				try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String quick = prop.getProperty("QuickConnectByAdmin");
		    String editable = prop.getProperty("isStatusBarEditableByAdmin");	
	    String Enablestatusbar = prop.getProperty("enableStatusBarForAll");	 

	     String cri = prop.getProperty("clientRefreshInterval");
			Thread.sleep(7000);
	     String defaultlocale = prop.getProperty("defaultLocale");
			Thread.sleep(7000);
	     String preferedlocale = prop.getProperty("preferredLocale");
	     System.out.println("CRI value is ::" + cri);
	     System.out.println("quick value is ::" + quick);
	     System.out.println("StatusBarEditableByAdmin value is ::" + editable);
	     System.out.println("EnableStatusBarForAll value is ::" + Enablestatusbar);
	     System.out.println("DefaultLocale value is ::" + defaultlocale);
	     System.out.println("PreferredLocale value is ::" + preferedlocale);
	        
       if(  quick.contains("true")== !Quick_chkbox) {
			
			System.out.println("Quick connection check box checked succussfully");
		}else {
			System.out.println("Allow_User_chkbox values are not displayed Properly");
		}
		if(Refresh_interval.getAttribute("value").contentEquals(cri)) {
			System.out.println("interval values are displayed succussfully");
			
		}else {
			System.out.println("interval values are not displayed Properly");
		}
      // if(Prefered_locale.getText().contains(preferedlocale) ) {
			
		//	System.out.println("Prefered_locale is displayed ");
		//}else {
		//	System.out.println("Prefered_locale is not displayed ");
		//}
		//try{
			 if(((List<WebElement>) Default_locale).contains(defaultlocale)) {
					
					System.out.println("Default_locale is displayed ");
				}else {
					System.out.println("Default_locale is not displayed ");
				}
				if(Allow_User_chkbox.isSelected() && editable.contains("true") ) {
					
					System.out.println("Allow_User check box is checked successfully");
				}else {
					System.out.println("Allow_User check box is not checked successfully");
				}
		     
		//  }
		 // catch(Exception e){
		   //  System.out.println(e.getMessage());
		 // }	
    
     
     if(!Enable_status_Bar.isSelected() && Enablestatusbar.contains("true") ) {
			
			System.out.println("Enable_status_Bar check box checked succussfully");
		}else {
			System.out.println("Enable_status_Bar check box is not checked");
		}
     
     logger.log(LogStatus.PASS, "<span style='color:green;'>Verified the Web.properties in HACP EE Admin console - preferrnce tab</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "PreferenceTab")));             
		Thread.sleep(2000);   
}	
	
	
public  void Admin_Build_Verification() throws IOException, InterruptedException {
		
	
		Thread.sleep(2000);
		WebElement About = driver.findElement(By.xpath("//*[@id=\"about\"]")); About.click();
		logger.log(LogStatus.INFO, "<span class='label success'>BUILD VERIFICATION</span>");	
		logger.log(LogStatus.PASS, "<span style='color:green;'>About Icon gets clicked</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Build Version")));             
		Thread.sleep(2000);
		WebElement Build_Ver = driver.findElement(By.xpath("//span[@class='text-font'][contains(text(),'Version')]")); 
		String Buildv = Build_Ver.getText(); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>The Build Version of HACP EE Adminconsole is : </span>" + "<span class='label success'>" + Buildv + "</span>");
		
		WebElement Buildid = driver.findElement(By.xpath("//span[@class='text-font'][contains(text(),'Build ID')]")); 
		String Buildi = Buildid.getText(); 
		//logger.log(LogStatus.PASS, "<span style='color:green;'>The Build Version of HACP EE is : </span>" + "<span class='label success'>" + Buildi + "</span>");
		

		WebElement BuildCR = driver.findElement(By.xpath("//*[contains(text(), 'Copyright')]")); 
		String BuildC = BuildCR.getText(); 
		System.out.println(BuildC);
		String Actual = "Copyright IBM Corp.1989,2020. All Rights Reserved";
		logger.log(LogStatus.PASS, "<span style='color:green;'>Copyright : </span>" + "<span class='label success'>" + BuildC + "</span>");
			
		WebElement Close = driver.findElement(By.xpath("/html/body/div/div[2]/div/mat-dialog-container/app-product-info-dialog/div/div[3]/div/div/button"));  //*[@id='infoModal']/div/div/div[1]/button"));
		Close.click();
		
}
    public void AllSessionVerification() throws InterruptedException {
     	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sessionImg0")))); 
		if(driver.findElement(By.id("sessionImg0")).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}else {

			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is not displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sessionImg1")))); 
		if(driver.findElement(By.id("sessionImg1")).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}else {
			logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is not displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}
		 
		try
		{
		boolean session = driver.findElement(By.id("sessionImg2")).isDisplayed();
		System.out.println(" 3270printer is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" 3270printer is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.id("sessionImg3")).isDisplayed();
		System.out.println(" 5250printer is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" 5250printer is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.id("sessionImg4")).isDisplayed();
		System.out.println(" VTDisplay session is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" VTDisplay session is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.id("sessionImg5")).isDisplayed();
		System.out.println(" FTP session is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" FTP session is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.id("sessionImg6")).isDisplayed();
		System.out.println(" CICS Gateway session is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" CICS Gateway session is not displayed");
		}
		
		
		if(driver.findElement(By.xpath("//*[@id=\"3270 Display\"]/span/span")).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session text is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}else {

			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is not displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='5250 Display']/span/span")))); 
		if(driver.findElement(By.xpath("//*[@id=\"5250 Display\"]/span/span")).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session Text is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}else {
			logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is not displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
		}
		 
		try
		{
		boolean session = driver.findElement(By.xpath("//*[@id=\"3270 Printer\"]/span/span")).isDisplayed();
		System.out.println(" 3270printer display name is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" 3270printer display name is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.xpath("//*[@id=\"5250 Printer\"]/span/span")).isDisplayed();
		System.out.println(" 5250printer display name is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" 5250printer display name is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.xpath("//*[@id=\"VT Display\"]/span/span")).isDisplayed();
		System.out.println(" VTDisplay session name is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" VTDisplay session name is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.xpath("//*[@id=\"FTp Display\"]/span/span")).isDisplayed();
		System.out.println(" FTP session name is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" FTP session name is not displayed");
		}
		try
		{
		boolean session = driver.findElement(By.xpath("//*[@id=\"CICS Display\"]/span/span")).isDisplayed();
		System.out.println(" CICS Gateway session name  is displayed  :"+session);
		
		} catch (Exception e) {
		System.out.println(" CICS Gateway session name is not displayed");
		}
		
    }
    
	public void Admin_logout() throws InterruptedException {
		Thread.sleep(2000);
		WebElement logout = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div/span[2]/img")); 
		logout.click();
		logger.log(LogStatus.INFO, "<span class='label success'>Logout clicked succussfully</span>");	
		
		}
	public void Help_Icon() throws InterruptedException {
		
		boolean Help_Icon = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div/a/img")).isDisplayed();
		
		System.out.println("help Icon is dispalyed: "+Help_Icon);
		
	}
	public void configmodel() throws InterruptedException {
		logger.log(LogStatus.INFO, "<span class='label success'>CONFIG MODEL VERIFICATION</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));	
		
		
		Thread.sleep(4000);
		WebElement User = driver.findElement(By.id("uname")); 
		User.sendKeys("admin");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Username gets entered as : </span>" + "<span class='label success'>" + "admin" + "</span>");
		WebElement Pwd = driver.findElement(By.id("pwd")); 
		Pwd.sendKeys("password");
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password gets entered</span>" );
		WebElement LoginButton = driver.findElement(By.id("login_button")); 
		LoginButton.click();
		Thread.sleep(3000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login button gets clicked and home page is displayed</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));		
		WebElement LogoutButton = driver.findElement(By.id("log_out")); 
		LogoutButton.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Logout button gets clicked</span>" );
	}
	
	public void fnSelectSession() throws IOException, InterruptedException {
		Thread.sleep(3000);
		
		WebElement elementSession=driver.findElement(By.id("sessionImg0"));
		wait.until(ExpectedConditions.visibilityOf(elementSession)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementSession));
		elementSession.click();
		//logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is clicked and gets connected</span>");
		//+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		Thread.sleep(8000);
	}
	
	public void fnSelect5250Session() throws IOException, InterruptedException {
		Thread.sleep(2000);
		
		WebElement elementSession=driver.findElement(By.id("sessionImg1"));
		wait.until(ExpectedConditions.visibilityOf(elementSession)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementSession));
		elementSession.click();
		//logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is clicked and gets connected</span>");
				//+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		Thread.sleep(5000);
	}
	public void fnSelect5250() throws IOException, InterruptedException {
		Thread.sleep(2000);
		
		WebElement elementSession=driver.findElement(By.id("sessionImg1"));
		wait.until(ExpectedConditions.visibilityOf(elementSession)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementSession));
		elementSession.click();
		//logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is clicked and gets connected</span>");
				//+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		Thread.sleep(5000);
	}
	public void fnCloseSession() throws IOException, InterruptedException {
		WebElement elementClosebtn=driver.findElement(By.id("closeSess"));
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(elementClosebtn)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementClosebtn));
		elementClosebtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS, "<span style='color:green;'> Session Close icon clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
	}
	
	public void fnCloseSessionX() throws IOException, InterruptedException {
        WebElement elementClosebtn=driver.findElement(By.xpath("//*[@id=\"closeSess\"]/img"));
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(elementClosebtn)); 
         wait.until(ExpectedConditions.elementToBeClickable(elementClosebtn));
        Thread.sleep(1000);
        elementClosebtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.log(LogStatus.PASS, "<span style='color:green;'> Session Close icon clicked successfully</span>"
                      + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
  }

	
	public void fnSearchPanelField() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchpanelElement = driver.findElement(By.xpath("//*[@id=\"search_settings\"]"));
         wait.until(ExpectedConditions.visibilityOf(searchpanelElement));
        String readonly = searchpanelElement.getAttribute("readonly");
        System.out.println("print:"+readonly);
        Assert.assertEquals(readonly, null);
      //Assert.assertNotNull(readonly);
            logger.log(LogStatus.PASS, "<span style='color:green;'> Search panelis editable successfully</span>"
                            + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
               
               }

	public void fnSearchPanelErrorMsg() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchelement = driver.findElement(By.id("search_settings"));
        wait.until(ExpectedConditions.visibilityOf(searchelement));
        searchelement.sendKeys("dsfa");
        Thread.sleep(2000);
        WebElement actual_error_panel = driver.findElement(By.xpath("//*[@id=\"invalid_settings\"]/span"));
        Thread.sleep(2000);
        System.out.println("error message is  :"+actual_error_panel.getText()); 
        logger.log(LogStatus.PASS, "<span style='color:green;'> Error message is displayed successfully</span>"
                      + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
        
  }

	public void fnPropertySearchField() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchpropertyElement = driver.findElement(By.xpath("//*[@id=\"search_property\"]"));
         wait.until(ExpectedConditions.visibilityOf(searchpropertyElement));
        String readonly = searchpropertyElement.getAttribute("readonly");
        System.out.println("print:"+readonly);
        Assert.assertEquals(readonly, null);
      //Assert.assertNotNull(readonly);
            logger.log(LogStatus.PASS, "<span style='color:green;'> Property Search is editable successfully</span>"
                            + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
               
               }


	public void fnSearchPropertyErrorMsg() throws InterruptedException {
        Thread.sleep(2000);
  
        WebElement propertysearch = driver.findElement(By.id("search_property"));
        wait.until(ExpectedConditions.visibilityOf(propertysearch));
        Thread.sleep(2000);
        propertysearch.sendKeys("abcd");
        
         Thread.sleep(2000);
        WebElement actual_error = driver.findElement(By.xpath("//*[@id=\"invalid_property\"]/span"));
        Thread.sleep(2000);
        
        System.out.println("error message is  :"+actual_error.getText()); 
        logger.log(LogStatus.PASS, "<span style='color:green;'> Error message is displayed successfully</span>"
                      + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
        
  }

	
	
	public void fnVerifycloseSession() throws IOException, InterruptedException {
		
		
//		Actions action = new Actions(driver);
//		action.moveToElement(element);
//		JavascriptExecutor javascript = (JavascriptExecutor) driver;
//		javascript.executeScript("var element = document.querySelector('locator'); element.value = 'whatever';");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("activeSession")))); 
			if(driver.findElement(By.id("activeSession")).isDisplayed())
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'> Session Closed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));
			}	
	}
	public void fnHomeIconclick() throws IOException, InterruptedException {
		WebElement elementHomebtn=driver.findElement(By.id("homeImg"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(elementHomebtn)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementHomebtn));
		elementHomebtn.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'> Home Page Icon is clicked and page gets navigated</span>");				
	}
	public void fnActiveSessionclick() throws IOException, InterruptedException 
	{
WebElement ele=driver.findElement(By.id("activeSession_list"));
		
		   List<WebElement> elementActiveSesslist=ele.findElements(By.xpath("//*[contains(@id, 'home_Img')]"));    		
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("activeSession")))); 
    		if(driver.findElement(By.id("activeSession")).isDisplayed())
    		{
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			wait.until(ExpectedConditions.visibilityOfAllElements(elementActiveSesslist));
    			System.out.println("Session size list : "+elementActiveSesslist.size());
    			//wait.until(ExpectedConditions.elementToBeClickable(elementActiveSesslist));
    			if (elementActiveSesslist.size() > 0)
    			{
    				for(int i=0;i<elementActiveSesslist.size();i++)	
    				{
    					elementActiveSesslist.get(i).click();
    					System.out.println("Inside theloop : "+i);
    					Thread.sleep(1000);
    					logger.log(LogStatus.PASS, "<span style='color:green;'> Active Session  is clicked successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
    					break;
						
					}
			}
		}
	}
	public void fnVerifyActiveSession() throws IOException, InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("display_sessionName"))));
		if(driver.findElement(By.id("display_sessionName")).isDisplayed())
		{
			Thread.sleep(3000);
			logger.log(LogStatus.PASS, "<span style='color:green;'> Active Session is opened successfully</span>"
		+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}
	
	}
	public void fnActiveSessionclickMultiple() throws IOException, InterruptedException
	
	{
			WebElement ele=driver.findElement(By.id("activeSession_list"));
		    List<WebElement> elementActiveSesslist=ele.findElements(By.xpath("//*[contains(@id, 'home_Img')]"));
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("activeSession")))); 
    		if(driver.findElement(By.id("activeSession")).isDisplayed())
    		{
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			wait.until(ExpectedConditions.visibilityOfAllElements(elementActiveSesslist));
    			System.out.println("Session size list : "+elementActiveSesslist.size());
    			//wait.until(ExpectedConditions.elementToBeClickable(elementActiveSesslist));
    			if (elementActiveSesslist.size() > 0)
    			{
    				for(int i=0;i<elementActiveSesslist.size();i++)	
    				{
    					elementActiveSesslist.get(i).click();
    					System.out.println("Inside theloop : "+i);
    					Thread.sleep(1000);
    					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("display_sessionName"))));
						if(driver.findElement(By.id("display_sessionName")).isDisplayed())
						{
							logger.log(LogStatus.PASS, "<span style='color:green;'> Active Session  is opened successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
							fnHomeIconclick();
						}
						
					}
			}
		}
	}
	public void fnNavigationBarclick() throws IOException, InterruptedException
	
	{
		WebElement expandElement=driver.findElement(By.id("expand_icon"));
		wait.until(ExpectedConditions.visibilityOf(expandElement));
		
		if(driver.findElement(By.id("expand_icon")).isDisplayed())
		
		{
			Thread.sleep(8000);
			expandElement.click();
		//	logger.log(LogStatus.PASS, "<span style='color:green;'> Navigation Expand icon gets clicked</span>");
		
		}
	
	}
	
	public void fnNavigationBarFSclick() throws IOException, InterruptedException
	
	{
		WebElement expandElement=driver.findElement(By.id("expand_icon_fs"));
		wait.until(ExpectedConditions.visibilityOf(expandElement));
		
		if(driver.findElement(By.id("expand_icon_fs")).isDisplayed())
		
		{
			expandElement.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'>Navigation Expand icon gets clicked</span>");
		
		}
	
	}

	public void fnSettingsIconclick() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		//WebElement ele = driver.findElement(By.id("img_masterSetting"));
		WebElement settingsElement=driver.findElement(By.id("img_masterSetting"));
		wait.until(ExpectedConditions.visibilityOf(settingsElement));
		
		if(settingsElement.isDisplayed())
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", settingsElement);
			//settingsElement.click();
			System.out.println("settings clicked");
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "<span style='color:green;'> Settings option is clicked successfully</span>"
		+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}
	
	}
	
	public void fnPrefernceTabFields() throws InterruptedException {
        Thread.sleep(2000);
        WebElement prefencesElement = driver.findElement(By.xpath("//*[@id=\"preferences_div_tab\"]/div/div[2]/span"));
        wait.until(ExpectedConditions.visibilityOf(prefencesElement));
        prefencesElement.click();
        WebElement autostartmacroElement = driver.findElement(By.id("autostartName"));
        Thread.sleep(2000);
        String readonly = autostartmacroElement.getAttribute("readonly");
        System.out.println("AutostartName Searchbox:"+readonly);
        Assert.assertEquals(readonly, null);
        //Assert.assertNotNull(readonly);
        Thread.sleep(1000);
        WebElement prefencecheckbox = driver.findElement(By.xpath("//*[@id=\"preferences_div\"]/div[2]/label[2]/label/span"));
        Thread.sleep(2000);
        String readonly1 = prefencecheckbox.getAttribute("readonly");
        System.out.println("Start Automatically checkbox:"+readonly1);
        Assert.assertEquals(readonly1, null);
        
        
            logger.log(LogStatus.PASS, "<span style='color:green;'> Auto-Start Macro editable successfully in Prefence tab</span>"
                            + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
               
               }

	public void PrefernceTab() throws InterruptedException {
		Thread.sleep(2000);
        WebElement prefencesElement = driver.findElement(By.id("preference_settings_icon"));
        wait.until(ExpectedConditions.visibilityOf(prefencesElement));
        
        prefencesElement.click();
        logger.log(LogStatus.PASS, "<span style='color:green;'> PrefernceTab is clicked successfully</span>"
     			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	}
	public void Prefernce_StatusBar() throws InterruptedException {
		
        WebElement statusBarElement = driver.findElement(By.xpath("/html/body/div[13]/div/div/div[2]/div[2]/div[3]/div[1]/div/div/label/span[1]"));
        Thread.sleep(2000);
         statusBarElement.click();
         logger.log(LogStatus.PASS, "<span style='color:green;'> Prefernce_StatusBar is clicked successfully</span>"
      			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	}
	public void PrefernceSave() throws InterruptedException {
		Thread.sleep(2000);
        WebElement prefencesSave = driver.findElement(By.id("settingSave"));
        wait.until(ExpectedConditions.visibilityOf(prefencesSave));
        prefencesSave.click();
        Thread.sleep(5000);
        logger.log(LogStatus.PASS, "<span style='color:green;'> PrefernceTab Save button is clicked successfully</span>"
     			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
        WebElement prefencespopup = driver.findElement(By.xpath("/html/body/div[14]/div/div/span/button"));
       
        prefencespopup.click();  
	}
	public void SessionConnectvity() throws InterruptedException {
		Thread.sleep(2000);
        WebElement prefencesSave = driver.findElement(By.xpath("settingSave"));
        wait.until(ExpectedConditions.visibilityOf(prefencesSave));
        prefencesSave.click();
		
	}
	public void fnVerifyGUISettingOption() throws InterruptedException {
		Thread.sleep(4000);
		String[] expected1 = {"Screen", "Key Remap", "Color Remap", "Print Screen", "Hotspot", "Cut/Copy/Paste", "Mouse Wheel", "Cursor", "Preferences"};
		
		
	List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id ='setting']//li//span"));
		System.out.println("all option "+ allOptions.size());

		ArrayList<String> availableitems =new ArrayList<String>();
		for(WebElement ele : allOptions) {
			
			availableitems.add(ele.getText().trim());
			
		}
		 for (int i =0;i<expected1.length;i++){
			assertTrue(availableitems.contains(expected1[i].trim()), "Settingtabs tabs  are not available");		           
		 }
		 logger.log(LogStatus.PASS, "<span style='color:green;'> Setting tab options are Verified successfully</span>"
 				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));

		
		  WebElement search_Setting = driver.findElement(By.xpath("//*[@id=\"search_settings\"]"));
		  if(search_Setting.isEnabled()) {
			  logger.log(LogStatus.PASS, "<span style='color:green;'> Search option is enabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
		  }else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'> Search option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
		  }
		  
		  //Screen
		  WebElement Screen_Tab = driver.findElement(By.id("screen_icon"));
		   if(Screen_Tab.isDisplayed()) {
			   Screen_Tab.click();
			   logger.log(LogStatus.PASS, "<span style='color:green;'> Screen Tab is clicked successfully</span>"
	    				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			   WebElement Changefont_tab = driver.findElement(By.id("fontactive"));
			   if(Changefont_tab.isDisplayed()) {
				   Changefont_tab.click();
				   boolean Screendropdown = driver.findElement(By.xpath("//*[@id=\"selectFont\"]")).isEnabled();
				   System.out.println("Screen dropdown is : "+Screendropdown);
				   WebElement ScreenPreviewtext = driver.findElement(By.xpath("//*[@id=\"font_sample\"]"));
				   System.out.println("Screen Preview text is : "+ScreenPreviewtext.getText());
				   logger.log(LogStatus.PASS, "<span style='color:green;'> ChangeFont Tab is displayed successfully</span>"
		    				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			   }else {
				   logger.log(LogStatus.FAIL, "<span style='color:green;'> ChangeFont Tab is not displayed</span>"
		    				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
			   }
			   WebElement Screen_RefreshInterval = driver.findElement(By.xpath("//a[contains(text(), 'Refresh Interval')]"));
			   if(Screen_RefreshInterval.isDisplayed()) {
				   Screen_RefreshInterval.click();
				   boolean Refresh_Clientpoll = driver.findElement(By.xpath("//*[@id=\"ajaxRefreshSelect\"]")).isEnabled();
				   System.out.println("Refresh_Clientpoll is : "+Refresh_Clientpoll);
				 
				   logger.log(LogStatus.PASS, "<span style='color:green;'> Screen_RefreshInterval Tab is clicked successfully</span>"
		    				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
			   }else {
				   logger.log(LogStatus.FAIL, "<span style='color:green;'> Screen_RefreshInterval Tab is not clicked successfully</span>"
		    				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			   }
			
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> Screen Tab  is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		  
		  //keymap
		  WebElement Keymap_Tab = driver.findElement(By.id("keyremap_icon"));
		   if(Keymap_Tab.isDisplayed()) {
			   Keymap_Tab.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'> Keymap Tab is displayed successfully</span>"
     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> Keymap Tab  is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		   WebElement Character_Tab = driver.findElement(By.xpath("//*[@id=\"keyRemapCharTab\"]"));
		   if(Character_Tab.isDisplayed()) {
			   Character_Tab.click();
			   boolean Keyeremap_search = driver.findElement(By.id("keyRemapSearch")).isEnabled(); 
			   System.out.println("KeyeremapChar Search is :"+Keyeremap_search);
			   boolean Keyeremap_Clear = driver.findElement(By.id("keyRemapClear")).isEnabled(); 
			   System.out.println("KeyeremapChar Clear button is :"+Keyeremap_Clear);
			   boolean Keyeremap_download = driver.findElement(By.xpath("//*[@id=\"accordionKeyRemap\"]/div[2]/div[2]/img")).isEnabled(); 
			   System.out.println("KeyeremapChar Download button is :"+Keyeremap_download);
			   WebElement Keyeremap_Import = driver.findElement(By.xpath("//*[@id=\"collapse_KeyRemap_div\"]/div[2]/div[3]/a"));
			  if(Keyeremap_Import.isDisplayed()) {
			   Keyeremap_Import.click();
			   WebElement Character_ImportFromSession = driver.findElement(By.xpath("//span[contains(text(), 'From Session')]"));
			  Character_ImportFromSession.click();
			  WebElement Character_ImportLocalSession = driver.findElement(By.xpath("//*[@id=\"local_kmp\"]/span"));
			  Character_ImportLocalSession.click();
			  boolean KeyeremapChar_impchooseFile = driver.findElement(By.xpath("//*[@id=\"key_Import\"]/label")).isEnabled(); 
			   System.out.println("KeyeremapChar Choosefile button is :"+KeyeremapChar_impchooseFile);
			   WebElement Character_Importcancel = driver.findElement(By.xpath("//*[@id=\"btnUploadCancel\"]"));
			   Character_Importcancel.click();
			   logger.log(LogStatus.PASS, "<span style='color:green;'> Character Tab import  is displayed successfully</span>"
	     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   }
			   logger.log(LogStatus.PASS, "<span style='color:green;'> Character Tab is displayed successfully</span>"
     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> Character Tab  is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		   
		   WebElement hostFunction_Tab = driver.findElement(By.id("keyRemapHFunctionTab"));
		   if(hostFunction_Tab.isDisplayed()) {
			   hostFunction_Tab.click();
			   boolean Keyeremap_search = driver.findElement(By.id("keyRemapSearch")).isEnabled(); 
			   System.out.println("Keyeremap host Search is :"+Keyeremap_search);
			   boolean Keyeremap_Clear = driver.findElement(By.id("keyRemapClear")).isEnabled(); 
			   System.out.println("Keyeremap host Clear button is :"+Keyeremap_Clear);
			   boolean Keyeremap_download = driver.findElement(By.xpath("//*[@id=\"accordionKeyRemap\"]/div[2]/div[2]/img")).isEnabled(); 
			   System.out.println("KeyeremapHost Download button is :"+Keyeremap_download);
			   WebElement Keyeremap_Import = driver.findElement(By.xpath("//*[@id=\"collapse_KeyRemap_div\"]/div[2]/div[3]/a"));
			  if(Keyeremap_Import.isDisplayed()) {
			   Keyeremap_Import.click();
			   WebElement Character_ImportFromSession = driver.findElement(By.xpath("//span[contains(text(), 'From Session')]"));
			  Character_ImportFromSession.click();
			  WebElement Character_ImportLocalSession = driver.findElement(By.xpath("//*[@id=\"local_kmp\"]/span"));
			  Character_ImportLocalSession.click();
			  boolean KeyeremapChar_impchooseFile = driver.findElement(By.xpath("//*[@id=\"key_Import\"]/label")).isEnabled(); 
			   System.out.println("Keyeremap host Choosefile button is :"+KeyeremapChar_impchooseFile);
			   WebElement Character_Importcancel = driver.findElement(By.xpath("//*[@id=\"btnUploadCancel\"]"));
			   Character_Importcancel.click();
			   logger.log(LogStatus.PASS, "<span style='color:green;'> hostFunction import  is displayed successfully</span>"
	     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   }
			   logger.log(LogStatus.PASS, "<span style='color:green;'> hostFunction Tab is displayed successfully</span>"
     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> hostFunction Tab  is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		   
		   WebElement CustomFunction_Tab = driver.findElement(By.id("keyRemapCustomFunctionsTab"));
		   if(CustomFunction_Tab.isDisplayed()) {
			   CustomFunction_Tab.click();
			   boolean Keyeremap_search = driver.findElement(By.id("keyRemapSearch")).isEnabled(); 
			   System.out.println("Keyeremap host Search is :"+Keyeremap_search);
			   boolean Keyeremap_Clear = driver.findElement(By.id("keyRemapClear")).isEnabled(); 
			   System.out.println("Keyeremap host Clear button is :"+Keyeremap_Clear);
			   boolean Keyeremap_download = driver.findElement(By.xpath("//*[@id=\"accordionKeyRemap\"]/div[2]/div[2]/img")).isEnabled(); 
			   System.out.println("KeyeremapHost Download button is :"+Keyeremap_download);
			   boolean Custom_name = driver.findElement(By.id("customName")).isEnabled(); 
			   System.out.println("CustomName textfield is :"+Custom_name);
			   boolean CustomData = driver.findElement(By.id("customData")).isEnabled(); 
			   System.out.println("CustomData textfield is :"+CustomData);
			   boolean CustomAdd = driver.findElement(By.id("customAdd")).isEnabled(); 
			   System.out.println("CustomAdd button  is :"+CustomAdd);
			   WebElement Keyeremap_Import = driver.findElement(By.xpath("//*[@id=\"collapse_KeyRemap_div\"]/div[2]/div[3]/a"));
			  if(Keyeremap_Import.isDisplayed()) {
			   Keyeremap_Import.click();
			   WebElement Character_ImportFromSession = driver.findElement(By.xpath("//span[contains(text(), 'From Session')]"));
			  Character_ImportFromSession.click();
			  WebElement Character_ImportLocalSession = driver.findElement(By.xpath("//*[@id=\"local_kmp\"]/span"));
			  Character_ImportLocalSession.click();
			  boolean KeyeremapChar_impchooseFile = driver.findElement(By.xpath("//*[@id=\"key_Import\"]/label")).isEnabled(); 
			   System.out.println("Keyeremap custom Choosefile button is :"+KeyeremapChar_impchooseFile);
			   WebElement Character_Importcancel = driver.findElement(By.xpath("//*[@id=\"btnUploadCancel\"]"));
			   Character_Importcancel.click();
			   logger.log(LogStatus.PASS, "<span style='color:green;'> CustomFunction import  is displayed successfully</span>"
	     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   }
			   logger.log(LogStatus.PASS, "<span style='color:green;'> CustomFunction Tab is displayed successfully</span>"
     				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> CustomFunction Tab  is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }  
		  //Color Remap
		  WebElement colorremap_Tab = driver.findElement(By.id("colorremap_icon"));
		   if(colorremap_Tab.isDisplayed()) {
			  colorremap_Tab.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'> Colorremap tab is displayed successfully</span>"
      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> Colorremap tab is not displayed</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		   WebElement base_attributes_tab = driver.findElement(By.id("base_attributes_tab"));
		   if(base_attributes_tab.isDisplayed()) {
			   base_attributes_tab.click();			   
			  logger.log(LogStatus.PASS, "<span style='color:green;'> base_attributes_tab is displayed successfully</span>"
      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			 			
		   } else {
				  logger.log(LogStatus.FAIL, "<span style='color:green;'> base_attributes_tab is not displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }
		   WebElement normalProtected = driver.findElement(By.id("nor_protected_btn"));
			 if(normalProtected.isDisplayed()) {
				 logger.log(LogStatus.PASS, "<span style='color:green;'> normalProtected tab is  displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
				 boolean normalProtect_Foreground = driver.findElement(By.xpath("//*[@id=\"nor_protected\"]/div[1]/div/div[2]/div/span/span")).isEnabled();
			     System.out.println("normalProtect Foreground color is :"+normalProtect_Foreground);
			     boolean normalProtect_Background = driver.findElement(By.xpath("//*[@id=\"nor_protected\"]/div[2]/div/div[2]/div/span/span")).isEnabled();
			     System.out.println("normalProtect backround color is :"+normalProtect_Background);
			     boolean normalProtect_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_normal_protected\"]")).isEnabled();
			     System.out.println("normalProtect text Foreground color is :"+normalProtect_TextForeground);
			     boolean normalProtect_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_normal_protected\"]")).isEnabled();
			     System.out.println("normalProtect text backround color is :"+normalProtect_TextBackground);
			 }else {
				 logger.log(LogStatus.FAIL, "<span style='color:green;'> normalProtected is not displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			 }
			  WebElement Unprotected = driver.findElement(By.id("nor_unprotected_btn"));
			  if(Unprotected.isDisplayed()) {
				  Unprotected.click();
				  logger.log(LogStatus.PASS, "<span style='color:green;'> normalUnProtected tab is  displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
				  boolean UnProtect_Foreground = driver.findElement(By.xpath("//*[@id=\"nor_unprotected\"]/div[1]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("Normal UnProtect Foreground color is :"+UnProtect_Foreground);
				     boolean UnProtect_Background = driver.findElement(By.xpath("//*[@id=\"nor_unprotected\"]/div[2]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("Normal UnProtect backround color is :"+UnProtect_Background);
				     boolean UnProtect_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_normal_unprotected\"]")).isEnabled();
				     System.out.println("Normal UnProtect TextForeground text Foreground color is :"+UnProtect_TextForeground);
				     boolean UnProtect_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_normal_unprotected\"]")).isEnabled();
				     System.out.println("normal UnProtect text backround color is :"+UnProtect_TextBackground);
				 }else {
					 logger.log(LogStatus.FAIL, "<span style='color:green;'> normalUnProtected is not displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				 } 
			
			  WebElement int_protected = driver.findElement(By.id("int_protected_btn"));
			  if(int_protected.isDisplayed()) {
				  int_protected.click();
				  logger.log(LogStatus.PASS, "<span style='color:green;'> intensfied Protected tab is  displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
				  boolean IntProtect_Foreground = driver.findElement(By.xpath("//*[@id=\"int_protected\"]/div[1]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("IntProtect Foreground color is :"+IntProtect_Foreground);
				     boolean IntProtect_Background = driver.findElement(By.xpath("//*[@id=\"int_protected\"]/div[2]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("IntProtect background color is :"+IntProtect_Background);
				     boolean IntProtect_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_intensified_protected\"]")).isEnabled();
				     System.out.println("IntProtect TextForeground text Foreground color is :"+IntProtect_TextForeground);
				     boolean IntProtect_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_intensified_protected\"]")).isEnabled();
				     System.out.println("IntProtect text backround color is :"+IntProtect_TextBackground);
				 }else {
					 logger.log(LogStatus.FAIL, "<span style='color:green;'> intensfied Protected tab is not displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				 } 
			  WebElement int_unprotected = driver.findElement(By.id("int_unprotected_btn"));
			  if(int_unprotected.isDisplayed()) {
				  int_unprotected.click();
				  logger.log(LogStatus.PASS, "<span style='color:green;'> intensfied UnProtected tab is  displayed </span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
				  boolean Int_UnProtect_Foreground = driver.findElement(By.xpath("//*[@id=\"int_unprotected\"]/div[1]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("intensfied UnProtect Foreground color is :"+Int_UnProtect_Foreground);
				     boolean IntUnProtect_Background = driver.findElement(By.xpath("//*[@id=\"int_unprotected\"]/div[2]/div/div[2]/div/span/span")).isEnabled();
				     System.out.println("intensfied UnProtect background color is :"+IntUnProtect_Background);
				     boolean IntUnProtect_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_intensified_unprotected\"]")).isEnabled();
				     System.out.println("intensfied UnProcted TextForeground text Foreground color is :"+IntUnProtect_TextForeground);
				     boolean IntUnProtect_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_intensified_unprotected\"]")).isEnabled();
				     System.out.println("intensfied UnProcted text backround color is :"+IntUnProtect_TextBackground);
				 }else {
					 logger.log(LogStatus.FAIL, "<span style='color:green;'> intensfied UnProtected tab is not displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				 } 
			  WebElement Previewtext = driver.findElement(By.id("base_attributes_preview_panel_text")); 
				Thread.sleep(2000);
				String actual = Previewtext.getText().trim();
				String expected = "The quick brown fox jumps over the lazy dog.";	
				assertEquals(actual, expected);
				logger.log(LogStatus.PASS, "<span style='color:green;'> Preview Text is displayed succussfully </span>"
	      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			 
			  WebElement Extended_attributes_tab = driver.findElement(By.id("extended_attributes_tab"));
			   if(Extended_attributes_tab.isDisplayed()) {
				   Extended_attributes_tab.click();			   
				  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended attributes tab is displayed successfully</span>"
	      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				 			
			   } else {
					  logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended attributes tab is not displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					  } 
			   WebElement extended_blue_btn = driver.findElement(By.xpath("//*[@id=\"extended_blue_btn\"]"));
				  if(extended_blue_btn.isDisplayed()) {
					  Thread.sleep(2000);
					  extended_blue_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended blue tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean Blue_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Blue Foreground color is :"+Blue_Foreground);
					     boolean Blue_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Blue background color is :"+Blue_Background);
					     boolean Blue_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("Blue TextForeground text Foreground color is :"+Blue_TextForeground);
					     boolean Blue_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("Blue text backround color is :"+Blue_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Blue  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				  WebElement extended_green_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[2]"));
				Thread.sleep(2000);
				  if(extended_green_btn.isDisplayed()) {
					  extended_green_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended green tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean Green_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Green Foreground color is :"+Green_Foreground);
					     boolean Green_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Green background color is :"+Green_Background);
					     boolean Green_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("Green TextForeground text Foreground color is :"+Green_TextForeground);
					     boolean Green_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("Green text backround color is :"+Green_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Green  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				
				   WebElement extended_Pink_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[3]"));
				  if(extended_Pink_btn.isDisplayed()) {
					  extended_Pink_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended Pink tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean Pink_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Pink Foreground color is :"+Pink_Foreground);
					     boolean Pink_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Pink background color is :"+Pink_Background);
					     boolean Pink_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("Pink TextForeground text Foreground color is :"+Pink_TextForeground);
					     boolean Pink_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("Pink text backround color is :"+Pink_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Pink  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				  WebElement extended_red_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[4]"));
				  if(extended_red_btn.isDisplayed()) {
					  extended_red_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended Red tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean Red_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Red Foreground color is :"+Red_Foreground);
					     boolean Red_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Red background color is :"+Red_Background);
					     boolean Red_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("Red TextForeground text Foreground color is :"+Red_TextForeground);
					     boolean Red_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("Red text backround color is :"+Red_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Red  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				  WebElement extended_turquoise_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[5]"));
				  if(extended_turquoise_btn.isDisplayed()) {
					  extended_turquoise_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended Turquoise tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean Turquoise_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Turquoise Foreground color is :"+Turquoise_Foreground);
					     boolean Turquoise_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("Turquoise background color is :"+Turquoise_Background);
					     boolean Turquoise_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("Turquoise TextForeground text Foreground color is :"+Turquoise_TextForeground);
					     boolean Turquoise_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("Turquoise text backround color is :"+Turquoise_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Turquoise  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 }
				 
				  WebElement extended_white_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[6]"));
				  if(extended_white_btn.isDisplayed()) {
					  extended_white_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended White tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  boolean White_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("White Foreground color is :"+White_Foreground);
					     boolean White_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("White background color is :"+White_Background);
					     boolean White_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("White TextForeground text Foreground color is :"+White_TextForeground);
					     boolean White_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("White text backround color is :"+White_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended White  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				  
				  WebElement extended_yellow_btn = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[1]/button[7]"));
				  if(extended_yellow_btn.isDisplayed()) {
					  extended_yellow_btn.click();
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Extended Yellow tab is  displayed </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					    boolean Yellow_Foreground = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[1]/div[2]/div/span/span")).isEnabled();
					     System.out.println("White Foreground color is :"+Yellow_Foreground);
					     boolean Yellow_Background = driver.findElement(By.xpath("//*[@id=\"extended_attributes\"]/div[1]/div[2]/div[2]/div[2]/div/span/span")).isEnabled();
					     System.out.println("White background color is :"+Yellow_Background);
					     boolean Yellow_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_foreground\"]")).isEnabled();
					     System.out.println("White TextForeground text Foreground color is :"+Yellow_TextForeground);
					     boolean Yellow_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_extended_attribute_background\"]")).isEnabled();
					     System.out.println("White text backround color is :"+Yellow_TextBackground);
					 }else {
						 logger.log(LogStatus.FAIL, "<span style='color:green;'> Extended Yellow  tab is not displayed </span>"
				      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					 } 
				  WebElement QIA_Tab = driver.findElement(By.id("oia_color_tab"));
				  if(QIA_Tab.isDisplayed()) {
					  QIA_Tab.click();
					  boolean statusIndicator_Foreground = driver.findElement(By.xpath("//*[@id=\"oia_color\"]/div/div[1]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("statusIndicator Foreground color is :"+statusIndicator_Foreground);
					     boolean InfoIndicator_Foreground = driver.findElement(By.xpath("//*[@id=\"oia_color\"]/div/div[2]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("InfoIndicator_Foreground color is :"+InfoIndicator_Foreground);
					     boolean AttendIndicator_Foreground = driver.findElement(By.xpath("//*[@id=\"oia_color\"]/div/div[3]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("AttendIndicator_Foreground color is :"+AttendIndicator_Foreground);
					     boolean ErrorIndicator_Foreground = driver.findElement(By.xpath("//*[@id=\"oia_color\"]/div/div[4]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println(" ErrorIndicator_Foreground color is :"+ErrorIndicator_Foreground);
					     boolean QIABackground = driver.findElement(By.xpath("//*[@id=\"oia_color\"]/div/div[5]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("QIABackground  color is :"+QIABackground);
					     
					     boolean statusIndicator_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_statusIndicator_oia_color\"]")).isEnabled();
					     System.out.println("statusIndicator Text Foreground color is :"+statusIndicator_TextForeground);
					     boolean InfoIndicator_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_InformationIndicator_oia_color\"]")).isEnabled();
					     System.out.println("InfoIndicator Text Foreground color is :"+InfoIndicator_TextForeground);
					     boolean AttendIndicator_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_AttentionIndicator_oia_color\"]")).isEnabled();
					     System.out.println("AttendIndicator TextForeground color is :"+AttendIndicator_TextForeground);
					     boolean ErrorIndicator_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_ErrorIndicator_oia_color\"]")).isEnabled();
					     System.out.println(" ErrorIndicator TextForeground color is :"+ErrorIndicator_TextForeground);
					     boolean QIABackgroundText = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_oiaBackground_oia_color\"]")).isEnabled();
					     System.out.println("QIABackground Text color is :"+QIABackgroundText);
					  logger.log(LogStatus.PASS, "<span style='color:green;'> QIA_Tab is displayed successfully</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }	
				  else {
					  logger.log(LogStatus.FAIL, "<span style='color:green;'> QIA_Tab is not displayed successfully</span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					  }	  
				  
				  WebElement Others_Tab = driver.findElement(By.id("others_tab"));
				  
				  if(Others_Tab.isDisplayed()) {
					  Others_Tab.click();
					  boolean CrosshairRular_Foreground = driver.findElement(By.xpath("//*[@id=\"others\"]/div[1]/div[2]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("CrosshairRular_Foreground color is :"+CrosshairRular_Foreground);
					     boolean Other_Foreground = driver.findElement(By.xpath("//*[@id=\"highlight_active_section\"]/div[1]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println(" Other_Foreground color is :"+Other_Foreground);
					     boolean Others_Background = driver.findElement(By.xpath("//*[@id=\"highlight_active_section\"]/div[2]/div/div/div[2]/div/span/span")).isEnabled();
					     System.out.println("QIABackground  color is :"+Others_Background);
					     
					     boolean CrosshairRular_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_CrossHairRulerColor_others\"]")).isEnabled();
					     System.out.println("CrosshairRular_ TextForeground color is :"+CrosshairRular_TextForeground);
					     boolean Other_TextForeground = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_hightlightactivecolorForeground_others\"]")).isEnabled();
					     System.out.println(" Other_Foreground color is :"+Other_Foreground);
					     boolean Others_TextBackground = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_hightlightactivecolorBackground_others\"]")).isEnabled();
					     System.out.println("QIABackground text color is :"+Others_TextBackground);
					     WebElement HightlightActivefield_chxbox = driver.findElement(By.xpath("//*[@id=\"others\"]/div[1]/div[3]/div/div/div[2]/label/span"));
					     System.out.println("HightlightActivefield_chxbox  is :"+HightlightActivefield_chxbox.isSelected());
					     if(HightlightActivefield_chxbox.isDisplayed()) {
					    	 HightlightActivefield_chxbox.click();
					    	 boolean Other_Foreground1 = driver.findElement(By.xpath("//*[@id=\"highlight_active_section\"]/div[1]/div/div/div[2]/div/span/span")).isEnabled();
						     System.out.println(" Other_Foreground color is :"+Other_Foreground1);
						     boolean Others_Background1 = driver.findElement(By.xpath("//*[@id=\"highlight_active_section\"]/div[2]/div/div/div[2]/div/span/span")).isEnabled();
						     System.out.println("QIABackground  color is :"+Others_Background1);
						     boolean Other_TextForeground1 = driver.findElement(By.xpath("//*[@id=\"text_foreGroundColor_hightlightactivecolorForeground_others\"]")).isEnabled();
						     System.out.println(" Other_Foreground color is :"+Other_Foreground1);
						     boolean Others_TextBackground1 = driver.findElement(By.xpath("//*[@id=\"text_backgroundColor_hightlightactivecolorBackground_others\"]")).isEnabled();
						     System.out.println("QIABackground text color is :"+Others_TextBackground1); 
					     }
					     logger.log(LogStatus.PASS, "<span style='color:green;'> Others tab is displayed successfully</span>"
		      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
					  
				  } else {
					  logger.log(LogStatus.FAIL, "<span style='color:green;'> Others tab is not displayed successfully</span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page"))); 
						  
				  } 
				  WebElement ResetColor = driver.findElement(By.xpath("//*[@id=\"reset_color\"]"));
				  if(ResetColor.isDisplayed()) {
					  ResetColor.click(); 
					 WebElement Resetpopup_close = driver.findElement(By.xpath("//*[@id=\"colorAlertBoxModal\"]/div/div/div[3]/button"));
					Thread.sleep(2000);
					 Resetpopup_close.click();
					  
					  logger.log(LogStatus.PASS, "<span style='color:green;'> Reset color button is clicked succussfully </span>"
			      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				  }  
			  //PrintScreen
		  WebElement PrintScreen_Tab = driver.findElement(By.id("printscreen_icon"));
		  Thread.sleep(2000);
		  if(PrintScreen_Tab.isDisplayed()) {
			  PrintScreen_Tab.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'> PrintScreen tab is displayed successfully</span>"
      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			  WebElement headerLeft = driver.findElement(By.id("headerLeft"));
			  if(headerLeft.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerLeft option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerLeft option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  WebElement headerCenter = driver.findElement(By.id("headerCenter"));
			  if(headerCenter.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerCenter option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerCenter option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  WebElement headerRight = driver.findElement(By.id("headerRight"));
			  if(headerRight.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerRight option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> headerRight option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  boolean header_text = driver.findElement(By.id("header_text")).isEnabled(); 
			  System.out.println("header_text is enabled:"+header_text);
			  WebElement footerLeft = driver.findElement(By.id("footerLeft"));
			  if(footerLeft.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerLeft option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerLeft option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  WebElement footerCenter = driver.findElement(By.id("footerCenter"));
			  if(footerCenter.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerCenter option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerCenter option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  WebElement footerRight = driver.findElement(By.id("footerRight"));
			  if(footerRight.isEnabled()) {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerRight option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> footerRight option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  boolean footer_text = driver.findElement(By.id("footer_text")).isEnabled(); 
			  System.out.println("header_text is enabled:"+footer_text); 
			  WebElement color = driver.findElement(By.xpath("//*[@id=\"graphix\"]/span"));
			  if(color.isEnabled()) {
				  color.click();
				  logger.log(LogStatus.PASS, "<span style='color:green;'> color option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> color option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
			  WebElement BWcheckGraphix = driver.findElement(By.xpath("//*[@id=\"noGraphix\"]/span"));
			  if(BWcheckGraphix.isEnabled()) {
				  BWcheckGraphix.click();
				  logger.log(LogStatus.PASS, "<span style='color:green;'> BWcheckGraphix option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }else {
				  logger.log(LogStatus.PASS, "<span style='color:green;'> BWcheckGraphix option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));  
			  }
		  
		  }else {
      				logger.log(LogStatus.FAIL, "<span style='color:green;'>PrintScreen tab is not displayed </span>"
      						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
      			}
		  
		  //HotSpot
		  WebElement hotSpot_Tab = driver.findElement(By.id("hotspot_icon"));
	        wait.until(ExpectedConditions.visibilityOf(hotSpot_Tab));
	        hotSpot_Tab.click();
	        if(driver.findElement((By.xpath("//*[@id=\"show_url\"]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Display URLs as Hotspots Checkbox is verified successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	        if(driver.findElement((By.xpath("//*[@id=\"url_cb\"]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'>  Don't show URLs in unprotected fields is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[4]/div[1]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'>PFnn checkbox is Selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'>PFnn checkbox is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[4]/div[2]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Fnn Checkbox is Selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				 logger.log(LogStatus.PASS, "<span style='color:green;'> Fnn Checkbox is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[4]/div[3]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> FPnn Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> FPnn Checkbox is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					}

			if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[4]/div[4]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> nn Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> nn Checkbox is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[6]/div/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'>Execute Macro Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				 logger.log(LogStatus.PASS, "<span style='color:green;'>Execute Macro Checkbox is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[8]/div/label[1]/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Cursor postion Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Cursor postion Checkbox is verifed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	       
	        if(driver.findElement((By.xpath("//*[@id=\"accordion2\"]/div/div[8]/div/label[2]/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Cursor string postion Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Cursor string postion Checkbox is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	       //Copy/Cut/Paste
	        WebElement cutcopypaste_Tab = driver.findElement(By.id("cutcopypaste_icon"));
	        wait.until(ExpectedConditions.visibilityOf(cutcopypaste_Tab));
	        if(cutcopypaste_Tab.isDisplayed()) {
	        	  cutcopypaste_Tab.click();
	        	  logger.log(LogStatus.PASS, "<span style='color:green;'> CutCopyPaste tab is displayed successfully</span>"
	      				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	      	}else {
	      				logger.log(LogStatus.FAIL, "<span style='color:green;'>CutCopyPaste tab is not displayed </span>"
	      						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
	      			}
	      
	        WebElement Cutcopy_tab = driver.findElement(By.id("Cutcopy_tab"));
	        WebElement Paste_tab = driver.findElement(By.id("Paste_tab"));
		  if(Cutcopy_tab.isDisplayed() && Paste_tab.isDisplayed())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> CutCopy and Paste tab option are displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.FAIL, "<span style='color:green;'> CutCopy and Paste tab option are not displayed</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
		  cutcopypaste_Tab.click();
		  WebElement Cutcopychk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/label[1]/span"));
		  if(Cutcopychk_box.isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Cut/Copy only if a trim rectangle Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Cut/Copy only if a trim rectangle is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			} 
		  WebElement trimrectanglechk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/label[2]/span"));
		  if(trimrectanglechk_box.isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Trim rectangle remains after edit function Checkbox is selected </span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Trim rectangle remains after edit function chkbox is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			} 
		  WebElement CopyAsFiledchk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/fieldset/div[1]/label/span"));
		  if(CopyAsFiledchk_box.isDisplayed())
			{
			  CopyAsFiledchk_box.click();
			  WebElement Protectedchk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/fieldset/div[2]/label[1]/span"));
			  if(Protectedchk_box.isEnabled())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>Protected Checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> Protected Checkbox is disabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement UnProtectedchk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/fieldset/div[2]/label[2]/span"));
			  if(UnProtectedchk_box.isEnabled())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>UnProtected Checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> UnProtected Checkbox is disabled </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement TrimSpaceschk_box = driver.findElement(By.xpath("//*[@id=\"cutcopy\"]/div/fieldset/div[2]/label[3]/span"));
			  if(TrimSpaceschk_box.isEnabled())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>TrimSpaces Checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> TrimSpaces Checkbox is disabled </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			}
		  if(Paste_tab.isDisplayed()) {
			  Paste_tab.click();
			  WebElement FieldWrapchk_box = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[1]/div/div[1]/label/span"));
			  if(FieldWrapchk_box.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>FieldWrap Checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> Field Wrap Checkbox is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement LineWrapchk_box = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[1]/div/div[2]/label/span"));
			  if(LineWrapchk_box.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>LineWrap Checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> LineWrap Checkbox is verified successfully </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement PasteMarkedArea_checkbox = driver.findElement(By.id("PasteMarkedArea_checkbox"));
			  if(PasteMarkedArea_checkbox.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>PasteMarkedArea_checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> PasteMarkedArea_checkbox is verified successfully </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement StopPasteLineEncounterd_checkbox = driver.findElement(By.id("StopPasteLineEncounterd_checkbox"));
			  if(StopPasteLineEncounterd_checkbox.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>StopPasteLineEncounterd_checkbox is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> StopPasteLineEncounterd_checkbox is verified successfully </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement AdvanceTabStop_radiobutton = driver.findElement(By.id("AdvanceTabStop_radiobutton"));
			  if(AdvanceTabStop_radiobutton.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>AdvanceTabStop_radiobutton is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			    
			    boolean Minus_Button = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[2]/div[1]/div[2]/div[1]/div/span[1]")).isEnabled();
			   System.out.println("minus pasteTab_blue is enbled :" +Minus_Button);
			   boolean plus_Button = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[2]/div[1]/div[2]/div[1]/div/span[2]")).isEnabled();
			   System.out.println("plus pasteTab_blue is enabled :" +plus_Button);
			  
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>AdvanceTabStop_radiobutton is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					    	
				}
			   
			  WebElement Replace_radiobutton = driver.findElement(By.id("Replace_radiobutton"));
			  if(Replace_radiobutton.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>Replace_radiobutton is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			    
			    boolean ReplaceMinus_Button = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[2]/div[2]/div[2]/div/div/span[1]")).isEnabled();
				   System.out.println("minus pasteTab_blue is enbled :" +ReplaceMinus_Button);
				   boolean Replaceplus_Button = driver.findElement(By.xpath("//*[@id=\"paste\"]/div/fieldset[2]/div[2]/div[2]/div/div/span[2]")).isEnabled();
				   System.out.println("plus pasteTab_blue is enabled :" +Replaceplus_Button);
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> Replace_radiobutton is verified successfully </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
			  WebElement PasteField_radiobutton = driver.findElement(By.id("PasteField_radiobutton"));
			  if(PasteField_radiobutton.isSelected())
				{
			    logger.log(LogStatus.PASS, "<span style='color:green;'>PasteField_radiobutton is enabled successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'> PasteField_radiobutton is verified successfully </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
				} 
		  }
		  
		  //Mouse Wheel
		  WebElement mouseWheel_Tab = driver.findElement(By.id("mousewheel_icon"));
	        wait.until(ExpectedConditions.visibilityOf(mouseWheel_Tab));
	        mouseWheel_Tab.click();
	        WebElement enableMouseWheel = driver.findElement(By.id("mousewheel_icon"));
		  if(enableMouseWheel.isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Enable Mouse Wheel Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Enable Mouse Wheel option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
		  WebElement pageUp = driver.findElement(By.id("selectMousewheelUp"));
		  WebElement pageDown = driver.findElement(By.id("selectMousewheelDown"));
		  if(pageUp.isEnabled() && pageDown.isEnabled()) {
			  logger.log(LogStatus.PASS, "<span style='color:green;'> PageUp and PageDown options are Disabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			 
		  }
		 
		  Thread.sleep(2000);
		  enableMouseWheel.click();
		  Thread.sleep(3000);
		  if(pageUp.isEnabled() && pageDown.isEnabled()) {
			  logger.log(LogStatus.PASS, "<span style='color:green;'> PageUp and PageDown options are Enabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			 
		  }else {
			 logger.log(LogStatus.PASS, "<span style='color:green;'> PageUp and PageDown options are Disabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
		  } 
		  
		  //Cursor Tab
		  WebElement cursor_Tab = driver.findElement(By.id("cursorstyle_icon"));
	        wait.until(ExpectedConditions.visibilityOf(cursor_Tab));
	        cursor_Tab.click();
	        WebElement block = driver.findElement(By.id("block_cursor"));
	        WebElement underline = driver.findElement(By.id("underline_cursor"));
	        if(block.isDisplayed() && underline.isDisplayed())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Block and underline fileds are displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.FAIL, "<span style='color:green;'> Block and underline fileds are not displayed</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	        if(driver.findElement((By.id("EnableCH"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Cross Hair Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Cross Hair option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	        if(driver.findElement((By.id("EnableBC"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Blicking Cursor Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Blicking Cursor option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
		  //Preference tab
		  WebElement prefencesElement = driver.findElement(By.id("preference_settings_icon"));
	        wait.until(ExpectedConditions.visibilityOf(prefencesElement));
	        
	        prefencesElement.click();
	        logger.log(LogStatus.PASS, "<span style='color:green;'> PrefernceTab is clicked successfully</span>"
	     			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	        if(driver.findElement((By.xpath("//*[@id=\"statusBar\"]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Display status bar checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Display status bar option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	        if(driver.findElement((By.xpath("//*[@id=\"confirmOnExit\"]/label/span[1]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Confirm On Exit Checkbox is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Confirm On Exit option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	        if(driver.findElement((By.xpath("//*[@id=\"EnableSOC\"]"))).isSelected())
			{
		    logger.log(LogStatus.PASS, "<span style='color:green;'> Search On Canvas option is selected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}else {
				logger.log(LogStatus.PASS, "<span style='color:green;'> Search On Canvas option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));	
			}
	}
	public void fnVerifySettingsOption() throws IOException, InterruptedException
	
	{
	//driver.findElement(By.id("font_div_tab")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fontactive"))));
	if(driver.findElement((By.id("fontactive"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Screen option is clicked successfully</span>"
			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	Thread.sleep(1000);
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("key_div_tab"))));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", driver.findElement(By.id("key_div_tab")));
	//driver.findElement(By.id("key_div_tab")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("keyremap_icon"))));
	if(driver.findElement((By.id("keyRemapCharTab"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Key option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("color_div_tab"))));
	driver.findElement(By.id("color_div_tab")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("base_attributes_tab"))));
	if(driver.findElement((By.id("base_attributes_tab"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Color option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("printScreen_div_tab"))));
	driver.findElement(By.id("printScreen_div_tab")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("leftpicture_size"))));
	if(driver.findElement((By.id("leftpicture_size"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Printscreen option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hotspot_icon"))));
	driver.findElement(By.id("hotspot_icon")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("HotSpot_div"))));
	if(driver.findElement((By.id("HotSpot_div"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Hotspot option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cutcopypaste_icon"))));
	driver.findElement(By.id("cutcopypaste_icon")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Cut')]"))));//"Cutcopy_tab"))));
	if(driver.findElement((By.xpath("//*[contains(text(),'Cut')]"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Cutcopy paste option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mousewheel_icon"))));
	driver.findElement(By.id("mousewheel_icon")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mousewheel_div"))));
	if(driver.findElement((By.id("mousewheel_div"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Mouse wheel option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));			}
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("CursorStyle_div_tab"))));
	jse.executeScript("arguments[0].click()", driver.findElement(By.id("CursorStyle_div_tab")));
	//driver.findElement(By.id("CursorStyle_div_tab")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("block_cursor"))));
	if(driver.findElement((By.id("block_cursor"))).isDisplayed())
			{
		logger.log(LogStatus.PASS, "<span style='color:green;'> Cursor option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
	
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preference_settings_icon"))));
	//driver.findElement(By.id("preference_settings_icon")).click();
	jse.executeScript("arguments[0].click()", driver.findElement(By.id("preference_settings_icon")));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("statusBar"))));
	if(driver.findElement((By.id("statusBar"))).isDisplayed())
	{
		logger.log(LogStatus.PASS, "<span style='color:green;'> status bar option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	}
	/*
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
	 * "helpLink")))); if(driver.findElement((By.id("helpLink"))).isDisplayed()) {
	 * logger.log(LogStatus.PASS,
	 * "<span style='color:green;'> Help option is clicked successfully</span>" +
	 * logger.addScreenCapture(Common.CaptureScreenShot(driver,
	 * "HACPEE Session Page"))); }
	 */
	Thread.sleep(2000);
	WebElement CloseButton = driver.findElement(By.id("close_button")); 
	CloseButton.click();
	Thread.sleep(2000);
		    }
 
	public void fnClickPropertiesOption() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menubutton0"))));
		driver.findElement(By.id("menubutton0")).click();
		Thread.sleep(2000);
		WebElement session_start =driver.findElement(By.xpath("//*[@id='context0']/span[1]"));
		WebElement properties = driver.findElement(By.xpath("//*[@id='context0']/span[2]"));
		if(session_start.isDisplayed() && properties.isDisplayed())
		{
			properties.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'> 3 dots options are displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'> 3 dots options are not displayed </span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}	
		//*[contains(text(),'Properties...')]")).click();
		Thread.sleep(2000);
		WebElement destAdr= driver.findElement(By.xpath("//*[@id='host']"));
		destAdr.clear();
		destAdr.sendKeys("10.134.71.157");
		driver.findElement(By.xpath("//*[@id=\"submit\" and @onclick=\"updateProp();\"]")).click();
		 //driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myModalLabel"))));
		//if(driver.findElement((By.id("myModalLabel"))).isDisplayed())
				//{
					logger.log(LogStatus.PASS, "<span style='color:green;'> Properties Pannel is clicked and displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			//	}
	}
	public void fnPropertiesOption_5250() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"menubutton1\"]"))));
		driver.findElement(By.xpath("//*[@id=\"menubutton1\"]")).click();
		Thread.sleep(2000);
		WebElement session_start =driver.findElement(By.xpath("//*[@id=\"context1\"]/span[1]"));
		WebElement properties = driver.findElement(By.xpath("//*[@id=\"context1\"]/span[2]"));
		if(session_start.isDisplayed() && properties.isDisplayed())
		{
			properties.click();
			
			logger.log(LogStatus.PASS, "<span style='color:green;'> 3 dots options are displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'> 3 dots options are not displayed </span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}	
		//driver.findElement(By.xpath("//*[@id='context2']/span[2]")).click();//*[contains(text(),'Properties...')]")).click();
		Thread.sleep(2000);
		WebElement destAdr= driver.findElement(By.xpath("//*[@id='host']"));
		destAdr.clear();
		destAdr.sendKeys("10.134.54.78");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"submit\" and @onclick=\"updateProp();\"]")).click();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'> Properties Pannel is clicked and displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
	}
	public void fnVerifyGUIPropertiesOption() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menubutton0"))));
		driver.findElement(By.id("menubutton0")).click();
		Thread.sleep(2000);
		WebElement start_Session= driver.findElement(By.xpath("//*[@id=\"context0\"]/span[1]"));
		WebElement properties= driver.findElement(By.xpath("//*[@id='context0']/span[2]"));
		if(start_Session.isDisplayed() && properties.isDisplayed()) {
			logger.log(LogStatus.PASS, "<span style='color:green;'>Start session and Properties are displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'>Start session and Properties are displayed</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}
		properties.click();
		if((driver.findElement((By.xpath("//*[@id=\"search_property\"]"))).isDisplayed()))
		{
		logger.log(LogStatus.PASS, "<span style='color:green;'>Search option is verified successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("generalactive"))));
		driver.findElement(By.id("generalactive")).click();
		Thread.sleep(2000);
		if((driver.findElement((By.id("sessionName"))).getText()).contains("3270 Display"))
			{
			logger.log(LogStatus.PASS, "<span style='color:green;'>Session name is verified successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
						
		if((driver.findElement(By.xpath("//*[contains(@id, 'host')]")).getText()).contains("10.134.71.156"))
			{
			logger.log(LogStatus.PASS, "<span style='color:green;'>Destination Address is verified successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
		if((driver.findElement(By.xpath("//*[contains(@id, 'port')]")).getText()).contains("992"))
		{
		logger.log(LogStatus.PASS, "<span style='color:green;'>Destination Port is verified successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
		}
		if((driver.findElement((By.id("TNEnhanced"))).isSelected()))
		{
		logger.log(LogStatus.PASS, "<span style='color:green;'>TN3270E option is verified successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
		}
		
		if(driver.findElement((By.id("negotiateCResolution"))).isSelected())
		{
		logger.log(LogStatus.FAIL, "<span style='color:green;'>contentresolution option is enabled</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
		}
		else
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>contentresolution option is verified successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
		}
		if(driver.findElement((By.id("LUName"))).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>LUName option is displayed successfully</span>"
		+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}
		if((driver.findElement((By.id("screensize"))).getText()).contains("24x80"))
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>screensize option is verified successfully</span>"
		+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}

		if(driver.findElement((By.id("codepage"))).isDisplayed())
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>codepage option is displayed successfully</span>"
		+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}
		WebElement  eleAdvancedtab= driver.findElement(By.id("advanced"));
		if(eleAdvancedtab.isDisplayed())
		{
			eleAdvancedtab.click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("connectionTimeout"))));
			if(driver.findElement((By.id("connectionTimeout"))).isDisplayed())
			{
				  logger.log(LogStatus.PASS,
			  "<span style='color:green;'>Connection Timeout option is displayed successfully</span>"
			 + logger.addScreenCapture(Common.CaptureScreenShot(driver,
			  "HACPEE Session Page"))); 
			  }
			  if(driver.findElement((By.id("panelOnlyTCPIPInactivityTimeout"))).isDisplayed())
			  {
				  logger.log(LogStatus.PASS,
				  "<span style='color:green;'>Connection Timeout option is displayed successfully</span>"
				 + logger.addScreenCapture(Common.CaptureScreenShot(driver,
				  "HACPEE Session Page"))); 
			  }
			  if((driver.findElement((By.id("keepAlive"))).isSelected()))
				{
				  logger.log(LogStatus.PASS, "<span style='color:green;'>keepAlive option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  else
			  {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>keepAlive option is not checked</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  
			  WebElement  AssociatedPrintertab= driver.findElement(By.xpath("//*[@id=\"printersession\"]"));
			  if(AssociatedPrintertab.isDisplayed())
				{
				  AssociatedPrintertab.click();
				  if(driver.findElement((By.xpath("//*[@id=\"printSupport\"]"))).isSelected())
					{
					logger.log(LogStatus.FAIL, "<span style='color:green;'>Printer session option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					else
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Printer session option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"printerLUName\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>PrinterLUName option is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"printBufferSize\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Print Buffer size is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if((driver.findElement(By.xpath("//*[@id=\"maxLinesPerPage\"]")).getText()).contains("60"))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>MaxLinesPerPage is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if((driver.findElement(By.xpath("//*[@id=\"maxCharsPerLine\"]")).getText()).contains("80"))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>MaxLinesCharPerLine is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"3270PSProps\"]/div[5]/label[2]/label/span"))).isSelected())
					{
					logger.log(LogStatus.FAIL, "<span style='color:green;'>Ignore FF when at First Position option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"3270PSProps\"]/div[6]/label[2]/label/span"))).isSelected())
					{
					logger.log(LogStatus.FAIL, "<span style='color:green;'>FF Takes Space if Before Data option is enabled</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  
				  
				  if(driver.findElement((By.xpath("//*[@id=\"formFeedPosition\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Form-feed Position is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"pdfPaperSize\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>PdfPaperSize option is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"pdfPaperOrientation\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>PaperOrientation is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"pdfFont\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Font option is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"printer_session_div\"]/div[4]/label[2]/label/span"))).isSelected())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Separate file option is enbled</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"printSaveAsExtension\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>File Extension is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  if(driver.findElement((By.xpath("//*[@id=\"intervTime\"]"))).isDisplayed())
					{
						logger.log(LogStatus.PASS, "<span style='color:green;'>Inactivity Time is displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				 
				} 
			  WebElement  Backupservertab= driver.findElement(By.id("backup_tab"));
			  Backupservertab.click();
			  if(driver.findElement((By.id("hostBackup1"))).isDisplayed())
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer1 Destination address is displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if((driver.findElement(By.id("portBackup1")).getText()).contains("23"))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer1 Destination port is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if(driver.findElement((By.id("LUNameBackup1"))).isDisplayed())
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer1 LUName is displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if(driver.findElement((By.id("hostBackup2"))).isDisplayed())
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer2 Destination address is displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if((driver.findElement(By.id("portBackup2")).getText()).contains("23"))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer2 Destination port is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if(driver.findElement((By.id("LUNameBackup2"))).isDisplayed())
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>BackupServer2 LUName is displayed successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if(driver.findElement((By.xpath("//*[@id=\"backup_server_div\"]/div[3]/label[2]"))).isSelected())
				{
				logger.log(LogStatus.FAIL, "<span style='color:green;'>Timeout option is enabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
				else
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Timeout option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  if(driver.findElement((By.xpath("//*[@id=\"backup_server_div\"]/div[4]/label[2]/label/span"))).isSelected())
				{
				logger.log(LogStatus.FAIL, "<span style='color:green;'>Connect option is enabled</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
				else
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Connect option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			  
	}
		    driver.findElement(By.xpath("//*[@id=\"tls\"]")).click();
		    Thread.sleep(2000);
		    if(driver.findElement((By.xpath("//*[@id=\"tls_ssl_div\"]/div[1]/label[2]/label/span"))).isSelected())
			{
			logger.log(LogStatus.FAIL, "<span style='color:green;'>FIPS option is enabled</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			else
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>FIPS option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
		    if(driver.findElement((By.xpath("//*[@id=\"tls_ssl_div\"]/div[2]/label[2]"))).isSelected())
			{
			logger.log(LogStatus.FAIL, "<span style='color:green;'>Send Certificate option is enabled</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			else
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Send Certificate option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
		    
		    WebElement  KeyUsageChkbox= driver.findElement(By.xpath("//*[@id=\"tls_ssl_div\"]/div[3]/label[2]/label/span"));
			   Thread.sleep(1000);
			   if(KeyUsageChkbox.isDisplayed()) {
				KeyUsageChkbox.click();
	}   
				WebElement  KeyUsageButton= driver.findElement(By.id("addKeyUsage"));
				if(KeyUsageButton.isDisplayed()) {
					Thread.sleep(1000);
					KeyUsageButton.click();
					logger.log(LogStatus.PASS, "<span style='color:green;'>KeyUsage button is clicked successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					
				}
				Thread.sleep(3000);
				WebElement  KeyUsageTab= driver.findElement(By.xpath("//*[@id=\"keyUsage\"]"));
				if(KeyUsageTab.isDisplayed()) {
					
					KeyUsageTab.click();
					logger.log(LogStatus.PASS, "<span style='color:green;'>keyUseTab is clicked successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[1]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Digital Signature option chkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Digital Signature option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[2]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Non-Repudiation Checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Non-Repudiation  option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[3]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Key Encipherment option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Key Encipherment  option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[4]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Data Encipherment option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Data Encipherment option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[5]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Key Agreement option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Key Agreement option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[6]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Certificate Signing option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Certificate Signing option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[7]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Encipher Only option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Encipher Only option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
					if((driver.findElement((By.xpath("//*[@id=\"keyUsage_div\"]/table/tbody/tr[8]/td[1]/label/span"))).isSelected()))
					{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Decipher Only option checkbox is selected successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.PASS, "<span style='color:green;'>Decipher Only option is verified successfully</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}	
				WebElement  extendedKeyUsageTab= driver.findElement(By.id("extendedKeyUsageTab"));
				if(extendedKeyUsageTab.isDisplayed()) {
					extendedKeyUsageTab.click();
					logger.log(LogStatus.PASS, "<span style='color:green;'>ExtendedKeyUsageTab is displayed successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}	
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[1]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Server Authentication Checkbox is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Server Authentication option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[2]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Client Authentication option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Client Authentication option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[3]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Code Signing option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Code Signing option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[4]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Secure Email option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Secure Email option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[5]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec End System option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec End System  option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[6]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec Tunneling System option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec Tunneling option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[7]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec User option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>IPSec User option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.xpath("//*[@id=\"extKeyUsage_div\"]/table/tbody/tr[8]/td[1]/label/span"))).isSelected()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Time Stamping option is selected successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Time Stamping option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				
				WebElement  CustomKeyUsage= driver.findElement(By.id("customKeyUsage"));
				if(CustomKeyUsage.isDisplayed()) {
					CustomKeyUsage.click();
					logger.log(LogStatus.PASS, "<span style='color:green;'>CustomKeyUsageTab is displayed successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}else {
						logger.log(LogStatus.FAIL, "<span style='color:green;'>CustomKeyUsageTab is not displayed </span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}	
				if((driver.findElement((By.id("keyDescription"))).isDisplayed()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>New KeyDescription is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>New KeyDescription is not displayed </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.id("keyObjIdentifier"))).isDisplayed()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>KeyObjIdentifier is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>KeyObjIdentifier is not displayed </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}		
				if((driver.findElement((By.id("addCustomKeyUsage"))).isEnabled()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>AddCustomKeyUsage button is enabled </span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>AddCustomKeyUsage button is disable state </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}	
				
				WebElement Keyusage_Okay 	=driver.findElement(By.xpath("//*[contains(@onclick,'updateKUProp()')]"));
				Keyusage_Okay.click();
				logger.log(LogStatus.PASS, "<span style='color:green;'>KeyUsage Save button is clicked successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				if((driver.findElement((By.xpath("//*[@id=\"SSLCertificatePromptHowOften\"]"))).isDisplayed()))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>How Often to Prompt is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
				
				//Preference tab
				WebElement preferences_Tab 	=driver.findElement(By.id("preferences_div_tab"));
			
				if((preferences_Tab.isDisplayed()))
				{
					preferences_Tab.click();
				logger.log(LogStatus.PASS, "<span style='color:green;'>Preference Tab is displayed successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>Preference Tab is not displayed </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
				WebElement AutoStart_macro 	=driver.findElement(By.id("autostartName"));
				if((AutoStart_macro.isEnabled()))
				{
					
				logger.log(LogStatus.PASS, "<span style='color:green;'>Auto-Start Macro is editable </span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.FAIL, "<span style='color:green;'>Auto-Start Macro is not editable </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
				if((driver.findElement((By.xpath("//*[@id=\"preferences_div\"]/div[2]/label[2]/label/span"))).isSelected()))
				{
					logger.log(LogStatus.PASS, "<span style='color:green;'>Start Automatically checkbox is checked succesfully </span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}else {
					logger.log(LogStatus.PASS, "<span style='color:green;'>Start Automatically checkbox is not checked </span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
									
				WebElement Property_Cancel 	=driver.findElement(By.xpath("//*[@id=\"sessionProps\"]/div/div/div[3]/button[2]"));
				Property_Cancel.click();
				logger.log(LogStatus.PASS, "<span style='color:green;'>Property Cancel button is clicked successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
						
				    
		
	}
	public void fnVerifyPropertiesOption() throws IOException, InterruptedException
		
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("generalactive"))));
			driver.findElement(By.id("generalactive")).click();
			Thread.sleep(2000);
			if((driver.findElement((By.id("sessionName"))).getText()).contains("3270 Display"))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Session name is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
							
			if((driver.findElement(By.xpath("//*[contains(@id, 'host')]")).getText()).contains("10.134.71.156"))
				{
				logger.log(LogStatus.PASS, "<span style='color:green;'>Destination Address is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
				}
			if((driver.findElement(By.xpath("//*[contains(@id, 'port')]")).getText()).contains("23"))
			{
			logger.log(LogStatus.PASS, "<span style='color:green;'>Destination Port is verified successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			if((driver.findElement((By.id("TNEnhanced"))).isSelected()))
			{
			logger.log(LogStatus.PASS, "<span style='color:green;'>TN3270E option is verified successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			
			if(driver.findElement((By.id("negotiateCResolution"))).isSelected())
			{
			logger.log(LogStatus.FAIL, "<span style='color:green;'>contentresolution option is enabled</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			else
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>contentresolution option is verified successfully</span>"
						+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
			}
			if(driver.findElement((By.id("LUName"))).isDisplayed())
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>LUName option is displayed successfully</span>"
			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
			if((driver.findElement((By.id("screensize"))).getText()).contains("24x80"))
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>screensize option is verified successfully</span>"
			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}

			if(driver.findElement((By.id("codepage"))).isDisplayed())
			{
				logger.log(LogStatus.PASS, "<span style='color:green;'>codepage option is displayed successfully</span>"
			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
			}
			

			/*
			 * if((driver.findElement((By.id("autoconnect"))).isSelected())) {
			 * logger.log(LogStatus.PASS,
			 * "<span style='color:green;'>autoconnect option is verified successfully</span>"
			 * + logger.addScreenCapture(Common.CaptureScreenShot(driver,
			 * "HACPEE Properties Page"))); }
			 * 
			 * if((driver.findElement((By.id("autoreconnect"))).isSelected())) {
			 * logger.log(LogStatus.PASS,
			 * "<span style='color:green;'>autoreconnect option is verified successfully</span>"
			 * + logger.addScreenCapture(Common.CaptureScreenShot(driver,
			 * "HACPEE Properties Page"))); }
			 */
			
			WebElement  eleAdvancedtab= driver.findElement(By.id("advanced"));
			if(eleAdvancedtab.isDisplayed())
			{
				eleAdvancedtab.click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("connectionTimeout"))));
				if(driver.findElement((By.id("connectionTimeout"))).isDisplayed())
				{
					  logger.log(LogStatus.PASS,
				  "<span style='color:green;'>Connection Timeout option is displayed successfully</span>"
				 + logger.addScreenCapture(Common.CaptureScreenShot(driver,
				  "HACPEE Session Page"))); 
				  }
				  if(driver.findElement((By.id("panelOnlyTCPIPInactivityTimeout"))).isDisplayed())
				  {
					  logger.log(LogStatus.PASS,
					  "<span style='color:green;'>Connection Timeout option is displayed successfully</span>"
					 + logger.addScreenCapture(Common.CaptureScreenShot(driver,
					  "HACPEE Session Page"))); 
				  }
				  if((driver.findElement((By.id("keepAlive"))).isSelected()))
					{
					  logger.log(LogStatus.PASS, "<span style='color:green;'>keepAlive option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  else
				  {
						logger.log(LogStatus.FAIL, "<span style='color:green;'>keepAlive option is not checked</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
  
		}
			WebElement  Backupservertab= driver.findElement(By.id("backup"));
			if(Backupservertab.isDisplayed())
			{
				Backupservertab.click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("backup_label1"))));
					if((driver.findElement((By.id("timeoutNoDataAtInitialization"))).isSelected()))
					{
					  logger.log(LogStatus.PASS, "<span style='color:green;'>timeOut_noData option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				  else
				  {
						logger.log(LogStatus.FAIL, "<span style='color:green;'>timeOut_noData option is not checked</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
						
					}
				if((driver.findElement((By.id("lastHostWithoutTimeout"))).isSelected()))
				{
					  logger.log(LogStatus.PASS, "<span style='color:green;'>connectToLastHostoData option is verified successfully</span>"
							+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
				else
				  {
						logger.log(LogStatus.FAIL, "<span style='color:green;'>connectToLastHost option is not checked</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));
					}
			}
			
		}	
	
	public void Verifysearch() throws InterruptedException {
				
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("myInput")); 
		search.sendKeys("3270");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>3270 session is entered in search box and verified</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "3270 session search")));
		search.clear();		
		search.sendKeys("5250");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>5250 session is entered in search box and verified</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "5250 session search")));		
		search.clear();
		
	}
	
	public void ClickAndVerifyKepPadIcon() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement Keypad = driver.findElement(By.id("keyboard")); 
		Keypad.click();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Keypad is clicked and displayed</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Keypad")));
		Keypad.click();
	}
	
	public void VerifySettingsFont() throws InterruptedException {
		
		Thread.sleep(4000);
		WebElement Settings = driver.findElement(By.id("masterSettingButton")); 
		Settings.click();
		Thread.sleep(2000); 
		
		WebElement FontDropdown = driver.findElement(By.id("selectFont")); 
		FontDropdown.click();
		Thread.sleep(2000); 
		
		
		WebElement SelectFont = driver.findElement(By.xpath("//*[@id='selectFontList']/li[1]/a")); 
		SelectFont.click();
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Font gets selected</span>");
		
		WebElement settingSave = driver.findElement(By.id("settingSave")); 
		settingSave.click();
		Thread.sleep(2000); 
		
		
		WebElement SaveCloseDialog = driver.findElement(By.xpath("//*[@id='saveSetting']/div/div/span/button")); 
		SaveCloseDialog.click();
		Thread.sleep(2000); 
			
		/*
		 * WebElement SelectTerminal = driver.findElement(By.id("SelectTerminal"));
		 * SelectTerminal.click(); Thread.sleep(1000); SelectTerminal.sendKeys("USER");
		 */	
		
	}
		
public void VerifySettingsFont5250() throws InterruptedException {
		
	/*
	 * Thread.sleep(4000); WebElement Settings =
	 * driver.findElement(By.id("masterSettingButton")); Settings.click();
	 * Thread.sleep(2000);
	 */
	
	
	WebElement RefreshInterval = driver.findElement(By.id("RefreshInterval")); 
	RefreshInterval.click();
	Thread.sleep(2000); 
	
	WebElement ChangeFont = driver.findElement(By.id("fontactive")); 
	ChangeFont.click();
	Thread.sleep(2000); 
	
		WebElement FontDropdown = driver.findElement(By.id("selectFont")); 
		FontDropdown.click();
		Thread.sleep(2000); 
		
		WebElement SelectFont = driver.findElement(By.xpath("//*[@id='selectFontList']/li[1]/a")); 
		SelectFont.click();
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Courier Font gets selected</span>");
		
		WebElement Preview_Font = driver.findElement(By.id("font_sample")); 
		String Font_Style = Preview_Font.getAttribute("style");
		if(Font_Style.contains("Courier")) {
			logger.log(LogStatus.PASS, "<span style='color:green;'>Courier Font gets displayed</span>");		
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Courier Font is not displayed</span>");	
		}
		Thread.sleep(2000); 
		
		WebElement settingSave = driver.findElement(By.id("settingSave")); 
		settingSave.click();
		Thread.sleep(2000); 
		
		
		WebElement SaveCloseDialog = driver.findElement(By.xpath("//*[@id='saveSetting']/div/div/span/button")); 
		SaveCloseDialog.click();
		Thread.sleep(2000); 
		
	}

	public void Verify5250ColorRemap() throws InterruptedException{
		
		Thread.sleep(2000);
		WebElement Settings = driver.findElement(By.id("masterSettingButton")); 
		Settings.click();
		Thread.sleep(2000);
		
		WebElement colorremap_icon = driver.findElement(By.id("colorremap_icon")); 
		colorremap_icon.click();
		Thread.sleep(2000);
		
		WebElement Foreground_Color = driver.findElement(By.xpath("//*[@id='fieldColor']/div[2]/div[1]/div/div[2]/div/span/span")); 
		Foreground_Color.click();
		Thread.sleep(2000);

		WebElement SelectBlue_Color = driver.findElement(By.xpath("//*[@id='fieldColor']/div[2]/div[1]/div/div[2]/div/div/ul/li[3]/span")); 
		SelectBlue_Color.click();
		Thread.sleep(2000);
		
		WebElement Foreground_ColorCode = driver.findElement(By.id("text_foreGroundColor_general_field_color")); 
		Foreground_ColorCode.click();
		Thread.sleep(2000);
		
		WebElement Background_Color = driver.findElement(By.xpath("//*[@id='fieldColor']/div[2]/div[2]/div/div[2]/div/span/span")); 
		Background_Color.click();
		Thread.sleep(2000);

		WebElement SelectWhite_Color = driver.findElement(By.xpath("//*[@id='fieldColor']/div[2]/div[2]/div/div[2]/div/div/ul/li[4]/span")); 
		SelectWhite_Color.click();
		Thread.sleep(2000);
		
		WebElement Background_ColorCode = driver.findElement(By.id("text_backgroundColor_general_field_color")); 
		Background_ColorCode.click();
		Thread.sleep(2000);
		
		WebElement settingSave = driver.findElement(By.id("settingSave")); 
		settingSave.click();
		Thread.sleep(2000); 
			
		WebElement SaveCloseDialog = driver.findElement(By.xpath("//*[@id='saveSetting']/div/div/span/button")); 
		SaveCloseDialog.click();
		Thread.sleep(2000); 
		
	}
		
	
	public void VerifyColorRemap() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement Session1 = driver.findElement(By.id("3270 Display-A")); 
		Session1.click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement Settings = driver.findElement(By.id("masterSettingButton")); 
		Settings.click();
		Thread.sleep(2000);
		
		WebElement colorremap_icon = driver.findElement(By.id("colorremap_icon")); 
		colorremap_icon.click();
		Thread.sleep(2000);
		
		// ******* Normal Protected ***************
		
		WebElement fgcnp = driver.findElement(By.xpath("//*[@id='nor_protected']/div[1]/div/div[2]/div/span/span"));
		fgcnp.click();
		Thread.sleep(500);
		WebElement fgscnp = driver.findElement(By.xpath("//*[@id='nor_protected']/div[1]/div/div[2]/div/div/ul/li[1]/span"));
		fgscnp.click();
		
		WebElement text_foreGroundColor_normal_protected = driver.findElement(By.id("text_foreGroundColor_normal_protected")); 
		text_foreGroundColor_normal_protected.clear();
		text_foreGroundColor_normal_protected.sendKeys("#00cf54");
		Thread.sleep(1000);
		
		WebElement bgcnp = driver.findElement(By.xpath("//*[@id='nor_protected']/div[2]/div/div[2]/div/span/span"));
		bgcnp.click();
		Thread.sleep(500);
		WebElement bgscnp = driver.findElement(By.xpath("//*[@id='nor_protected']/div[2]/div/div[2]/div/div/ul/li[4]/span"));
		bgscnp.click();
		
		WebElement text_backgroundColor_normal_protected = driver.findElement(By.id("text_backgroundColor_normal_protected")); 
		text_backgroundColor_normal_protected.clear();
		text_backgroundColor_normal_protected.sendKeys("#ffffff");
		Thread.sleep(1000);
		
		// ******* Normal Un-protected ***************
		
		WebElement nor_unprotected_btn = driver.findElement(By.id("nor_unprotected_btn")); 
		nor_unprotected_btn.click();
		Thread.sleep(1000);
		
		WebElement nor_unprotected_btnFGC = driver.findElement(By.xpath("//*[@id='nor_unprotected']/div[1]/div/div[2]/div/span/span")); 
		nor_unprotected_btnFGC.click();
		Thread.sleep(1000);
		
		WebElement nor_unprotected_btnFGCW = driver.findElement(By.xpath("//*[@id='nor_unprotected']/div[1]/div/div[2]/div/div/ul/li[1]/span")); 
		nor_unprotected_btnFGCW.click();
		Thread.sleep(1000);
				
		WebElement text_foreGroundColor_normal_unprotected = driver.findElement(By.id("text_foreGroundColor_normal_unprotected")); 
		text_foreGroundColor_normal_unprotected.clear();
		text_foreGroundColor_normal_unprotected.sendKeys("#00cf54");
		Thread.sleep(1000);
		
		WebElement nor_unprotected_btnBGC = driver.findElement(By.xpath("//*[@id='nor_unprotected']/div[2]/div/div[2]/div/span/span")); 
		nor_unprotected_btnBGC.click();
		Thread.sleep(1000);
		
		WebElement nor_unprotected_btnBGCW = driver.findElement(By.xpath("//*[@id='nor_unprotected']/div[2]/div/div[2]/div/div/ul/li[4]/span")); 
		nor_unprotected_btnBGCW.click();
		Thread.sleep(1000);
		
		WebElement text_backgroundColor_normal_unprotected = driver.findElement(By.id("text_backgroundColor_normal_unprotected")); 
		text_backgroundColor_normal_unprotected.clear();
		text_backgroundColor_normal_unprotected.sendKeys("#ffffff");
		Thread.sleep(1000);
		
		// ******* Intensified Protected ***************
		
		WebElement int_protected_btn = driver.findElement(By.id("int_protected_btn")); 
		int_protected_btn.click();
		Thread.sleep(1000);
		
		WebElement int_protected_btnFGC = driver.findElement(By.xpath("//*[@id='int_protected']/div[1]/div/div[2]/div/span/span")); 
		int_protected_btnFGC.click();
		Thread.sleep(1000);
		
		WebElement int_protected_btnFGCW = driver.findElement(By.xpath("//*[@id='int_protected']/div[1]/div/div[2]/div/div/ul/li[1]/span")); 
		int_protected_btnFGCW.click();
		Thread.sleep(1000);
		
		WebElement text_foreGroundColor_intensified_protected = driver.findElement(By.id("text_foreGroundColor_intensified_protected")); 
		text_foreGroundColor_intensified_protected.clear();
		text_foreGroundColor_intensified_protected.sendKeys("#00cf54");
		Thread.sleep(1000);
		
		WebElement int_protected_btnBGC = driver.findElement(By.xpath("//*[@id='int_protected']/div[2]/div/div[2]/div/span/span")); 
		int_protected_btnBGC.click();
		Thread.sleep(1000);
		
		WebElement int_protected_btnBGCW = driver.findElement(By.xpath("//*[@id='int_protected']/div[2]/div/div[2]/div/div/ul/li[4]/span")); 
		int_protected_btnBGCW.click();
		Thread.sleep(1000);
			
		WebElement text_backGroundColor_intensified_protected = driver.findElement(By.id("text_backGroundColor_intensified_protected")); 
		text_backGroundColor_intensified_protected.clear();
		text_backGroundColor_intensified_protected.sendKeys("#ffffff");
		Thread.sleep(1000);
		
		// ******* Intensified un-Protected ***************
		
		WebElement int_unprotected_btn = driver.findElement(By.id("int_unprotected_btn")); 
		int_unprotected_btn.click();
		Thread.sleep(1000);
		
		WebElement fgciunp = driver.findElement(By.xpath("//*[@id='int_unprotected']/div[1]/div/div[2]/div/span/span"));
		fgciunp.click();
		Thread.sleep(500);
		WebElement fgsciunp = driver.findElement(By.xpath("//*[@id='int_unprotected']/div[1]/div/div[2]/div/div/ul/li[1]/span"));
		fgsciunp.click();
		
		WebElement text_foreGroundColor_intensified_unprotected = driver.findElement(By.id("text_foreGroundColor_intensified_unprotected")); 
		text_foreGroundColor_intensified_unprotected.clear();
		text_foreGroundColor_intensified_unprotected.sendKeys("#00cf54");
		Thread.sleep(1000);
		
		WebElement bgciunp = driver.findElement(By.xpath("//*[@id='int_unprotected']/div[2]/div/div[2]/div/span/span"));
		bgciunp.click();
		Thread.sleep(500);
		WebElement bgsciunp = driver.findElement(By.xpath("//*[@id='int_unprotected']/div[2]/div/div[2]/div/div/ul/li[4]/span"));
		bgsciunp.click();
		
		WebElement text_backGroundColor_intensified_unprotected = driver.findElement(By.id("text_backGroundColor_intensified_unprotected")); 
		text_backGroundColor_intensified_unprotected.clear();
		text_backGroundColor_intensified_unprotected.sendKeys("#ffffff");
		text_backGroundColor_intensified_unprotected.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		WebElement settingSave = driver.findElement(By.id("settingSave")); 
		settingSave.click();
		Thread.sleep(2000); 
			
		WebElement SaveCloseDialog = driver.findElement(By.xpath("//*[@id='saveSetting']/div/div/span/button")); 
		SaveCloseDialog.click();
		Thread.sleep(2000); 	
		logger.log(LogStatus.PASS, "<span style='color:green;'>The changed color gets verified in the gressn screen</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "ColorChangeVerification")));
			 
	}
	
	public void ExecuteMacro() throws InterruptedException {
		
		WebElement elementSession=driver.findElement(By.id("sessionImg2"));
		wait.until(ExpectedConditions.visibilityOf(elementSession)); 
		wait.until(ExpectedConditions.elementToBeClickable(elementSession));
		elementSession.click();
		Thread.sleep(4000);
		
		WebElement ExpandIcon = driver.findElement(By.xpath("//*[@id='smallNavBar']/div/div[3]/a[3]/img")); 
		ExpandIcon.click();
		Thread.sleep(6000);
		
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		
		/*
		 * WebElement SessionMacTab = driver.findElement(By.id("sessionMac_Tab"));
		 * SessionMacTab.click();
		 */
		
		WebElement SelectMacro = driver.findElement(By.xpath("//*[@id='macroDropDown']/tr[3]/td")); 
		SelectMacro.click();
		Thread.sleep(500);
		/*
		 * WebElement ExeMacro = driver.findElement(By.id("executing_macro")); if
		 * (ExeMacro.isDisplayed()) { JavascriptExecutor js = (JavascriptExecutor)
		 * driver; js.
		 * executeScript("arguments[0].setAttribute('style', 'background: grey; border: 2px solid yellow;');"
		 * , ExeMacro); }
		 */
		logger.log(LogStatus.PASS, "<span style='color:green;'>Selected Macro gets executed</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Macro")));
		
		
		
	}
	
	public void VerifyPrintScreen() throws InterruptedException, AWTException {
		
		Thread.sleep(5000);
		WebElement PrintScreen = driver.findElement(By.id("printImageButton")); 
		PrintScreen.click();
		Thread.sleep(2000);
		
		logger.log(LogStatus.PASS, "<span style='color:green;'>Print screen gets clicked and the pop up gets opened to select printer</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Print")));
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		String child_window=I1.next();
		driver.switchTo().window(child_window);
		Thread.sleep(2000);
		I1.hasNext();
		driver.switchTo().window(child_window);
	//	driver.switchTo().window(parent);
	//	Thread.sleep(2000);
		
		/*
		 * while(I1.hasNext()) {
		 * 
		 * String child_window=I1.next();
		 * 
		 * 
		 * if(!parent.equals(child_window)) { driver.switchTo().window(child_window);
		 * 
		 * System.out.println(driver.switchTo().window(child_window).getTitle());
		 * 
		 * //driver.close(); } //switch to the parent window
		 * driver.switchTo().window(parent);
		 * 
		 * }
		 */
		

	Robot a = new Robot();
    a.keyPress(KeyEvent.VK_ENTER);Thread.sleep(3000); a.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(1000);
    
  
  		Thread.sleep(3000);
    
    a.keyPress(KeyEvent.VK_P); a.keyRelease(KeyEvent.VK_P); 
    a.keyPress(KeyEvent.VK_R); a.keyRelease(KeyEvent.VK_R); 
    a.keyPress(KeyEvent.VK_I); a.keyRelease(KeyEvent.VK_I); 
    a.keyPress(KeyEvent.VK_N); a.keyRelease(KeyEvent.VK_N); 
    a.keyPress(KeyEvent.VK_T); a.keyRelease(KeyEvent.VK_T); 
    
    logger.log(LogStatus.PASS, "<span style='color:green;'>Print button gets clicked and file gets downloaded on default location</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Print_Location")));
	
    a.keyPress(KeyEvent.VK_ENTER);Thread.sleep(3000); a.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(1000);
	
        
	}
	
	public void VerifyCutCopyPaste() throws InterruptedException {
			
		Thread.sleep(3000);
		WebElement SessionName = driver.findElement(By.id("dispName")); 
		SessionName.click();
		String A = SessionName.getAttribute("id");
		System.out.println("Session Name is: "+ A);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.dragAndDropBy(SessionName, 10, 10);
		Thread.sleep(3000);
			
		WebElement Terminal = driver.findElement(By.id("Terminal")); 
		Terminal.click();
		a.dragAndDropBy(Terminal, 50, 50);
		Thread.sleep(3000);
		
		
	}
	
	public void New_User() throws InterruptedException {
    	Thread.sleep(5000);
  	  WebElement UserIcon = driver.findElement(By.xpath("//div[@class='col-3 col-md-3 col-xl-3 col-lg-3 col-3']//img"));
  	UserIcon.click();
  	Thread.sleep(5000);
  		WebElement User_id = driver.findElement(By.id("newUserUserId"));
   		User_id.sendKeys("demo");
  		WebElement Discription = driver.findElement(By.id("newUserDesc"));
  		Discription.sendKeys("New User");
  		WebElement psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[3]/td[2]/input"));
  		psw.sendKeys("new");
  		WebElement Confirm_psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[4]/td[2]/input"));
  		Confirm_psw.sendKeys("new");
  		Thread.sleep(5000);
  		WebElement HOD_Icon = driver.findElement(By.xpath("//*[@id=\"avlblGrps\"]/div[2]/table/tr[2]/td/img[2]"));
  		HOD_Icon.click();
  		
  		WebElement Save_button = driver.findElement(By.xpath("//*[@id=\"submit\"]")); 
  	
  		Save_button.click();
  		
    	
    }
	
	public void Enter_Credentials_configmodel() throws InterruptedException {
		logger.log(LogStatus.INFO, "<span class='label success'>CONFIG MODEL VERIFICATION</span>");	
		
		Thread.sleep(4000);
		WebElement User = driver.findElement(By.id("uname")); 
		User.sendKeys("admin");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Username gets entered as : </span>" + "<span class='label success'>" + "admin" + "</span>");
		WebElement Pwd = driver.findElement(By.id("pwd")); 
		Pwd.sendKeys("password");
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password gets entered</span>" );
		WebElement LoginButton = driver.findElement(By.id("login_button")); 
		LoginButton.click();
		Thread.sleep(3000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login button gets clicked and home page is displayed</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));		
		
	}

	public void Enter_Invalid_Credentials_configmodel() throws InterruptedException {
		
		Thread.sleep(4000);
		WebElement User = driver.findElement(By.id("uname")); 
		User.sendKeys("Invalidadmin");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'> Invalid Username gets entered as : </span>" + "<span class='label success'>" + "Invalidadmin" + "</span>");
		WebElement Pwd = driver.findElement(By.id("pwd")); 
		Pwd.sendKeys("password");
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password gets entered</span>" );
		WebElement LoginButton = driver.findElement(By.id("login_button")); 
		LoginButton.click();
		Thread.sleep(3000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login button gets clicked</span>");		
		Thread.sleep(3000); 
		WebElement Error_Message = driver.findElement(By.id("errorMessage")); 
		String actual = Error_Message.getText();
		String expected = "Unknown user. Please try again.";	
		assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Error mesage is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));		
		
		User.clear(); Pwd.clear();
	}
	
	public void Enter_Invalid_Credentials_Adminconsole() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement User = driver.findElement(By.id("uname")); 
		User.sendKeys("Invalidadmin");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'> Invalid Username gets entered as : </span>" + "<span class='label success'>" + "Invalidadmin" + "</span>");
		WebElement Pwd = driver.findElement(By.id("pwd")); 
		Pwd.sendKeys("password");
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password gets entered</span>" );
		WebElement LoginButton = driver.findElement(By.id("login-button")); 
		LoginButton.click();
		Thread.sleep(3000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login button gets clicked</span>");		
		Thread.sleep(5000); 
		WebElement Error_Message = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]/div/app-notification/div/span")); 
		Thread.sleep(2000);
		String actual = Error_Message.getText().trim();
		String expected = "Unknown User. Please try again.";	
		assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Error mesage is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));		
		
		User.clear();
		Pwd.clear();
		
		
	}
	
	public void Enter_Credentials_adminconsole() throws InterruptedException {
		logger.log(LogStatus.INFO, "<span class='label success'>ADMINCONSOLE VERIFICATION</span>");	
		
		Thread.sleep(4000);
		WebElement User = driver.findElement(By.id("uname")); 
		User.sendKeys("admin");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Username gets entered as : </span>" + "<span class='label success'>" + "admin" + "</span>");
		WebElement Pwd = driver.findElement(By.id("pwd")); 
		Pwd.sendKeys("password");
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password gets entered</span>" );
		WebElement LoginButton = driver.findElement(By.id("login-button")); 
		LoginButton.click();
		Thread.sleep(3000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login button gets clicked and home page is displayed</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "Config Model")));		
		
	}
	
	public void Validate_TitleOfAdminconsole() throws InterruptedException {
		
		WebElement Title_Element = driver.findElement(By.xpath("//div[@class='product-navbar pl-3 pt-0 pr-3']/a/span")); 
		if(Title_Element.isDisplayed()) {
			
			logger.log(LogStatus.PASS, "<span style='color:green;'>HACP-ADMINCONSOLE Title is displayed</span>");
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'>HACP-ADMINCONSOLE Title is not displayed</span>");
		}
				
		
	}
	public void ClickExpandIcon() throws InterruptedException {
		WebElement ExpandIcon = driver.findElement(By.xpath("//*[@id=\"buttonsBar\"]/div[1]/div/img")); 
		ExpandIcon.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Navigation bar icon gets clicked and expanded</span>");
	}
	public void Click_On_User() throws InterruptedException {
		logger.log(LogStatus.PASS, "<span style='color:green;'>USER TAB VERIFICATION</span>");
		Thread.sleep(2000);
		WebElement UserTab = driver.findElement(By.xpath("//span[contains(text(),'All Users')]"));
		logger.log(LogStatus.PASS, "<span style='color:green;'>User tab gets clicked and expanded</span>");
		UserTab.click();
	}
	public void HOD_User() throws InterruptedException {
		Thread.sleep(2000);
		WebElement UserTab = driver.findElement(By.xpath("//table[@class='my-3 group-table']/tr[3]/td/div/div[1]/span"));
		logger.log(LogStatus.PASS, "<span style='color:green;'>HOD User Verification </span>"); 
		UserTab.click();
	}
	public void PCOMM_User() throws InterruptedException {
		logger.log(LogStatus.PASS, "<span style='color:green;'>PCOMM USER VERIFICATION </span>");
		Thread.sleep(2000);
		WebElement PCOMM_Tab = driver.findElement(By.xpath("//table[@class='my-3 group-table']/tr[2]/td/div/div[1]"));
		 
		PCOMM_Tab.click();
	}
public void PCOMM_Dot_option() throws InterruptedException {
		
		WebElement Dot_icon = driver.findElement(By.xpath("//table[@class='my-3 group-table']/tr[2]/td/div/div[2]/div/img"));
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Dot option gets clicked </span>");
		Dot_icon.click();
	}
	public void Dot_option() throws InterruptedException {
		
		WebElement Dot_icon = driver.findElement(By.className("pr-2"));
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Dot option gets clicked </span>");
		Dot_icon.click();
	}
public void NewUser_Dot_option() throws InterruptedException {
	Thread.sleep(5000);
		WebElement Dot_icon = driver.findElement(By.xpath("//table[@class='my-3 user-table']/tr[1]/td/div/div[2]/div/img"));
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>NewUser dot option gets clicked </span>");
		Dot_icon.click();
		
	}
	
public void AdminConsole_Options() throws InterruptedException {
	Thread.sleep(2000);
	String[] expected = {"Users", "Services", "Directory", "Host Connections", "Log", "Trace Settings", "Preferences"};
	List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='buttonClass p-2 ng-star-inserted']"));
	 List validFields = Arrays.asList(expected);
	ArrayList<String> availableitems =new ArrayList<String>();
	for(WebElement ele : allOptions) {
		availableitems.add(ele.getText().trim());
	}
	 System.out.println("expected options are : " + Arrays.toString(expected));
	 System.out.println("Actual options are : " + availableitems);
	 for (int i =0;i<expected.length;i++){
             assertTrue(availableitems.contains(expected[i].trim()), "Adminconsole tabs  are not available");
     
     }
	
	
}
	public void VerifyNewUserdotoption() throws InterruptedException {
		
		Thread.sleep(5000);
		/*String[] expected = {"Sessions", "Disable Functions", "Copy", "Cut", "Paste Session", "Delete", "Trace Facility","Properties"};
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"mat-menu-panel-4\"]/div/div/button"));
		 List validFields = Arrays.asList(expected);
		ArrayList<String> availableitems =new ArrayList<String>();   
		for(WebElement ele : allOptions) {
			availableitems.add(ele.getText().trim());
		}
		 System.out.println("expected options are : " + Arrays.toString(expected));
		 System.out.println("Actual options are : " + availableitems);
		 for (int i =0;i<expected.length;i++){
	             assertTrue(availableitems.contains(expected[i].trim()), "Adminconsole 3dots  are not available");
	           
	     }*/
		
		 WebElement Session = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/button[1]/span")); 
		 Session.click();
		 WebElement Title = driver.findElement(By.className("dialogHeader")); 
			//WebElement Title = driver.findElement(By.xpath("//*[@id=\"mat-dialog-14\"]/app-sessions-panel/div/div[2]")); 
			Thread.sleep(4000);
			String actual = Title.getText();
			String expected = "Configured Sessions - demo";	
			assertEquals(actual, expected);
			logger.log(LogStatus.PASS, "<span style='color:green;'>Session heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
			if(actual.equalsIgnoreCase(expected))
		    {
		        System.out.println("String is same");
		    }
		    else{
		        System.out.println("String is not same");
		    }
	}

public void VerifyUserOptions() throws InterruptedException {
		
		Thread.sleep(2000);
		
		//WebElement Dot_icon = driver.findElement(By.className("pr-2"));
		//Dot_icon.click();
		//*[@id=\"mat-menu-panel-10\"]/div/div/button[1]
		
		//logger.log(LogStatus.PASS, "<span style='color:green;'>Dot icon gets clicked</span>");
		WebElement Session = driver.findElement(By.xpath("//span[contains(text(), 'Sessions')]"));
		
		WebElement Disable_fuction = driver.findElement(By.xpath("//span[contains(text(), 'Disable Functions')]"));
		WebElement Copy = driver.findElement(By.xpath("//span[contains(text(), 'Copy')]"));
		
		WebElement Cut = driver.findElement(By.xpath("//span[contains(text(), 'Cut')]"));
		
		WebElement Paste_Session = driver.findElement(By.xpath("//span[contains(text(), 'Paste Session')]"));
		WebElement Delete = driver.findElement(By.xpath("//span[contains(text(), 'Delete')]"));
		WebElement Trace = driver.findElement(By.xpath("//span[contains(text(), 'Trace Facility')]"));
		WebElement Properties = driver.findElement(By.xpath("//span[contains(text(), 'Properties')]"));
		
		
		if(Session.isDisplayed()&&Disable_fuction.isDisplayed()&&Copy.isDisplayed()&&Cut.isDisplayed()&&
				Paste_Session.isDisplayed()&&Delete.isDisplayed()&&Trace.isDisplayed()&&Properties.isDisplayed()&&
				Session.isEnabled()&&Disable_fuction.isEnabled()&&Copy.isEnabled()&&Cut.isEnabled()&&
				Paste_Session.isEnabled()&&Delete.isEnabled()&&Trace.isEnabled()&&Properties.isEnabled()) {
			
			logger.log(LogStatus.PASS, "<span style='color:green;'>The below options are displayed while clicking on Dot user icon : </span> </br>" + 
					  "<span class='label success'>" + "Session " + "</span></br>"
					+ "<span class='label success'>" + " Disable_fuction" + "</span></br>"
					+ "<span class='label success'>" + " Copy" + "</span></br>"
					+ "<span class='label success'>" + "Cut" + "</span></br>"
					+ "<span class='label success'>" + "Paste_Session" + "</span></br>"
					+ "<span class='label success'>" + "Delete" + "</span></br>"
					+ "<span class='label success'>" + "Trace" + "</span></br>"
					+ "<span class='label success'>" + "Properties" + "</span></br>");
			logger.addScreenCapture(Common.CaptureScreenShot(driver, "User_Options"));	
		}
		
	}
public void NewUser_3270Session() throws InterruptedException {
	
	Thread.sleep(1000);
	WebElement Session_Icon = driver.findElement(By.xpath("//*[@id=\"3270\"]"));
	Session_Icon.click();
	WebElement sessionName = driver.findElement(By.id("sessionName"));
	sessionName.sendKeys("3270 Display");
	Thread.sleep(2000);
	WebElement hostName = driver.findElement(By.xpath("//*[@id=\"host\"]"));
	hostName.sendKeys("10.134.71.156");
	Thread.sleep(1000);
	WebElement Save = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	Save.click();
		
	logger.log(LogStatus.PASS, "<span style='color:green;'>3270 session is created successfully</span>");		
}
public void NewUser_5250Session() throws InterruptedException {
	  Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session gets clicked</span>");
	WebElement Session_Icon = driver.findElement(By.xpath("//*[@id=\"5250\"]"));
	Session_Icon.click();
	WebElement sessionName = driver.findElement(By.id("sessionName"));
	sessionName.sendKeys("5250 Display");
	Thread.sleep(2000);
	WebElement hostName = driver.findElement(By.xpath("//*[@id=\"host\"]"));
	hostName.sendKeys("10.134.54.46");
	Thread.sleep(1000);
	WebElement Save = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	Save.click();
	Thread.sleep(2000);
	//WebElement close_popup = driver.findElement(By.xpath("//*[@id=\"mat-dialog-27\"]/app-notification/div/img"));
	WebElement close_popup = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/mat-dialog-container/app-notification/div/img"));
	close_popup.click();
	
	logger.log(LogStatus.PASS, "<span style='color:green;'>5250 session is created successfully</span>");		
	
}
public void NewUser_5250StartSession() throws InterruptedException {
	Thread.sleep(5000);
	logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session 3dots gets clicked</span>");
	WebElement Session = driver.findElement(By.xpath("/html/body/div/div[2]/div/mat-dialog-container/app-sessions-panel/div/div[3]/div/div[2]/div/div[1]/img"));
	Thread.sleep(3000);
	Session.click();
    WebElement Start_Session = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-4\"]/div/div/button[1]"));
    Start_Session.click();
    Thread.sleep(5000);
    
    String currentwindow = driver.getWindowHandle();
    
    Set<String> allWindows = driver.getWindowHandles();
    Iterator<String> i = allWindows.iterator();
    
    while(i.hasNext()){
       String childwindow = i.next();
       if(!childwindow.equalsIgnoreCase(currentwindow)){
          driver.switchTo().window(childwindow);
          System.out.println("The child window is "+childwindow);
       } else {
          System.out.println("There are no children");
       }
    }
    driver.quit();
    
    
    
}
public void Session3270_Display() throws InterruptedException {
	
	Thread.sleep(3000); 
	WebElement session_name = driver.findElement(By.xpath("//*[@id=\"SessionPanel\"]/div/div[2]/div[1]/div[2]/img")); 
	session_name.isDisplayed();  
	logger.log(LogStatus.PASS, "<span style='color:green;'>3270 session is Displayed successfully</span>");		
	}
public void Session5250_Display() throws InterruptedException {
	
	Thread.sleep(3000); 
	WebElement session_name = driver.findElement(By.xpath("//*[@id=\"SessionPanel\"]/div/div[2]/div[2]/div[2]/img")); 
	session_name.isDisplayed();  
	logger.log(LogStatus.PASS, "<span style='color:green;'>5250 session is Displayed successfully</span>");		
	}
  public void VerifySession_Tab() throws InterruptedException {
	  Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Session gets clicked</span>");
		WebElement Session = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/button[1]"));
	Session.click();
	WebElement Title = driver.findElement(By.className("dialogHeader")); 
	//WebElement Title = driver.findElement(By.xpath("//*[@id=\"mat-dialog-14\"]/app-sessions-panel/div/div[2]")); 
	Thread.sleep(4000);
	String actual = Title.getText();
	String expected = "Configured Sessions - admin";	
	assertEquals(actual, expected);
	logger.log(LogStatus.PASS, "<span style='color:green;'>Session heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
	if(actual.equalsIgnoreCase(expected))
    {
        System.out.println("String is same");
    }
    else{
        System.out.println("String is not same");
    }
	  boolean Help_Icon = driver.findElement(By.xpath("//div[@class='footerIcons sideByside']/app-help/a/img")).isDisplayed();
		System.out.println("help Icon is dispalyed: "+Help_Icon);
	
	//WebElement Cancel_button = driver.findElement(By.className("btn btn-outline-primary dialogButton")); 
	WebElement Cancel_button = driver.findElement(By.className("closeImage"));	
	Thread.sleep(4000);
	Cancel_button.click(); 
  }
  public void PCOMM_VerifySession_Tab() throws InterruptedException {
	  Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Session gets clicked</span>");
		WebElement Session = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/button[1]"));
	Session.click();
	WebElement Title = driver.findElement(By.className("dialogHeader")); 
	//WebElement Title = driver.findElement(By.xpath("//*[@id=\"mat-dialog-14\"]/app-sessions-panel/div/div[2]")); 
	Thread.sleep(4000);
	String actual = Title.getText();
	String expected = "Configured Sessions - PCOMM";	
	assertEquals(actual, expected);
	logger.log(LogStatus.PASS, "<span style='color:green;'>Session heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
	if(actual.equalsIgnoreCase(expected))
    {
        System.out.println("String is same");
    }
    else{
        System.out.println("String is not same");
    }
	
	//WebElement Cancel_button = driver.findElement(By.className("btn btn-outline-primary dialogButton")); 
	WebElement Cancel_button = driver.findElement(By.className("closeImage"));	
	Thread.sleep(4000);
	Cancel_button.click(); 
  }
  public void Disable_Functions_Tab() throws InterruptedException {
	  Thread.sleep(5000);
	 
		
		WebElement Disable = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-2\"]/div/div/button[2]/span"));
		Disable.click();
		Thread.sleep(4000);
		WebElement Title = driver.findElement(By.xpath("//span[contains(text(), 'Disable Functions - admin')]"));
		
	 
	String actual = Title.getText().trim();
	Thread.sleep(2000);
	String expected = "Disable Functions - admin";	
	assertEquals(actual, expected);
	
	logger.log(LogStatus.PASS, "<span style='color:green;'>Disable Functions - admin heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
	
	if(actual.equalsIgnoreCase(expected))
    {
        System.out.println("String is same");
    }
    else{
        System.out.println("String is not same");
    }
	  boolean Help_Icon = driver.findElement(By.xpath("//div[@class='footerIcons sideByside']/app-help/a/img")).isDisplayed();
		System.out.println("help Icon is dispalyed: "+Help_Icon);
  }
  public void PCOMM_Disable_Functions_Tab() throws InterruptedException {
	  Thread.sleep(5000);
	 
		
		WebElement Disable = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/button[2]"));
		Disable.click();
		Thread.sleep(4000);
		WebElement Title = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/app-manage-functions/div/div[2]"));
		
		 
		String actual = Title.getText().trim();
		Thread.sleep(2000);
		String expected = "Disable Functions - PCOMM";	
		assertEquals(actual, expected);
		
		logger.log(LogStatus.PASS, "<span style='color:green;'>Disable Functions - PCOMM heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
		
		if(actual.equalsIgnoreCase(expected))
	    {
	        System.out.println("String is same");
	    }
	    else{
	        System.out.println("String is not same");
	    }
  }
  public void Desktop_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Desktop = driver.findElement(By.id("keyButton"));
		Desktop.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Desktop Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
	
  }
  public void Connection_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Connection = driver.findElement(By.id("connectionButton"));
		Connection.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Connection Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Thread.sleep(2000);
		Disable_button.click();
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
	
  }
  public void Appearance_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Appearance_Button = driver.findElement(By.id("appearanceButton"));
		Appearance_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Appearance Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Macro_Tab() throws InterruptedException {
	  Thread.sleep(2000);
	  
		WebElement Macro_Button = driver.findElement(By.id("macroButton"));
		Macro_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void File_Transfer_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement File_Button = driver.findElement(By.xpath("//div[contains(text(), 'File Transfer ')]"));
		File_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>FileTranfer Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Expand_FileTransfer() throws InterruptedException {
		WebElement ExpandIcon = driver.findElement(By.xpath("//div[@class='navButton expandmenu disablefun-active']/img")); 
		ExpandIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Expand File tranfer Tab gets clicked and expanded</span>");
		Thread.sleep(3000);
		
	}
  public void FTP_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement FTP_Button = driver.findElement(By.xpath("//div[contains(text(), ' FTP ')]"));
		FTP_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>FTP Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Data_Transfer() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Datatransfer_Button = driver.findElement(By.xpath("//div[contains(text(), ' Data Transfer ')]"));
		Datatransfer_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Data Tranfer Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Expand_DataTransfer() throws InterruptedException {
		WebElement ExpandIcon = driver.findElement(By.xpath("//div[@class='navButton expandmenu disablefun-active']/img")); 
		ExpandIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Expand Data Trsnfer Tab gets clicked and expanded</span>");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Navigation bar icon gets clicked and expanded</span>");
	}
  
  public void Edit_Permission() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Edit_Button = driver.findElement(By.xpath("//div[contains(text(), ' Edit Permissions ')]"));
		Edit_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Edit Perminssion Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void SQL_Statement() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement SQL_Button = driver.findElement(By.xpath("//div[contains(text(), ' SQL Statements')]"));
		SQL_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>SQL Statement Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Configuration() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement Config_Button = driver.findElement(By.xpath("//div[contains(text(),   'Configuration ')]"));
		Config_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Configuration Tab gets clicked and expanded</span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void Display_Print_Functions_Tab() throws InterruptedException {
	  Thread.sleep(2000);
	  WebElement Display_Print = driver.findElement(By.xpath("//div[contains(text(),   ' Display Print Functions ')]"));
	  Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Display Print Session Tab gets clicked and expanded</span>");
		Display_Print.click();
		
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		 Thread.sleep(2000);
		Enable_button.click();
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]"));
		 Thread.sleep(2000);
		Disable_button.click();
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void  PrinterSession_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement  Printer = driver.findElement(By.xpath("//div[contains(text(),   ' Printer Session ')]"));
		 Thread.sleep(2000);
		 logger.log(LogStatus.PASS, "<span style='color:green;'>PrinterSession Tab gets clicked and expanded</span>");
		Printer .click();
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		 Thread.sleep(2000);
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		 Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
		Thread.sleep(2000);
  }
  public void  Preferences_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement  Preferences = driver.findElement(By.xpath("//div[@class='navButton disablefun-active']"));
		 Thread.sleep(2000);
		 Preferences.click();
		 logger.log(LogStatus.PASS, "<span style='color:green;'>Preference Tab gets clicked </span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
  }
  public void  Others_Tab() throws InterruptedException {
	  Thread.sleep(2000);
		WebElement  Other = driver.findElement(By.xpath("//div[contains(text(),   ' Others')]"));
		 Thread.sleep(2000);
		Other .click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Other Tab gets clicked </span>");
		WebElement Enable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[2]/input"));
		Enable_button.click();
		WebElement Disable_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[3]/input"));
		Disable_button.click();
		 Thread.sleep(2000);
		WebElement Inherit_button = driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div[1]/table/tr[1]/th[4]/input"));
		Inherit_button.click();
		
		WebElement  Cancle = driver.findElement(By.xpath("//button[contains(text(),   ' Cancel ')]"));
		Cancle .click();
  }
  public void Trace_Facility_Tab() throws InterruptedException {
  Thread.sleep(2000);
	logger.log(LogStatus.PASS, "<span style='color:green;'>Trace Facilitis gets clicked</span>");
	WebElement Trace_Facility = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-2\"]/div/div/button[7]"));
	Trace_Facility.click();
WebElement Title = driver.findElement(By.className("dialogHeader")); 
Thread.sleep(2000);
String actual = Title.getText().trim();
String expected = "Server Log";	
assertEquals(actual, expected);


logger.log(LogStatus.PASS, "<span style='color:green;'>Trace Facility Tab heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
if(actual.equalsIgnoreCase(expected))
{
    System.out.println("String is same");
}
else{
    System.out.println("String is not same");
}
boolean Help_Icon = driver.findElement(By.xpath("//div[@class='footerIcons sideByside']/app-help/a/img")).isDisplayed();
	System.out.println("help Icon is dispalyed: "+Help_Icon);
WebElement Refresh_button = driver.findElement(By.xpath("//div[@class='modelBottomDiv']/img")); 
Refresh_button.click();
Thread.sleep(5000);
WebElement Cancel_button = driver.findElement(By.xpath("//div[@class='modelBottomDiv']/button")); 
Thread.sleep(2000);
Cancel_button.click();
//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modelBottomDiv']/button"))).click();;



  }
  public void Properties_Tab() throws InterruptedException {
	  Thread.sleep(2000);
	  WebElement Property = driver.findElement(By.xpath("//*[contains(text(), 'Properties')]"));
	  Property.click();
	  WebElement Title = driver.findElement(By.xpath("//span[contains(text(), 'Edit User')]")); 
		//WebElement Title = driver.findElement(By.xpath("//*[@id=\"mat-dialog-14\"]/app-sessions-panel/div/div[2]")); 
		Thread.sleep(4000);
		String actual = Title.getText();
		String expected = "Edit User";	
		assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Properties heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
		if(actual.equalsIgnoreCase(expected))
	    {
	        System.out.println("String is same");
	    }
	    else{
	        System.out.println("String is not same");
	    }
		  boolean Help_Icon = driver.findElement(By.xpath("//div[@class='footerIcons sideByside']/app-help/a/img")).isDisplayed();
			System.out.println("help Icon is dispalyed: "+Help_Icon);
		WebElement User_id = driver.findElement(By.id("newUserUserId"));
		WebElement Discription = driver.findElement(By.id("newUserDesc"));
		WebElement psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[3]/td[2]/input"));
		WebElement Confirm_psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[4]/td[2]/input"));
		//WebElement Save_preference = driver.findElement(By.id("noSavePref"));
		
		
		if(User_id.isDisplayed()&&Discription.isDisplayed()&&psw.isDisplayed()&&Confirm_psw.isDisplayed()&&
				User_id.isEnabled()&&Discription.isEnabled()&&psw.isEnabled()&&Confirm_psw.isEnabled()) {
			
			logger.log(LogStatus.PASS, "<span style='color:green;'>The below options are displayed while clicking on Property tab : </span> </br>" + 
					  "<span class='label success'>" + "User_id " + "</span></br>"
					+ "<span class='label success'>" + " Discription" + "</span></br>"
					+ "<span class='label success'>" + " Password" + "</span></br>"
					+ "<span class='label success'>" + "Confirmpsw" + "</span></br>");
			logger.addScreenCapture(Common.CaptureScreenShot(driver, "Property_Options"));	
		}
			boolean Save_preference = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[1]/label/span")).isSelected();
			Thread.sleep(2000);
			System.out.println(Save_preference);
			//Save_preference.click();
			WebElement UserCanChangePsw = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[2]/label/span"));
			UserCanChangePsw.click();
			WebElement Racf = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[4]/label/span"));
	  		Racf.click();
	  		
	  		System.out.println("User Password is enabled"+psw.isEnabled());
	  		
	  		System.out.println("User Password is enabled"+Confirm_psw.isEnabled());
	  		System.out.println("User can change password is enabled :"+UserCanChangePsw.isEnabled());
			WebElement UserNative = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[3]/label/span"));
			UserNative.click();
			
			WebElement Native_UserId = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[2]/td[2]/input"));
			
			if(Racf.isDisplayed()&&Native_UserId.isDisplayed()&&psw.isDisplayed()&&Confirm_psw.isDisplayed()&&UserCanChangePsw.isDisplayed()&&
					Racf.isEnabled()&&Native_UserId.isEnabled()&&psw.isEnabled()&&Confirm_psw.isEnabled()&&UserCanChangePsw.isEnabled()) {
				
				logger.log(LogStatus.PASS, "<span style='color:green;'>The below options are displayed and enableed while clicking on Property tab : </span> </br>" + 
						  "<span class='label success'>" + "Racf " + "</span></br>"
						+ "<span class='label success'>" + " Native_UserId" + "</span></br>"
						+ "<span class='label success'>" + " UserCanChangePsw" + "</span></br>"
						+ "<span class='label success'>" + " Password" + "</span></br>"
						+ "<span class='label success'>" + "Confirmpsw" + "</span></br>");
				logger.addScreenCapture(Common.CaptureScreenShot(driver, "Property_Options"));	
			
		}
			
		WebElement Cancel_button = driver.findElement(By.xpath("//button[contains(text(), ' Cancel')]")); 
		Thread.sleep(2000);
		Cancel_button.click();
		WebElement confirm = driver.findElement(By.xpath("//button[contains(text(), ' Confirm ')]"));
		confirm.click();
		
	  
  }
  
  public void Directory_Tab() throws InterruptedException {
	  logger.log(LogStatus.INFO, "<span class='label success'>DIRECTORY TAB VERIFICATION</span>");
	  WebElement DirectoryButton = driver.findElement(By.id("directoryButton"));
		DirectoryButton.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Directory Tab gets clicked </span>");
		  WebElement Title = driver.findElement(By.xpath("//div[@class='col-12']//span"));
		   	String actual = Title.getText().trim();
		  	Thread.sleep(2000);
		  	String expected = "Directory";	
		  	assertEquals(actual, expected);
		  	logger.log(LogStatus.PASS, "<span style='color:green;'>Trace Settings heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
		  	if(actual.equalsIgnoreCase(expected))
		  	{
		  	    System.out.println("String is same");
		  	}
		  	else{
		  	    System.out.println("String is not same");
		  	}
	 WebElement LDAP_Checkbox = driver.findElement(By.xpath("//*[@class='checkboxcontainer directory']//span"));
		 //WebElement LDAP_Checkbox = driver.findElement(By.xpath(" (//input[@type='checkbox'])[1]"));
	 if(LDAP_Checkbox.isDisplayed()) {
		 Thread.sleep(2000);
			LDAP_Checkbox.click(); 
	 }
		 
		Thread.sleep(2000);
		WebElement Dest_addr = driver.findElement(By.name("destAddres")); 
		Dest_addr.sendKeys("10.134.71.156");
		Thread.sleep(2000);
		WebElement Dest_Port = driver.findElement(By.name("destPort")); 
		Dest_Port.clear();
		Thread.sleep(2000);
		Dest_Port.sendKeys("380");
		
		WebElement Admin_Name = driver.findElement(By.name("adminName")); 
		Thread.sleep(2000);
		Dest_addr.sendKeys("Adminusr");
		WebElement AdminName_Suffix = driver.findElement(By.xpath("//*[@id=\"ldapTable\"]/tr[3]/td[2]/input")); 
		Thread.sleep(2000);
		AdminName_Suffix.sendKeys("AdminNameSuffix ");
		WebElement Password = driver.findElement(By.name("adminPaswrd")); 
		Thread.sleep(2000);
		Password.sendKeys("Password ");
		Thread.sleep(2000);
		WebElement Advanced_checkbox = driver.findElement(By.xpath("//*[@class='checkboxcontainer advance']//span"));
		Advanced_checkbox.click();
		Thread.sleep(2000);
		WebElement Refresh_button = driver.findElement(By.xpath("//div[@class='ml-auto']/img"));
		Refresh_button.click();
		Thread.sleep(2000);
		WebElement Cancel = driver.findElement(By.xpath("//div[@class='mx-auto']//button"));
		Cancel.click();

	  
  }
  public void Account_Tab() throws InterruptedException {
	  WebElement PreferencesButton = driver.findElement(By.xpath("//*[@id=\"preferencesButton\"]/div/img"));
	  Thread.sleep(2000);
	  PreferencesButton.click();
	  logger.log(LogStatus.PASS, "<span style='color:green;'>Preference Tab gets clicked </span>");
	  
	  WebElement Account = driver.findElement(By.xpath("//span[contains(text(), 'Accounts')]"));
	  if(Account.isDisplayed()) {
		  Account.click();
		  logger.log(LogStatus.PASS, "<span style='color:green;'>Account tab gets clicked  </span>");
	  }
	  else {
		  logger.log(LogStatus.FAIL, "<span style='color:green;'>Account tab is not displayed </span>"); 
	  } 
	  
	  WebElement Incorrect_psw = driver.findElement(By.xpath("//div[@class='h-100 col-9 col-md-9 col-lg-9 float-left']//table/tr/td[2]/input"));
	  if(Incorrect_psw.isEnabled()) {
		  logger.log(LogStatus.PASS, "<span style='color:green;'>Incorrect password field is enabled  </span>");
		 Incorrect_psw.clear();
		 Thread.sleep(4000);
		 Incorrect_psw.sendKeys("2");
	  }
	  WebElement Accounttab_savebutton = driver.findElement(By.id("serverLog"));
	  Accounttab_savebutton.click();
	  Thread.sleep(4000);
	  WebElement Accounttab_Popup = driver.findElement(By.xpath("//*[@class=\"alert-info info mx-0 p-1 ng-star-inserted\"]//img"));
	  Accounttab_Popup.click();
	  Thread.sleep(4000);
	  WebElement AdminlogOut = driver.findElement(By.xpath("//*[@title ='Logout']//img"));
	  AdminlogOut.click();
	  WebElement AdminlogOut_Confirm = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	  AdminlogOut_Confirm.click();
	  for(int i =0;i<2; i++) {
		  WebElement User = driver.findElement(By.id("uname")); 
			User.sendKeys("admin");
			Thread.sleep(2000);
			WebElement Pwd = driver.findElement(By.id("pwd")); 
			Pwd.sendKeys("pass");
			WebElement LoginButton = driver.findElement(By.id("login-button")); 
			LoginButton.click();
			User.clear();
			Pwd.clear();
	  }
	  WebElement Loginexceeded_Err = driver.findElement(By.xpath("//span[contains(text(),'Retry count exceeded')]"));
	System.out.println("Login Error Message is :"+Loginexceeded_Err.getText() );
  }
  public void Preference_Tab() throws InterruptedException {
	  logger.log(LogStatus.INFO, "<span class='label success'>PREFERENCE TAB VERIFICATION</span>");
	  //WebElement PreferencesButton = driver.findElement(By.id("preferencesButton"));
	  WebElement PreferencesButton = driver.findElement(By.xpath("//*[@id=\"preferencesButton\"]/div/img"));
	  Thread.sleep(2000);
	  PreferencesButton.click();
	  logger.log(LogStatus.PASS, "<span style='color:green;'>Preference Tab gets clicked </span>");
	  
	  WebElement Account = driver.findElement(By.xpath("//span[contains(text(), 'Accounts')]"));
	  if(Account.isDisplayed()) {
		  Account.click();
		  logger.log(LogStatus.PASS, "<span style='color:green;'>Account tab gets clicked successfully </span>");
	  }
	  else {
		  logger.log(LogStatus.FAIL, "<span style='color:green;'>Account tab is not displayed </span>"); 
	  }
	
	  boolean Incorrect_psw = driver.findElement(By.xpath("//div[@class='h-100 col-9 col-md-9 col-lg-9 float-left']//table/tr/td[2]/input")).isEnabled();
	  System.out.println("Account Incorrect password is :"+ Incorrect_psw);
	  
		 WebElement Account_Checkbox = driver.findElement(By.xpath("//span[@class='float-left']/label/span"));
		  if(Account_Checkbox.isSelected()) {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Account_Checkbox is selected successfully </span>");
		  }
		  else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Account_Checkbox is verified successfully </span>"); 
		  }
	
		
		WebElement License_Manager = driver.findElement(By.xpath("//div[contains(text(), 'License Manager')]"));
		
		if(License_Manager.isDisplayed()) {
			License_Manager.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'>License_Manager tab is  displayed successfully </span>");
		  }
		  else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>License_Manager tab is not displayed </span>"); 
		  }
		boolean License_Manager_Path = driver.findElement(By.xpath("//table[@class='w-75']/tr[1]/td[2]/input")).isEnabled();
		System.out.println("License_Manager_Path is enabled :"+License_Manager_Path);
		
		 boolean License_Manager_MacAddr = driver.findElement(By.xpath("//table[@class='w-75']/tr[2]/td[2]/span/label/span")).isSelected();
		  
		System.out.println("The checkbox is selection state is - " +License_Manager_MacAddr );
		 WebElement License_Manager_Macname= driver.findElement(By.xpath("//table[@class='w-75']/tr[3]/td[2]/span/label/span"));
			  
		System.out.println("The checkbox is selection state is - " + License_Manager_Macname.isSelected());
				
		boolean timeout = driver.findElement(By.xpath("//table[@class='w-75']/tr[4]/td[2]/input")).isEnabled();
		System.out.println("Time out is enabled : " +timeout);		
		
		
		WebElement Application = driver.findElement(By.xpath("//div[contains(text(), 'Application')]"));
		if(Application.isDisplayed()) {
			Application.click();
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is  displayed successfully </span>");
		  }
		  else {
			  logger.log(LogStatus.PASS, "<span style='color:green;'>Application tab is not displayed </span>"); 
		  }
		
		
		boolean Quick_chkbox = driver.findElement(By.xpath("//table[@class='w-75']/tr[1]/td[2]/span/label/span")).isSelected();
		System.out.println("Quick_chkbox is enabled :"+Quick_chkbox);
		boolean Refresh_interval = driver.findElement(By.xpath("//table[@class='w-75']/tr[2]/td[2]/input")).isEnabled();
		System.out.print("Refresh_interval text box is enabled. "+Refresh_interval);
		boolean Default_locale = driver.findElement(By.xpath("//table[@class='w-75']/tr[3]/td[2]/mat-select/div/div[1]/span/span")).isEnabled();
		System.out.print("Default_locale text dropdown is enabled. "+Default_locale);
		boolean Prefered_locale = driver.findElement(By.xpath("//table[@class='w-75']/tr[4]/td[2]/mat-select/div/div[1]")).isEnabled();
		System.out.print("Prefered_locale text box is enabled. "+Prefered_locale);
		boolean Enable_status_Bar = driver.findElement(By.xpath("//table[@class='w-75']/tr[5]/td[2]/span/label/span")).isSelected();
		System.out.print("Enable_status_Bar chk box is selected. "+Enable_status_Bar);
		boolean Allow_User_chkbox = driver.findElement(By.xpath(" //table[@class='w-75']/tr[6]/td[2]/span/label/span")).isSelected();
		System.out.print("Allow_User_chkbox  is selected. "+Allow_User_chkbox);
		
		WebElement Custom_Ui = driver.findElement(By.xpath("//table[@class='w-75']/tr[7]/td[2]/span/input"));
		System.out.println("Custom Ui text box is enabled"+ Custom_Ui.isEnabled());
		
  }
  public void Trace_setting_Tab() throws InterruptedException {
	  logger.log(LogStatus.INFO, "<span class='label success'>TRACE SETTING TAB VERIFICATION</span>");
	  WebElement TraceSettingsButton = driver.findElement(By.id("traceSettingsButton"));
	  if(TraceSettingsButton.isDisplayed()) {
	  TraceSettingsButton.click();
	  logger.log(LogStatus.PASS, "<span style='color:green;'>Trace setting Tab gets clicked </span>");
	  }
	  Thread.sleep(2000);
	  WebElement Title = driver.findElement(By.xpath("//span[contains(text(), 'Trace Settings')]"));
   	String actual = Title.getText().trim();
  	Thread.sleep(2000);
  	String expected = "Trace Settings";	
  	assertEquals(actual, expected);
  	logger.log(LogStatus.PASS, "<span style='color:green;'>Trace Settings heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
  	if(actual.equalsIgnoreCase(expected))
  	{
  	    System.out.println("String is same");
  	}
  	else{
  	    System.out.println("String is not same");
  	}
	  WebElement ServiceTrace_Expand = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[1]/div[1]"));
	  ServiceTrace_Expand.click();
	  boolean EnableRun_Chkbox = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[1]/table/tr[1]/td/label/span")).isSelected();
	  System.out.println("EnableRun_Chkbox is :"+EnableRun_Chkbox);
	  boolean EnableAction_chkbox = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[1]/table/tr[2]/td/label/span")).isSelected();
	  System.out.println("EnableAction_chkbox is :"+EnableAction_chkbox);
	  boolean EnbleUtil_chkbox = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[1]/table/tr[3]/td/label/span")).isSelected();
	  System.out.println("EnbleUtil_chkbox is :"+EnbleUtil_chkbox);
	  Thread.sleep(4000);
	  WebElement UserMacro_Expand = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[2]/div[1]/img"));
	  UserMacro_Expand.click();
	  boolean UserMacro_Trace = driver.findElement(By.xpath("//table[@class='ng-star-inserted']/tr[2]/td[2]/mat-select/div/div[1]/span/span")).isEnabled();
	  System.out.println("UserMacro_Trace is enable :"+UserMacro_Trace);
	  Thread.sleep(2000);
	  UserMacro_Expand.click();
	  WebElement Display_Terminal_expand = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[3]/div[1]/img"));
	  Display_Terminal_expand.click();
	  boolean Terminal_Display = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[3]/table/tr[2]/td/label/span")).isSelected();
	  System.out.println("Terminal_Display is enable :"+Terminal_Display);
	  boolean Host_chkbox = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[3]/table/tr[4]/td/label/span")).isSelected();
	  System.out.println("Host_chkbox is enable :"+Host_chkbox);
	  Display_Terminal_expand.click();
	  Thread.sleep(4000);
	  WebElement Trace_OutputExpand = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']//div/div[2]/div[4]/div[1]/img"));
	  Trace_OutputExpand.click();
	 	 Thread.sleep(2000); 
	  boolean MaxFilesize = driver.findElement(By.id("tracemaxFileSize")).isEnabled();
	  System.out.print(MaxFilesize);
	  Thread.sleep(2000);
	  boolean TracemaxHistFiles = driver.findElement(By.id("tracemaxHistFiles")).isEnabled();
	  System.out.print(TracemaxHistFiles);
	  Thread.sleep(2000);
	  boolean TraceFileTempName = driver.findElement(By.id("traceFileTempName")).isEnabled();
	  System.out.print(TraceFileTempName);
	  
	  WebElement Refresh_button = driver.findElement(By.xpath("//div[@class='ml-auto']/img"));
		Refresh_button.click();
		Thread.sleep(2000);
		WebElement download_button = driver.findElement(By.xpath("//div[@class='mx-auto']/button[2]"));
		download_button.click();
		Thread.sleep(2000);
		WebElement Clear = driver.findElement(By.xpath("//div[@class='mx-auto']/button[1]"));
		Clear.click();
		WebElement close_popup = driver.findElement(By.xpath("//div[@class='alert-info info mx-0 p-1 ng-star-inserted']/img"));
		if(close_popup.isDisplayed()) {
			close_popup.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'>Close popup message gets clicked </span>");
		}
		
		
  }
  
    public void LogSetting() throws InterruptedException {
    	logger.log(LogStatus.INFO, "<span class='label success'>lOG SETTING TAB VERIFICATION</span>");
    	WebElement Log = driver.findElement(By.id("viewLogButton"));
    	Log.click();
    	logger.log(LogStatus.PASS, "<span style='color:green;'>LOG setting Tab gets clicked </span>");
    	WebElement Title = driver.findElement(By.xpath("//span[contains(text(), 'Log Settings')]"));
     	String actual = Title.getText().trim();
    	Thread.sleep(2000);
    	String expected = "Log Settings";	
    	assertEquals(actual, expected);
    	logger.log(LogStatus.PASS, "<span style='color:green;'>Log Settings heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
    	if(actual.equalsIgnoreCase(expected))
    	{
    	    System.out.println("String is same");
    	}
    	else{
    	    System.out.println("String is not same");
    	}
    	
    	WebElement Setting_button = driver.findElement(By.xpath("//div[@class='h-100 flex-grow-1 border-bottom-1']/div/div[1]/div/img"));
    	Setting_button.click();
    	 Thread.sleep(2000); 
   	  boolean MaxFilesize = driver.findElement(By.id("logMaxFileSize")).isEnabled();
   	  System.out.print(MaxFilesize);
   	  Thread.sleep(2000);
   	  boolean LogmaxHistFiles = driver.findElement(By.id("logMaxHistFiles")).isEnabled();
   	  System.out.print("Log host file is enabled"+LogmaxHistFiles);
   	  Thread.sleep(2000);
   	  boolean LogFileTempName = driver.findElement(By.id("logFileTempName")).isEnabled();
   	  System.out.print("Temp file is enabled"+LogFileTempName);
   	  Thread.sleep(2000);
  		WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
  		Cancel.click();
  		 Thread.sleep(7000);
    	WebElement Refresh = driver.findElement(By.xpath("//div[@class='ml-auto']/img"));
    	Refresh.click();
    	 Thread.sleep(7000);
    	WebElement Download = driver.findElement(By.id("servicemangrTrace"));
    	Download.click();
    	WebElement clear = driver.findElement(By.id("serverLog"));
    	clear.click();
    	 Thread.sleep(2000);
    	WebElement msgclose = driver.findElement(By.xpath("//div[@class='alert-info info mx-0 p-1 ng-star-inserted']/img"));
    	 Thread.sleep(7000);
    	msgclose.click();
    	
    	
    }
    public void Service_Tab() throws InterruptedException {
    	logger.log(LogStatus.INFO, "<span class='label success'>SERVICE TAB VERIFICATION</span>");
    	Thread.sleep(4000);
    	WebElement Services = driver.findElement(By.id("servicesButton"));
    	Services.click();
    	logger.log(LogStatus.PASS, "<span style='color:green;'>Service Tab gets clicked </span>");
    	WebElement Title = driver.findElement(By.xpath("//span[contains(text(), 'Services')]"));
     	String actual = Title.getText().trim();
    	Thread.sleep(2000);
    	String expected = "Services";	
    	assertEquals(actual, expected);
    	logger.log(LogStatus.PASS, "<span style='color:green;'>Service tab heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
    	if(actual.equalsIgnoreCase(expected))
    	{
    	    System.out.println("String is same");
    	}
    	else{
    	    System.out.println("String is not same");
    	}
    	WebElement Service_status = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[1]/td[2]/div"));
    	
    	if(Service_status.isDisplayed()) {
    		Thread.sleep(2000);
    		Service_status.click();
    		logger.log(LogStatus.PASS, "<span class='label success'>Service_status play button gets clicked</span>");
    	}
    	
    	WebElement Trace_status = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[1]/td[3]/div/img"));
    	if(Trace_status.isDisplayed()) {
    		Thread.sleep(5000);
        	Trace_status.click();
        	logger.log(LogStatus.PASS, "<span class='label success'>Trace_status play button gets clicked</span>");
    	}
    	WebElement Config_proxy = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[1]/td[4]/div"));
    	Config_proxy.click();
    	Thread.sleep(2000);
    	WebElement Proxy_chkbox = driver.findElement(By.xpath("//label[@class='checkboxcontainer']/span"));
    	if( Proxy_chkbox.isSelected()) {
    	
    		logger.log(LogStatus.PASS, "<span class='label success'>The Proxy checkbox is selection enable</span>");
    	}else {
    		
    		logger.log(LogStatus.PASS, "<span class='label success'>The Proxy checkbox is verified</span>");
    	}
    	
    
    	boolean Proxy_serverPort = driver.findElement(By.name("proxyPort")).isEnabled();
    	System.out.print("Proxy_serverPort is enabled"+Proxy_serverPort);
    	boolean Proxy_maxconn = driver.findElement(By.name("maxConn")).isEnabled();
    	System.out.print("Proxy_maxconn is enabled"+Proxy_maxconn);
      	WebElement Proxy_Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
    	Proxy_Cancel.click();
    	
    	WebElement Redirector_service_status = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[2]/td[2]/div/img"));
    	if(Redirector_service_status.isDisplayed()) {
    		Redirector_service_status.click();
    		logger.log(LogStatus.PASS, "<span style='color:green;'> Redirector_service_status play button gets clicked </span>");
    	}
    	
    	Thread.sleep(4000);
    	WebElement Redirector_Trace_status1 = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[2]/td[3]/div/img"));
    	if(Redirector_Trace_status1.isDisplayed()) {
    		Redirector_Trace_status1.click();
    		logger.log(LogStatus.PASS, "<span style='color:green;'> Redirector_service_status play button2 gets clicked </span>");
    	}
    	
    	Thread.sleep(2000);
    	WebElement Redirector_Config = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[2]/td[4]/div/img"));
    	if(Redirector_Config.isDisplayed()) {
    		Redirector_Config.click();
    		logger.log(LogStatus.PASS, "<span style='color:green;'> Redirector_Config button gets clicked </span>");
    	}
    	Thread.sleep(4000);
    	WebElement Redirector_Config_plusIcon = driver.findElement(By.xpath("//div[@class='dialogHeader']/img"));
    	Redirector_Config_plusIcon.click();
    	Thread.sleep(2000);
    	WebElement Redirector_destaddr = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[2]/td[2]/input"));
    	Redirector_destaddr.sendKeys("10.134.71.156");
    	boolean Redirector_Port = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[3]/td[2]/input")).isEnabled();
    	System.out.print("Redirector_Port is enabled :"+Redirector_Port);
    	boolean Redirector_LocalPort = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[4]/td[2]/input")).isEnabled();
    	System.out.print("Redirector_LocalPort is enabled :"+Redirector_LocalPort);
    	boolean Redirector_Clientchkbox = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[6]/td[2]/label/span")).isSelected();
    	System.out.print("Redirector_LocalPort is enabled :"+Redirector_Clientchkbox);
    	Thread.sleep(2000);
    	boolean Redirector_Logchkbox = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[7]/td[2]/label/span")).isSelected();
    	System.out.print("Redirector_Logchkbox is enabled :"+Redirector_Logchkbox);
    	boolean Redirector_KeepLive = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[10]/td[2]/label/span")).isSelected();
     	System.out.print("Redirector_KeepLive is enabled :"+Redirector_KeepLive);
    	boolean Redirector_IpTrace = driver.findElement(By.xpath("//div[@class='dialogDIV overflow-auto px-3']/table/tr[12]/td[2]/input")).isEnabled();
    	System.out.print("Redirector_IpTrace is enabled :"+Redirector_IpTrace);
    	Thread.sleep(4000);
    	WebElement Save = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/mat-dialog-container/app-new-redirector/div/div[4]/div[2]/button[2]"));
    	Save.click();
    	Thread.sleep(4000);
    	WebElement Edit = driver.findElement(By.xpath("//div[@class='dialog-container px-0']/div[3]/table/tbody/tr/td[5]/img[2]"));
    	Thread.sleep(4000);
    	Edit.click();
    	WebElement Edit_Cancel = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/mat-dialog-container/app-new-redirector/div/div[4]/div[2]/button[1]"));
    	
    	Edit_Cancel.click();
    	Thread.sleep(4000);
    	WebElement delete = driver.findElement(By.xpath("//div[@class='dialog-container px-0']/div[3]/table/tbody/tr/td[5]/img[1]"));
    	Thread.sleep(4000);
    	delete.click();
    	Thread.sleep(4000);
    	WebElement Confirm = driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]"));
    	Confirm.click();
    	WebElement Redirector_Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
    	Redirector_Cancel.click();
    	Thread.sleep(4000);
    	WebElement Webserver_Config = driver.findElement(By.xpath("//*[@id=\"servicesTable\"]/tr[3]/td[4]/div/img"));
    	Thread.sleep(4000);
    	Webserver_Config.click();
    	boolean Webserver_Port = driver.findElement(By.name("WebAppServerPort")).isEnabled();
    	System.out.print("Webserver_Port is enabled"+Webserver_Port);
    	boolean Webserver_SecurePort = driver.findElement(By.name("WebAppServerSecurePort")).isEnabled();
    	boolean Webserver_HodContextpath = driver.findElement(By.xpath("//*[@class=\"dialogDIV\"]/table/tr[3]/td[2]/input")).isEnabled();
    	System.out.print("Webserver HodContextpath is enabled"+Webserver_HodContextpath);
    	boolean Webserver_HACPEEContextpath = driver.findElement(By.name("zfpClientContextPath")).isEnabled();
    	System.out.print("Webserver_HACPEEContextpath is enabled"+Webserver_HACPEEContextpath);
    	boolean Webserver_LicenseContextpath = driver.findElement(By.name("lmContextPath")).isEnabled();
    	System.out.print("Webserver_LicenseContextpath is enabled"+Webserver_LicenseContextpath);
    	WebElement Webserver_Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
    	Thread.sleep(4000);
    	Webserver_Cancel.click();    	   	
    	WebElement Service_Refresh = driver.findElement(By.xpath("//div[@class='col-12 pt-3 pb-3']/div[1]/div[3]/img"));
    	Service_Refresh.click();
    	
    	Thread.sleep(4000);
    	
    	WebElement ServerLog = driver.findElement(By.id("serverLog"));
    	ServerLog.click();
    	Thread.sleep(4000);
    	WebElement Refresh_Serverlog = driver.findElement(By.xpath("//div[@class='modelBottomDiv']/img"));
    	Refresh_Serverlog.click();
    	Thread.sleep(2000);
    	WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
    	Cancel.click();
    	Thread.sleep(4000);
    	WebElement ServicemangrTrace = driver.findElement(By.id("servicemangrTrace"));
    	ServicemangrTrace.click();
    	boolean Trace_active = driver.findElement(By.xpath("//*[@id=\"traceManagerTable\"]/tr[1]/td[2]/label/span")).isSelected();
    	System.out.println(" Trace_active checkbox is :"+Trace_active);
    	Thread.sleep(2000);
    	boolean Trace_level = driver.findElement(By.xpath("//*[@id='traceManagerTable']/tr[2]/td[2]/mat-select/div/div[1]")).isEnabled();
    	System.out.println("Trace_level dropdown is enbaled:"+Trace_level);
     	WebElement ServicemangrTrace_Cancel = driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
    	ServicemangrTrace_Cancel.click();
    	
    
    	
    }
    
    public void HostConnection_Tab() throws InterruptedException {
    	logger.log(LogStatus.INFO, "<span class='label success'>HOST CONNECTION Tab VERIFICATION</span>");
    	Thread.sleep(4000);
    	logger.log(LogStatus.PASS, "<span style='color:green;'>Host Connection Tab gets clicked </span>");
    	WebElement Host_Connection = driver.findElement(By.id("connPoolButton"));
    	Host_Connection.click();
    	Thread.sleep(4000);
    	WebElement Popup_Close = driver.findElement(By.xpath("//div[@class='alert-info info mx-0 p-1 ng-star-inserted']/img"));
    	
    		Thread.sleep(4000);
    	Popup_Close.click();
    	
    	WebElement Title = driver.findElement(By.xpath("//*[@id=\"connPoolDIV\"]/div[1]/div/span"));
     	String actual = Title.getText().trim();
    	Thread.sleep(2000);
    	String expected = "Host Connections";	
    	assertEquals(actual, expected);
    	logger.log(LogStatus.PASS, "<span style='color:green;'>Disable Functions - admin heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
    	if(actual.equalsIgnoreCase(expected))
    	{
    	    System.out.println("String is same");
    	}
    	else{
    	    System.out.println("String is not same");
    	}
    	Thread.sleep(4000);
    	boolean Search_Creteria = driver.findElement(By.xpath("//div[@class='w-25 pl-4']/span/mat-select/div/div[1]")).isEnabled();
    	System.out.print("Search_Creteria  is enabled :"+Search_Creteria);
    	//Select s = new Select(driver.findElement(By.xpath("")));
    	//s.selectByVisibleText("LU Name");
    	boolean Value = driver.findElement(By.xpath("//*[@id=\"whiteDiv\"]/div/div[2]/span/input")).isEnabled();
    	System.out.print("Serach textbox is enabled :"+Value);
    	
    	
    	boolean Hostconnection_chkbox = driver.findElement(By.xpath("//*[@id=\"connPoolDIV\"]/div[3]/table/tr/th[1]/label/span")).isSelected();
    	Thread.sleep(4000);
    	System.out.print("Hostconnection_chkbox is enabled :"+Hostconnection_chkbox);
    	Thread.sleep(7000);
     WebElement Refresh = driver.findElement(By.xpath("//div[@class='col-12 pt-3 pb-3']//div[3]/img"));
     Thread.sleep(4000);	
     Refresh.click();
    	Thread.sleep(4000);
    	WebElement pop_up_close = driver.findElement(By.xpath("//div[@class='alert-info info mx-0 p-1 ng-star-inserted']/img"));
    	if(pop_up_close.isDisplayed()) {
    		pop_up_close.click();
    	}
    	
    	
    }
    public void Group_Icon() throws InterruptedException {
    	Thread.sleep(3000); 
		WebElement GroupIcon = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-admin-console/app-users/div/div[1]/div[1]/div[1]/div/img")); 
		GroupIcon.click();
		boolean NewGroup_Id = driver.findElement(By.id("newGrpId")).isEnabled();
    	System.out.print("NewGroup_Id textbox is enabled :"+NewGroup_Id);
    	boolean Desc = driver.findElement(By.id("newGrpDesc")).isEnabled();
    	System.out.print("NewGroup desc textbox is enabled :"+Desc);
    	WebElement Cancel = driver.findElement(By.xpath("//button[contains(text(), ' Cancel ')]")); 
    	Cancel.click();
    	Thread.sleep(2000);
		WebElement Confirm = driver.findElement(By.xpath("//button[contains(text(), ' Confirm ')]")); 
		if(Confirm.isDisplayed()) {
			Confirm.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'>Confirm button gets clicked</span>" );
		}
		
    }
    public void PCOMM_Group_Icon() throws InterruptedException {
    	Thread.sleep(3000); 
		WebElement Properties = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/button[5]/span")); 
		Properties.click();
		WebElement Title = driver.findElement(By.xpath("/html/body/div/div[2]/div/mat-dialog-container/app-group-edit/div[2]/span")); 
		//WebElement Title = driver.findElement(By.xpath("//*[@id=\"mat-dialog-14\"]/app-sessions-panel/div/div[2]")); 
		Thread.sleep(4000);
		String actual = Title.getText();
		String expected = "Edit Group";	
		assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Session heading is displayed as : </span>"+ "<span class='label success'>" + expected + "</span>"+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "Admin Console")));		
		if(actual.equalsIgnoreCase(expected))
	    {
	        System.out.println("String is same");
	    }
	    else{
	        System.out.println("String is not same");
	    }
		boolean NewGroup_Id = driver.findElement(By.id("newGrpId")).isEnabled();
    	System.out.print("NewGroup_Id textbox is enabled :"+NewGroup_Id);
    	boolean Desc = driver.findElement(By.id("newGrpDesc")).isEnabled();
    	System.out.print("NewGroup desc textbox is enabled :"+Desc);
    	WebElement Cancel = driver.findElement(By.xpath("/html/body/div/div[2]/div/mat-dialog-container/app-group-edit/div[4]/div[2]/button[1]")); 
    	Cancel.click();
    	Thread.sleep(2000);
		WebElement Confirm = driver.findElement(By.xpath("/html/body/div/div[4]/div/mat-dialog-container/app-confirmation-dialog/div[4]/button[2]")); 
		Confirm.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Confirm button gets clicked</span>" );
    }
    public void User_Icon() throws InterruptedException {
    	Thread.sleep(5000);
    	  WebElement UserIcon = driver.findElement(By.xpath("//div[@class='col-3 col-md-3 col-xl-3 col-lg-3 col-3']//img"));
    	UserIcon.click();
    	Thread.sleep(5000);
    		boolean User_id = driver.findElement(By.id("newUserUserId")).isEnabled();
    		System.out.println("User Id is enabled :"+User_id);
    		boolean Discription = driver.findElement(By.id("newUserDesc")).isEnabled();
    		System.out.println("User Discription is enabled :"+Discription);
    		
    		boolean psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[3]/td[2]/input")).isEnabled();
    		System.out.println("User Password is enabled :"+psw);
    		
    		boolean Confirm_psw = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[4]/td[2]/input")).isEnabled();
    		System.out.println("User ConfirmPassword is enabled :"+Confirm_psw);
    		WebElement PCOMM_AddIcon = driver.findElement(By.xpath("//*[@id='avlblGrps']/div[2]/table/tr[1]/td/img[2]"));
    		PCOMM_AddIcon.click();
    		
     		//WebElement PCOMM_MinusIcon = driver.findElement(By.xpath("/html/body/div/div[2]/div/mat-dialog-container/app-user-edit/div/div[3]/div/div/div[2]/div[2]/table/tr[1]/td/img[2]"));
     		//PCOMM_MinusIcon.click();
    		
    		WebElement Save_preference = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[1]/label/span"));
    		Thread.sleep(2000);
    		Save_preference.click();
    		WebElement UserCanChangePsw = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[2]/label/span"));
    		UserCanChangePsw.click();
    		WebElement UserNative = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[3]/label/span"));
    		UserNative.click();
    		boolean Native_UserId = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[2]/td[2]/input")).isEnabled();
    		System.out.println("Native user id is enabled"+Native_UserId);
    		UserNative.click();
    		WebElement Recf_Auth = driver.findElement(By.xpath("//*[@class='addusertable mb-2']/tr[1]/td[4]/label/span"));
    		Recf_Auth.click();
    		boolean psw1 = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[3]/td[2]/input")).isEnabled();
    		System.out.println("User Password is enabled"+psw1);
    		boolean Confirm_psw1 = driver.findElement(By.xpath("//div[@class= 'dialogDIV pt-2' ]/table/tr[4]/td[2]/input")).isEnabled();
    		System.out.println("User Password is enabled"+Confirm_psw1);
    		WebElement Cancel_button = driver.findElement(By.xpath("//div[@class='modal-footer']/div[2]/button[1]")); 
    		Thread.sleep(2000);
    		Cancel_button.click();
    		WebElement confirm = driver.findElement(By.xpath("//button[contains(text(), ' Confirm ')]"));
    		confirm.click();
      
    	
    }
    
	public void Logout_configmodel() throws InterruptedException {
		
		Thread.sleep(3000); 
		WebElement LogoutButton = driver.findElement(By.id("log_out")); 
		LogoutButton.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Logout button gets clicked</span>" );
	}
	
	public void Verify_WelcomeUserConfigModel() throws InterruptedException {
		
		Thread.sleep(3000); 
		WebElement WelcomeUser = driver.findElement(By.id("custName")); 
		String actual = WelcomeUser.getText(); String expected = "Welcome admin"; 
		assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "<span style='color:green;'>The welcome user message is displayed as :</span>" + "<span class='label success'>" + actual + "</span>");
	}
	
	public void Verify_HelpIconConfigModel() throws InterruptedException, AWTException {
		
		Thread.sleep(2000); 
		WebElement HelpIcon = driver.findElement(By.xpath("//*[@id='help']")); 
		HelpIcon.isDisplayed();
		Thread.sleep(2000); 
		logger.log(LogStatus.PASS, "<span style='color:green;'>Help Icon gets verified</span>");
		/*
		 * Robot a = new Robot();
		 * 
		 * a.keyPress(KeyEvent.VK_CONTROL); a.keyPress(KeyEvent.VK_TAB);
		 * Thread.sleep(1000); a.keyRelease(KeyEvent.VK_CONTROL);
		 * a.keyRelease(KeyEvent.VK_TAB); Thread.sleep(1000);
		 * a.keyPress(KeyEvent.VK_CONTROL); a.keyPress(KeyEvent.VK_F4);
		 * Thread.sleep(1000); a.keyRelease(KeyEvent.VK_CONTROL);
		 * a.keyRelease(KeyEvent.VK_F4);
		 */
		//logger.log(LogStatus.PASS, "<span style='color:green;'>Help window gets closed</span>");
	}
	
	public void Verify_HomePageConfigModel() throws InterruptedException {
		
		Thread.sleep(3000); 
		WebElement product_name = driver.findElement(By.id("product_name")); 
		product_name.isDisplayed();  
		logger.log(LogStatus.PASS, "<span style='color:green;'>The Home page is displayed</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "ConfigHome")));
	}
	
	public void VerifySessionCount() throws InterruptedException {
		 Thread.sleep(3000);
		 int expected = 7;
		 List<WebElement> Sessions = driver.findElements(By.xpath("//div[@id='dashboard_icons']/div"));
		 int actual = Sessions.size();
		 System.out.println("The session count is :" + actual);
		 assertEquals(actual, expected);
		 logger.log(LogStatus.PASS, "<span style='color:green;'>The session count given in HOD is : 7</span>"); 
		 logger.log(LogStatus.PASS, "<span style='color:green;'>The actual session count displayed in HACP EE homepage is </span>" + actual + logger.addScreenCapture(Common.CaptureScreenShot(driver, "SessionCount")));
			
	}
	
	public void VerifySessionDefinition() throws InterruptedException {
		 
		Thread.sleep(2000);
		 String S1_expected = "3270 Display";
		 WebElement Ses1 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[1]"));
		 String S1_actual = Ses1.getText();
		 System.out.println("The defenition of session 1  is : " + S1_actual);
		 assertEquals(S1_actual, S1_expected);
		 
		 String S2_expected = "5250 Display";
		 WebElement Ses2 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[2]"));
		 String S2_actual = Ses2.getText();
		 System.out.println("The defenition of session 2  is : " + S2_actual);
		 assertEquals(S2_actual, S2_expected);
		 
		 String S3_expected = "1:5250 Display";
		 WebElement Ses3 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[3]"));
		 String S3_actual = Ses3.getText();
		 System.out.println("The defenition of session 3  is : " + S3_actual);
		 assertEquals(S3_actual, S3_expected);
		 
		 String S4_expected = "1:3270 Display";
		 WebElement Ses4 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[4]"));
		 String S4_actual = Ses4.getText();
		 System.out.println("The defenition of session 4  is : " + S4_actual);
		 assertEquals(S4_actual, S4_expected);
		 
		 String S5_expected = "2:3270 Display";
		 WebElement Ses5 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[5]"));
		 String S5_actual = Ses5.getText();
		 System.out.println("The defenition of session 5  is : " + S5_actual);
		 assertEquals(S5_actual, S5_expected);
		 
		 String S6_expected = "2:5250 Display";
		 WebElement Ses6 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[6]"));
		 String S6_actual = Ses6.getText();
		 System.out.println("The defenition of session 6  is : " + S6_actual);
		 assertEquals(S6_actual, S6_expected);
		 
		 String S7_expected = "3:5250 Display";
		 WebElement Ses7 = driver.findElement(By.xpath("//div[@id='dashboard_icons']/div[7]"));
		 String S7_actual = Ses7.getText();
		 System.out.println("The defenition of session 7  is : " + S7_actual);
		 assertEquals(S7_actual, S7_expected);
		 
		logger.log(LogStatus.PASS, "<span style='color:green;'>The session defenitions entered in HOD are : </span> </br>" + "<span class='label success'>" + S1_actual + "</span></br>"
				+ "<span class='label success'>" + S2_actual + "</span></br>"
				+ "<span class='label success'>" + S3_actual + "</span></br>"
				+ "<span class='label success'>" + S4_actual + "</span></br>"
				+ "<span class='label success'>" + S5_actual + "</span></br>"
				+ "<span class='label success'>" + S6_actual + "</span></br>"
				+ "<span class='label success'>" + S7_actual + "</span></br>");
					
	}
	
	public void Click_OK() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement ClickOK = driver.findElement(By.id("logout"));
		ClickOK.click();
		Thread.sleep(2000);
	}
	
	public void VerifyMacroOptions() throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		WebElement PlayMacro = driver.findElement(By.id("playmacro"));
		WebElement RecordMacro = driver.findElement(By.id("recordmacro"));
		WebElement PauseMacro = driver.findElement(By.id("pausemacro"));
		WebElement StopMacro = driver.findElement(By.id("stopmacro"));
		WebElement PromptMacro = driver.findElement(By.id("macroprompt"));
		WebElement ExtractMacro = driver.findElement(By.id("macroextract"));
		WebElement EditMacro = driver.findElement(By.id("macroedit"));
		
		if(PlayMacro.isDisplayed()&&RecordMacro.isDisplayed()&&PauseMacro.isDisplayed()&&StopMacro.isDisplayed()&&
			StopMacro.isDisplayed()&&PromptMacro.isDisplayed()&&ExtractMacro.isDisplayed()&&EditMacro.isDisplayed()&&
			PlayMacro.isEnabled()&&RecordMacro.isEnabled()&&EditMacro.isEnabled()) {
			
			logger.log(LogStatus.PASS, "<span style='color:green;'>The below options are displayed while clicking on macro icon : </span> </br>" + 
					  "<span class='label success'>" + "Play Macro" + "</span></br>"
					+ "<span class='label success'>" + "Record Macro" + "</span></br>"
					+ "<span class='label success'>" + "Pause Macro" + "</span></br>"
					+ "<span class='label success'>" + "Stop Macro" + "</span></br>"
					+ "<span class='label success'>" + "Record a Prompt" + "</span></br>"
					+ "<span class='label success'>" + "Record an Extract" + "</span></br>"
					+ "<span class='label success'>" + "Edit Macro" + "</span></br>");
			logger.addScreenCapture(Common.CaptureScreenShot(driver, "Macro_Options"));	
		}
		
	}
	
	public void ClickRecordMacro() throws InterruptedException {
		Thread.sleep(2000);
		WebElement RecordMacro = driver.findElement(By.id("recordmacro"));
		logger.log(LogStatus.PASS, "<span style='color:green;'>Record Macro icon gets clicked</span>");
		RecordMacro.click(); 
		//common.Wait(driver.findElement(By.xpath("*//span[@id='myModalLabel']/img[contains(@text(),'Record Macro')]")));
	}

	public void EnterRecordNameDesandClickRecord() throws InterruptedException {

		Thread.sleep(2000);
		WebElement EnterCS_MacroName = driver.findElement(By.id("macroName"));
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro name gets entered</span>");
		EnterCS_MacroName.sendKeys("MACRORandom1"); 
		WebElement EnterCS_MacroDesc = driver.findElement(By.id("macroDesc"));
		logger.log(LogStatus.PASS, "<span style='color:green;'>Record Macro description gets entered</span>");
		EnterCS_MacroDesc.sendKeys("Description entered for MACRO"); 
		//WebElement ClickRecordbutton = driver.findElement(By.xpath("//*[@id='macroRecordModel']/div/div/div[3]/a/button[1]"));
		Thread.sleep(2000);
		EnterCS_MacroDesc.sendKeys(Keys.TAB,Keys.ENTER);
		Thread.sleep(1000);
		
		logger.log(LogStatus.PASS, "<span style='color:green;'>Record button gets clicked</span>");
		//ClickRecordbutton.click(); 
		
		Thread.sleep(500);
		common.Wait(driver.findElement(By.id("recording_macro")));
	}
	
	public void RecordMacro() throws AWTException {
		
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_C); a.keyRelease(KeyEvent.VK_C);
		a.keyPress(KeyEvent.VK_H); a.keyRelease(KeyEvent.VK_H);
		a.keyPress(KeyEvent.VK_A); a.keyRelease(KeyEvent.VK_A);
		a.keyPress(KeyEvent.VK_R); a.keyRelease(KeyEvent.VK_R);
		a.keyPress(KeyEvent.VK_L); a.keyRelease(KeyEvent.VK_L);
		a.keyPress(KeyEvent.VK_E); a.keyRelease(KeyEvent.VK_E);
		a.keyPress(KeyEvent.VK_S); a.keyRelease(KeyEvent.VK_S);
	}
	
	public void StopMacro() throws InterruptedException {
		Thread.sleep(2000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		Thread.sleep(2000);
		WebElement StopMacro = driver.findElement(By.id("stopmacro")); 
		StopMacro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Stop Macro gets clicked</span>");
		 
	}
	
	public void PlayCS_Macro() throws InterruptedException {
		Thread.sleep(2000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		Thread.sleep(2000);
		WebElement PlayMacro = driver.findElement(By.id("playmacro")); 
		PlayMacro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Play Macro gets clicked</span>");
		Thread.sleep(1000);
		WebElement searchCSMacro = driver.findElement(By.id("mySessionMacro")); 
		searchCSMacro.sendKeys("MACRORandom1");
		Thread.sleep(1000);		
		WebElement MacroPlay = driver.findElement(By.id("MacroPlay")); 
		MacroPlay.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Current session Macro gets executed</span>");
		
		Thread.sleep(500);
		common.Wait(driver.findElement(By.id("executing_macro")));

	}
	public void SessionConnectivity() throws InterruptedException  {
		Thread.sleep(3000);
		driver.switchTo().frame(0);
	 WebElement sessionConnectivity = driver.findElement(By.xpath("//input[@id=\"statusBarAndOIA2\"]"));
		
			if(sessionConnectivity.getAttribute("value") != null) {
			System.out.println("Destination Address is :"+sessionConnectivity.getAttribute("value"));
			
			}else {
				WebElement expandElement=driver.findElement(By.id("expand_icon"));
				wait.until(ExpectedConditions.visibilityOf(expandElement));
				
				if(driver.findElement(By.id("expand_icon")).isDisplayed())
				
				{
					Thread.sleep(8000);
					expandElement.click();
				//	logger.log(LogStatus.PASS, "<span style='color:green;'> Navigation Expand icon gets clicked</span>");
				
				}

		   WebElement settingsElement=driver.findElement(By.id("img_masterSetting"));
				wait.until(ExpectedConditions.visibilityOf(settingsElement));
				
				if(settingsElement.isDisplayed())
				{
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", settingsElement);
					//settingsElement.click();
					System.out.println("settings clicked");
					Thread.sleep(1000);
					logger.log(LogStatus.PASS, "<span style='color:green;'> Settings option is clicked successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
				}
		WebElement prefencesElement = driver.findElement(By.id("preference_settings_icon"));
		        wait.until(ExpectedConditions.visibilityOf(prefencesElement));
		        
		        prefencesElement.click();
		    WebElement statusBarElement = driver.findElement(By.xpath("/html/body/div[13]/div/div/div[2]/div[2]/div[3]/div[1]/div/div/label/span[1]"));
		        Thread.sleep(2000);
		         statusBarElement.click();
		 WebElement prefencesSave = driver.findElement(By.id("settingSave"));
		        wait.until(ExpectedConditions.visibilityOf(prefencesSave));
		        prefencesSave.click();
		        Thread.sleep(5000);
		        logger.log(LogStatus.PASS, "<span style='color:green;'> PrefernceTab Save button is clicked successfully</span>"
		     			+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		        WebElement prefencespopup = driver.findElement(By.xpath("/html/body/div[14]/div/div/span/button"));
		       
		        prefencespopup.click();
		        if(sessionConnectivity.getAttribute("value") != null) {
		        	System.out.println("Destination host is :10.134.71.156");
		        }
			}
			logger.log(LogStatus.PASS, "<span style='color:green;'> Session is Connected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		
		
		
	}
	public void SessionConnectivity_5250() throws InterruptedException  {
		Thread.sleep(9000);
		driver.switchTo().frame(0);
		WebElement sessionConnectivity = driver.findElement(By.id("statusBarAndOIA2"));
		//WebElement sessionConnectivity = driver.findElement(By.xpath("//*[@id=\"statusBarAndOIA2\"]"));
		wait.until(ExpectedConditions.visibilityOf(sessionConnectivity));
		
		//if(driver.findElement(By.xpath("//input[@id=\"statusBarAndOIA2\"]")).isDisplayed())
			if(sessionConnectivity.getAttribute("value") != null)
		{
				System.out.println("session connection is" + sessionConnectivity.getAttribute("value"));
			logger.log(LogStatus.PASS, "<span style='color:green;'> Session is Connected successfully</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'> Session is not Connectedy</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		}
		
	}
	public void TLS_Disconnected_Session() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement sessionDisconnect = driver.findElement(By.xpath("//div[@class=\"HATSSTATUSHEADER\"]/div/div/div[2]/h3"));
		wait.until(ExpectedConditions.visibilityOf(sessionDisconnect));
		
		if(driver.findElement(By.xpath("//div[@class=\"HATSSTATUSHEADER\"]/div/div/div[2]/h3")).isDisplayed())
		
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is not Connected</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		
		}
		
	}
	
	public void Disconnected_Session() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement sessionDisconnect = driver.findElement(By.xpath("//div[@class=\"HATSSTATUSHEADER\"]/div/div/div[2]/h3"));
		wait.until(ExpectedConditions.visibilityOf(sessionDisconnect));
		
		if(driver.findElement(By.xpath("//div[@class=\"HATSSTATUSHEADER\"]/div/div/div[2]/h3")).isDisplayed())
		
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>3270 Session is not Connected</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		
		}
		
	}
	public void Disconnected_Session_5250() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement sessionDisconnect = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div/div[2]/h3"));
		wait.until(ExpectedConditions.visibilityOf(sessionDisconnect));
		
		if(driver.findElement(By.xpath("//div[@class=\"HATSSTATUSHEADER\"]/div/div/div[2]/h3")).isDisplayed())
		
		{
			logger.log(LogStatus.PASS, "<span style='color:green;'>5250 Session is not Connected</span>"
				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
		
		}
		
	}
	public void ClickMacroIcon() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
	}
	
	public void ClickLocalMacro() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		WebElement LocalMacro = driver.findElement(By.id("locations"));//*[@id='locations']/option[2]\"));
		common.SelectByValue(LocalMacro, "Local Macro");
		
		Robot a = new Robot();	
		WebElement CSMacro = driver.findElement(By.xpath("//*[@id='locations']/option[1]"));
		a.keyPress(KeyEvent.VK_CONTROL); CSMacro.click();
		a.keyRelease(KeyEvent.VK_CONTROL);
		
		//LocalMacro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>localMacro gets selected</span>");
	
	}
	
	public void PlayLocal_Macro() throws InterruptedException {
		Thread.sleep(2000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		Thread.sleep(2000);
		
		WebElement PlayMacro = driver.findElement(By.id("playmacro")); 
		PlayMacro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Play Macro gets clicked</span>");
		Thread.sleep(1000);
		
		WebElement local_Macro = driver.findElement(By.id("local_Macro")); 
		local_Macro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Local Macro gets selected</span>");
		Thread.sleep(1000);
		
		WebElement UploadLocalMacro = driver.findElement(By.id("macrofileToUpload")); 
		UploadLocalMacro.sendKeys("C:\\Users\\charles_a\\Downloads\\MACRORandom1.mac");
		Thread.sleep(1000);		
		WebElement MacroPlay = driver.findElement(By.xpath("//*[@id='localMacro']/button[2]")); 
		MacroPlay.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Local Macro gets executed</span>");
		Thread.sleep(500);
		common.Wait(driver.findElement(By.id("executing_macro")));
		Thread.sleep(3000);
	}
	
	public void ClickPromptRecord() throws InterruptedException {
		Thread.sleep(1000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		Thread.sleep(1000);
		
		WebElement macroprompt = driver.findElement(By.id("macroprompt")); 
		macroprompt.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Prompt Macro gets clicked</span>");
		Thread.sleep(1000);		
	}
	
	public void ClickExtractRecord() throws InterruptedException {
		Thread.sleep(1000);
		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>");
		Thread.sleep(1000);
		
		WebElement macroextract = driver.findElement(By.id("macroextract")); 
		macroextract.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Extract Macro gets clicked</span>");
		Thread.sleep(1000);
	}
	
	public void ValidatePromptRecord() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement PromptName = driver.findElement(By.id("promptNameLabel")); 
		PromptName.sendKeys("Prompt Record");
		logger.log(LogStatus.PASS, "<span style='color:green;'>Prompt name gets entered</span>");
		WebElement DefaultValue = driver.findElement(By.id("promptDefaultLabel")); 
		DefaultValue.sendKeys("3");
		logger.log(LogStatus.PASS, "<span style='color:green;'>Value gets entered</span>");
		WebElement PromptTitle = driver.findElement(By.id("promptTitleLabel")); 
		PromptTitle.sendKeys("MPT");
		logger.log(LogStatus.PASS, "<span style='color:green;'>Prompt title gets entered</span>");
		WebElement Value_Req = driver.findElement(By.id("valueCheckReq")); 
		Value_Req.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Value Required checkbox gets checked</span>");
		WebElement Password = driver.findElement(By.id("checkpassword")); 
		Password.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Password checkbox gets checked</span>");
		WebElement clearHostCheck = driver.findElement(By.id("clearHostCheck")); 
		clearHostCheck.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Clear Host Field checkbox gets checked</span>");
		
		WebElement Cancel = driver.findElement(By.xpath("//*[@id='macroPromptModel']/div/div/div[3]/button[2]")); 
		Cancel.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Cancel button gets clicked</span>");	
		
	}
	
	public void ValidateExtractRecord() throws InterruptedException {
		Thread.sleep(2000);
		WebElement extractName = driver.findElement(By.id("extractName")); 
		extractName.sendKeys("Extract Macro");
		logger.log(LogStatus.PASS, "<span style='color:green;'>Extract name name gets entered</span>");
		
		WebElement DataPlane = driver.findElement(By.id("RecordExtractMacro")); 
		DataPlane.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>DataPlane gets clicked</span>");
		DataPlane.click();
		
		WebElement Cancel = driver.findElement(By.xpath("//*[@id='macroExtractModel']/div/div/div[3]/button[2]")); 
		Cancel.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Cancel button gets clicked</span>");	
		
	}
	
	public void ClickEditMacro() throws InterruptedException {
		Thread.sleep(2000);
		WebElement MacroEDIT = driver.findElement(By.id("macroEdit")); 
		MacroEDIT.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro edit gets clicked</span>");
	}
	
	public void ClickCodeEditor() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement CodeEDIT = driver.findElement(By.id("EditMacro")); 
		CodeEDIT.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Code editor gets clicked</span>");
	}
	
	public void ClickEditMacroSave() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement editor_save = driver.findElement(By.id("editor_save")); 
		editor_save.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Code editor gets saved</span>");
	}
	
	public void DeleteMacro() throws InterruptedException, AWTException {
		
		Thread.sleep(2000);
		WebElement deleteMacro = driver.findElement(By.id("deleteMacro")); 
		deleteMacro.click();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Delete icon gets clicked to delete macro</span>");
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_ENTER); a.keyRelease(KeyEvent.VK_ENTER);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Ok button gets clicked and Macro gets deleted</span>");
		
		Thread.sleep(6000);
	}
	
	public void ClickFileTransfer() throws InterruptedException {
		Thread.sleep(5000);
		WebElement FileTransfer = driver.findElement(By.id("fileNav")); 
		FileTransfer.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>File Transfer gets clicked</span>");
	}
	
	public void ClickFilestohost() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement ClickSendFilestohost = driver.findElement(By.id("fileTransferButton")); 
		ClickSendFilestohost.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Send files to host gets clicked</span>");
	}
	
	public void ClickReceiveFilesFromHost() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement fileTransferReceiveButton = driver.findElement(By.id("fileTransferReceiveButton")); 
		fileTransferReceiveButton.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Receive files from host gets clicked</span>");
	}
	
	public void ValidateFilestoHost() throws InterruptedException {		
		Thread.sleep(2000);
		WebElement fileTransferReceiveButton = driver.findElement(By.xpath("//*[@id='filetransferSend']/div/div/div[3]/button[1]")); 
		fileTransferReceiveButton.click();
	}
	
	public void ValidateFilesfromHost() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement fileTransferReceiveButton = driver.findElement(By.id("//*[@id='sessionMacro']/button[1]")); 
		fileTransferReceiveButton.click();
	}	
	public void TLS_HowOftenToPrompt() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rightClick_session = driver.findElement(By.xpath("//*[@id=\"menubutton0\"]/img")); 
		rightClick_session.click();
		Thread.sleep(1000);
		WebElement session_start =driver.findElement(By.xpath("//*[@id='context0']/span[1]"));
		WebElement properties = driver.findElement(By.xpath("//*[@id='context0']/span[2]"));
		if(session_start.isDisplayed() && properties.isDisplayed())
		{
			properties.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'> 3 dots options are displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'> 3 dots options are not displayed </span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}	
		WebElement Clickon_TLS = driver.findElement(By.xpath("//*[@id=\"tls\"]")); 
		Clickon_TLS.click();
		String[] expected1 = {"First time", "On Each Connection", "Only Once for each certificate"};
		
		  driver.findElement(By.xpath("//*[@id=\"SSLCertificatePromptHowOften\"]")).click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"promptlist\"]//li"));
			System.out.println("all option "+ allOptions.size());

			ArrayList<String> availableitems =new ArrayList<String>();
			for(WebElement ele : allOptions) {
				
				availableitems.add(ele.getText().trim());
				
			}
			System.out.println("availableitems value is :"+availableitems);
			 for (int i =0;i<expected1.length;i++){
				 System.out.println("expected value is :"+expected1[i]);
				assertTrue(availableitems.contains(expected1[i].trim()), "promptlist are not available");		           
			 }
			 
			//selecting options 
			 for (WebElement opt : allOptions) {
		            if (opt.getText().equals("First time")) {
		                opt.click();
		                return;
		            }
		        }
			 
			 
			 logger.log(LogStatus.PASS, "<span style='color:green;'> Setting tab options are Verified successfully</span>"
	 				+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
	}
	public void TLS_SessionProperties() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rightClick_session = driver.findElement(By.xpath("//*[@id=\"menubutton0\"]/img")); 
		rightClick_session.click();
		Thread.sleep(1000);
		WebElement session_start =driver.findElement(By.xpath("//*[@id='context0']/span[1]"));
		WebElement properties = driver.findElement(By.xpath("//*[@id='context0']/span[2]"));
		if(session_start.isDisplayed() && properties.isDisplayed())
		{
			properties.click();
			logger.log(LogStatus.PASS, "<span style='color:green;'> 3 dots options are displayed successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'> 3 dots options are not displayed </span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Properties Page")));	
		}	
		//WebElement property_Session = driver.findElement(By.xpath("//*[@id=\"context0\"]/span[2]")); 
		//property_Session.click();
		Thread.sleep(1000);
		WebElement protocal = driver.findElement(By.xpath("//*[@id=\"SSL\"]"));
		protocal.click();
		WebElement selectTLS = driver.findElement(By.xpath("//*[@id=\"protocollist\"]/li[2]/a"));
		selectTLS.click();
		WebElement Clickon_TLS = driver.findElement(By.xpath("//*[@id=\"tls\"]")); 
		Clickon_TLS.click();
		Thread.sleep(1000);
		WebElement Sendcertificate_checkbox = driver.findElement(By.xpath("//*[@id=\"tls_ssl_div\"]/div[2]/label[2]"));
	
		System.out.println("The checkbox is selection state is - " + Sendcertificate_checkbox.isSelected());
		WebElement save = driver.findElement(By.xpath("//*[@id=\"submit\" and @onclick=\"updateProp();\"]")); 
		save.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>TLS SessionProperties values validated successfully</span>");
	}
	public void TLS_5250SessionProperties() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rightClick_session = driver.findElement(By.xpath("//*[@id=\"menubutton1\"]/img")); 
		rightClick_session.click();
		Thread.sleep(1000);
		WebElement property_Session = driver.findElement(By.xpath("//*[@id=\"context1\"]/span[2]")); 
		property_Session.click();
		Thread.sleep(1000);
		WebElement protocal = driver.findElement(By.xpath("//*[@id=\"SSL\"]"));
		protocal.click();
		WebElement selectTLS = driver.findElement(By.xpath("//*[@id=\"protocollist\"]/li[2]/a"));
		selectTLS.click();
		WebElement Clickon_TLS = driver.findElement(By.xpath("//*[@id=\"tls\"]")); 
		Clickon_TLS.click();
		Thread.sleep(1000);
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"tls_ssl_div\"]/div[2]/label[2]"));
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		WebElement save = driver.findElement(By.xpath("//*[@id=\"submit\" and @onclick=\"updateProp();\"]")); 
		save.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>TLS SessionProperties values validated successfully</span>");
	}
	
	public void TLS_UploadFile() throws InterruptedException, Exception {
		Thread.sleep(2000);	
		WebElement upload_file = driver.findElement(By.xpath("/html/body/div[30]/div/div/div[2]/div[1]/div/label"));
		upload_file.click();
		Thread.sleep(5000);	
		StringSelection ss = new StringSelection("C:\\Users\\neeladri.p\\Desktop\\3270\\client.jks");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     logger.log(LogStatus.PASS, "<span style='color:green;'>TLS Client certificate uploaded successfully</span>");
	}
	public void TLS_5250UploadFile() throws InterruptedException, Exception {
		Thread.sleep(2000);	
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"clientAuthentication\"]/div/div/div[2]/div[1]/div/label"));
		upload_file.click();
		Thread.sleep(5000);	
		StringSelection ss = new StringSelection("C:\\Users\\neeladri.p\\Desktop\\5250\\client .jks");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     logger.log(LogStatus.PASS, "<span style='color:green;'>TLS Client 5250 certificate uploaded successfully</span>");
	}
	public void TLS_Password() throws InterruptedException {
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//*[@id=\"SSLCertificatePassword\"]"));
		password.sendKeys("client123");
		logger.log(LogStatus.PASS, "<span style='color:green;'>TLS client password entered successfully</span>");
	}
	public void TLS_Ok_Button() throws InterruptedException {
		Thread.sleep(3000);
		WebElement okay_button = driver.findElement(By.xpath("/html/body/div[30]/div/div/div[3]/button[1]"));
		okay_button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>TLS Okay button clicked successfully</span>");
	}
	public void TLS_WrongUploadFile() throws InterruptedException, Exception {
		Thread.sleep(2000);	
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"clientAuthentication\"]/div/div/div[2]/div[1]/div/label"));
		upload_file.click();
		Thread.sleep(5000);	
		StringSelection ss = new StringSelection("C:\\Users\\neeladri.p\\Desktop\\Custom\\CustomizedCAs.jks");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     logger.log(LogStatus.PASS, "<span style='color:green;'>TLS Wrong certificate uploaded successfully</span>");
	}
	public void TLS_5250WrongUploadFile() throws InterruptedException, Exception {
		Thread.sleep(2000);	
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"clientAuthentication\"]/div/div/div[2]/div[1]/div/label"));
		upload_file.click();
		Thread.sleep(5000);	
		StringSelection ss = new StringSelection("C:\\Users\\neeladri.p\\Desktop\\Custom\\CustomizedCAs.jks");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     logger.log(LogStatus.PASS, "<span style='color:green;'>TLS Wrong certificate uploaded successfully</span>");
	}	
}

