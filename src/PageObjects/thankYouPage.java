package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class thankYouPage extends basePage {

	public thankYouPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#back-to-products")
	WebElement backHomeBtn;

	@FindBy(css = ".complete-header")
	WebElement thankYouTitle;

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// click back home button

	public void backHomeBtn() {

		click(backHomeBtn);
	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Validation

	// is thank you page

	public boolean isThankYouPage() {

		if (thankYouTitle.getText().equalsIgnoreCase("Thank you for your order!")) {

			return true;

		}
		return false;

	}

}
