package medifix_Page_Locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class Dashboard_Page_Locator {
	public WebDriver driver = null;
	public ExtentTest logger = null;
	public Dashboard_Page_Locator(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboradLink;
	
	public WebElement getDashboradLink() {
		return dashboradLink;
	}
	
	@FindBy(linkText = "Patient Management")
	private WebElement patientManagementLink;
	
	public WebElement getPatientManagementLink() {
		return patientManagementLink;
	}
	//To identify multiple web elements we use @FindBys annotation
	@FindBys({@FindBy(tagName = "li")})
	private List<WebElement> allDashboardLinks;
	
	public List<WebElement> getAllDashboardLinks(){
		return allDashboardLinks;
	}
	//Another way to identify element using @FindBy annotation
	@FindBy(how = How.LINK_TEXT, using = "Doctor")
	private WebElement doctorLink;
	
	public WebElement getDoctorLink() {
		return doctorLink;
	}
	//Another way of integration of @FindBys & How
	@FindBys({@FindBy(how = How.TAG_NAME, using = "li")})
	private List<WebElement> dashLinks;
	
	public List<WebElement> getAllDashLinks(){
		return dashLinks;
	}
	
	//Another way with multiple @FindBy, it works like AND operation
	@FindBys({@FindBy(how = How.TAG_NAME, using = "li"),
		      @FindBy(how = How.TAG_NAME, using = "span")})
	private List<WebElement> abcLinks;
	
	public List<WebElement> getABCLinks(){
		return abcLinks;
	}
	
	//Another way with multiple @FindBy, it works like OR operation
	@FindAll({@FindBy(how = How.TAG_NAME, using = "li"),
		      @FindBy(how = How.TAG_NAME, using = "span")})
	private List<WebElement> xyzLinks;
	
	public List<WebElement> getXYZLinks(){
		return xyzLinks;
	}
	
	/*
	 * Difference between @FindBys & @FindAll
	 * @FindBys - is used when elements needs to match all condition
	 * @FindAll - is used when elements needs to match anyone condition
	 */
	
}






