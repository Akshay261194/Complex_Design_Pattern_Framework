package dataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import webCommonFunctions.WebBrowser;
import webCommonFunctions.WebTextBox;

public class PropertyReader {
	public static String getPropertyValue(String path, String key) {
		Properties prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(path);
			prop.load(file);
		} catch (IOException e) {
			System.out.println("File Not Found Exception on Properties File");
		}
		return prop.getProperty(key);
	}
	
	
	public static void main(String[] args) throws IOException {
		String path = "C:/Selenium/Jan2024/Complex_Design_Pattern_Framework/TestData/medifox/config.properties";
		System.out.println(getPropertyValue(path, "reporterPath")+LocalDateTime.now()+"report.html");
		
		Date date = Calendar.getInstance().getTime();
		DateFormat formatMine = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(formatMine.format(date));
				
		WebDriver driver = null;
		ExtentReports graphicalReport = new ExtentReports(getPropertyValue(path, "reporterPath")+formatMine.format(date)+"/report.html",true);//Report Start
		ExtentTest logger = graphicalReport.startTest("Framework Test");//Test Start
		driver = WebBrowser.openBrowser(getPropertyValue(path, "browser"), 
										logger, 
										getPropertyValue(path, "url"));
		WebTextBox.enterText(driver, By.id("Username"), "admin", logger);
		WebTextBox.enterText(driver, By.id("dfgassword"), "password", "admin", logger);
		graphicalReport.endTest(logger);//End Test
		graphicalReport.flush();
		
	}
}
















