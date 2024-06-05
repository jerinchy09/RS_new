package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ObjectRepository.login;

public class BaseClass {
	public WebDriver driver ;
//	static WebDriver driver ;
	public login l ;

	public WebDriver initializeDriver() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\GlobalData.properties");
		//E:\Nexvalli\Eclipse Wrokspace\RS_e2e_cart_proj\src\main\java\RS_e2e\resources\globalData.properties
		Properties p = new Properties();
		p.load(fis);
		//ternary operator
		//System.getProperty  also called System level variable 
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser"): p.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")){
			WebDriver driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public List<HashMap<String, String>> geJsonDataToMap(String filePath) throws IOException {
		//FilUtils coming from commons.io package
		//read json toString
		String f=	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		//String to HashMap Jackson Databind
		//add jar jackson-databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(f, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public login launchApp() throws IOException {
		driver =initializeDriver();
		l = new login(driver);
		l.goTo();
		return l;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void taerDown() {
		driver.quit();
		
				
	}
	
	

}
