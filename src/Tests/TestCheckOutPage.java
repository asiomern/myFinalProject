package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.checkOutPage;
import PageObjects.loginPage;
import PageObjects.myCartPage;
import PageObjects.overViewPage;
import PageObjects.productsPage;

public class TestCheckOutPage extends baseTest {

	// Click continue with valid details

	@Test

	public void tc_01_validInfo() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		productsPage pp = new productsPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.checkOut();
		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		overViewPage ovp = new overViewPage(driver);
		Assert.assertTrue(ovp.isOverViewPage());
		driver.navigate().back();

	}

	// Click continue with blank First name field

	@Test

	public void tc_02_blankFirstName() {
		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("", "Nuralian", "12345");
		cop.continueBtn();
		Assert.assertTrue(cop.missingFirstName());
		driver.navigate().refresh();

	}

	// Checkout with blank Last name name field

	@Test

	public void tc_03_blankLastName() {
		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("Asi", "", "12345");
		cop.continueBtn();
		Assert.assertTrue(cop.missingLastName());
		driver.navigate().refresh();
	}

	// Checkout with blank Postal code field

	@Test

	public void tc_04_blankPostalCode() {

		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "");
		cop.continueBtn();
		Assert.assertTrue(cop.missingPostalCode());
		driver.navigate().refresh();

	}

}
