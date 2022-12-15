package baseClasses;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseForLaunchUrl {
	
	protected WebDriver driver;
	
	GenericMethods GenericMethodsObject;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	
	public FileInputStream InputStream;
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void launchUrl(String browserName) throws Exception
	{
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\AmazonTesting\\Project2_AmazonTesting\\Project_2_Amazon\\DatFiles\\Properties.properties");
		PageProperties.load(InputStream);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(PageProperties.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
