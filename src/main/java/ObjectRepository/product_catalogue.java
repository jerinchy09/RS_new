package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.abstractclass;

public class product_catalogue extends abstractclass{
	WebDriver driver;
	public product_catalogue(WebDriver dr) {
		super(dr);
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="card")
	List<WebElement> items;
	
	@FindBy(css =".ng-animating")
	WebElement spinner;
	
	By itemList = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	//Boolean r= items.stream().filter(i->i.getText().equalsIgnoreCase("Zara Coat 3"));
	public List<WebElement> getProductList(){
		waitforElementtoAppear(itemList);
		return items;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addtoCart).click();
		waitforElementtoAppear(toastMessage);
		waitforElementtoDisappear(spinner);
	}
	
	
}
