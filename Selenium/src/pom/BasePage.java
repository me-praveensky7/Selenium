package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Verify Title of Current Page
	public void verifyTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
				wait.until(ExpectedConditions.titleIs(expectedTitle));
				Reporter.log("Title is Matching "+expectedTitle,true);
			}
		catch(Exception e) {
			Reporter.log("Title is not Matching "+expectedTitle,true);
			Assert.fail();
		}
	}
	
	//Verify Element Present and Visible
		public void veirfyElementVisible(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, null, null, 0, 0);
			try {
					wait.until(ExpectedConditions.visibilityOf(element));
					Reporter.log("Element is Present and Visible "+element,true);
				}
			catch(Exception e) {
				Reporter.log("Element is Present and not Visible "+element,true);
				Assert.fail();
			}
		}
		
		
		//Navigate to specified URL
		public void navigateTOURL(String URL) {
			driver.get(URL);
		}
		
		
		//Scroll into View
		public void scrollIntoView(WebElement Element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].scrollIntoView();", Element);
		}
		
		//Maximize the Browser
		public void maximizeBrowser() {
			driver.manage().window().maximize();
		}
		
}
