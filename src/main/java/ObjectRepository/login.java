package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.abstractclass;

public class login extends abstractclass{
	WebDriver driver;
	
	public login(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	

	public product_catalogue loginApp(String user, String pass) {
		userEmail.sendKeys(user);
		userPassword.sendKeys(pass);
		submit.click();
		product_catalogue pd_ct = new product_catalogue(driver);
		return pd_ct;
		
	}
	public String getErrorMessage() {
		waitforWebElementtoAppear(errorMessage);
		return errorMessage.getText();
		
	}
	public void goTo() {		
		driver.get("https://rahulshettyacademy.com/client");
	}
}
