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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hacpee.pages.ActiveTabPage;
import hacpee.pages.Common;
import hacpee.pages.TestExecutor;

public class UX_StepDef extends TestExecutor {

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
	@Given("^I Launch the Browser and enter the url$")
	public void i_Launch_the_Browser_and_enter_the_url() throws Throwable {                       
          initialize(); 
			 logger = report.startTest(featureName);
          System.setProperty("webdriver.chrome.driver","Broswer_Drivers\\chromedriver.exe");	
				/*
				 * driver=new ChromeDriver();
				 * driver.get("http://10.115.50.33:9082/2807/hm#");
				 * //Thread.sleep(10000);
				 */	 
          String CURL = prop.getProperty("ConfigBasedModel");
      	driver.get(CURL);
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         // driver.manage().window().maximize();
          common.sleepInSeconds(2);             
          logger.log(LogStatus.PASS, "<span style='color:green;'>HACPEE Url Launched Successfully</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "HACP EE Homepage")));             
   
	}
	@When("^I Check the Font and Colour For HACP EE$")
	public void i_Check_the_Font_and_Colour_For_HACP_EE() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.HACPEE_Text();
	}
	
	@Then("^I check the Header Colour For HACP EE$")
	public void i_check_the_Header_Colour_For_HACP_EE() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.HeaderColour();
	}
	@Then("^I Check the Backgorund Colour For HACP EE$")
	public void i_Check_the_Backgorund_Colour_For_HACP_EE() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.BAckgroundColour();
	}

	@Then("^I Check the Login Panel Colour$")
	public void i_Check_the_Login_Panel_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.LoginPanelColour();
	}
	@Then("^I check the Username font and Colour$")
	public void i_check_the_Username_font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Username();
	}
	@Then("^I Check the password Font and Colour$")
	public void i_Check_the_password_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Password();
	}
	@Then("^I Check the Input Field Colour$")
	public void i_Check_the_Input_Field_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.inputfields();
	}
	@Then("^I Check Remberme Font and colour$")
	public void i_Check_Remberme_Font_and_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Remberme();
	}
	@Then("^I Check the Login Font and Colour$")
	public void i_Check_the_Login_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.LoginText();
	}
	@Then("^I Check the Continue as guest Font and colour$")
	public void i_Check_the_Continue_as_guest_Font_and_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Continueasguests();
	}
	@Then("^I Check the Copyright Details$")
	public void i_Check_the_Copyright_Details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Copyright();
	}
	@Then("^I Check the Error Messages$")
	public void i_Check_the_Error_Messages() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Errormessgae();
	}
	@Then("^I Check the Guest Connect Background colour$")
	public void i_Check_the_Guest_Connect_Background_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.GuestConnect();
	}
	@Then("^I Check the Guest Connect Title Font and Colour$")
	public void i_Check_the_Guest_Connect_Title_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.GuestConnectTitle();
	}
	@Then("^I Check the Guest connect Heading Font and Colour$")
	public void i_Check_the_Guest_connect_Heading_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.GuestConnectHeading();
	}
	@Then("^I Check the Guest Connect SubHeading Font and Colour$")
	public void i_Check_the_Guest_Connect_SubHeading_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ActiveTabPage fn = new ActiveTabPage();
	    fn.GuestConnectSubHeading();
	}
	@Then("^I Check the Field Disable Background Colour$")
	public void i_Check_the_Field_Disable_Background_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.FieldDisable();
	}
	@Then("^I Check the Input Field Background Colour$")
	public void i_Check_the_Input_Field_Background_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.InputField();
	}
	@Then("^I Check the Connect Font, colour and ConnectButton BAckground Colour$")
	public void i_Check_the_Connect_Font_colour_and_ConnectButton_BAckground_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Connect();
	}
	@Then("^I Check the Active session font and colour$")
	public void i_Check_the_Active_session_font_and_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Activesession();
	}
	@Then("^I Check the Available Session Font anc Colour$")
	public void i_Check_the_Available_Session_Font_anc_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AvailableSession();
	}
	@Then("^I Check the Session Name FOnt and Colour$")
	public void i_Check_the_Session_Name_FOnt_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.SessionName();
	}
	@Then("^I Check the search bar background colour$")
	public void i_Check_the_search_bar_background_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.searchbar();
	}
	@Then("^I Check the About Panel Footer Colour$")
	public void i_Check_the_About_Panel_Footer_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AboutFooterClr();
	}

	@Then("^I Check the About Panel Header Colour$")
	public void i_Check_the_About_Panel_Header_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AboutPanelHeaderClr();
	}

	@Then("^I CHeck the About Heading Font and Colour$")
	public void i_CHeck_the_About_Heading_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AboutPanelHeading();
	}

	@Then("^I Check the About Content Font and Colour$")
	public void i_Check_the_About_Content_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AboutPanelContent();
	}

	@Then("^I Check the About Panel Close Background Colour$")
	public void i_Check_the_About_Panel_Close_Background_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.AboutPanelCancel();
	}

	@Then("^I Check the PropertyPanel Heading$")
	public void i_Check_the_PropertyPanel_Heading() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertPanelHeading();
	}
	@Then("^I Check the current Panel Font and colour$")
	public void i_Check_the_current_Panel_Font_and_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.CurrentPanel();
	}
	@Then("^I Check the Other Panel Font and Colour$")
	public void i_Check_the_Other_Panel_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.Otherpanel();
	}
	@Then("^I Check the Current Header Panel font and Colour$")
	public void i_Check_the_Current_Header_Panel_font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.CurrentHeaderPaenl();
	}
	@Then("^I Check the Other Header panel font and colour$")
	public void i_Check_the_Other_Header_panel_font_and_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.OtherHeaderPanel();
	}
	@Then("^I Check the Property Panel Sub Menu Font and Colour$")
	public void i_Check_the_Property_Panel_Sub_Menu_Font_and_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertyPanelSubMenu();
	}
	@Then("^I CHeck the Property Panel Background colour$")
	public void i_CHeck_the_Property_Panel_Background_colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertyPanelBackground();
	}
	@Then("^I Check the Property Panel Footer Colour$")
	public void i_Check_the_Property_Panel_Footer_Colour() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertyPanelFooterClr();
	}
	@Then("^I Check the Property Panel Savebutton$")
	public void i_Check_the_Property_Panel_Savebutton() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertyPanelSave();
	}
	@Then("^I Check the Property Panel CancelButton$")
	public void i_Check_the_Property_Panel_CancelButton() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ActiveTabPage fn = new ActiveTabPage();
	    fn.PropertyPanelCancel();
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


