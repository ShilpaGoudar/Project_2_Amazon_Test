package testCases;

import org.testng.annotations.Test;

import baseClasses.TestBaseForLaunchUrl;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;

public class TestCase_03_CreateAccount extends TestBaseForLaunchUrl{
	
	HomePage HomePageObject;
	CreateAccountPage CreateAccountPageObject;
	
	@Test()
	public void createAccountForNewUser() throws Exception
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.clickCreateAccountButton();		
		CreateAccountPageObject = new CreateAccountPage(driver);
		CreateAccountPageObject.createAccount();
	}


}
