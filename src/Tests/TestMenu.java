package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.loginPage;
import PageObjects.productsPage;

public class TestMenu extends baseTest {

	// enter to about option
	@Test
	public void tc_01_enterAboutPage() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu bm = new Menu(driver);
		bm.aboutoption();
		String actual = bm.aboutValidation();
		String expected = "CASE STUDIES";
		Assert.assertEquals(actual, expected);
		driver.navigate().back();
	}

	// Back to All Items page

	@Test

	public void tc_02_backToAllItems() {
		productsPage pp = new productsPage(driver);
		pp.enterProductpage("Sauce Labs Fleece Jacket");
		Menu bm = new Menu(driver);
		bm.allItemsOption();
		pp = new productsPage(driver);
		Assert.assertTrue(pp.isProductsPage());

	}

	// Enter to cart page

	@Test
	public void tc_03_enterToCartPage() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		String actual= mp.isCartPage();
				String expected= "Description";
		Assert.assertEquals(actual, expected);

	}

	// logging out

	@Test
	public void tc_04_logOut() {
		Menu bm = new Menu(driver);
		bm.logOut();
		loginPage lp = new loginPage(driver);
		String actual = lp.logOutValidation();
		String expected = "Accepted usernames are:";
		Assert.assertEquals(actual, expected);

	}

}
