package hacpee.StepDefenition;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import hacpee.pages.Common;
import hacpee.pages.HomePage;
import hacpee.pages.TestExecutor;

public class SmokeTests extends TestExecutor{

	String featureName = "";
	
	@Before
	public ExtentReports Release2(final Scenario scenario) throws IOException {  
		
		
	    String rawFeatureName = scenario.getId().split(";")[0].replace("-","_");
	    featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		
        String destFile=null;
        destFile=userDir + "\\test-output\\extentreports";
        DateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");                
        String destDir=dateFormat.format(new Date()) + ".html";                  
        report=new ExtentReports(destFile + "\\" + featureName + "_"  + destDir, true); 
        return report;       
        }
	
		/*
		 * @Given("^I launch the browser and verify the login and logout from config model$"
		 * ) public void
		 * i_launch_the_browser_and_verify_the_login_and_logout_from_config_model()
		 * throws Throwable { initialize(); logger = report.startTest(featureName);
		 * 
		 * Thread.sleep(3000); driver.get("http://10.156.210.34:9080/11/");
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * common.sleepInSeconds(2); logger.log(LogStatus.PASS,
		 * "<span style='color:green;'>HACPEE Url Launched Successfully for config based model</span>"
		 * + logger.addScreenCapture( Common.CaptureScreenShot(driver,
		 * "HACP EE Homepage_html")));
		 * 
		 * HomePage fn = new HomePage(); fn.configmodel(); report.endTest(logger);
		 * report.flush(); Thread.sleep(2000); driver.quit(); }
		 */
	
	@After
	public void reportclosewindows() throws InterruptedException, IOException{
		
		try{	
		 report.endTest(logger);
		 report.flush();
		 Thread.sleep(2000);
		 driver.quit();
		 }
		catch(Exception e){	 
		 logger.log(LogStatus.FAIL, "<span style='color:green;'>Test Failed and Screenshot is captured for More details</span>" );
		 Common.CaptureScreenShots(driver); 
		 report.endTest(logger);
		 report.flush();
		 Thread.sleep(2000);
		 driver.quit();	 
	 }
}
	
}
