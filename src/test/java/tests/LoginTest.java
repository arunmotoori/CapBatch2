package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends Base{
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddressIntoEmailAddressTextField(prop.getProperty("validEmailAddress"));
		loginPage.enterPasswordIntoPasswordTextField(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationLink());
		
	}
	
	@Test(priority=2)
	public void loginWithInvalidEmailAndValidPassword() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddressIntoEmailAddressTextField("invalidemailaddress"+getTimeStamp()+"@gmail.com");
		loginPage.enterPasswordIntoPasswordTextField(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.retrieveWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
	
	@Test(priority=3)
	public void loginWithValidEmailAndInvalidPassword() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountDropMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddressIntoEmailAddressTextField(prop.getProperty("validEmailAddress"));
		loginPage.enterPasswordIntoPasswordTextField(prop.getProperty("InvalidPassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.retrieveWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
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
