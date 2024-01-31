package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.aboutPage;
import PageObjects.loginPage;

public class TestAboutPage extends baseTest {

	// Click on the “Try it free” button

	@Test
	public void tc_01_tryItFree() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu mp = new Menu(driver);
		mp.aboutoption();
		aboutPage ap = new aboutPage(driver);
		ap.tryItFree();
		Assert.assertTrue(ap.isTryItFreeTitlePage());
		driver.navigate().back();
		driver.navigate().refresh();

	}

	// Click on the “Request a Demo” button

	@Test
	public void tc_02_requestAdemo() {

		aboutPage ap = new aboutPage(driver);
		ap.requestAdemo();
		String actual = ap.isRequestAdemoPage();
		String expected = "Let us know what you’re looking for, and we’ll be in touch soon. Our experts can show you how Sauce Labs helps increase development velocity, reduce application risk, and deliver seamless customer experiences.";
		Assert.assertEquals(actual, expected);

	}

}
