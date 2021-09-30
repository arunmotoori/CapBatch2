package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(css="input[value='Login']")
	private WebElement loginButton;
	
	@FindBy(css=".alert.alert-danger.alert-dismissible")
	private WebElement warningMessage;
	
	public String retrieveWarningMessageText() {
		
		return warningMessage.getText();
		
	}
	
	
	public void enterEmailAddressIntoEmailAddressTextField(String emailAddress) {
		
		emailAddressTextField.sendKeys(emailAddress);
		
	}
	
	public void enterPasswordIntoPasswordTextField(String password) {
		
		passwordTextField.sendKeys(password);
		
	}
	
	public void clickOnLoginButton() {
		
		loginButton.click();
		
	}
	
	

}
