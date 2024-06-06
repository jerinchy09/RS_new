package RS.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ObjectRepository.CartPage;
import ObjectRepository.checkOutPage;
import ObjectRepository.confirmation_page;
import ObjectRepository.login;
import ObjectRepository.product_catalogue;
import TestComponents.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseClass {
	public login l;
	public product_catalogue pc;
	public confirmation_page cfm_page;

	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
		l = launchApp();
	}

	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String passwrod) {
		pc = l.loginApp(username, passwrod);
	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> prod = pc.getProductList();
		pc.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		CartPage c = pc.goToCartPage();
		Boolean match = c.cartValidation(productName);
		Assert.assertTrue(match);
		checkOutPage checkout = c.checkoutButton();

		// checkOutPage checkout = c.checkoutButton();
		checkout.sCountry("India");

		cfm_page = checkout.submitorder();
	}

	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) {
		String m = cfm_page.verifyConfirmationMessage();
		Assert.assertTrue(m.equalsIgnoreCase(string));
		driver.close();
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		Assert.assertEquals(string, l.getErrorMessage());
		driver.close();

	}

}
