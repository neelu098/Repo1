package hacpee.config;

import org.openqa.selenium.By;

import hacpee.pages.TestExecutor;

public class Config extends TestExecutor {

	//Login Page
		
			
			//public static final String username = "//input[@id='username']";
	
		public static final String About_Icon =  "//*[@id=\\\"about\\"; //"//*[@id='logobar']/a/button/div/ul/li[4]/a/img";
		public static final String Build_Version =  "//*[@id=\"infoModal\"]/div/div/div[2]/div[2]/div/p[1]/span";  //"//span[@class='version_detail'][contains(text(),'Version')]";
		public static final String Build_ID =  "//*[@id=\"infoModal\"]/div/div/div[2]/div[2]/div/p[2]/span"; //"//span[@class='version_detail'][contains(text(),'Build ID')]";
		public static final String PRN_Text = driver.findElement(By.xpath("*//p[@id='product_name']")).getCssValue("font");
		public static final String PRN_Color = driver.findElement(By.xpath("*//p[@id='product_name']")).getCssValue("color");
}
