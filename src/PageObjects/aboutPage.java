package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class aboutPage extends basePage {

	public aboutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".css-chbenk > div:nth-child(1) > a > button")
	WebElement tryItFreeBtn;

	@FindBy(css = ".MuiButton-outlinedSizeMedium.MuiButton-disableElevation.css-hy804n")
	WebElement requestAdemo;

	@FindBy(css = ".index_submain__tLoEr h1")
	WebElement tryItFreeTitle;

	@FindBy(css = ".MuiTypography-root.MuiTypography-body2.css-mpn3ah")
	WebElement demoTitle;

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Try it free button

	public void tryItFree() {

		click(tryItFreeBtn);

	}

	// Request a Demo button

	public void requestAdemo() {

		click(requestAdemo);

	}

	// Validation

	// is try it free page

	public boolean isTryItFreeTitlePage() {

		if (tryItFreeTitle.getText().equalsIgnoreCase("Start testing in minutes")) {

			return true;

		}
		return false;
	}

	// is request a Demo page

	public String isRequestAdemoPage() {

		
		sleep(1000);
		return demoTitle.getText();

	}

}
