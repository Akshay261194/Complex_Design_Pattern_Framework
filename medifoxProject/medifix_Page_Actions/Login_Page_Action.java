package medifix_Page_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import medifix_Page_Locators.Login_Page_Locator;
import webCommonFunctions.WebButton;
import webCommonFunctions.WebElementCommon;
import webCommonFunctions.WebTextBox;

public class Login_Page_Action {
	public WebDriver driver = null;
	public ExtentTest logger = null;
	public Login_Page_Locator loginPL = null;
	public Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPL = new Login_Page_Locator(driver, logger);
	}
	
	public void enterUserName(String user) {
		WebElement username = loginPL.getUser();
		if(username!=null) {
			WebTextBox.enterText(driver, username, "Username", user, logger);
		}else {
			logger.log(LogStatus.FAIL, "Username is null, please initialize");
		}
	}
	
	public void enterPassword(String pass) {
		if(loginPL.getPassword()!=null) {
			WebTextBox.enterText(driver, loginPL.getPassword(), "Password", pass, logger);
		}else {
			logger.log(LogStatus.FAIL, "Password is null, please initialize");
		}
	}
	
	public void clickLogin() {
		if(loginPL.getLoginBtn()!=null) {
			WebButton.click(driver, loginPL.getLoginBtn(), "Login", logger);
		}else {
			logger.log(LogStatus.FAIL, "Login Button is null, please initialize");
		}
	}
	
	public void checkErrorMessage(String expectedText) {
		if(loginPL.getErrorMessage()!=null) {
			String actual = WebElementCommon.getElementText(driver, loginPL.getErrorMessage());
			if(actual.equals(expectedText)) {
				logger.log(LogStatus.PASS, actual+" text found and test step is pass");
			}
		}else {
			logger.log(LogStatus.FAIL, "Login Button is null, please initialize");
		}
	}
	
	public Dashboard_Page_Action succesfullLogin(String user, String pass) {
		Dashboard_Page_Action dashboardPA = null;
		try {
			enterUserName(user);
			enterPassword(pass);
			clickLogin();
			dashboardPA = new Dashboard_Page_Action(driver, logger);
		} catch (Exception e) {
			System.out.println("Exception in Login");
		}
		return dashboardPA;
	}
	
	public void wrongUserPass(String user, String pass, String message) {
		enterUserName(user);
		enterPassword(pass);
		clickLogin();
		checkErrorMessage(message);
	}
}
