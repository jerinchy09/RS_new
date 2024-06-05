package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.abstractclass;

public class CartPage extends abstractclass {
	WebDriver driver;

	public CartPage(WebDriver dr) {
		super(dr);
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	public boolean cartValidation(String prod_name) {
		cart.click();
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(prod_name));
		return match;

	} // Assert.assertTrue(match);

	public checkOutPage checkoutButton() {
		checkoutButton.click();
		return new checkOutPage(driver);
	}

}
