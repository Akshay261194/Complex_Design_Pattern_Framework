package medifix_Page_Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataSource.PropertyReader;
import initializer.BaseClass;
import medifix_Page_Actions.Dashboard_Page_Action;
import medifix_Page_Actions.Login_Page_Action;

public class Dashboard_Page_Test extends BaseClass{

	@Test
	public void verifyAllDashboardLinks() {
		try {
			Dashboard_Page_Action dashboardPA = new Login_Page_Action(driver, logger).succesfullLogin(
									PropertyReader.getPropertyValue(path, "user"), 
									PropertyReader.getPropertyValue(path, "password"));
			dashboardPA.verifyDashboardLinks();
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenCapture(driver,"verifyAllDashboardLinks"))+ "Test Pass");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenCapture(driver,"verifyAllDashboardLinks"))+ "Test Failed -  "+e.getMessage());
		}
	}
}
