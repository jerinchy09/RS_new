package RS.RS_new;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.checkOutPage;
import ObjectRepository.product_catalogue;
import TestComponents.BaseClass;

public class ErrorValidation extends BaseClass {

	@Test
	public void LoginError() {
		String prod_name = "ZARA COAT 3";
		product_catalogue prd_ct = l.loginApp("anshika@gmail.com", "Iamki00");
		System.out.println(l.getErrorMessage());
		Assert.assertEquals("Incorrect email or password.", l.getErrorMessage());
	}
	@Test	
	public void ProductError() throws IOException, InterruptedException {
		String prod_name="ZARA COAT 3";
		
		product_catalogue prd_ct= l.loginApp("anshika@gmail.com", "Iamking@000");		
		List<WebElement> prod = prd_ct.getProductList();
		prd_ct.addProductToCart(prod_name);		
		CartPage c=prd_ct.goToCartPage();
		boolean match =c.cartValidation("Zara coat 33");
		Assert.assertFalse(match);
	}
}
