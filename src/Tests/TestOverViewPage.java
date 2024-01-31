package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.checkOutPage;
import PageObjects.loginPage;
import PageObjects.myCartPage;
import PageObjects.overViewPage;
import PageObjects.productPage;
import PageObjects.productsPage;
import PageObjects.thankYouPage;

public class TestOverViewPage extends baseTest {

	// Click cancel

	@Test

	public void clickCancel() {

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
		ovp.cancelBtn();
		pp = new productsPage(driver);
		Assert.assertTrue(pp.isProductsPage());

	}

	// Click finish

	@Test

	public void clickFinish() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.checkOut();
		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		overViewPage ovp = new overViewPage(driver);
		ovp.finishBtn();
		thankYouPage tp = new thankYouPage(driver);
		Assert.assertTrue(tp.isThankYouPage());

	}

	// Click on product

	@Test

	public void clickOnProduct() {

		Menu mp = new Menu(driver);
		mp.allItemsOption();
		productsPage pp = new productsPage(driver);
		pp.addToCart("Sauce Labs Bolt T-Shirt");
		mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.checkOut();
		checkOutPage cop = new checkOutPage(driver);
		cop.fillInfo("Asi", "Nuralian", "12345");
		cop.continueBtn();
		overViewPage ovp = new overViewPage(driver);
		ovp.enterProductPage("Sauce Labs Bolt T-Shirt");
		productPage prp = new productPage(driver);
		String actual = prp.isProductPage();
		String expected = "Sauce Labs Bolt T-Shirt";
		Assert.assertEquals(actual, expected);

	}

}
