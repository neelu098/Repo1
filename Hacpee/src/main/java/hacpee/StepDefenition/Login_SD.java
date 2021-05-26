
package hacpee.StepDefenition;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.internal.TestResult;

	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.LogStatus;
	//import com.thoughtworks.selenium.SeleniumException;


	import TestUtills.DataUtils;
	import cucumber.api.DataTable;
	import cucumber.api.PendingException;
	import cucumber.api.Scenario;
	import cucumber.api.java.After;
	import cucumber.api.java.Before;
	import cucumber.api.java.en.And;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import hacpee.pages.ActiveTabPage;
import hacpee.pages.Common;
import hacpee.pages.HomePage;
import hacpee.pages.Loginpage;
import hacpee.pages.TestExecutor;
	
	public class Login_SD  extends TestExecutor {
		String featureName = "";
		
		@Before
		public ExtentReports Release2(final Scenario scenario) {  
					
		    String rawFeatureName = scenario.getId().split(";")[0].replace("-","_");
		    featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
			
	        String destFile=null;
	        destFile=userDir + "\\test-output\\extentreports";
	        DateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");                
	        String destDir=dateFormat.format(new Date()) + ".html";                  
	        report=new ExtentReports(destFile + "\\" + featureName + "_"  + destDir, true); 
	       // report=new ExtentReports(destFile + "\\" + featureName, true); 

	        return report;       
	        }
		
		@Given("^I launch browser and enter the url$")
	       public void as_a_user_i_launch_browser_enter_url() throws Throwable {                        
	             initialize(); 
				 logger = report.startTest(featureName);
	             System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
					/*
					 * driver=new ChromeDriver();
					 * driver.get("http://10.115.50.33:9082/2807/hm#");
					 * //Thread.sleep(10000);
					 */	 
	             Thread.sleep(5000);
	             //driver.get("https://tetdemos.hclpnp.com/hex/sample.html");
	            driver.get("http://localhost:9080/hex/usha.html"); // 2.0 Build
	             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	            // driver.manage().window().maximize();
                 common.sleepInSeconds(2);  
              //   String screenshotName = "." + common.getScreenshot("Login");
                
	             logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE Homepage")));             
	            // logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully</span>" + logger.addScreenCapture(common.CaptureScreen(driver, "Login")));             
		         //common.screenCapture(screenshotName);
		         
	             //common.CaptureScreenShots(driver); 
	             
		}
		
		@Given("^I launch browser again and enter the url$")
	       public void as_a_user_i_launch_again_browser_enter_url() throws Throwable {                        
	             initialize(); 
				// logger = report.startTest(featureName);
	             System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
					/*
					 * driver=new ChromeDriver();
					 * driver.get("http://10.115.50.33:9082/2807/hm#");
					 * //Thread.sleep(10000);
					 */	 
	             Thread.sleep(5000);
	             //driver.get("https://tetdemos.hclpnp.com/hex/sample.html");
	            driver.get("http://10.115.90.137:9080/hex/demo.html"); // 2.0 Build
	             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	            // driver.manage().window().maximize();
              common.sleepInSeconds(2);             
	           //  logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE Homepage")));             
	      
		}
		
		@And("^I verify the build version details$")
		public void i_verify_the_build_version_details() throws Throwable {
		    HomePage fn = new HomePage();
		    fn.Build_Verification();
		    
		}
		@Given("^I verify the build version details in HACP EE Admin console$")
		public void i_verify_the_build_version_details_in_HACP_EE_Admin_console() throws Throwable {
			HomePage fn = new HomePage();
		    fn.Admin_Build_Verification();
		}
		@Then("^I logout the AdminConsole page$")
		public void i_logout_the_AdminConsole_page() throws Throwable {
		    
			HomePage fn = new HomePage();
		    fn.Admin_logout();
		}
		@Then("^I verify the Help button in HACP EE Admin console$")
		public void i_verify_the_Help_button_in_HACP_EE_Admin_console() throws Throwable {
			HomePage fn = new HomePage();
		    fn.Help_Icon();
		}
		
		@Then("^I connect to a session and verify the disconnect and reconnect options$")
		public void i_connect_to_a_session_and_verify_the_disconnect_and_reconnect_options() throws Throwable {
		    ActiveTabPage fn = new ActiveTabPage();
		    fn.DisconnectAndRestartSession();
		}

		/*
		 * @Then("^I close the session$") public void i_close_the_session() throws
		 * Throwable {
		 * 
		 * }
		 */
		@Then("^I traverse between multiple seesions including (\\d+) and (\\d+)$")
		public void i_traverse_between_multiple_seesions_including_and(int arg1, int arg2) throws Throwable {
		    
		}
		
		@Then("^I maximize and minimize the connected session$")
		public void i_maximize_and_minimize_the_connected_session() throws Throwable {
			ActiveTabPage fn = new ActiveTabPage();
		    fn.MaximizeAndMinimize();
		}
		
		@Then("^I expand the ribbon bar to verify the macro options$")
		public void i_verify_the_macro_options() throws Throwable {
			ActiveTabPage fn = new ActiveTabPage();
		    fn.ClickExpandIcon();
		    fn.VerifyMacro();
		}
		
		@Then("^I maximize the connected session$")
	       public void i_maximize_the_connected_session() throws Throwable {
	             ActiveTabPage fn = new ActiveTabPage();
	             fn.MaximizeScreen();
	       }
	@Then("^I Verify Ribbon bar is able to open while maximizing the screen$")
	       public void i_Verify_Ribbon_bar_is_able_to_open_while_maximizing_the_screen() throws Throwable {
	          
	             HomePage fn = new HomePage();
	             fn.fnNavigationBarFSclick();
	       }

	@Then("^Verify the all fields from preferences tab are editable in session properties$")
    public void verify_the_all_fields_from_preferences_tab_are_editable_in_session_properties() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnPrefernceTabFields();
    }

	@Then("^I close the session by X icon$")
    public void i_close_the_session_by_X_icon() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnCloseSessionX(); 
    }

	
	
		
		@Then("^I click on Print Screen$")
		public void i_click_on_Print_Screen() throws Throwable {
			HomePage fn = new HomePage();
			fn.VerifyPrintScreen();
		}
		
		@Then("^I verify cut copy paste$")
		public void i_verify_cut_copy_paste() throws Throwable {
			HomePage fn = new HomePage();
			fn.VerifyCutCopyPaste();
		}
		
		@Then("^I verify launching maximum sessions$")
		public void i_verify_launching_maximum_sessions() throws Throwable {
			ActiveTabPage fn = new ActiveTabPage();
		    fn.LanuchMaxSessions();
		}
		
		
		@Then("^I click on Preferences tab$")
		public void i_click_on_Preferences_tab() throws Throwable {
			HomePage fn = new HomePage();
			fn.PrefernceTab();
		}

		@Then("^I select display status bar$")
		public void i_select_display_status_bar() throws Throwable {
			HomePage fn = new HomePage();
			fn.Prefernce_StatusBar();
		}

		@Then("^I click on Save button$")
		public void i_click_on_Save_button() throws Throwable {
			HomePage fn = new HomePage();
			fn.PrefernceSave();
		}

		

		@Then("^I verify the session connectivity$")
		public void i_verify_the_session_connectivity() throws Throwable {
			HomePage fn = new HomePage();
			fn.SessionConnectivity();
		}
		
		  @Given("^I launch the browser for combined model$") 
		  public void i_launch_the_browser_for_combined_model() throws Throwable { 
			  
			  initialize(); 
			  logger = report.startTest(featureName);
			  Thread.sleep(3000); 
			  driver.get("http://10.156.210.34:9080/12/cbm.html");
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  common.sleepInSeconds(2); 
			  logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully for combined based model</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage_html")));		
		  }
		  
		 
		  @Given("^I launch browser for all HACP EE session$")
		  public void i_launch_browser_for_all_HACP_EE_session() throws Throwable {
			  initialize(); 
			  logger = report.startTest(featureName);
			  Thread.sleep(3000); 
			  driver.get("http://10.115.160.170:9080/hex/all");
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  common.sleepInSeconds(2); 
			  logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully for All Sessions</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage_html")));		
		    
		  }
		  @Given("^I click on Preferences Settings tab and varify the options the properties values$")
		  public void i_click_on_Preferences_Settings_tab_and_varify_the_options_the_properties_values() throws Throwable {
			  HomePage fn = new HomePage();
				fn.PrefenceVerification();
		  }


		  @Then("^I verify the all sessions are displayed or not HACP EE$")
		  public void i_verify_the_all_sessions_are_displayed_or_not_HACP_EE() throws Throwable {
			  HomePage fn = new HomePage();
				fn.AllSessionVerification();
		  }

		
		  @Given("^I launch the browser and verify the login and logout from config model$") 
		  public void i_launch_the_browser_and_verify_the_login_and_logout_from_config_model() throws Throwable { 
			  
			  initialize(); 
			//  logger = report.startTest(featureName);
			
	        //System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
		  Thread.sleep(3000); 
		  driver.get("http://10.156.210.34:9080/12");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  common.sleepInSeconds(2); 
		  logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully for config based model</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage_html")));
		  
		  HomePage fn = new HomePage(); 
		  fn.configmodel();
			/*
			 * report.endTest(logger); report.flush(); Thread.sleep(2000); driver.quit();
			 */
		  
		  }
		  
		  @Given("^I launch the browser for config model$") 
		  public void i_launch_the_browser_for_config_model() throws Throwable { 
			  
			  initialize(); 
			  logger = report.startTest(featureName);
			  Thread.sleep(3000); 
			  driver.get("http://10.156.210.34:9080/12");
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  common.sleepInSeconds(2); 
			  logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully for config based model</span>" + logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage_html")));		
		  }
		  
		 

		@Then("^I verify by accessing the pages with and without html$")
		public void i_verify_by_accessing_the_pages_with_and_without_html() throws Throwable {
			initialize(); 
				/*
				 * logger = report.startTest(featureName);
				 * System.setProperty("webdriver.chrome.driver",
				 * "Broswer_Drivers\\chromedriver.exe");
				 */	
			 logger.log(LogStatus.INFO, "<span class='label success'>ACCESSING WITH AND WITHOUT HTML</span>");	
			 
             Thread.sleep(3000);
             driver.get("http://10.156.210.34:9080/12/new.html");
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             common.sleepInSeconds(2);             
             logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully with .html</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE Homepage.html")));             
            // report.endTest(logger);  report.flush(); Thread.sleep(2000);
    		 driver.quit();
    		 initialize(); 
    		 Thread.sleep(3000);
             driver.get("http://10.156.210.34:9080/12/new.html");
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             common.sleepInSeconds(2);             
             logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully without .html</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE Homepage_html")));             
				
				//  report.endTest(logger); report.flush(); Thread.sleep(2000); driver.quit();
				 
		}
		
		/*
		 * @Then("^I close the session$") public void i_close_the_session() throws
		 * Throwable { HomePage fn = new HomePage(); fn.fnVerifycloseSession();
		 * 
		 * }
		 */

		/*
		 * @Then("^I traverse between multiple seesions including (\\d+) and (\\d+)$")
		 * public void i_traverse_between_multiple_seesions_including_and(int arg1, int
		 * arg2) throws Throwable {
		 * 
		 * }
		 */
		@Given("^I want to write a step with precondition$")
		public void i_want_to_write_a_step_with_precondition() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			System.out.println("Checking the test");
		}

		@Then("^I click on 3270 Session$")
		public void i_click_on_3270_session() throws Throwable {
			HomePage fn = new HomePage();
			fn.fnSelectSession();
			//logger.log(LogStatus.PASS, "<span style='color:green;'>Session Selected successfully</span>"
				//	+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));

		}
		
		@Then("^I click on 5250 Session$")
		public void i_click_on_Session() throws Throwable {
			HomePage fn = new HomePage();
			fn.fnSelect5250Session();
		}
		
		@Then("^I click on next Session$")
		public void i_click_on_5250Session(int arg1) throws Throwable {
			HomePage fn = new HomePage();
			fn.fnSelect5250Session();
			//logger.log(LogStatus.PASS, "<span style='color:green;'>Session Selected successfully</span>"
					//+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));

		}
		
		@Then("^I click on Session for (\\d+)$")
		public void i_click_on_Session_for(int arg1) throws Throwable {
			HomePage fn = new HomePage();
			fn.fnSelect5250();   
		}

		@Then("^I click on search bar to search the sessions$")
		public void i_click_on_search_bar_to_search_the_sessions() throws Throwable {
			HomePage fn = new HomePage();
			fn.Verifysearch();
		}

		@Then("^I close the session$")
		public void i_close_the_session() throws Throwable {
			HomePage fn = new HomePage();
			fn.fnCloseSession();
			logger.log(LogStatus.PASS, "<span style='color:green;'> Session Close icon clicked successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Dashboard Page")));

		}

		@Then("^I verify the closed session$")
		public void i_verify_the_closed_session() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			HomePage fn = new HomePage();
			fn.fnVerifycloseSession();
		}
		@Then("^click on Home icon$")
		public void click_on_Home_icon() throws Throwable {
			HomePage fn = new HomePage();
			fn.fnHomeIconclick();
		}

		@Then("^I click on KeyPad Icon and verify$")
		public void i_click_on_KeyPad_Icon_and_verify() throws Throwable {
			HomePage fn = new HomePage();
			fn.ClickAndVerifyKepPadIcon();
		}

		
		@When("^click on Active session$")
		public void click_on_Active_session() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			HomePage fn = new HomePage();
			fn.fnActiveSessionclick();
		}

		@Then("^Active session screen will appear$")
		public void active_session_screen_will_appear() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			HomePage fn = new HomePage();
			fn.fnVerifyActiveSession();
		}
		@Then("^click on All Active session and screen will appear$")
		public void click_on_All_Active_session_and_screen_will_appear() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			HomePage fn = new HomePage();
			fn.fnActiveSessionclickMultiple();
			logger.log(LogStatus.PASS, "<span style='color:green;'> Active Session  is opened successfully</span>"
					+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACPEE Session Page")));
					
		}

		@And("^I click on Navigation Bar$")
		public void i_click_on_Navigation_Barn() throws Throwable {
			HomePage fn = new HomePage();
			fn.fnNavigationBarclick();
		}
		
	@Then("^click on Settings icon$")
	public void click_on_Settings_icon() throws Throwable {
		HomePage fn = new HomePage();
		fn.fnSettingsIconclick();
	    
	}

	@Then("^I click on all the options present in Settings ribbon bar$")
	public void i_click_on_all_the_options_present_in_Settings_ribbon_bar() throws Throwable {    
		HomePage fn = new HomePage();
		fn.fnVerifySettingsOption();
	}
	
	@Then("^Verify the all fields in Setting panel$")
	public void verify_the_all_fields_in_Setting_panel() throws Throwable {
		HomePage fn = new HomePage();
		fn.fnVerifyGUISettingOption();
	}
	
	@Then("^I verify font color remap and keyremap from settings$")
	public void i_verify_font_color_remap_and_keyremap_from_settings() throws Throwable {
		HomePage fn = new HomePage();
		fn.VerifySettingsFont();
		fn.VerifyColorRemap();
	}

	@Then("^right click on the session and go to properties$")
	public void right_click_on_the_session_and_go_to_properties() throws Throwable {
		HomePage fn = new HomePage();
		fn.fnClickPropertiesOption();
		}
	@Then("^right click on the session and go to properties and Verify the all fields in property panel$")
	public void right_click_on_the_session_and_go_to_properties_and_Verify_the_all_fields_in_property_panel() throws Throwable {
		HomePage fn = new HomePage();
		fn.fnVerifyGUIPropertiesOption();
	}
	
	@Then("^right click on the (\\d+) session and go to properties$")
	public void right_click_on_the_session_and_go_to_properties(int arg1) throws Throwable {
		HomePage fn = new HomePage();
		fn.fnPropertiesOption_5250();
	}
	@Then("^the session is not connected$")
	public void the_session_is_not_connected() throws Throwable {
		HomePage fn = new HomePage();
		fn.Disconnected_Session();
	}
	@Then("^the session is not connected for (\\d+)$")
	public void the_session_is_not_connected_for(int arg1) throws Throwable {
		HomePage fn = new HomePage();
		fn.Disconnected_Session_5250();  
	}
	@Then("^I verify the session connectivity for (\\d+)$")
	public void i_verify_the_session_connectivity_for(int arg1) throws Throwable {
		HomePage fn = new HomePage();
		fn.SessionConnectivity_5250();
	}


	@Then("^I click and verify all the options present in the properties pannel$")
	public void i_click_and_verify_all_the_options_present_in_the_properties_pannel() throws Throwable {
		HomePage fn = new HomePage();
		fn.fnVerifyPropertiesOption();
	}
	@Given("^I launch browser with \\.html URL and verify$")
	public void i_launch_browser_with_html_URL_and_verify() throws Throwable {
		initialize();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		logger = report.startTest(featureName);
		//driver.get("https://tetdemos.hclpnp.com/hex10/sample.html");
		driver.get("http://localhost:9080/hex/usha.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("product_name"))));
		if(driver.findElement(By.id("product_name")).isDisplayed())
				{
			
						logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfull with .HTML</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage")));
						driver.manage().window().maximize();
					
				}    
	}

	@Then("^I launch the URL without giving \\.html and verify$")
	public void i_launch_the_URL_without_giving_html_and_verify() throws Throwable {
		initialize();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		logger = report.startTest(featureName);
		//driver.get("https://tetdemos.hclpnp.com/hex10/sample.html");
		driver.get("http://localhost:9080/hex/three.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("product_name"))));
		if(driver.findElement(By.id("product_name")).isDisplayed())
				{
			
						logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfull without .HTML</span>"
								+ logger.addScreenCapture(Common.CaptureScreenShot(driver, "HACP EE Homepage")));
						driver.manage().window().maximize();
					
				}    
	}
	
	@Then("^I verify the Macro option$")
	public void i_verify_the_Macro_option() throws Throwable {
		initialize();
		driver.get("http://10.156.210.34:9080/12/new.html");
		HomePage fn = new HomePage();
		fn.ExecuteMacro();
	}
	
	@Then("^I  Verify whether search field is editable$")
    public void i_Verify_whether_search_field_is_editable() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnSearchPanelField();
    }

	@Then("^I Verify the error message by entering invalid data$")
    public void i_Verify_the_error_message_by_entering_invalid_data() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnSearchPanelErrorMsg();
    }

    @Then("^I Verify the error message by entering invalid data in property panel$")
    public void i_Verify_the_error_message_by_entering_invalid_data_in_property_panel() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnSearchPropertyErrorMsg();
    }

    @Then("^I  Verify whether search field is editable in properties$")
    public void i_Verify_whether_search_field_is_editable_in_properties() throws Throwable {
          HomePage fn = new HomePage();
          fn.fnPropertySearchField();
    }

	

	@Then("^I verify launching maximum alternate sessions$")
	public void i_verify_launching_maximum_alternate_sessions() throws Throwable {
		ActiveTabPage fn = new ActiveTabPage();
	    fn.LaunchAlternateSessions();
	}
	
	@Then("^I enter the credentials and verify the access$")
	public void i_enter_the_credentials_and_verify_the_access() throws Throwable {
		HomePage fn = new HomePage();
		fn.Enter_Credentials_configmodel();
	}

	@Then("^I verify the welcome user$")
	public void i_verify_the_welcome_user() throws Throwable {
		HomePage fn = new HomePage();
		fn.Verify_WelcomeUserConfigModel();
	}

	@Then("^I verify the Home icon$")
	public void i_verify_the_Home_icon() throws Throwable {
		HomePage fn = new HomePage();
		fn.Verify_HomePageConfigModel();
	}

	@Then("^I verify the About panel icon$")
	public void i_verify_the_About_panel_icon() throws Throwable {
		HomePage fn = new HomePage();
		fn.Build_Verification();
	}

	@Then("^I verify the help icon$")
	public void i_verify_the_help_icon() throws Throwable {
		HomePage fn = new HomePage();
		fn.Verify_HelpIconConfigModel();
	}

	@Then("^I click on logout$")
	public void i_click_on_logout() throws Throwable {
		HomePage fn = new HomePage();
		fn.Logout_configmodel();
	}
	
	@Then("^I verify the session count in the home page$")
	public void i_verify_the_session_count_in_the_home_page() throws Throwable {
		HomePage fn = new HomePage();
		fn.VerifySessionCount();
	}

	@Then("^I verify the session defenition from the home page$")
	public void i_verify_the_session_defenition_from_the_home_page() throws Throwable {
		HomePage fn = new HomePage();
		fn.VerifySessionDefinition();
	}
	
	@When("^I enter the invalid credentials and verify the error message$")
	public void i_enter_the_invalid_credentials_and_verify_the_error_message() throws Throwable {
		HomePage fn = new HomePage();
		fn.Enter_Invalid_Credentials_configmodel();
	}
	
	@Then("^I verify the warning message and click on Ok button to logout$")
	public void i_verify_the_warning_message_and_click_on_Ok_button_to_logout() throws Throwable {
		HomePage fn = new HomePage();
		fn.Click_OK();
	}

	@Then("^I verify font for 5250 session$")
	public void i_verify_font_for_session() throws Throwable {
		HomePage fn = new HomePage();
		fn.VerifySettingsFont5250();
	}

	@Then("^I verify color remap for 5250 session$")
	public void i_verify_color_remap_for_session() throws Throwable {
		HomePage fn = new HomePage();
		fn.Verify5250ColorRemap();
	}
	
	@Then("^I verify keyremap for 5250 session$")
	public void i_verify_keyremap_for_session() throws Throwable {
		System.out.println("CCCCCCCCC");
	}
	
	@Then("^I click on Macro Icon and verify the options$")
	public void i_click_on_Macro_Icon_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage();
		fn.VerifyMacroOptions();
	}

	@Then("^I click on Record Macro$")
	public void i_click_on_Record_Macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickRecordMacro();
	}

	@Then("^I enter the name and description for current session macro and click on Record button$")
	public void i_enter_the_name_and_description_and_click_on_Record_button() throws Throwable {
		HomePage fn = new HomePage();
		fn.EnterRecordNameDesandClickRecord();
	}

	@Then("^I enter a text to record a current session macro and verify the record in progress$")
	public void i_enter_a_text_to_record_a_macro_and_verify_the_record_in_progress() throws Throwable {
		HomePage fn = new HomePage();
		fn.RecordMacro();
	}
	
	@Then("^I click on stop Macro$")
	public void i_click_on_stop_Macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.StopMacro();
	}

	@Then("^I play the recorded current session Macro and verify$")
	public void i_play_the_recorded_current_session_Macro_and_verify() throws Throwable {
		HomePage fn = new HomePage();
		fn.PlayCS_Macro();
	}
	
	@Then("^I click on Macro Icon to record a local macro$")
	public void i_click_on_Macro_Icon_to_record_a_local_macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickMacroIcon();
	}

	@Then("^I select local macro$")
	public void i_select_local_macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickLocalMacro();
	}

	@Then("^I enter the name and description for local macro and click on Record button$")
	public void i_enter_the_name_and_description_for_local_macro_and_click_on_Record_button() throws Throwable {
		HomePage fn = new HomePage();
		fn.EnterRecordNameDesandClickRecord();
	}

	@Then("^I enter a text to record a local macro and verify the record in progress$")
	public void i_enter_a_text_to_record_a_local_macro_and_verify_the_record_in_progress() throws Throwable {
		HomePage fn = new HomePage();
		fn.RecordMacro();
	}

	@Then("^I play the recorded local Macro and verify$")
	public void i_play_the_recorded_local_Macro_and_verify() throws Throwable {
		HomePage fn = new HomePage();
		fn.PlayLocal_Macro();
	}

	@Then("^I click on Macro Icon$")
	public void i_click_on_Macro_Icon() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickMacroIcon();
	}

	@Then("^I click on Record a Prompt$")
	public void i_click_on_Record_a_Prompt() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickPromptRecord();
	}

	@Then("^I validate the fields for record prompt and click cancel$")
	public void i_validate_the_fields_for_record_prompt_and_click_cancel() throws Throwable {
		HomePage fn = new HomePage();
		fn.ValidatePromptRecord();
	}

	@Then("^I click on Record an extract$")
	public void i_click_on_Record_an_extract() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickExtractRecord();
	}

	@Then("^I validate the fields for extract record and click cancel$")
	public void i_validate_the_fields_for_extract_record_and_click_cancel() throws Throwable {
		HomePage fn = new HomePage();
		fn.ValidateExtractRecord();
	}
	
	@Then("^I click on Edit Macro$")
	public void i_click_on_Edit_Macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickEditMacro();
	}

	@Then("^I click on Code Editor$")
	public void i_click_on_Code_Editor() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickCodeEditor();
	}

	@Then("^I make changes in code and click verify and validate error message$")
	public void i_make_changes_in_code_and_click_verify_and_validate_error_message() throws Throwable {
	    
	}

	@Then("^I clear the error and click on save$")
	public void i_clear_the_error_and_click_on_save() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickEditMacroSave();
	}

	@Then("^I delete the macro$")
	public void i_delete_the_macro() throws Throwable {
		HomePage fn = new HomePage();
		fn.DeleteMacro();
	}
	
	@Then("^I click on File Transfer$")
	public void i_click_on_File_Transfer() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickFileTransfer();
	}

	@Then("^I click on Send Files to Host$")
	public void i_click_on_Send_Files_to_Host() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickFilestohost();
	}

	@Then("^I validate the fields under send files to host and click on cancel$")
	public void i_validate_the_fields_under_send_files_to_host_and_click_on_cancel() throws Throwable {
		HomePage fn = new HomePage();
		fn.ValidateFilestoHost();
	}
	
	@Then("^I validate the fields under receive files from host and click on cancel$")
	public void i_validate_the_fields_under_receive_files_to_host_and_click_on_cancel() throws Throwable {
		HomePage fn = new HomePage();
		fn.ValidateFilesfromHost();
	}

	@Then("^I click on Receive Files from Host$")
	public void i_click_on_Receive_Files_from_Host() throws Throwable {
		HomePage fn = new HomePage();
		fn.ClickReceiveFilesFromHost();
	}
	
	@Then("^I close the browser$")
	public void I_close_the_browser() throws Throwable {
		driver.quit();
	}
	
	@Given("^I launch the browser for AdminConsole$")
	public void i_launch_the_browser_for_AdminConsole() throws Throwable {
		 initialize(); 
		 logger = report.startTest(featureName);
         System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
         Thread.sleep(5000);
         driver.get("http://localhost:9080/zieweb3/adminconsole/"); 
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         common.sleepInSeconds(2);  
         logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE AdminConsole Url Launched Successfully</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE AdminConsole Homepage")));             
         
	}
	@When("^I enter the invalid credentials and verify the error message for Adminconsole$")
	public void i_enter_the_invalid_credentials_and_verify_the_error_message_for_Adminconsole() throws Throwable {
		HomePage fn = new HomePage();
		fn.Enter_Invalid_Credentials_Adminconsole();
	}

	@When("^I enter the credentials and verify the access for Adminconsole$")
	public void i_enter_the_credentials_and_verify_the_access_for_Adminconsole() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Enter_Credentials_adminconsole();
	}

	@Then("^I verify the  title of adminconsole$")
	public void i_verify_the_title_of_adminconsole() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		HomePage fn = new HomePage() ;
		fn.Validate_TitleOfAdminconsole();
		
	}
   
	@Then("^I expand the ribbon bar for AdminConsole$")
	public void i_expand_the_ribbon_bar_for_AdminConsole() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.ClickExpandIcon();
		
			}
	@When("^verify the (\\d+) dots options in New User and click Session Tab$")
	public void verify_the_dots_options_in_New_User_and_click_Session_Tab(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.VerifyNewUserdotoption();
	}
	@Then("^I varify the options for AdminConsole$")
	public void i_varify_the_options_for_AdminConsole() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.AdminConsole_Options();
	}
	@When("^I click on All Users tab$")
	public void i_click_on_All_Users_tab() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Click_On_User();
		
	}
	@When("^I click on HOD Admin User$")
	public void i_click_on_HOD_Admin_User() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.HOD_User();
		
	}
	@When("^I click on PCOMM Admin User$")
	public void i_click_on_PCOMM_Admin_User() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PCOMM_User();
	}
	@When("^I click on (\\d+) dots in PCOMM Admin user$")
	public void i_click_on_dots_in_PCOMM_Admin_user(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PCOMM_Dot_option();
	}
	@When("^I click on sessions tab and varify the options PCOMM Admin user$")
	public void i_click_on_sessions_tab_and_varify_the_options_PCOMM_Admin_user() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PCOMM_VerifySession_Tab(); 
	}

	@When("^I click on Disable Functions tab and varify the title in PCOMM Admin user$")
	public void i_click_on_Disable_Functions_tab_and_varify_the_title_in_PCOMM_Admin_user() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PCOMM_Disable_Functions_Tab();
	}

	@When("^I click on New Group Icon and Verify the Options$")
	public void i_click_on_New_Group_Icon_and_Verify_the_Options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Group_Icon();
	}
	@When("^I click on properties tab and verify the options in PCOMM group$")
	public void i_click_on_properties_tab_and_verify_the_options_in_PCOMM_group() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PCOMM_Group_Icon();
	}

	@When("^I click on New User Icon and Verify the Options$")
	public void i_click_on_New_User_Icon_and_Verify_the_Options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.User_Icon();
	}

	@When("^I click on New User Icon and validate the details$")
	public void i_click_on_New_User_Icon_and_validate_the_details() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.New_User();
	}
	@When("^I click on (\\d+) dots in Admin user$")
	public void i_click_on_dots_in_Admin_user(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Dot_option();
		//fn.VerifyUserOptions();
	}
	@When("^I click on (\\d+) dots in New User$")
	public void i_click_on_dots_in_New_User(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.NewUser_Dot_option(); 
	}

	@When("^I verify the option avaiable in Admin user$")
	public void i_verify_the_option_avaiable_in_Admin_user() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.VerifyUserOptions(); 
	}
	@When("^I click on sessions tab and varify the options$")
	public void i_click_on_sessions_tab_and_varify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.VerifySession_Tab(); 
	}
	
	@When("^I click on (\\d+) sessions tab and validate the options$")
	public void i_click_on_sessions_tab_and_validate_the_options(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.NewUser_3270Session(); 
	}
	@When("^I click on sessions tab and validate the options for (\\d+)$")
	public void i_click_on_sessions_tab_and_validate_the_options_for(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.NewUser_5250Session();
	}
	@Then("^right click on the (\\d+) session and start sesson$")
	public void right_click_on_the_session_and_start_sesson(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.NewUser_5250StartSession();
	}

	@When("^I click on Disable Functions tab and varify the heading$")
	public void i_click_on_Disable_Functions_tab_and_varify_the_heading() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Disable_Functions_Tab(); 
	}

	@When("^I click on desktop tab and verify the options$")
	public void i_click_on_desktop_tab_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Desktop_Tab(); 
	}

	@When("^I click on  Connection tab in Disable fuction and verify the options$")
	public void i_click_on_Connection_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Connection_Tab(); 
	}

	@When("^I click on  Appearance tab in Disable fuction and verify the options$")
	public void i_click_on_Appearance_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Appearance_Tab(); 
	}

	@When("^I click on  Macro tab in Disable fuction and verify the options$")
	public void i_click_on_Macro_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Macro_Tab(); 
	}

	@When("^I click on  File Transfer in Disable fuction and verify the options$")
	public void i_click_on_File_Transfer_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.File_Transfer_Tab();
	}

	@Then("^I expand the ribbon bar for File Transfer$")
	public void i_expand_the_ribbon_bar_for_File_Transfer() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Expand_FileTransfer();
	}

	@When("^I click on  FTP tab in File Transfer and verify the options$")
	public void i_click_on_FTP_tab_in_File_Transfer_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.FTP_Tab();
	}

	@When("^I click on  Data transfer tab in Disable fuction and verify the options$")
	public void i_click_on_Data_transfer_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Data_Transfer();
	}

	@Then("^I expand the ribbon bar for Data transfer tab$")
	public void i_expand_the_ribbon_bar_for_Data_transfer_tab() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Expand_DataTransfer();
	}
	@Then("^I verify the session is displayed or not for (\\d+)$")
	public void i_verify_the_session_is_displayed_or_not_for(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Session3270_Display();
	}
	@Then("^I verify the (\\d+) session is displayed or not$")
	public void i_verify_the_session_is_displayed_or_not(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Session5250_Display();
	}

	@When("^I click on  Edit Permissions tab in  Data transfer and verify the options$")
	public void i_click_on_Edit_Permissions_tab_in_Data_transfer_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Edit_Permission();
	}

	@When("^I click on  SQL Statements tab in  Data transfer and verify the options$")
	public void i_click_on_SQL_Statements_tab_in_Data_transfer_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.SQL_Statement();
	}

	@When("^I click on  Configuration tab in  Data transfer and verify the options$")
	public void i_click_on_Configuration_tab_in_Data_transfer_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Configuration();
	}

	@When("^I click on  Display Print Functions tab in Disable fuction and verify the options$")
	public void i_click_on_Display_Print_Functions_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Display_Print_Functions_Tab();
	}

	@When("^I click on  Printer Session tab in Disable fuction and verify the options$")
	public void i_click_on_Printer_Session_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PrinterSession_Tab();
	}

	@When("^I click on  Preferences tab in Disable fuction and verify the options$")
	public void i_click_on_Preferences_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Preferences_Tab();
	}

	@When("^I click on  Others tab in Disable fuction and verify the options$")
	public void i_click_on_Others_tab_in_Disable_fuction_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Others_Tab();
	}

	@When("^I click on Trace Facility tab and verify the options$")
	public void i_click_on_Trace_Facility_tab_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Trace_Facility_Tab(); 
	}
	
	@When("^I click on properties tab and verify the options$")
	public void i_click_on_properties_tab_and_verify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Properties_Tab();
	}
	@Given("^I launch the browser for TLS Authentication$")
	public void i_launch_the_browser_for_TLS_Authentication() throws Throwable {
		initialize(); 
		 logger = report.startTest(featureName);
        //System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
        Thread.sleep(5000);
        driver.get("http://10.115.160.170:9080/hex/tls4.html"); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        common.sleepInSeconds(2);  
        logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE TLS Url Launched Successfully</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE AdminConsole Homepage")));             
        
	}

	@Then("^right click on the session and verify the properties for TLS Auth$")
	public void right_click_on_the_session_and_verify_the_properties_for_TLS_Auth() throws Throwable {
		
		HomePage fn = new HomePage() ;
		fn.TLS_SessionProperties();
	}
	@Then("^right click on the session and verify the How often to prompt option in TLS$")
	public void right_click_on_the_session_and_verify_the_How_often_to_prompt_option_in_TLS() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_HowOftenToPrompt();
	}

	@When("^click on the choose file and select the Certificate from Local machine$")
	public void click_on_the_choose_file_and_select_the_Certificate_from_Local_machine() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_UploadFile();
	}

	@When("^I enter the password for TLS auth$")
	public void i_enter_the_password_for_TLS_auth() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_Password();
	}

	@Then("^I click on the Ok button$")
	public void i_click_on_the_Ok_button() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_Ok_Button();
	}
	@When("^click on the choose file and select the wrong Certificate from Local machine$")
	public void click_on_the_choose_file_and_select_the_wrong_Certificate_from_Local_machine() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_WrongUploadFile();
	}
	@When("^click on the choose file and select the wrong Certificate for (\\d+) session$")
	public void click_on_the_choose_file_and_select_the_wrong_Certificate_for_session(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_5250WrongUploadFile();
	}

	@Then("^the session is not connected for TLS auth$")
	public void the_session_is_not_connected_for_TLS_auth() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_Disconnected_Session();
	}

	@Then("^right click on the (\\d+) session and verify the properties for TLS Auth$")
	public void right_click_on_the_session_and_verify_the_properties_for_TLS_Auth(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_5250SessionProperties();
	}

	@When("^click on the choose file and select the Certificate for (\\d+) session$")
	public void click_on_the_choose_file_and_select_the_Certificate_for_session(int arg1) throws Throwable {
		HomePage fn = new HomePage() ;
		fn.TLS_5250UploadFile();
	}

	
	@Given("^I click on Services tab and varify the options$")
	public void i_click_on_Services_tab_and_varify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Service_Tab();
		
	}

	@Given("^I click on Directory tab and varify the options$")
	public void i_click_on_Directory_tab_and_varify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Directory_Tab();
		
	}

	@Given("^I click on Host Connections tab and varify the options$")
	public void i_click_on_Host_Connections_tab_and_varify_the_options() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.HostConnection_Tab();
	}

	@Given("^I click on Log tab and varify the options$")
	public void i_click_on_Log_tab_and_varify_the_options() throws Throwable {
		
		HomePage fn = new HomePage() ;
		fn.LogSetting();
		
	}
	
	@Given("^I click on Preferences Settings tab and varify the Web properties values$")
	public void i_click_on_Preferences_Settings_tab_and_varify_the_Web_properties_values() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.PreferenceProperties(); 
	}



	@Given("^I click on Trace setting tab and varify the options$")
	public void i_click_on_Trace_setting_tab_and_varify_the_options() throws Throwable {
		
		HomePage fn = new HomePage() ;
		fn.Trace_setting_Tab();
	}

	@Given("^I click on Preferences Settings tab and varify the options$")
	public void i_click_on_Preferences_Settings_tab_and_varify_the_options() throws Throwable {
		
		HomePage fn = new HomePage() ;
		fn.Preference_Tab();
	}
	@Given("^I click on Preferences Settings tab and varify account tab functionalities$")
	public void i_click_on_Preferences_Settings_tab_and_varify_account_tab_functionalities() throws Throwable {
		HomePage fn = new HomePage() ;
		fn.Account_Tab(); 
	}

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
