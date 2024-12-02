package webCommonFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebElementCommon {
	
	public static String getElementText(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		return element.getText();
	}
	
	public static WebElement isClickable(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static WebElement isClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static WebElement isClickable(WebDriver driver, By by, ExtentTest logger) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			ele = wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "We found exception - "+e.getMessage());
		}
		return ele;
	}
	
	public static WebElement isClickable(WebDriver driver, WebElement element, ExtentTest logger) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "We found exception - "+e.getMessage());
		}
		return ele;
	}

	public static WebElement isClickable(WebDriver driver, int sec, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static WebElement isClickable(WebDriver driver, int sec, int poll, By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(poll)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static boolean isPresent(WebElement element) {
		boolean isPre = false;
		if (element.isDisplayed()) {
			isPre = true;
		}
		return isPre;
	}

	public static boolean isClickable(WebElement element) {
		boolean isClick = false;
		if (isPresent(element)) {
			if (element.isEnabled()) {
				isClick = true;
			}
		}
		return isClick;
	}

	public static WebElement buildElement(WebDriver driver, String locator, String locval) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		switch (locator.toLowerCase()) {
		case "id": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locval)));
			break;
		}
		case "name": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.name(locval)));
			break;
		}
		case "linktext": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locval)));
			break;
		}
		case "classname": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.className(locval)));
			break;
		}
		case "xpath": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locval)));
			break;
		}
		case "cssselector": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locval)));
			break;
		}
		case "tagname": {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName(locval)));
			break;
		}
		default:
			System.out.println("Element not selected properly");
		}
		return element;
	}
	public static List<WebElement> buildElements(WebDriver driver, String locator, String locval) {
		List<WebElement> elements = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		switch (locator.toLowerCase()) {
		case "id": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locval)));
			break;
		}
		case "name": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locval)));
			break;
		}
		case "linktext": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locval)));
			break;
		}
		case "classname": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locval)));
			break;
		}
		case "xpath": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locval)));
			break;
		}
		case "cssselector": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locval)));
			break;
		}
		case "tagname": {
			elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locval)));
			break;
		}
		default:
			System.out.println("Element not selected properly");
		}
		return elements;
	}

}
