package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage{

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement amazonProductSearchInput;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement amazonProductSearchButton;
	
	@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']/div[@data-asin]")
	private List<WebElement> productsSearchResult;
	
	public void searchProductInput(String product) {
		amazonProductSearchInput.sendKeys(product);
	}
	
	public void searchProductBtn() {
		amazonProductSearchButton.click();
	}
	
	public List<WebElement> getProductSearchResults() {
		return productsSearchResult;
	}
	
	
}
