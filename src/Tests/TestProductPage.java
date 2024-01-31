package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.loginPage;
import PageObjects.myCartPage;
import PageObjects.productPage;
import PageObjects.productsPage;

public class TestProductPage extends baseTest {

	// back to products page

	@Test
	public void tc_01_backToProductsPage() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		productsPage pp = new productsPage(driver);
		pp.enterProductpage("Sauce Labs Bolt T-Shirt");
		productPage prp = new productPage(driver);
		prp.backToProductsPage();
		pp = new productsPage(driver);
		pp.isProductsPage();
		Assert.assertTrue(pp.isProductsPage());

	}

	// Add to cart product

	@Test
	public void tc_02_addToCart() {
		productsPage pp = new productsPage(driver);
		pp.enterProductpage("Sauce Labs Bolt T-Shirt");
		productPage prp = new productPage(driver);
		prp.addToCart("sauce-labs-bolt-t-shirt");
		Menu mp = new Menu(driver);
		mp.enterCart();
		prp = new productPage(driver);
		Assert.assertTrue(prp.isProductAddedToCart("Sauce Labs Bolt T-Shirt"));
		driver.navigate().back();

	}

	// remove product from cart

	@Test
	public void tc_03_removeFromCart() {

		productPage prp = new productPage(driver);

		prp.removeFromCart("sauce-labs-bolt-t-shirt");
		Menu mp = new Menu(driver);
		mp.enterCart();
		prp = new productPage(driver);
		Assert.assertTrue(prp.isProductRemovedFromCart("Sauce Labs Bolt T-Shirt"));
		driver.navigate().back();

	}

	// enter to the cart page

	@Test

	public void tc_04_enterCartPage() {

		Menu mp = new Menu(driver);
		mp.enterCart();
		myCartPage mcp = new myCartPage(driver);
		String actual = mcp.isCartPage();
		String expected = "Description";
		Assert.assertEquals(actual, expected);

	}

}
