package webCommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebButton {
	public static void click(WebDriver driver,By by, String field, ExtentTest logger) {
		WebElement button = WebElementCommon.isClickable(driver, by, logger);
		if(button!=null) {
			button.click();
			logger.log(LogStatus.PASS, "User succesfully click on "+field+" button");
		}else {
			logger.log(LogStatus.FAIL, "User not able to click on "+field+" button");
		}
	}
	
	public static void click(WebDriver driver,WebElement by, String field, ExtentTest logger) {
		WebElement button = WebElementCommon.isClickable(driver, by, logger);
		if(button!=null) {
			button.click();
			logger.log(LogStatus.PASS, "User succesfully click on "+field+" button");
		}else {
			logger.log(LogStatus.FAIL, "User not able to click on "+field+" button");
		}
	}
}
