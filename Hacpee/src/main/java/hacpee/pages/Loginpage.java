package hacpee.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.LogStatus;

import TestUtills.DataUtils;
import hacpee.config.Config;

public class Loginpage extends TestExecutor{
	
	/*@FindBy(how = How.NAME, using = Config.username)
	public WebElement username;
	
	@FindBy(how = How.XPATH, using = Config.password)
	public WebElement password;
*/


	 WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		
		this.driver = driver;
	
	}

	public  void login() throws IOException, InterruptedException {
		
      
}
	
}
