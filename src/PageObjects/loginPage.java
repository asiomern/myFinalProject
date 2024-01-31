package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#user-name")
	WebElement userNameField;

	@FindBy(css = "#password")
	WebElement passwordField;

	@FindBy(css = "#login-button")
	WebElement loginBtn;

	@FindBy(css = "#root h3")
	WebElement wrongPassOrUserName;

	@FindBy(css = ".error-message-container.error>[data-test='error']")
	WebElement blankFields;

	@FindBy(css = "#login_credentials > h4")
	WebElement loginPageTitle;

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Login Action

	public void login(String userName, String password) {

		fillText(userNameField, userName);
		fillText(passwordField, password);
		click(loginBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Wrong User Name or Password error

	public String wrongUserNameOrPassError() {

		return wrongPassOrUserName.getText();

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Login with blank fields

	public String blankLoginFields() {

		return blankFields.getText();

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Validation

//LogOut validtion

	public String logOutValidation() {

		return loginPageTitle.getText();

	}
}