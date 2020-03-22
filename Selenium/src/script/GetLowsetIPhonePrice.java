package script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AmazonHomePage;
import pom.BasePage;
import pom.FlipKartHomePage;
import pom.FlipkartLoginPage;

public class GetLowsetIPhonePrice extends BaseTest {

	@Test
	public void iphone() {
		AmazonHomePage a = new AmazonHomePage(driver);		
		BasePage b = new BasePage(driver);
		FlipkartLoginPage flpLogin = new FlipkartLoginPage(driver);
		FlipKartHomePage flpHme = new FlipKartHomePage(driver);		
		
		
		//Amazon
		b.navigateTOURL("https://www.amazon.in/");
		b.maximizeBrowser();
		b.verifyTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		a.searchProductInput("iPhone XR (64GB) - Yellow");
		a.searchProductBtn();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> lis = a.getProductSearchResults();
		int amazonPrice = 0;
		for(int i = 0; i <= lis.size()-1; i++) {
			b.scrollIntoView(lis.get(i));
			WebElement res = lis.get(i).findElement(By.xpath("./div[@class='sg-col-inner']/span[@cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']/div/div//div[@class='sg-row']//h2//span"));
			String productName = res.getText();
			if((productName.indexOf("iPhone XR") != -1 ? true : false) && (productName.indexOf("Yellow") != -1 ? true : false) && (productName.indexOf("64GB") != -1 ? true : false)) {
			WebElement el = lis.get(i).findElement(By.xpath("./div[@class='sg-col-inner']/span[@cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']/div/div//div[@class='sg-row']//span[@class='a-price-whole']"));
				String price = el.getText();
				price = price.replaceAll("[^0-9_-]", "");
				amazonPrice = Integer.parseInt(price);
 
			}
		}
			
		//FlipKart
		b.navigateTOURL("https://www.flipkart.com/");
		b.verifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		flpLogin.loginPopUpCloseBtn();
		flpHme.searchProduct("iPhone XR (64GB) - Yellow");
		flpHme.productSearchBtn();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> prodctsLis = flpHme.getProductSearchResults(); 
		int flipKartPrice = 0;
		for(int i = 0; i <= prodctsLis.size()-1; i++) {
			b.scrollIntoView(prodctsLis.get(i));
			WebElement res = prodctsLis.get(i).findElement(By.xpath("./div//div[@class='_3wU53n']"));
			String productName = res.getText();
			if((productName.indexOf("iPhone XR") != -1 ? true : false) && (productName.indexOf("Yellow") != -1 ? true : false)  && (productName.indexOf("64 GB") != -1 ?true : false) ) {
				WebElement el = prodctsLis.get(i).findElement(By.xpath("./div[@data-id]//div[@class='_1-2Iqu row']//div[contains(@class,' _2o7WAb')]//div[@class='_1vC4OE _2rQ-NK']"));
				String price = el.getText();
				price = price.replaceAll("[^0-9_-]", "");
				flipKartPrice = Integer.parseInt(price);   
			}
		}
	
		if((amazonPrice > 0)&&(amazonPrice < flipKartPrice)) {
			Reporter.log("Amazon has less price and the price is "+amazonPrice,true);
		}else if((flipKartPrice > 0) && (flipKartPrice < amazonPrice)) {
			Reporter.log("FlipKart has less price and the price is "+flipKartPrice);
		}else if(((amazonPrice > 0) && (flipKartPrice > 0)) && (amazonPrice == flipKartPrice)) {
			Reporter.log("FlipKart and Amazon has less price and the pice is "+flipKartPrice);
		}else {
			Reporter.log("Does not match the product ");
		}
		
	}
}
