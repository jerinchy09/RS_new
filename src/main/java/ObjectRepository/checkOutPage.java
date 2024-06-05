package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.abstractclass;

public class checkOutPage extends abstractclass{
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class, 'ta-item')][2]")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void sCountry(String countryName) {
			Actions a = new Actions(driver);
			a.sendKeys(country,countryName).build().perform();
			
			waitforElementtoAppear(results);
			//searching India in dropdown
			selectcountry.click();
			
			//clicking plac order
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".action__submit")));
			
			//Actions act =  new Actions(driver);
			//a.moveToElement(submit).click().perform();
		  
	 }
	 public confirmation_page submitorder() {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click();", submit);
		 //Actions act =  new Actions(driver);
		 //a.moveToElement(submit).click().perform();
		
		 return new confirmation_page(driver);		 
	 }

}
