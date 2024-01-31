package PageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class footer extends basePage {

	public footer(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "li.social_twitter > a")
	WebElement twitterBtn;

	@FindBy(css = ".r-1ny4l3l > div > div.css-175oi2r.r-1awozwy.r-18u37iz.r-1wbh5a2 > div > div > div > span")
	WebElement twitterTitle;

	@FindBy(css = " .social_linkedin > a")
	WebElement linkedinBtn;

	@FindBy(css = "#organization_guest_contextual-sign-in-modal-header")
	WebElement linkedinTitle;

	@FindBy(css = "li.social_facebook > a")
	WebElement facebookBtn;

	@FindBy(css = ".xqfms19 > span > span")
	WebElement facebookTitle;

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Enter to twitter social media link

	public void twitterLink() {

		click(twitterBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Enter to linkedin social media link
	public void linkedinLink() {

		click(linkedinBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Enter to facebook social media link

	public void facebookLink() {

		click(facebookBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Validation

	// validate that its on facebook site

	public boolean validateFacebook() {

		click(facebookBtn);

		String main = driver.getWindowHandle();

		Set<String> list = driver.getWindowHandles();

		for (String win : list) {
			driver.switchTo().window(win);

		}

		sleep(2000);
		if (facebookTitle.getText().equalsIgnoreCase("Connect with Sauce Labs on Facebook")) {
			driver.switchTo().window(main);

			return true;
		}
		return false;

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// validate that its on LinkEdin site

	public boolean validateLinkedin() {

		click(linkedinBtn);

		String main = driver.getWindowHandle();

		Set<String> list = driver.getWindowHandles();

		for (String win : list) {
			driver.switchTo().window(win);

		}
		sleep(2000);
		if (linkedinTitle.getText().equalsIgnoreCase("Sign in to see who you already know at Sauce Labs")) {
			driver.switchTo().window(main);

			return true;

		}
		return false;

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// validate that its on Twitter site

	public boolean validateTwitter() {

		click(twitterBtn);
		String main = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();

		for (String win : list) {
			driver.switchTo().window(win);

		}

		sleep(2000);
		if (twitterTitle.getText().equalsIgnoreCase("@saucelabs")) {
			driver.switchTo().window(main);

			return true;

		}
		return false;

	}

}
