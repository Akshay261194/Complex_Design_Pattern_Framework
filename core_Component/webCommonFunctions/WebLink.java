package webCommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebLink {
	public static void click(WebDriver driver,By by, String field, ExtentTest logger) {
		WebElement link = WebElementCommon.isClickable(driver, by, logger);
		if(link!=null) {
			link.click();
			logger.log(LogStatus.PASS, "User succesfully click on "+field+" link");
		}else {
			logger.log(LogStatus.FAIL, "User not able to click on "+field+" link");
		}
	}
	
	public static void click(WebDriver driver,WebElement by, String field, ExtentTest logger) {
		WebElement link = WebElementCommon.isClickable(driver, by, logger);
		if(link!=null) {
			link.click();
			logger.log(LogStatus.PASS, "User succesfully click on "+field+" link");
		}else {
			logger.log(LogStatus.FAIL, "User not able to click on "+field+" link");
		}
	}
	
	public static void isAvailable(WebDriver driver,WebElement by, String field, ExtentTest logger) {
		WebElement link = WebElementCommon.isClickable(driver, by, logger);
		if(link!=null) {
			logger.log(LogStatus.PASS, "User succesfully able to see "+field+" link");
		}else {
			logger.log(LogStatus.FAIL, "User not able to see "+field+" link");
		}
	}
}
