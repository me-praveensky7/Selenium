package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FlipKartHomePage extends BasePage{

	
	public FlipKartHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@type='text' and @title='Search for products, brands and more']")
	private WebElement productSearchInputField;
	
	@FindBy(xpath="//button[@class='vh79eN' and @type='submit']")
	private WebElement productSearchBtn;
	
	@FindBy(xpath="//div[contains(@class,'bhgxx2')]//div[@class='_3O0U0u']")
	private List<WebElement> productsSearchResult;
	
	
	public void searchProduct(String product) {
		productSearchInputField.sendKeys(product);
	}
	
	public void productSearchBtn() {
		productSearchBtn.click();
	}
		
	public List<WebElement> getProductSearchResults() {
		return productsSearchResult;
	}
	
	
	
}
