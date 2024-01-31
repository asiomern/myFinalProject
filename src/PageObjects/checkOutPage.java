package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends basePage {

	public checkOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".checkout_info")

	WebElement checkoutTitle;

	@FindBy(css = "#first-name")
	WebElement firstName;

	@FindBy(css = "#last-name")
	WebElement lastName;

	@FindBy(css = "#postal-code")
	WebElement postalCode;

	@FindBy(css = "#continue")
	WebElement continueBtn;

	@FindBy(css = "#cancel")
	WebElement cancelBtn;

	@FindBy(css = ".error-message-container.error h3")
	WebElement missingFieldError;

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// fill info

	public void fillInfo(String firstName, String lastName, String postalCode) {

		fillText(this.firstName, firstName);
		fillText(this.lastName, lastName);
		fillText(this.postalCode, postalCode);

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// cancel button

	public void cancelBtn() {

		click(cancelBtn);
	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// continue button

	public void continueBtn() {

		click(continueBtn);
	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Validation

	// is checkout page

	public boolean isCheckOutPage() {

		if (checkoutTitle.isDisplayed()) {

			return true;

		}
		return false;

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Error missing first name

	public boolean missingFirstName() {

		if (missingFieldError.getText().equalsIgnoreCase("Error: First Name is required")) {

			return true;

		}
		return false;

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Error missing last name

	public boolean missingLastName() {

		if (missingFieldError.getText().equalsIgnoreCase("Error: Last Name is required")) {

			return true;

		}
		return false;

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Error missing postal code

	public boolean missingPostalCode() {

		if (missingFieldError.getText().equalsIgnoreCase("Error: Postal Code is required")) {

			return true;

		}
		return false;

	}

}
