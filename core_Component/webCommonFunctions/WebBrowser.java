package webCommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebBrowser {
	public static WebDriver openBrowser(String browserName, ExtentTest logger, String url) {
		WebDriver driver = null;
		switch(browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			logger.log(LogStatus.PASS, browserName+" browser open succesfully");
			openURl(driver, url, logger);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			logger.log(LogStatus.PASS, browserName+" browser open succesfully");
			openURl(driver, url, logger);
			break;
		case "edge":
			driver = new EdgeDriver();
			logger.log(LogStatus.PASS, browserName+" browser open succesfully");
			openURl(driver, url, logger);
			break;
		case "safari":
			driver = new SafariDriver();
			logger.log(LogStatus.PASS, browserName+" browser open succesfully");
			openURl(driver, url, logger);
			break;
		default:
			driver = new ChromeDriver();
			logger.log(LogStatus.PASS, " Input browser is not correct, so we open chrome succesfully");
			openURl(driver, url, logger);
			break;
		}
		return driver;
	}

	public static void openURl(WebDriver driver, String url, ExtentTest logger) {
		driver.get(url);
		logger.log(LogStatus.PASS, url+" Succesfully opened.");
	}


}
