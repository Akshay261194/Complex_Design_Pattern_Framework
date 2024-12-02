package initializer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import dataSource.PropertyReader;
import webCommonFunctions.WebBrowser;

public class BaseClass {
	public WebDriver driver = null;
	public ExtentReports graphicalReport = null;
	public ExtentTest logger = null;
	public String path = "E:/Selenium_4april_2022/Complex_Design_Pattern_Framework/TestData/Souce_demo/config.properties";
	
	@BeforeSuite
	public void beforeSuiteStart(){
		graphicalReport = new ExtentReports(PropertyReader.getPropertyValue(path, "reporterPath")+"ScreenShotMultipleResults.html", true);
	}
	
	@BeforeMethod
	public void beforeEachTest(Method testMethod){
		logger = graphicalReport.startTest(testMethod.getName());
		driver = WebBrowser.openBrowser(PropertyReader.getPropertyValue(path, "browser"), 
										logger, 
										PropertyReader.getPropertyValue(path, "url"));
	}
	
	@AfterMethod
	public void afterEachTest(){
		graphicalReport.endTest(logger);
		graphicalReport.flush();
		driver.close();
	}
	
	public static String screenCapture(WebDriver driver,String name) {
		
		TakesScreenshot takeSS = (TakesScreenshot) driver;
		
		File sourceOutputFile = takeSS.getScreenshotAs(OutputType.FILE);//will take complete page screenshot
		File Dest = new File("./Screenshot/"+name+".png");//Dest where we want to copy screen shot file
		try {
			FileUtils.copyFile(sourceOutputFile, Dest);
		} catch (IOException e) {
			System.out.println("Exception in screenshot");
		}//we are copying source to destination
		String errflpath = Dest.getAbsolutePath();//we are returning complete path of destination
		return errflpath;
	}
}
