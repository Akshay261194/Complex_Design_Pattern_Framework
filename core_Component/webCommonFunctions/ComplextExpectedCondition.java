package webCommonFunctions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ComplextExpectedCondition {
	public static Alert ifAlertPresent(WebDriver driver, ExtentTest logger) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "found exception - "+e.getMessage());
		}
		return alert;
	}
}
