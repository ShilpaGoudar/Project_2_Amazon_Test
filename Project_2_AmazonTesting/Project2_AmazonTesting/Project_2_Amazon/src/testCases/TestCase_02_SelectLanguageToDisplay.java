package testCases;

import org.testng.annotations.Test;

import baseClasses.TestBaseForLaunchUrl;
import pageObjects.HomePage;

public class TestCase_02_SelectLanguageToDisplay extends TestBaseForLaunchUrl{
	
	HomePage HomePageObject;
	
	@Test
	public void selectLanguage()
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.selectCountryLanguage();
	}

}
