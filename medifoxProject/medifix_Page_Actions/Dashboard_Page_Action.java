package medifix_Page_Actions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import medifix_Page_Locators.Dashboard_Page_Locator;
import webCommonFunctions.WebLink;


public class Dashboard_Page_Action {
	public WebDriver driver = null;
	public ExtentTest logger = null;
	public Dashboard_Page_Locator dashboardPL = null;
	public Dashboard_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		dashboardPL = new Dashboard_Page_Locator(driver, logger);
	}
	
	public void clickDashboard() {
		if(dashboardPL.getDashboradLink()!=null) {
			WebLink.click(driver, dashboardPL.getDashboradLink(), "Dashboard", logger);
		}else {
			logger.log(LogStatus.FAIL, "Dashboard Link is null, please initialize");
		}
	}
	
	public void verifyDashboardLink() {
		if(dashboardPL.getDashboradLink()!=null) {
			WebLink.isAvailable(driver, dashboardPL.getDashboradLink(), "Dashboard", logger);
		}else {
			logger.log(LogStatus.FAIL, "Dashboard Link is null, please initialize");
		}
	}
	
	public void clickPatientManagement() {
		if(dashboardPL.getPatientManagementLink()!=null) {
			WebLink.click(driver, dashboardPL.getPatientManagementLink(), "Patient Management", logger);
		}else {
			logger.log(LogStatus.FAIL, "Patient Management Link is null, please initialize");
		}
	}
	
	public void verifyPatientMgtLink() {
		if(dashboardPL.getPatientManagementLink()!=null) {
			WebLink.isAvailable(driver, dashboardPL.getPatientManagementLink(), "Patient Management", logger);
		}else {
			logger.log(LogStatus.FAIL, "Patient Management Link is null, please initialize");
		}
	}
	
	public void verifyDashboardLinks() {
		verifyDashboardLink();
		verifyPatientMgtLink();
	}
}
