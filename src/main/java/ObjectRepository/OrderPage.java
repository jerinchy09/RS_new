package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.abstractclass;

public class OrderPage extends abstractclass {
	WebDriver driver;

	public OrderPage(WebDriver dr) {
		super(dr);
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	public Boolean VerifyOrderDisplay(String prod_name) {
		
		Boolean match = productNames.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(prod_name));
		return match;

	} // Assert.assertTrue(match);

	public checkOutPage checkoutButton() {
		checkoutButton.click();
		return new checkOutPage(driver);
	}
}
