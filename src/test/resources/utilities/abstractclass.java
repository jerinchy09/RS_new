package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.CartPage;
import ObjectRepository.OrderPage;

public class abstractclass {
	WebDriver dr;
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public abstractclass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.dr = driver;
		PageFactory.initElements(dr, this);
	}

	public void waitforElementtoAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitforWebElementtoAppear(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void waitforElementtoDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public CartPage goToCartPage() {

		cartHeader.click();
		CartPage c = new CartPage(dr);
		return c;
	}

	public OrderPage goToOrderPage() {

		cartHeader.click();
		OrderPage o = new OrderPage(dr);
		return o;
	}
}
