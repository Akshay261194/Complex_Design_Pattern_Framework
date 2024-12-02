package medifix_Page_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Login_Page_Locator {
	public WebDriver driver = null;
	public ExtentTest logger = null;
	public Login_Page_Locator(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);//Mandatory to initialize all webElement
	}
	
	//WebElement user = driver.findElement(By.id("Username"));
	
	@FindBy(id = "Username")
	private WebElement user;
	
	public WebElement getUser() {
		return user;
	}
	
	@FindBy(id = "Password")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	@FindBy(xpath = "//li")
	private WebElement errorMessage;
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}
}
