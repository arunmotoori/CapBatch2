package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	WebDriver driver;
	
	public RegisterAccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameTextField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameTextField;
	
	@FindBy(id="input-email")
	private WebElement emailTextField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmTextField;
	
	@FindBy(name="newsletter")
	private WebElement yesRadioOption;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckBoxField;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueButton;
	
	public void enterFirstName(String firstName) {
		
		firstNameTextField.sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		
		lastNameTextField.sendKeys(lastName);
		
	}
	
	public void enterEmailAddress(String emailAddress) {
		
		emailTextField.sendKeys(emailAddress);
		
	}
	
	public void enterTelephoneNumber(String telephoneNumber) {
		
		telephoneTextField.sendKeys(telephoneNumber);
		
	}
	
	public void enterPassword(String password) {
		
		passwordTextField.sendKeys(password);
		
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		
		passwordConfirmTextField.sendKeys(confirmPassword);
		
	}
	
	public void selectYesRadioOption() {
		
		yesRadioOption.click();
		
	}
	
	public void selectPrivacyPolicyCheckboxField() {
		
		privacyPolicyCheckBoxField.click();
		
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
		
	}

}
