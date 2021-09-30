package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterAccountPage;

public class RegisterTest extends Base{

	@Test(priority=1)
	public void registerWithAllDetails() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		homePage.selectRegisterOption();
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
		
		registerAccountPage.enterFirstName(prop.getProperty("firstName"));
		registerAccountPage.enterLastName(prop.getProperty("lastName"));
		registerAccountPage.enterEmailAddress("amotooricap"+getTimeStamp()+"@gmail.com");
		registerAccountPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerAccountPage.enterPassword(prop.getProperty("password"));
		registerAccountPage.enterConfirmPassword(prop.getProperty("password"));
		registerAccountPage.selectYesRadioOption();
		registerAccountPage.selectPrivacyPolicyCheckboxField();
		registerAccountPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountSuccessPage.retrieveAccountSuccessPageHeading().equals("Your Account Has Been Created!"));
	
	}
	
	@Test(priority=2)
	public void registerWithOnlyMandatoryFields() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		homePage.selectRegisterOption();
		
		RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
		
		registerAccountPage.enterFirstName(prop.getProperty("firstName"));
		registerAccountPage.enterLastName(prop.getProperty("lastName"));
		registerAccountPage.enterEmailAddress("amotooricap"+getTimeStamp()+"@gmail.com");
		registerAccountPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerAccountPage.enterPassword(prop.getProperty("password"));
		registerAccountPage.enterConfirmPassword(prop.getProperty("password"));
		registerAccountPage.selectPrivacyPolicyCheckboxField();
		registerAccountPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountSuccessPage.retrieveAccountSuccessPageHeading().equals("Your Account Has Been Created!"));
		
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		
		loadPropertiesFile();
		openBrowserAndURL(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
	

}
