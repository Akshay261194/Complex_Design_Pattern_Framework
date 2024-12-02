package souceDemo_PageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Souce_demo_LoginPage {
	public WebDriver driver = null;
	public ExtentTest logger = null;
	public Souce_demo_LoginPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);//Mandatory to initialize all webElement
	}
	@FindBy(id = "user-name")
	private WebElement user;
	
	public WebElement getUser() {
		return user;
	}
	
	@FindBy(id = "password")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
