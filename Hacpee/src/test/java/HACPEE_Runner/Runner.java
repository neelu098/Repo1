package HACPEE_Runner;

import java.io.File;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ={"Feature//Test.Feature","Feature//Test.Feature"}, //tags={"@Smoke"},
glue={"hacpee.StepDefenition"}) //,monochrome = true)

	public class Runner extends AbstractTestNGCucumberTests {
	
	
		
		  @BeforeClass public static void setup() {
		  
		  ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		  ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml "));
		  ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		  ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
		  ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");
		  
		  
		  }
		 
}

