package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FlipkartLoginPage extends BasePage{

	
	
	public FlipkartLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[@class='_1hgiYz']//span[text()='Login']")
	private WebElement loginPopUp;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c'and @type='submit']")
	private WebElement loginSubmit;

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement loginPopUpCloseBtn;
	

	
	public void loginPagePopUp() {
		WebDriverWait wait = new WebDriverWait(driver, null, null, 0, 0);
		try {
			wait.until(ExpectedConditions.visibilityOf(loginPopUp));
			Reporter.log("Login PopUp Present "+true);
		}
		catch(Exception e) {
			Reporter.log("Login PopUp not Present "+true);
			Assert.fail();
		}
	}
	
	
	
	public void enterUserName(String user) {
			userName.sendKeys(user);
	}
	
	public void enterPassword(String passwrd) {
		password.sendKeys(passwrd);
	}
	
	public void clickLogin() {
		loginSubmit.click();
	}
	
	public void loginPopUpCloseBtn() {
		loginPopUpCloseBtn.click();
	}
	
	
}
