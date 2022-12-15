package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By enterMobileNo = By.id("ap_email");
	By signInContinue = By.xpath("//*[@id=\'continue\']");
	By password = By.id("ap_password");
	By clickSignIn = By.id("signInSubmit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void signInCredentials()
	{
		driver.findElement(enterMobileNo).sendKeys("8147556436");
		driver.findElement(signInContinue).click();
		driver.findElement(password).sendKeys("123456");
		driver.findElement(clickSignIn).click();
	}
}
