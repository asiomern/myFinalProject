package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.footer;
import PageObjects.loginPage;

public class TestFooterSocialMedia extends baseTest {

	// enter to LinkEdin link

	@Test
	public void tc_01_linkedin() {
		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		footer f = new footer(driver);
		Assert.assertTrue(f.validateLinkedin());

	}

	// enter to facebook link

	@Test
	public void tc_02_facebook() {
		footer f = new footer(driver);
		Assert.assertTrue(f.validateFacebook());

	}

	// enter to twitter link

	@Test
	public void tc_03_twitter() {

		footer f = new footer(driver);
		Assert.assertTrue(f.validateTwitter());

	}

}
