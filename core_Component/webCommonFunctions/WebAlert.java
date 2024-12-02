package webCommonFunctions;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebAlert {
	static Alert alert;
	public static void acceptAlert(WebDriver driver, ExtentTest logger) {
		alert = ComplextExpectedCondition.ifAlertPresent(driver, logger);
		if(alert!=null) {
			alert.accept();
			logger.log(LogStatus.PASS, "Alert is Present and accepted");
		}else {
			logger.log(LogStatus.WARNING, "Alert is not Present and not accepted");
		}
	}

	public static void dismissAlert(WebDriver driver, ExtentTest logger) {
		alert = ComplextExpectedCondition.ifAlertPresent(driver, logger);
		alert.dismiss();
	}

	public static void enterTextAlert(WebDriver driver,String alerttext, ExtentTest logger) {
		alert = ComplextExpectedCondition.ifAlertPresent(driver, logger);
		alert.sendKeys(alerttext);
	}
}