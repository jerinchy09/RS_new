package RS.RS_new;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.OrderPage;
import ObjectRepository.checkOutPage;
import ObjectRepository.confirmation_page;
import ObjectRepository.login;
import ObjectRepository.product_catalogue;
import TestComponents.BaseClass;

import TestComponents.Retry;


public class SubmitOrderTest extends BaseClass
{  
	String prod_name="ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void  submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
	
		
		product_catalogue prd_ct= l.loginApp("anshika@gmail.com", "Iamking@000");		
		
		//product_catalogue prd_ct = new product_catalogue(driver);
		List<WebElement> prod = prd_ct.getProductList();
		prd_ct.addProductToCart(input.get("item"));		
		
		CartPage c=prd_ct.goToCartPage();
		
		//CartPage c = new CartPage(driver);
		Boolean match =c.cartValidation(input.get("item"));
		Assert.assertTrue(match);
		checkOutPage checkout =c.checkoutButton();

		//checkOutPage checkout = c.checkoutButton();
		checkout.sCountry("India");
		
		confirmation_page cfm_page = checkout.submitorder();
		String m =cfm_page.verifyConfirmationMessage();
		Assert.assertTrue(m.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	//to verify zara coat 3 is displaying in orders page
	@Test(dependsOnMethods = {"submitOrder"}, retryAnalyzer = Retry.class )
	public void OrderHisotryTest() {
		product_catalogue productCatalogue = l.loginApp("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(prod_name));
	
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		//   "user.dir"+"//src//test//resources//utilities//purchaseOrder.json")
		List<HashMap<String, String>> data=geJsonDataToMap(System.getProperty("user.dir")+"//src//test//resources//utilities//purchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}


    
}
