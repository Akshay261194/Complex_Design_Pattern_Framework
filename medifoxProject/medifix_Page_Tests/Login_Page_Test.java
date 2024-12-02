package medifix_Page_Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataSource.PropertyReader;
import initializer.BaseClass;
import medifix_Page_Actions.Login_Page_Action;

public class Login_Page_Test extends BaseClass{
	@Test(priority = 1, description = "As a user, want to login with valid credentials")
	public void loginTest() {
		try {
			Login_Page_Action loginPA = new Login_Page_Action(driver, logger);
			loginPA.succesfullLogin(PropertyReader.getPropertyValue(path, "user"), 
									PropertyReader.getPropertyValue(path, "password"));
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenCapture(driver,"loginTest"))+ "Test Pass");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenCapture(driver,"loginTest"))+ "Test Failed -  "+e.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void wrongPassword() {
		try {
			Login_Page_Action loginPA = new Login_Page_Action(driver, logger);
			loginPA.wrongUserPass(PropertyReader.getPropertyValue(path, "user"), 
									PropertyReader.getPropertyValue(path, "password")+"asdd",
									PropertyReader.getPropertyValue(path, "message"));
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenCapture(driver,"wrongPassword"))+ "Test Pass");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenCapture(driver,"wrongPassword"))+ "Test Failed -  "+e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void wrongUsername() {
		try {
			Login_Page_Action loginPA = new Login_Page_Action(driver, logger);
			loginPA.wrongUserPass(PropertyReader.getPropertyValue(path, "user")+"abc", 
									PropertyReader.getPropertyValue(path, "password"),
									PropertyReader.getPropertyValue(path, "message"));
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenCapture(driver,"wrongPassword"))+ "Test Pass");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenCapture(driver,"wrongPassword"))+ "Test Failed -  "+e.getMessage());
		}
	}
}
