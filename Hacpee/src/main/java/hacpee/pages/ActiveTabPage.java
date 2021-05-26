package hacpee.pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class ActiveTabPage extends TestExecutor {

	WebDriverWait wait = new WebDriverWait(driver, 100);


	public void DisconnectAndRestartSession() throws InterruptedException {
		logger.log(LogStatus.INFO, "<span class='label success'>DISCONNECT AND RESTART SESSION</span>");	
		Thread.sleep(3000);
		WebElement SessionOne = driver.findElement(By.id("sessionImg0")); 
		SessionOne.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Click and connected to 3270 session display </span>");
		Thread.sleep(5000);
		WebElement SessionMenu = driver.findElement(By.id("menubuttonList10")); 
		SessionMenu.click();
		Thread.sleep(7000);
		WebElement Disconnect = driver.findElement(By.xpath("//*[@id='list1_3270 Display-A']")); 
		Thread.sleep(7000);
		Disconnect.click();
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Select and click disconnect to disconnect the sesison</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "DisconnectSession")));

		Thread.sleep(3000);

		SessionMenu.click();
		Thread.sleep(3000);

		Disconnect.click();
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Select and click connect to restart the sesison</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "RestartSession")));

		SessionMenu.click();
		Thread.sleep(3000);
		WebElement Close = driver.findElement(By.xpath("//*[@id='list10']/span[3]")); 
		Close.click();
		Thread.sleep(3000);

		//driver.switchTo().frame(driver.findElement(By.name("iframe_3270 Display-A")));

		/*
		 * driver.switchTo().frame(1);
		 * 
		 * WebElement Restart =
		 * driver.findElement(By.xpath("//input[@name='HATS_restart']"));
		 * Restart.click(); logger.log(LogStatus.PASS,
		 * "<span style='color:green;'>Restart gets clicked to restart the session</span>"
		 * );
		 * 
		 * driver.switchTo().defaultContent();
		 */
	}

	public void MaximizeAndMinimize() throws InterruptedException  {
		logger.log(LogStatus.INFO, "<span class='label success'>MAXIMIZE AND MINIMIZE SESSION</span>");	
		WebElement Maximize = driver.findElement(By.id("fcr")); 
		Maximize.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Maximize icon gets clicked and the session is maximized</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "MaximizeSession")));
		WebElement Minimize = driver.findElement(By.xpath("//*[@id='fullscreen_navbar']/div/div[4]/a[2]/img")); //*[@id="fullscreen_navbar"]/div/div[4]/a[2]/img
		Minimize.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Minimize icon gets clicked and the session is Minimize</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "MinimizeSession")));
	}

	public void MaximizeScreen() throws InterruptedException {
		Thread.sleep(2000);
		WebElement maxmize = driver.findElement(By.xpath("//*[@id=\"fcr\"]/img"));
        maxmize.click();
        logger.log(LogStatus.PASS, "<span style='color:green;'>Maximize icon gets clicked and the session is maximized</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "MaximizeSession")));
               
  }
	
	public void ClickExpandIcon() throws InterruptedException {
		WebElement ExpandIcon = driver.findElement(By.xpath("//*[@id='smallNavBar']/div/div[3]/a[3]/img")); 
		ExpandIcon.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Navigation bar icon gets clicked and expanded</span>");
	}

	public void VerifyMacro() throws InterruptedException {

		logger.log(LogStatus.INFO, "<span class='label success'>MACRO VERIFICATION</span>");	

		WebElement MacroIcon = driver.findElement(By.id("macro")); 
		MacroIcon.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro icon gets clicked</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Macros")));

		WebElement SessionMacTab = driver.findElement(By.id("sessionMac_Tab")); 
		SessionMacTab.click();
		String SessionMacro = SessionMacTab.getText();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Session Macro tab gets clicked and verified</span>");

		WebElement SharedMacTab = driver.findElement(By.id("shared_Macro")); 
		SharedMacTab.click();
		String SharedMacro = SharedMacTab.getText();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Shared Macro tab gets clicked and verified</span>");


		WebElement LocalMacTab = driver.findElement(By.id("local_Macro")); 
		LocalMacTab.click();
		String LocalMacro = LocalMacTab.getText();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>local Macro tab gets clicked and verified</span>");

		SessionMacTab.click();

		WebElement CloseMacro = driver.findElement(By.xpath("//*[@id='sessionMacro']/button")); 
		CloseMacro.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Macro window gets closed</span>");

	}

	public void LanuchMaxSessions() throws InterruptedException{

		logger.log(LogStatus.INFO, "<span class='label success'>MAXIMUM SESSION VERIFICATION</span>");	

		for(int i=0; i<=24; i++) {
			Thread.sleep(2000);
			WebElement CopySession = driver.findElement(By.id("copySession")); 	
			wait.until(ExpectedConditions.visibilityOf(CopySession));
			CopySession.click();
			Thread.sleep(2000); 
		}


		List<WebElement> SessionCount = driver.findElements(By.xpath("//*[@class='list-group-item p-0']"));
		int count = SessionCount.size();
		System.out.println("Count of Max Session: "+count);			

		logger.log(LogStatus.PASS, "<span style='color:green;'>Copy session icon gets clicked repeatedly to launch maximum sessions </span>");

		logger.log(LogStatus.PASS, "<span style='color:green;'>Session Error Window gets dispalyed </span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "SessionError")));				

		logger.log(LogStatus.PASS, "<span style='color:green;'>Total number of sessions launched is : </span>" + "<span class='label success'>26</span>");

		Thread.sleep(2000);
		WebElement CloseSessionError = driver.findElement(By.xpath("//*[@id='alertModal']/div/div/div[3]/button")); 	
		wait.until(ExpectedConditions.visibilityOf(CloseSessionError));
		CloseSessionError.click();

		logger.log(LogStatus.PASS, "<span style='color:green;'>Session Error Window gets closed </span>");				


		/*
		 * do { Thread.sleep(3000); WebElement CopySession =
		 * driver.findElement(By.id("copySession")); CopySession.click();
		 * Thread.sleep(3000); }while(MaxSession.isDisplayed());
		 */


	}

	public void LaunchAlternateSessions() throws InterruptedException {

		for (int i=0;i<=11;i++) {

			WebElement elementHomebtn=driver.findElement(By.id("homeImg"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(elementHomebtn)); 
			wait.until(ExpectedConditions.elementToBeClickable(elementHomebtn));
			elementHomebtn.click();

			WebElement elementSession=driver.findElement(By.id("sessionImg0"));
			wait.until(ExpectedConditions.visibilityOf(elementSession)); 
			wait.until(ExpectedConditions.elementToBeClickable(elementSession));
			elementSession.click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(elementHomebtn)); 
			wait.until(ExpectedConditions.elementToBeClickable(elementHomebtn));
			elementHomebtn.click();

			WebElement element50Session=driver.findElement(By.id("sessionImg1"));
			wait.until(ExpectedConditions.visibilityOf(element50Session)); 
			wait.until(ExpectedConditions.elementToBeClickable(element50Session));
			element50Session.click();

			if(driver.findElement(By.xpath("//*[@id='alertModal']/div/div/div[3]/button")).isDisplayed()) {
				break;
			}

		}

		Thread.sleep(2000);
		WebElement ExpandIcon = driver.findElement(By.xpath("//*[@id='smallNavBar']/div/div[3]/a[3]/img")); 
		ExpandIcon.click();
		Thread.sleep(8000);

		WebElement CopySession = driver.findElement(By.id("R_copysession")); 	
		wait.until(ExpectedConditions.visibilityOf(CopySession));
		Thread.sleep(8000);
		CopySession.click();
		Thread.sleep(2000);

		List<WebElement> SessionCount = driver.findElements(By.xpath("//*[@class='list-group-item p-0']"));
		int count = SessionCount.size();
		System.out.println("Count of Max Session: "+count);			

		logger.log(LogStatus.PASS, "<span style='color:green;'>Session Error Window gets dispalyed </span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "SessionError")));				

		logger.log(LogStatus.PASS, "<span style='color:green;'>Total number of sessions launched is : </span>" + "<span class='label success'>26</span>");

		Thread.sleep(2000);
		WebElement CloseSessionError = driver.findElement(By.xpath("//*[@id='alertModal']/div/div/div[3]/button")); 	
		wait.until(ExpectedConditions.visibilityOf(CloseSessionError));
		CloseSessionError.click();

		logger.log(LogStatus.PASS, "<span style='color:green;'>Session Error Window gets closed </span>");				


	}


	public void HACPEE_Text() {
		String PRN_Font = prop.getProperty("ProductName_Expected_Font");
		String PRN_Size = prop.getProperty("ProductName_Expected_Size");
		String PRN_Clr = prop.getProperty("ProductName_Expected_Colour");
		String PRN_Text = driver.findElement(By.xpath("*//p[@id='product_name']")).getCssValue("font");
		//System.out.println(PRN_Text);
		String PRN_Color = driver.findElement(By.xpath("*//p[@id='product_name']")).getCssValue("color");
		//System.out.println(PRN_Color);
		String[] PRN_RBG = PRN_Color.replace("rgba(", "").replace(")", "").split(",");
		int PRN_R = Integer.parseInt(PRN_RBG[0].trim());
		int PRN_G = Integer.parseInt(PRN_RBG[1].trim());
		int PRN_B = Integer.parseInt(PRN_RBG[2].trim());
		String hex_PRN = "#" + Integer.toHexString(PRN_R) + Integer.toHexString(PRN_G) + Integer.toHexString(PRN_B);
		//System.out.println(hex_PRN);
		if( PRN_Text.contains(PRN_Font) && (PRN_Text.contains(PRN_Size)) && (hex_PRN.contains(PRN_Clr))){
			System.out.println("Font"+PRN_Text+"Colour"+PRN_RBG);
			logger.log(LogStatus.PASS, "<span style='color:green;'>HACP EE Product Name Font style and Colour Matched :</span>" +PRN_Text+""+hex_PRN);
		}
		else {
			System.out.println("ERROR - Product Name HACP EE Extended Edition font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>HACP EE Product Name Font style and Colour MisMatched :</span>" +PRN_Text+""+hex_PRN);
		}

		//---------------------------------------------------------------------------------------------------------

	}
	public void HeaderColour() {
		/** Header color */
		String H_Clr = prop.getProperty("H_Expected_Colour");
		String Header_Color = driver.findElement(By.xpath("*//nav[@id='logobar']")).getCssValue("background-color"); 
		//System.out.println(BackGround_color);
		String[] H_RBG = Header_Color.replace("rgba(", "").replace(")", "").split(",");
		int H_R = Integer.parseInt(H_RBG[0].trim());
		int H_G = Integer.parseInt(H_RBG[1].trim());
		int H_B = Integer.parseInt(H_RBG[2].trim());
		String hex_H = "#" + Integer.toHexString(H_R) + Integer.toHexString(H_G) + Integer.toHexString(H_B);
		//System.out.println(hex_H);
		if((hex_H.contains(H_Clr))){
			System.out.println("Header Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Header Colour Matched :</span>" +hex_H);
		}
		else {
			System.out.println("ERROR - Header color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Header Colour MisMatched :</span>" +hex_H);
		}

		//------------------------------------------------------------------------------------------>
	}

	public void BAckgroundColour() {
		/** Background color */
		String BG_Clr = prop.getProperty("BG_Expected_Colour");
		String BackGround_color = driver.findElement(By.xpath("*//div[@id='login']")).getCssValue("background-color"); 
		//System.out.println(BackGround_color);
		String[] BG_RBG = BackGround_color.replace("rgba(", "").replace(")", "").split(",");
		int BG_R = Integer.parseInt(BG_RBG[0].trim());
		int BG_G = Integer.parseInt(BG_RBG[1].trim());
		int BG_B = Integer.parseInt(BG_RBG[2].trim());
		String hex_BG = "#" + Integer.toHexString(BG_R) + Integer.toHexString(BG_G) + Integer.toHexString(BG_B);
		if((hex_BG.contains(BG_Clr))){
			System.out.println("Background Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Background Colour Matched :</span>" +hex_BG);
		}
		else {
			System.out.println("ERROR - Background color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Background Colour MisMatched :</span>" +hex_BG);
		}
	}
	public void LoginPanelColour() {
		/** login Panel color */
		String LPB_Clr = prop.getProperty("LPB_Expected_color");
		String LoginPanelBG_Color = driver.findElement(By.xpath("*//div[@style='background-color: #ECECEC;']")).getCssValue("background-color"); 
		//System.out.println(BackGround_color);
		String[] LPB_RBG = LoginPanelBG_Color.replace("rgba(", "").replace(")", "").split(",");
		int LPB_R = Integer.parseInt(LPB_RBG[0].trim());
		int LPB_G = Integer.parseInt(LPB_RBG[1].trim());
		int LPB_B = Integer.parseInt(LPB_RBG[2].trim());
		String hex_LPB = "#" + Integer.toHexString(LPB_R) + Integer.toHexString(LPB_G) + Integer.toHexString(LPB_B);
		//        System.out.println(hex_LPB);
		if((hex_LPB.contains(LPB_Clr))){
			System.out.println("LoginPanel  Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Login Panel Colour Matched :</span>" +hex_LPB);
		}
		else {
			System.out.println("ERROR - LoginPanel color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Login Panel Colour MisMatched :</span>" +hex_LPB);
		}
	}

	public void Username() {
		String UN_Font = prop.getProperty("UserName_Expected_Font");
		String UN_Size = prop.getProperty("UserName_Expected_Size");
		String UN_Clr = prop.getProperty("UserName_Expected_Colour");
		WebElement UserName_Text = driver.findElement(By.xpath("*//label[@for='uname']"));
		String A_UN = UserName_Text.getAttribute("style");
		//System.out.println(A_UN);
		String UserName_color = driver.findElement(By.xpath("*//label[@for='uname']")).getCssValue("color");
		String[] UN_RBG = UserName_color.replace("rgba(", "").replace(")", "").split(",");
		int UN_R = Integer.parseInt(UN_RBG[0].trim());
		int UN_G = Integer.parseInt(UN_RBG[1].trim());
		int UN_B = Integer.parseInt(UN_RBG[2].trim());
		String hex_UN = "#" + Integer.toHexString(UN_R) + Integer.toHexString(UN_G) + Integer.toHexString(UN_B);
		//System.out.println(hex_UN);
		if( A_UN.contains(UN_Font) && (A_UN.contains(UN_Size)) && (hex_UN.contains(UN_Clr))){
			System.out.println("UserName font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Username font and Colour Matched :</span>" +A_UN+""+UN_Clr);
		}
		else {
			System.out.println("ERROR - UserName font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Username font and Colour MisMatched :</span>" +A_UN+""+UN_Clr);
		}
	}
	public void Password() {
		String PS_Font = prop.getProperty("Password_Expected_Font");
		String PS_Size = prop.getProperty("Password_Expected_Size");
		String PS_Clr = prop.getProperty("Password_Expected_Colour");
		WebElement Password_Text = driver.findElement(By.xpath("*//label[@for='pwd']"));
		String A_PWD = Password_Text.getAttribute("style");
		//System.out.println(A_PWD);
		String Password_color = driver.findElement(By.xpath("*//label[@for='pwd']")).getCssValue("color");
		String[] PWD_RBG = Password_color.replace("rgba(", "").replace(")", "").split(",");
		int PWD_R = Integer.parseInt(PWD_RBG[0].trim());
		int PWD_G = Integer.parseInt(PWD_RBG[1].trim());
		int PWD_B = Integer.parseInt(PWD_RBG[2].trim());
		String hex_PWD = "#" + Integer.toHexString(PWD_R) + Integer.toHexString(PWD_G) + Integer.toHexString(PWD_B);
		//System.out.println(hex_PWD);
		if( A_PWD.contains(PS_Font) && (A_PWD.contains(PS_Size)) && (hex_PWD.contains(PS_Clr))){
			System.out.println("Password font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Password Font and colour Matched :</span>" +A_PWD+""+hex_PWD);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Password Font and Colour MisMatched :</span>" +A_PWD+""+hex_PWD);
		}
		WebElement User = driver.findElement(By.id("uname"));
		User.sendKeys("admin");
		//Thread.sleep(5000);
		WebElement Pwd = driver.findElement(By.id("pwd"));
		Pwd.sendKeys("password");
		//Thread.sleep(5000);
	}
	public void inputfields() {
		String Inp_Clr = prop.getProperty("Input_Expected_Colour");
		String InputfieldBG_Color = driver.findElement(By.xpath("*//div[@style='background-color: #FFFFFF; border: none; border-bottom: 1px solid #4A4A4A; border-radius: 0px;']")).getCssValue("background-color"); 

		String[] if_RBG = InputfieldBG_Color.replace("rgba(", "").replace(")", "").split(",");
		int if_R = Integer.parseInt(if_RBG[0].trim());
		int if_G = Integer.parseInt(if_RBG[1].trim());
		int if_B = Integer.parseInt(if_RBG[2].trim());
		String hex_if = "#" + Integer.toHexString(if_R) + Integer.toHexString(if_G) + Integer.toHexString(if_B);
		//        System.out.println(hex_if);
		if((hex_if.contains(Inp_Clr))){
			System.out.println("Inputfield Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Input Field Colour Matched :</span>" +hex_if);
		}
		else {
			System.out.println("ERROR - Input field color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Input Field Colour MisMatched :</span>" +hex_if);
		}
	}
	public void Remberme() {
		String RM_Font = prop.getProperty("RM_Expected_Font");
		String RM_Size = prop.getProperty("RM_Expected_Size");
		String RM_Clr = prop.getProperty("RM_Expected_Colour");
		WebElement RM_Text = driver.findElement(By.xpath("*//label[@class='checkboxcontainer']"));
		String A_RM = RM_Text.getAttribute("style");
		//System.out.println(A_RM);
		String RM_color = driver.findElement(By.xpath("*//label[@class='checkboxcontainer']")).getCssValue("color");
		String[] RM_RBG = RM_color.replace("rgba(", "").replace(")", "").split(",");
		int RM_R = Integer.parseInt(RM_RBG[0].trim());
		int RM_G = Integer.parseInt(RM_RBG[1].trim());
		int RM_B = Integer.parseInt(RM_RBG[2].trim());
		String hex_RM = "#" + Integer.toHexString(RM_R) + Integer.toHexString(RM_G) + Integer.toHexString(RM_B);
		//System.out.println(hex_RM);

		if( A_RM.contains(RM_Font) && (A_RM.contains(RM_Size)) && (hex_RM.contains(RM_Clr))){
			System.out.println("Remember Me font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>RememberMe Font and Colour Matched :</span>" +A_RM+""+hex_RM);
		}
		else {
			System.out.println("ERROR - Remember Me font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>RememberMe Font and Colour MisMatched :</span>" +A_RM+""+hex_RM);
		}
	}
	public void LoginText() throws InterruptedException {
		String L_Font = prop.getProperty("Login_Expected_Font");
		String L_Size = prop.getProperty("Login_Expected_Size");
		String L_Clr = prop.getProperty("Login_Expected_Colour");
		String LB_Clr = prop.getProperty("LB_Expected_color");
		String Login_Size = driver.findElement(By.xpath("*//button[@id='login_button']")).getCssValue("font-size");
		String Login_Style = driver.findElement(By.xpath("*//button[@id='login_button']")).getCssValue("font-family");
		//System.out.println(Login_Size);
		//System.out.println(Login_Style);
		String Login_color = driver.findElement(By.xpath("*//button[@id='login_button']")).getCssValue("color");
		String[] L_RBG = Login_color.replace("rgba(", "").replace(")", "").split(",");
		int L_R = Integer.parseInt(L_RBG[0].trim());
		int L_G = Integer.parseInt(L_RBG[1].trim());
		int L_B = Integer.parseInt(L_RBG[2].trim());
		String hex_L = "#" + Integer.toHexString(L_R) + Integer.toHexString(L_G) + Integer.toHexString(L_B);
		//System.out.println(hex_L);
		String LoginBtn_Color = driver.findElement(By.xpath("*//button[@id='login_button']")).getCssValue("background-color"); 
		String[] LB_RBG = LoginBtn_Color.replace("rgba(", "").replace(")", "").split(",");
		int LB_R = Integer.parseInt(LB_RBG[0].trim());
		int LB_G = Integer.parseInt(LB_RBG[1].trim());
		int LB_B = Integer.parseInt(LB_RBG[2].trim());
		String hex_LB = "#" + Integer.toHexString(LB_R) + Integer.toHexString(LB_G) + Integer.toHexString(LB_B);
		//System.out.println(hex_LB);
		if( Login_Style.contains(L_Font) && (Login_Size.contains(L_Size)) && (hex_L.contains(L_Clr))){
			System.out.println("Login Button font style, size and color - Status 'passed'");
		}
		else {
			System.out.println("ERROR - Login Button font style, size and color - Status 'Failed'");
		}
		if((hex_LB.contains(LB_Clr))){
			System.out.println("LoginButton  Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Login Font and Colour Matched :</span>" +Login_Size+""+Login_Style+""+hex_LB);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Login Font and Colour MisMatched :</span>" +Login_Size+""+Login_Style+""+hex_LB);
		}
		WebElement LoginButton = driver.findElement(By.id("login_button"));
		LoginButton.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Login - Connected</span>"+ logger.addScreenCapture( Common.CaptureScreenShot(driver, "SessionError")));
		WebElement logoutButton = driver.findElement(By.id("logoutbutton"));
		logoutButton.click();
	}
	public void Continueasguests() throws InterruptedException {
		String CAG_Font = prop.getProperty("CAG_Expected_Font");
		String CAG_Size = prop.getProperty("CAG_Expected_Size");
		String CAG_Clr = prop.getProperty("CAG_Expected_Colour");
		String CAG_Text = driver.findElement(By.xpath("*//a[@id='quickLink']")).getCssValue("font");
		System.out.println(CAG_Text);
		String CAG_color = driver.findElement(By.xpath("*//a[@id='quickLink']")).getCssValue("color");
		String[] CAG_RBG = CAG_color.replace("rgba(", "").replace(")", "").split(",");
		int CAG_R = Integer.parseInt(CAG_RBG[0].trim());
		int CAG_G = Integer.parseInt(CAG_RBG[1].trim());
		int CAG_B = Integer.parseInt(CAG_RBG[2].trim());
		String hex_CAG = "#" + Integer.toHexString(CAG_R) + Integer.toHexString(CAG_G) + Integer.toHexString(CAG_B);
		//System.out.println(hex_CAG);
		if( CAG_Text.contains(CAG_Font) && (CAG_Text.contains(CAG_Size)) && (hex_CAG.contains(CAG_Clr))){
			System.out.println("Continue As Guest font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Continue As Guest Font and Colour Matched :</span>" +CAG_Text+""+hex_CAG);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Continue As Guest Font and Colour MisMatched :</span>" +CAG_Text+""+hex_CAG);
		}
		WebElement QC_Button = driver.findElement(By.id("quickLink"));
		QC_Button.click();
		logger.log(LogStatus.PASS, "<span style='color:green;'>Guest Connect :</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Continue as Guest")));
	}
	public void Copyright() {
		String CRT_Font = prop.getProperty("CRT_Expected_Font");
		String CRT_Size = prop.getProperty("CRT_Expected_Size");
		String CRT_Clr = prop.getProperty("CRT_Expected_Colour");
		WebElement CRT_Text = driver.findElement(By.xpath("*//span[@style='font-size: 10px; font-family: Roboto Light; color: #717171;']"));
		String A_CRT = CRT_Text.getAttribute("style");
		//System.out.println(A_CAG);
		String CRT_color = driver.findElement(By.xpath("*//span[@style='font-size: 10px; font-family: Roboto Light; color: #717171;']")).getCssValue("color");
		String[] CRT_RBG = CRT_color.replace("rgba(", "").replace(")", "").split(",");
		int CRT_R = Integer.parseInt(CRT_RBG[0].trim());
		int CRT_G = Integer.parseInt(CRT_RBG[1].trim());
		int CRT_B = Integer.parseInt(CRT_RBG[2].trim());
		String hex_CRT = "#" + Integer.toHexString(CRT_R) + Integer.toHexString(CRT_G) + Integer.toHexString(CRT_B);
		//System.out.println(hex_CRT);
		if( A_CRT.contains(CRT_Font) && (A_CRT.contains(CRT_Size)) && (hex_CRT.contains(CRT_Clr))){
			System.out.println("Copyright font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Copyright Font and Colour Matched :</span>" +A_CRT+""+hex_CRT);
		}
		else {
			System.out.println("ERROR - Copyright font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Copyright Font and Colour MisMatched :</span>" +A_CRT+""+hex_CRT);
		}
	}
	public void Errormessgae() throws InterruptedException {
		WebElement E_User = driver.findElement(By.id("uname"));
		E_User.sendKeys("Nivetha");
		//Thread.sleep(5000);
		WebElement E_Pwd = driver.findElement(By.id("pwd"));
		E_Pwd.sendKeys("143");
		//Thread.sleep(5000);
		WebElement E_LoginButton = driver.findElement(By.id("login_button"));
		E_LoginButton.click();
		//Thread.sleep(5000);

		String ERM_Font = prop.getProperty("ERM_Expected_Font");
		String ERM_Size = prop.getProperty("ERM_Expected_Size");
		String ERM_Clr = prop.getProperty("ERM_Expected_Colour");
		WebElement ERR_Text = driver.findElement(By.xpath("*//span[@id='errorMessage']"));
		String A_ERR = ERR_Text.getAttribute("style");
		//System.out.println(A_ERR);
		String ERM_color = driver.findElement(By.xpath("*//span[@id='errorMessage']")).getCssValue("color");
		String[] ERM_RBG = ERM_color.replace("rgba(", "").replace(")", "").split(",");
		int ERM_R = Integer.parseInt(ERM_RBG[0].trim());
		int ERM_G = Integer.parseInt(ERM_RBG[1].trim());
		int ERM_B = Integer.parseInt(ERM_RBG[2].trim());
		String hex_ERM = "#" + Integer.toHexString(ERM_R) + Integer.toHexString(ERM_G) + Integer.toHexString(ERM_B);
		//System.out.println(hex_ERM);
		if( A_ERR.contains(ERM_Font) && (A_ERR.contains(ERM_Size)) && (hex_ERM.contains(ERM_Clr))){
			System.out.println("Error Message font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Error Message Font and Colour Matched :</span>" +A_ERR+""+hex_ERM + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Error Message")));
		}
		else {
			System.out.println("ERROR - Error Message font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Error Message Font and Colour Matched :</span>" +A_ERR+""+hex_ERM + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Error Message")));
		}
	}
	public void GuestConnect() {
		String QG_Clr = prop.getProperty("QG_Expected_Colour");
		String QG_Color = driver.findElement(By.xpath("*//body[@onload ='sendRequest();onload();']")).getCssValue("background-color"); 
		String[] QG_RBG = QG_Color.replace("rgba(", "").replace(")", "").split(",");
		int QG_R = Integer.parseInt(QG_RBG[0].trim());
		int QG_G = Integer.parseInt(QG_RBG[1].trim());
		int QG_B = Integer.parseInt(QG_RBG[2].trim());
		String hex_QG = "#" + Integer.toHexString(QG_R) + Integer.toHexString(QG_G) + Integer.toHexString(QG_B);
		//        System.out.println(hex_if);
		if((hex_QG.contains(QG_Clr))){
			System.out.println("QuickConnect Background Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Guest Connect Colour Matched :</span>" +hex_QG);
		}
		else {
			System.out.println("QuickConnect - Background color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Guest Connect Colour MisMatched :</span>" +hex_QG);
		}
	}
	public void GuestConnectTitle() {
		String GC_Font = prop.getProperty("GC_Expected_Font");
		String GC_Size = prop.getProperty("GC_Expected_Size");
		String GC_Clr = prop.getProperty("GC_Expected_Colour");
		WebElement GC_Text = driver.findElement(By.xpath("*//span[@style='font-size: 24px; color: #4A4A4A; font-family: Roboto Regular;']"));
		String A_GC = GC_Text.getAttribute("style");
		String GC_color = driver.findElement(By.xpath("*//span[@style='font-size: 24px; color: #4A4A4A; font-family: Roboto Regular;']")).getCssValue("color");
		String[] GC_RBG = GC_color.replace("rgba(", "").replace(")", "").split(",");
		int GC_R = Integer.parseInt(GC_RBG[0].trim());
		int GC_G = Integer.parseInt(GC_RBG[1].trim());
		int GC_B = Integer.parseInt(GC_RBG[2].trim());
		String hex_GC = "#" + Integer.toHexString(GC_R) + Integer.toHexString(GC_G) + Integer.toHexString(GC_B);
		if( A_GC.contains(GC_Font) && (A_GC.contains(GC_Size)) && (hex_GC.contains(GC_Clr))){
			System.out.println("Guest_Connect font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Guest Connect Title font and Colour Matched :</span>" +A_GC+""+hex_GC);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Guest Connect Title font and Colour MisMatched :</span>" +A_GC+""+hex_GC);
		}
	}
	public void GuestConnectHeading() {
		String CH_Font = prop.getProperty("GC_Expected_Font");
		String CH_Size = prop.getProperty("GC_Expected_Size");
		String CH_Clr = prop.getProperty("GC_Expected_Colour");
		WebElement CH_Text = driver.findElement(By.xpath("*//span[@style='font-size: 24px; color: #4A4A4A; font-family: Roboto Regular;']"));
		String A_CH = CH_Text.getAttribute("style");
		String CH_color = driver.findElement(By.xpath("*//span[@style='font-size: 24px; color: #4A4A4A; font-family: Roboto Regular;']")).getCssValue("color");
		String[] CH_RBG = CH_color.replace("rgba(", "").replace(")", "").split(",");
		int CH_R = Integer.parseInt(CH_RBG[0].trim());
		int CH_G = Integer.parseInt(CH_RBG[1].trim());
		int CH_B = Integer.parseInt(CH_RBG[2].trim());
		String hex_CH = "#" + Integer.toHexString(CH_R) + Integer.toHexString(CH_G) + Integer.toHexString(CH_B);
		if( A_CH.contains(CH_Font) && (A_CH.contains(CH_Size)) && (hex_CH.contains(CH_Clr))){
			System.out.println("Guest_Connect Heading font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Guest Connect Heading font and Colour Matched :</span>" +A_CH+""+hex_CH);
		}
		else {
			System.out.println("ERROR - Guest_Connect Heading font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Guest Connect Heading font and Colour MisMatched :</span>" +A_CH+""+hex_CH);
		}
	}
	public void GuestConnectSubHeading() throws InterruptedException {
		Thread.sleep(3000);
		String SB_Font = prop.getProperty("Sub_Expected_Font");
		String SB_Size = prop.getProperty("Sub_Expected_Size");
		String SB_Clr = prop.getProperty("Sub_Expected_Colour");
		WebElement SB_Text = driver.findElement(By.xpath("*//div[contains(text(),'Quickly connect to the session')]")); //div[@style='margin-top: 5%; border: 1px solid #4A4A4A;font:15px Roboto Regular']"));
		String A_SB = SB_Text.getAttribute("style");
		String SB_color = driver.findElement(By.xpath("*//div[@style='margin-top: 5%; border: 1px solid #4A4A4A;font:15px Roboto Regular']")).getCssValue("color");
		String[] SB_RBG = SB_color.replace("rgba(", "").replace(")", "").split(",");
		int SB_R = Integer.parseInt(SB_RBG[0].trim());
		int SB_G = Integer.parseInt(SB_RBG[1].trim());
		int SB_B = Integer.parseInt(SB_RBG[2].trim());
		String hex_SB = "#" + Integer.toHexString(SB_R) + Integer.toHexString(SB_G) + Integer.toHexString(SB_B);
		if( A_SB.contains(SB_Font) && (A_SB.contains(SB_Size)) && (hex_SB.contains(SB_Clr))){
			System.out.println("Guest_Connect Sub-Heading. font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Guest Connect Sub Heading font and Colour Matched :</span>" +A_SB+""+hex_SB);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:green;'>Guest Connect Sub Heading font and Colour MisMatched :</span>" +A_SB+""+hex_SB);
		}
	}
	public void FieldDisable() {
		String FD_Clr = prop.getProperty("Field_Disable_Colour");
		String FD_color = driver.findElement(By.xpath("*//input[@disabled='disabled']")).getCssValue("background-color");
		String[] FD_RBG = FD_color.replace("rgba(", "").replace(")", "").split(",");
		int FD_R = Integer.parseInt(FD_RBG[0].trim());
		int FD_G = Integer.parseInt(FD_RBG[1].trim());
		int FD_B = Integer.parseInt(FD_RBG[2].trim());
		String hex_FD = "#" + Integer.toHexString(FD_R) + Integer.toHexString(FD_G) + Integer.toHexString(FD_B);
		if( hex_FD.contains(FD_Clr)) {
			System.out.println("Field Disable font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Field Disable Background Colour Matched :</span>" +hex_FD);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Field Disable Background Colour MisMatched :</span>" +hex_FD);
		}
	}
	public void InputField() {
		String IF_Clr = prop.getProperty("Input_Colour");
		String IF_color = driver.findElement(By.xpath("*//input[@autocomplete='off']")).getCssValue("background-color");
		String[] IF_RBG = IF_color.replace("rgba(", "").replace(")", "").split(",");
		int IF_R = Integer.parseInt(IF_RBG[0].trim());
		int IF_G = Integer.parseInt(IF_RBG[1].trim());
		int IF_B = Integer.parseInt(IF_RBG[2].trim());
		String hex_IF = "#" + Integer.toHexString(IF_R) + Integer.toHexString(IF_G) + Integer.toHexString(IF_B);
		if( hex_IF.contains(IF_Clr)) {
			System.out.println("Input_Expected_Colour font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Input Field Background Colour Matched :</span>" +hex_IF);
		}
		else {
			System.out.println("ERROR - Input_Expected_Colour font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Input Field Background Colour MisMatched :</span>" +hex_IF);
		}
	}
	public void Connect() throws InterruptedException {
		String CB_Font = prop.getProperty("Connect_Expected_Font");
		String CB_Size = prop.getProperty("Connect_Expected_Size");
		String CB_Clr = prop.getProperty("Connect_Expected_Colour");
		String CBG_Clr = prop.getProperty("CB_Colour");
		String CB_F = driver.findElement(By.xpath("*//button[@id='submit_quick']")).getCssValue("font-family");
		String CB_S = driver.findElement(By.xpath("*//button[@id='submit_quick']")).getCssValue("font-size");
		String CB_color = driver.findElement(By.xpath("*//button[@id='submit_quick']")).getCssValue("color");
		String CBG_color = driver.findElement(By.xpath("*//button[@id='submit_quick']")).getCssValue("background-color");
		String[] CB_RBG = CB_color.replace("rgba(", "").replace(")", "").split(",");
		int CB_R = Integer.parseInt(CB_RBG[0].trim());
		int CB_G = Integer.parseInt(CB_RBG[1].trim());
		int CB_B = Integer.parseInt(CB_RBG[2].trim());
		String hex_CB = "#" + Integer.toHexString(CB_R) + Integer.toHexString(CB_G) + Integer.toHexString(CB_B);
		String[] CBG_RBG = CBG_color.replace("rgba(", "").replace(")", "").split(",");
		int CBG_R = Integer.parseInt(CBG_RBG[0].trim());
		int CBG_G = Integer.parseInt(CBG_RBG[1].trim());
		int CBG_B = Integer.parseInt(CBG_RBG[2].trim());
		String hex_CBG = "#" + Integer.toHexString(CBG_R) + Integer.toHexString(CBG_G) + Integer.toHexString(CBG_B);
		if( CB_F.contains(CB_Font) && (CB_S.contains(CB_Size)) && (hex_CB.contains(CB_Clr))){
			System.out.println("Connect Button font style, size and color - Status 'passed'");
		}
		else {
			System.out.println("ERROR - Connect Button font style, size and color - Status 'Failed'");
		}
		if((hex_CBG.contains(CBG_Clr))){
			System.out.println("Connect Button Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Connect Font, Colour Matched :</span>" +CB_F+""+CB_S+""+hex_CB);
			logger.log(LogStatus.PASS, "<span style='color:green;'>Connect Button Colour Matched :</span>" +hex_CBG);
		}
		else {
			System.out.println("Connect Button - Color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Connect Font, Colour MisMatched :</span>" +CB_F+""+CB_S+""+hex_CB);
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Connect Button Colour MisMatched :</span>" +hex_CBG);
		}
		WebElement GC_DA = driver.findElement(By.id("invalidDestination"));
		GC_DA.sendKeys("10.134.71.156");
		Thread.sleep(3000);
		WebElement GC_Connect = driver.findElement(By.id("submit_quick"));
		GC_Connect.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>Session gets Connected Sucessfully :</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Session Connected")));


		WebElement GC_Close = driver.findElement(By.id("closeSess"));
		GC_Close.click();
	}
	public void Activesession() throws InterruptedException {
		String HURL = prop.getProperty("HtmlPageurl");
		driver.get(HURL);
		logger.log(LogStatus.PASS, "<span style='color:green;'>HACP EE HTML/Combined Page Launched Sucessfully :</span>" + logger.addScreenCapture( Common.CaptureScreenShot(driver, "Dashbaord")));
		String AS_Font = prop.getProperty("ActiveSessions_Expected_Font");
		String AS_Size = prop.getProperty("ActiveSessions_Expected_Size");
		String AS_Clr = prop.getProperty("ActiveSessions_Expected_Colour");
		WebElement ActiveSessions_Text = driver.findElement(By.xpath("*//span[@style='float: left; margin-top: 10px; font: 22px Roboto regular;']"));
		String A_AS = ActiveSessions_Text.getAttribute("style");
		//System.out.println(A_AS);
		String ActiveSessions_color = driver.findElement(By.xpath("*//span[@style='float: left; margin-top: 10px; font: 22px Roboto regular;']")).getCssValue("color");
		String[] AS_RBG = ActiveSessions_color.replace("rgba(", "").replace(")", "").split(",");
		int AS_R = Integer.parseInt(AS_RBG[0].trim());
		int AS_G = Integer.parseInt(AS_RBG[1].trim());
		int AS_B = Integer.parseInt(AS_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_AS = "#" + Integer.toHexString(AS_R) + Integer.toHexString(AS_G) + Integer.toHexString(AS_B);
		//System.out.println(hex_AS);
		if( A_AS.contains(AS_Font) && (A_AS.contains(AS_Size)) && (hex_AS.contains(AS_Clr))){
			System.out.println("Active session font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Active Session Font and Colour Matched :</span>" +A_AS+""+hex_AS);
		}
		else {
			System.out.println("ERROR - Active session font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Active Session Font and Colour MisMatched :</span>" +A_AS+""+hex_AS);
		}
	}
	public void AvailableSession() {
		String VS_Font = prop.getProperty("AvailableSessions_Expected_Font");
		String VS_Size = prop.getProperty("AvailableSessions_Expected_Size");
		String VS_Clr = prop.getProperty("AvailableSessions_Expected_Colour");
		WebElement AvailableSessions_Text = driver.findElement(By.xpath("*//span[@style='float: left; margin-top: 10px; font: 22px Roboto regular;']"));
		String A_A = AvailableSessions_Text.getAttribute("style");
		//System.out.println(A_A);
		String AvailableSessions_color = driver.findElement(By.xpath("*//span[@style='float: left; margin-top: 10px; font: 22px Roboto regular;']")).getCssValue("color");
		String[] A_RBG = AvailableSessions_color.replace("rgba(", "").replace(")", "").split(",");
		int A_R = Integer.parseInt(A_RBG[0].trim());
		int A_G = Integer.parseInt(A_RBG[1].trim());
		int A_B = Integer.parseInt(A_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_A = "#" + Integer.toHexString(A_R) + Integer.toHexString(A_G) + Integer.toHexString(A_B);
		//System.out.println(hex_A);
		if( A_A.contains(VS_Font) && (A_A.contains(VS_Size)) && (hex_A.contains(VS_Clr))){
			System.out.println("Available session font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Available Session Font and Colour Matched :</span>" +A_A+""+hex_A);
		}
		else {
			System.out.println("ERROR - Available session font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Available Session Font and Colour MisMatched :</span>" +A_A+""+hex_A);
		}
	}
	public void SessionName() {
		String SN_Font = prop.getProperty("SessionName_Expected_Font");
		String SN_Size = prop.getProperty("SessionName_Expected_Size");
		String SN_Clr = prop.getProperty("SessionName_Expected_Colour");
		WebElement SessionName_Text = driver.findElement(By.xpath("*//span[@style='font:14px Roboto Regular;']"));
		String A_SN = SessionName_Text.getAttribute("style");
		//System.out.println(A_SN);
		String SessionName_color = driver.findElement(By.xpath("*//span[@style='font:14px Roboto Regular;']")).getCssValue("color");
		String[] SN_RBG = SessionName_color.replace("rgba(", "").replace(")", "").split(",");
		int SN_R = Integer.parseInt(SN_RBG[0].trim());
		int SN_G = Integer.parseInt(SN_RBG[1].trim());
		int SN_B = Integer.parseInt(SN_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_SN = "#" + Integer.toHexString(SN_R) + Integer.toHexString(SN_G) + Integer.toHexString(SN_B);
		//System.out.println(hex_SN);
		if( A_SN.contains(SN_Font) && (A_SN.contains(SN_Size)) && (hex_SN.contains(SN_Clr))){
			System.out.println("SessionName font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Session Name Font and Colour Matched :</span>" +A_SN+""+hex_SN);
		}
		else {
			System.out.println("ERROR - SessionName font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Session Name Font and Colour MisMatched :</span>" +A_SN+""+hex_SN);
		}
	}
	public void searchbar() throws InterruptedException {
		String SBC_Clr = prop.getProperty("Search_Expected_Colour");
		String SearchbarBG_Color = driver.findElement(By.xpath("*//div[@style='background-color: #ffffff !important; border: none; border-bottom: 1px solid #4A4A4A; border-radius: 0px;']")).getCssValue("background-color"); 

		String[] search_RBG = SearchbarBG_Color.replace("rgba(", "").replace(")", "").split(",");
		int search_R = Integer.parseInt(search_RBG[0].trim());
		int search_G = Integer.parseInt(search_RBG[1].trim());
		int search_B = Integer.parseInt(search_RBG[2].trim());
		String hex_search = "#" + Integer.toHexString(search_R) + Integer.toHexString(search_G) + Integer.toHexString(search_B);
		//		        System.out.println(hex_search);
		if((hex_search.contains(SBC_Clr))){
			System.out.println("Searchbar Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Searchbar Background Colour Matched :</span>" +hex_search);
		}
		else {
			System.out.println("ERROR - Searchbar color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Searchbar Background Colour MisMatched :</span>" +hex_search);
		}
		WebElement About = driver.findElement(By.id("about"));
		About.click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Launched Sucessfully :</span>" +logger.addScreenCapture( Common.CaptureScreenShot(driver, "About Panel")));
	}
	public void AboutFooterClr() {
		String AF_Clr = prop.getProperty("AboutFooter_Expected_Colour");
		String helpcontentfooter_Color = driver.findElement(By.xpath("*//div[@class='modal-footer']")).getCssValue("background-color"); 

		String[] hfoot_RBG = helpcontentfooter_Color.replace("rgba(", "").replace(")", "").split(",");
		int hfoot_R = Integer.parseInt(hfoot_RBG[0].trim());
		int hfoot_G = Integer.parseInt(hfoot_RBG[1].trim());
		int hfoot_B = Integer.parseInt(hfoot_RBG[2].trim());
		String hex_hfoot = "#" + Integer.toHexString(hfoot_R) + Integer.toHexString(hfoot_G) + Integer.toHexString(hfoot_B);
		//        System.out.println(hex_hfoot);
		if((hex_hfoot.contains(AF_Clr))){
			System.out.println("About footer Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Footer Background Colour Matched :</span>" +hex_hfoot);
		}
		else {
			System.out.println("ERROR - about footer color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>About Panel Footer Background Colour MisMatched :</span>" +hex_hfoot);
		}
	}
	public void AboutPanelHeaderClr() {
		String AH_Clr = prop.getProperty("AboutHeader_Expected_Colour");
		String helpcontentheader_Color = driver.findElement(By.xpath("*//div[@style='padding: 30px; background-color: #FFFFFF;']")).getCssValue("background-color"); 
		String[] help_RBG = helpcontentheader_Color.replace("rgba(", "").replace(")", "").split(",");
		int help_R = Integer.parseInt(help_RBG[0].trim());
		int help_G = Integer.parseInt(help_RBG[1].trim());
		int help_B = Integer.parseInt(help_RBG[2].trim());
		String hex_help = "#" + Integer.toHexString(help_R) + Integer.toHexString(help_G) + Integer.toHexString(help_B);
		//        System.out.println(hex_help);
		if((hex_help.contains(AH_Clr))){
			System.out.println("aboutcontentheader Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Header Background Colour Matched :</span>" +hex_help);
		}
		else {
			System.out.println("ERROR - aboutcontentheader color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>About Panel Header Background Colour Matched :</span>" +hex_help);
		}
	}
	public void AboutPanelHeading() {
		String AHH_Font = prop.getProperty("AboutHeading_Font");
		String AHH_Size = prop.getProperty("AboutHeading_Size");
		String AHH_Clr = prop.getProperty("AboutHeading_Colour");
		String AHH_Text = driver.findElement(By.xpath("*//span[@class='aboutpanel']")).getCssValue("font");
		String AHH_Colour = driver.findElement(By.xpath("*//span[@class='aboutpanel']")).getCssValue("color");
		String[] AHH_RBG = AHH_Colour.replace("rgba(", "").replace(")", "").split(",");
		int AHH_R = Integer.parseInt(AHH_RBG[0].trim());
		int AHH_G = Integer.parseInt(AHH_RBG[1].trim());
		int AHH_B = Integer.parseInt(AHH_RBG[2].trim());
		String hex_AHH = "#" + Integer.toHexString(AHH_R) + Integer.toHexString(AHH_G) + Integer.toHexString(AHH_B);
		if( AHH_Text.contains(AHH_Font) && (AHH_Text.contains(AHH_Size)) && (hex_AHH.contains(AHH_Clr))){
			System.out.println("About Heading font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Heading Font and Colour Matched :</span>" +AHH_Text+""+hex_AHH);
		}
		else {
			System.out.println("ERROR - About Heading font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>About Panel Heading Font and Colour Colour MisMatched :</span>" +AHH_Text+""+hex_AHH);
		}
	}
	public void AboutPanelContent() {
		String ACH_Font = prop.getProperty("AboutContentDetails_Font");
		String ACH_Size = prop.getProperty("AboutContentDetails_Size");
		String ACH_Clr = prop.getProperty("AboutContentDetails_Colour");
		String ACH_Text = driver.findElement(By.xpath("*//span[@class='version_detail']")).getCssValue("font");
		String ACH_Colour = driver.findElement(By.xpath("*//span[@class='version_detail']")).getCssValue("color");
		String[] ACH_RBG = ACH_Colour.replace("rgba(", "").replace(")", "").split(",");
		int ACH_R = Integer.parseInt(ACH_RBG[0].trim());
		int ACH_G = Integer.parseInt(ACH_RBG[1].trim());
		int ACH_B = Integer.parseInt(ACH_RBG[2].trim());
		String hex_ACH = "#" + Integer.toHexString(ACH_R) + Integer.toHexString(ACH_G) + Integer.toHexString(ACH_B);
		if( ACH_Text.contains(ACH_Font) && (ACH_Text.contains(ACH_Size)) && (hex_ACH.contains(ACH_Clr))){
			System.out.println("About Content font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Content Font and Colour Matched :</span>" +ACH_Text+""+hex_ACH);
		}
		else {
			System.out.println("ERROR - About Content font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>About Panel Content Font and Colour MisMatched :</span>" +ACH_Text+""+hex_ACH);
		}
	}
	public void AboutPanelCancel() throws InterruptedException {
		String AC_Clr = prop.getProperty("AboutClose_Expected_Colour");
		String helpclose_Color = driver.findElement(By.xpath("*//button[@id='about-close']")).getCssValue("background-color"); 
		
		String[] hc_RBG = helpclose_Color.replace("rgba(", "").replace(")", "").split(",");
		int hc_R = Integer.parseInt(hc_RBG[0].trim());
		int hc_G = Integer.parseInt(hc_RBG[1].trim());
		int hc_B = Integer.parseInt(hc_RBG[2].trim());
		String hex_hc = "#" + Integer.toHexString(hc_R) + Integer.toHexString(hc_G) + Integer.toHexString(hc_B);
//      System.out.println(hex_hc);
		if((hex_hc.contains(AC_Clr))){
			System.out.println("aboutClose button Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>About Panel Close Background Colour Matched :</span>" +hex_hc);
		}
		else {
			System.out.println("ERROR - aboutClose Button  color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>About Panel Close Background Colour MisMatched :</span>" +hex_hc);
		}
		WebElement Close = driver.findElement(By.xpath("//*[@id='about-close']"));
        Close.click();
        Thread.sleep(5000);
	}
	public void PropertPanelHeading() throws InterruptedException {
		String HURL = prop.getProperty("CombinedBasedModel");
		driver.get(HURL);
		Thread.sleep(1000);

		driver.findElement(By.id("menubutton0")).click();

		driver.findElement(By.xpath("//*[contains(text(),'Properties...')]")).click();
		Thread.sleep(1000);
		//PropertyPanelHeadling 
		String PHH_Font = prop.getProperty("PropertyHeading_Expected_Font");
		String PHH_Size = prop.getProperty("PropertyHeading_Expected_Size");
		String PHH_Clr = prop.getProperty("PropertyHeading_Expected_Colour");
		WebElement PPH_Text = driver.findElement(By.xpath("*//span[@id='myModalLabel']"));
		String A_PPH = PPH_Text.getAttribute("style");
		//System.out.println(A_PPH);
		String PPH_color = driver.findElement(By.xpath("*//span[@id='myModalLabel']")).getCssValue("color");
		String[] PPH_RBG = PPH_color.replace("rgba(", "").replace(")", "").split(",");
		int PPH_R = Integer.parseInt(PPH_RBG[0].trim());
		int PPH_G = Integer.parseInt(PPH_RBG[1].trim());
		int PPH_B = Integer.parseInt(PPH_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_PPH = "#" + Integer.toHexString(PPH_R) + Integer.toHexString(PPH_G) + Integer.toHexString(PPH_B);
		//System.out.println(hex_PPH);
		if( A_PPH.contains(PHH_Font) && (A_PPH.contains(PHH_Size)) && (hex_PPH.contains(PHH_Clr))){
			System.out.println("Property Heading font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>PropertyPanel Heading Font and Colour Matched :</span>" +A_PPH+""+hex_PPH +logger.addScreenCapture( Common.CaptureScreenShot(driver, "Property Panel")));
		}
		else {
			System.out.println("ERROR - Property Heading font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>PropertyPanel Heading Font and Colour MisMatched :</span>" +A_PPH+""+hex_PPH +logger.addScreenCapture( Common.CaptureScreenShot(driver, "Property Panel")));
		}
	}
	public void CurrentPanel() {
		String CP_Font = prop.getProperty("CurrentTab_Expected_Font");
		String CP_Size = prop.getProperty("CurrentTab_Expected_Size");
		String CP_Clr = prop.getProperty("CurrentTab_Expected_Colour");
		String CP_Text = driver.findElement(By.xpath("*//a[@class='masterProperty_tab active']")).getCssValue("font");
		String CP_color = driver.findElement(By.xpath("*//a[@class='masterProperty_tab active']")).getCssValue("color");
		String[] CP_RBG = CP_color.replace("rgba(", "").replace(")", "").split(",");
		int CP_R = Integer.parseInt(CP_RBG[0].trim());
		int CP_G = Integer.parseInt(CP_RBG[1].trim());
		int CP_B = Integer.parseInt(CP_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_CP = "#" + Integer.toHexString(CP_R) + Integer.toHexString(CP_G) + Integer.toHexString(CP_B);
		if( CP_Text.contains(CP_Font) && (CP_Text.contains(CP_Size)) && (hex_CP.contains(CP_Clr))){
			System.out.println("Current Tab font font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Current Panel Font and Colour Matched :</span>" +CP_Text+""+hex_CP);
		}
		else {
			System.out.println("ERROR - Current Tab Font font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Current Panel Font and Colour MisMatched :</span>" +CP_Text+""+hex_CP);
		}
	}
	public void Otherpanel() {
		String OP_Font = prop.getProperty("OtherTab_Expected_Font");
		String OP_Size = prop.getProperty("OtherTab_Expected_Size");
		String OP_Clr = prop.getProperty("OtherTab_Expected_Colour");
		String OP_Text = driver.findElement(By.xpath("*//a[@class='masterProperty_tab']")).getCssValue("font");
		String OP_color = driver.findElement(By.xpath("*//a[@class='masterProperty_tab']")).getCssValue("color");
		String[] OP_RBG = OP_color.replace("rgba(", "").replace(")", "").split(",");
		int OP_R = Integer.parseInt(OP_RBG[0].trim());
		int OP_G = Integer.parseInt(OP_RBG[1].trim());
		int OP_B = Integer.parseInt(OP_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_OP = "#" + Integer.toHexString(OP_R) + Integer.toHexString(OP_G) + Integer.toHexString(OP_B);
		if( OP_Text.contains(OP_Font) && (OP_Text.contains(OP_Size)) && (hex_OP.contains(OP_Clr))){
			System.out.println("Other Tab font font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Other Panel Font and Colour Matched :</span>" +OP_Text+""+hex_OP);
		}
		else {
			System.out.println("ERROR - Other Tab Font font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Other Panel Font and Colour MisMatched :</span>" +OP_Text+""+hex_OP);
		}
	}
	public void CurrentHeaderPaenl() {
		String CHP_Font = prop.getProperty("CurrentTab_Header_Font");
		String CHP_Size = prop.getProperty("CurrentTab_Header_Size");
		String CHP_Clr = prop.getProperty("CurrentTab_Header_Colour");
		String CHP_Text = driver.findElement(By.xpath("*//li[@class='property_tab active']")).getCssValue("font");
		String CHP_color = driver.findElement(By.xpath("*//li[@class='property_tab active']")).getCssValue("color");
		String[] CHP_RBG = CHP_color.replace("rgba(", "").replace(")", "").split(",");
		int CHP_R = Integer.parseInt(CHP_RBG[0].trim());
		int CHP_G = Integer.parseInt(CHP_RBG[1].trim());
		int CHP_B = Integer.parseInt(CHP_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_CHP = "#" + Integer.toHexString(CHP_R) + Integer.toHexString(CHP_G) + Integer.toHexString(CHP_B);
		if( CHP_Text.contains(CHP_Font) && (CHP_Text.contains(CHP_Size)) && (hex_CHP.contains(CHP_Clr))){
			System.out.println("Current Header Tab font font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Current Header Panel Font and Colour Matched :</span>" +CHP_Text+""+hex_CHP);
		}
		else {
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Current Header Panel Font and Colour MisMatched :</span>" +CHP_Text+""+hex_CHP);
		}
	}
	public void OtherHeaderPanel() {
		String OHP_Font = prop.getProperty("OtherTab_Header_Font");
		String OHP_Size = prop.getProperty("OtherTab_Header_Size");
		String OHP_Clr = prop.getProperty("OtherTab_Header_Colour");
		String OHP_Text = driver.findElement(By.xpath("*//li[@class='property_tab masterProperty_tab']")).getCssValue("font");
		String OHP_color = driver.findElement(By.xpath("*//li[@class='property_tab masterProperty_tab']")).getCssValue("color");
		String[] OHP_RBG = OHP_color.replace("rgba(", "").replace(")", "").split(",");
		int OHP_R = Integer.parseInt(OHP_RBG[0].trim());
		int OHP_G = Integer.parseInt(OHP_RBG[1].trim());
		int OHP_B = Integer.parseInt(OHP_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_OHP = "#" + Integer.toHexString(OHP_R) + Integer.toHexString(OHP_G) + Integer.toHexString(OHP_B);
		if( OHP_Text.contains(OHP_Font) && (OHP_Text.contains(OHP_Size)) && (hex_OHP.contains(OHP_Clr))){
			System.out.println("Other Header Tab font font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>other Header Panel Font and Colour Matched :</span>" +OHP_Text+""+hex_OHP);
		}
		else {
			System.out.println("ERROR - Other Header Tab Font font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:green;'>other Header Panel Font and Colour MisMatched :</span>" +OHP_Text+""+hex_OHP);
		}
	}
	public void PropertyPanelSubMenu() {
		String HHP_Font = prop.getProperty("Header_Font");
		String HHP_Size = prop.getProperty("Header_Size");
		String HHP_Clr = prop.getProperty("Header_Colour");
		String HHP_Text = driver.findElement(By.xpath("*//label[@class='col-lg-5 col-md-5 col-sm-5 col-5 col-xl-4 control-label']")).getCssValue("font");
		String HHP_color = driver.findElement(By.xpath("*//label[@class='col-lg-5 col-md-5 col-sm-5 col-5 col-xl-4 control-label']")).getCssValue("color");
		String[] HHP_RBG = HHP_color.replace("rgba(", "").replace(")", "").split(",");
		int HHP_R = Integer.parseInt(HHP_RBG[0].trim());
		int HHP_G = Integer.parseInt(HHP_RBG[1].trim());
		int HHP_B = Integer.parseInt(HHP_RBG[2].trim());
		//System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex_HHP = "#" + Integer.toHexString(HHP_R) + Integer.toHexString(HHP_G) + Integer.toHexString(HHP_B);
		if( HHP_Text.contains(HHP_Font) && (HHP_Text.contains(HHP_Size)) && (hex_HHP.contains(HHP_Clr))){
			System.out.println("Properties Tab font font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Panel Submenu Font and Colour Matched :</span>" +HHP_Text+""+hex_HHP);
		}
		else {
			System.out.println("ERROR - Properties Tab Font font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Panel Submenu Font and Colour MisMatched :</span>" +HHP_Text+""+hex_HHP);
		}
	}
	public void PropertyPanelBackground() {
		String PC_Clr = prop.getProperty("PropertyBackground_Colour");
		String PC_Color = driver.findElement(By.xpath("*//div[@style='border-top: 4px solid #3D70B2; margin-top: 5%; box-shadow: 0px 2px 4px 0px #000000; opacity: 50;']")).getCssValue("background-color"); 
		String[] PC_RBG = PC_Color.replace("rgba(", "").replace(")", "").split(",");
		int PC_R = Integer.parseInt(PC_RBG[0].trim());
		int PC_G = Integer.parseInt(PC_RBG[1].trim());
		int PC_B = Integer.parseInt(PC_RBG[2].trim());
		String hex_PC = "#" + Integer.toHexString(PC_R) + Integer.toHexString(PC_G) + Integer.toHexString(PC_B);
		if((hex_PC.contains(PC_Clr))){
			System.out.println("Property Background Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Panel Background Colour Matched :</span>" +hex_PC);
		}
		else {
			System.out.println("ERROR - Property Background color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Panel Background Colour MisMatched :</span>" +hex_PC);
		}
	}
	public void PropertyPanelFooterClr() {
		String HC_Clr = prop.getProperty("PropertyHeader_Colour");
		String HC_Color = driver.findElement(By.xpath("*//div[@style='background-color: #F4F7FB; padding: 15px; display: block']")).getCssValue("background-color"); 
		String[] HC_RBG = HC_Color.replace("rgba(", "").replace(")", "").split(",");
		int HC_R = Integer.parseInt(HC_RBG[0].trim());
		int HC_G = Integer.parseInt(HC_RBG[1].trim());
		int HC_B = Integer.parseInt(HC_RBG[2].trim());
		String hex_HC = "#" + Integer.toHexString(HC_R) + Integer.toHexString(HC_G) + Integer.toHexString(HC_B);
		if((hex_HC.contains(HC_Clr))){
			System.out.println("Property Footer Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Panel Footer Colour Matched :</span>" +hex_HC);
		}
		else {
			System.out.println("ERROR - Property Footer color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Panel Footer Colour MisMatched :</span>" +hex_HC);
		}
	}
	public void PropertyPanelSave() {
		String SB_Font = prop.getProperty("SaveButton_Font");
		String SB_Size = prop.getProperty("SaveButton_Size");
		String SB_Clr = prop.getProperty("SaveButton_Clr");
		String SBG_Clr = prop.getProperty("SaveButtonBAckgroundclr");
		String SB_F = driver.findElement(By.xpath("*//button[@id='submit']")).getCssValue("font-family");
		String SB_S = driver.findElement(By.xpath("*//button[@id='submit']")).getCssValue("font-size");
		String SB_color = driver.findElement(By.xpath("*//button[@id='submit']")).getCssValue("color");
		String SBG_color = driver.findElement(By.xpath("*//button[@id='submit']")).getCssValue("background-color");
		String[] SB_RBG = SB_color.replace("rgba(", "").replace(")", "").split(",");
		int SB_R = Integer.parseInt(SB_RBG[0].trim());
		int SB_G = Integer.parseInt(SB_RBG[1].trim());
		int SB_B = Integer.parseInt(SB_RBG[2].trim());
		String hex_SB = "#" + Integer.toHexString(SB_R) + Integer.toHexString(SB_G) + Integer.toHexString(SB_B);
		String[] SBG_RBG = SBG_color.replace("rgba(", "").replace(")", "").split(",");
		int SBG_R = Integer.parseInt(SBG_RBG[0].trim());
		int SBG_G = Integer.parseInt(SBG_RBG[1].trim());
		int SBG_B = Integer.parseInt(SBG_RBG[2].trim());
		String hex_SBG = "#" + Integer.toHexString(SBG_R) + Integer.toHexString(SBG_G) + Integer.toHexString(SBG_B);
		if( SB_F.contains(SB_Font) && (SB_S.contains(SB_Size)) && (hex_SB.contains(SB_Clr))){
			System.out.println("submit font style, size and color - Status 'passed'");
		}
		else {
			System.out.println("ERROR - Submit font style, size and color - Status 'Failed'");
		}
		if((hex_SBG.contains(SBG_Clr))){
			System.out.println("Connect Button Color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Save Font, Colour Matched :</span>" +SB_S+""+SB_F+""+hex_SB);
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Save Button Colour Matched :</span>" +hex_SBG);
		}
		else {
			System.out.println("Connect Button - Color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Save Font, Colour MisMatched :</span>" +SB_S+""+SB_F+""+hex_SB);
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Save Button Colour MisMatched :</span>" +hex_SBG);
		}
	}
	public void PropertyPanelCancel() throws InterruptedException {
		String PPC_Font = prop.getProperty("CancelButton_Font");
		String PPC_Size = prop.getProperty("CancelButton_Size");
		String PPC_Clr = prop.getProperty("CancelButton_Clr");
		String PPC_F = driver.findElement(By.xpath("*//button[@class='btn btn-outline-secondary col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2']")).getCssValue("font-family");
		String PPC_S = driver.findElement(By.xpath("*//button[@class='btn btn-outline-secondary col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2']")).getCssValue("font-size");
		String PPC_color = driver.findElement(By.xpath("*//button[@class='btn btn-outline-secondary col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2']")).getCssValue("color");
		String[] PPC_RBG = PPC_color.replace("rgba(", "").replace(")", "").split(",");
		int PPC_R = Integer.parseInt(PPC_RBG[0].trim());
		int PPC_G = Integer.parseInt(PPC_RBG[1].trim());
		int PPC_B = Integer.parseInt(PPC_RBG[2].trim());
		String hex_PPC = "#" + Integer.toHexString(PPC_R) + Integer.toHexString(PPC_G) + Integer.toHexString(PPC_B);
		if( PPC_F.contains(PPC_Font) && (PPC_S.contains(PPC_Size)) && (hex_PPC.contains(PPC_Clr))){
			System.out.println("Cancel font style, size and color - Status 'passed'");
			logger.log(LogStatus.PASS, "<span style='color:green;'>Property Cancel Button Colour Matched :</span>" +PPC_S+""+PPC_F+""+hex_PPC);
		}
		else {
			System.out.println("ERROR - Cancel font style, size and color - Status 'Failed'");
			logger.log(LogStatus.FAIL, "<span style='color:red;'>Property Cancel Button Colour MisMatched :</span>" +PPC_S+""+PPC_F+""+hex_PPC);
		}
		WebElement Property_cancel = driver.findElement(By.xpath("*//button[@class='btn btn-outline-secondary col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2']"));
		Property_cancel.click();
		Thread.sleep(3000);
	}
	
}
