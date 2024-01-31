package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.checkOutPage;
import PageObjects.loginPage;
import PageObjects.myCartPage;
import PageObjects.overViewPage;
import PageObjects.productsPage;
import PageObjects.thankYouPage;

public class TestThankYouPage extends baseTest {

	// Click back home button

	@Test

	public void backHome() {

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
		ovp.finishBtn();
		thankYouPage typ = new thankYouPage(driver);
		typ.backHomeBtn();
		pp= new productsPage(driver);
		Assert.assertTrue(pp.isProductsPage());

	}

}
