package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage{
	
	WebDriver driver;

	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By enterYourName = By.name("customerName");
	By enterModileNumber = By.id("ap_phone_number");
	By enterEmail = By.id("ap_email");
	By enterPassword = By.id("ap_password");
	By clickContinueButton = By.id("continue");


	public void createAccount() throws Exception
	{
		Properties PageProperties = new Properties();
		FileInputStream InputStream = new FileInputStream("D:\\Shilpa\\Selenium_Testing\\Projects_ExcelR\\AmazonTesting\\Project2_AmazonTesting\\Project_2_Amazon\\DatFiles\\Properties.properties");
		PageProperties.load(InputStream);
        
		String yourName = PageProperties.getProperty("yourName");
		String mobileNumberFromProp = PageProperties.getProperty("mobileNumber");
		String emailIdFromProp = PageProperties.getProperty("emailId");
		String passwordFromProp = PageProperties.getProperty("password");
		
		driver.findElement(enterYourName).sendKeys(yourName);
		Thread.sleep(0);
		driver.findElement(enterModileNumber).sendKeys(mobileNumberFromProp);
		driver.findElement(enterEmail).sendKeys(emailIdFromProp);
		driver.findElement(enterPassword).sendKeys(passwordFromProp);
		driver.findElement(clickContinueButton).click();
	}
}
