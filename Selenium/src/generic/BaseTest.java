package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst {

	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication() {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver = new ChromeDriver();
		driver.navigate();
	}
	
	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}
}
