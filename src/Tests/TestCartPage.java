package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Menu;
import PageObjects.checkOutPage;
import PageObjects.loginPage;
import PageObjects.myCartPage;
import PageObjects.productPage;
import PageObjects.productsPage;

public class TestCartPage extends baseTest {

	// checkOut with empty cart

	@Test
	public void tc_01_checkOutEmptyCart() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.checkOut();
		checkOutPage cop = new checkOutPage(driver);
		Assert.assertTrue(cop.isCheckOutPage());
		driver.navigate().back();

	}

	// continue shopping

	@Test

	public void tc_02_continueShopping() {

		myCartPage mcp = new myCartPage(driver);
		mcp.continueShopping();
		productsPage pp = new productsPage(driver);
		Assert.assertTrue(pp.isProductsPage());

	}

	// remove product

	@Test

	public void tc_03_removeProduct() {
		productsPage pp = new productsPage(driver);
		pp.addToCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.removeProduct("sauce-labs-onesie");
		productPage prp = new productPage(driver);
		Assert.assertTrue(prp.isProductRemovedFromCart("sauce-labs-onesie"));
		driver.navigate().back();

	}

	// Enter to product page via the product name on the cart product list

	@Test

	public void tc_04_enterProductPage() {
		productsPage pp = new productsPage(driver);
		pp.addToCart("Sauce Labs Bike Light");
		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		mcp.enterProductPage("Sauce Labs Bike Light");
		productPage prp = new productPage(driver);
		String actual = prp.isProductPage();
		String expected = "Sauce Labs Bike Light";
		Assert.assertEquals(actual, expected);

	}
}
