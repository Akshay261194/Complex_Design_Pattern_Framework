package webCommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebTextBox {
	public static void enterText(WebElement textBox,String text) {
		if (WebElementCommon.isClickable(textBox)) {
			textBox.sendKeys(text);
		}
	}

	public static void enterText(WebDriver driver,By by, String text) {
		WebElement textBox = WebElementCommon.isClickable(driver, by);
		textBox.sendKeys(text);

	}
	
	public static void enterText(WebDriver driver,By by, String text, ExtentTest logger) {
		WebElement textBox = WebElementCommon.isClickable(driver, by, logger);
		if(textBox!=null) {
			textBox.sendKeys(text);
			logger.log(LogStatus.PASS, "User succesfully entered text - "+text);
		}else {
			logger.log(LogStatus.FAIL, "User not able to entered text - "+text);
		}

	}
	
	public static void enterText(WebDriver driver,By by, String field, String text, ExtentTest logger) {
		WebElement textBox = WebElementCommon.isClickable(driver, by, logger);
		if(textBox!=null) {
			textBox.sendKeys(text);
			logger.log(LogStatus.PASS, "User succesfully entered text - "+text+" on "+field+" textbox");
		}else {
			logger.log(LogStatus.FAIL, "User not able to entered text - "+text+" on "+field+" textbox");
		}

	}
	
	public static void enterText(WebDriver driver,WebElement by, String field, String text, ExtentTest logger) {
		WebElement textBox = WebElementCommon.isClickable(driver, by, logger);
		if(textBox!=null) {
			textBox.sendKeys(text);
			logger.log(LogStatus.PASS, "User succesfully entered text - "+text+" on "+field+" textbox");
		}else {
			logger.log(LogStatus.FAIL, "User not able to entered text - "+text+" on "+field+" textbox");
		}

	}

	public static void clearText(WebElement textBox) {
		if (WebElementCommon.isClickable(textBox)) {
			textBox.clear();
		}
	}
	
	public static void clearText(WebDriver driver,By by) {
		WebElement ele = WebElementCommon.isClickable(driver, by);
		if (ele!=null) {
			ele.clear();
		}
	}
	
	public static void enterText(WebDriver driver,String locator,String locval, String text) {
		WebElement element=WebElementCommon.buildElement(driver, locator, locval);
		if(WebElementCommon.isClickable(element)) {
			element.sendKeys(text);
		}
	}
}
