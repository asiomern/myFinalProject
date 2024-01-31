package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Menu;
import PageObjects.loginPage;
import PageObjects.productPage;
import PageObjects.productsPage;

public class TestProductsPage extends baseTest {

	// Add product to cart

	@Test
	public void tc_01_addToCart() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		productsPage pp = new productsPage(driver);
		pp.addToCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		String actual = pp.productInCart();
		String expected = "Sauce Labs Onesie";
		Assert.assertEquals(actual, expected);
		driver.navigate().back();
	}

	// Remove product from cart

	@Test
	public void tc_02_removeFromCart() {
		productsPage pp = new productsPage(driver);
		pp.removeFromCart("Sauce Labs Onesie");
		Menu mp = new Menu(driver);
		mp.enterCart();
		productPage prp = new productPage(driver);
		driver.navigate().back();
		Assert.assertTrue(prp.isProductRemovedFromCart("Sauce Labs Onesie"));
		

	}

	// Enter to product page

	@Test
	public void tc_03_productPage() {
		productsPage pp = new productsPage(driver);
		pp.enterProductpage("Test.allTheThings() T-Shirt (Red)");
		productPage prp = new productPage(driver);
		String actual = prp.isProductPage();
		String expected = "Test.allTheThings() T-Shirt (Red)";
		Assert.assertEquals(actual, expected);
		driver.navigate().back();

	}

	// Sorting A to Z

	@Test
	public void tc_04_sortAtoZ() {
		productsPage pp = new productsPage(driver);

		pp.sortingAtoZ();
		Assert.assertTrue(pp.isSortAtoZ());

	}

	// Sorting Z to A

	@Test

	public void tc_05_sortZtoA() {

		productsPage pp = new productsPage(driver);

		pp.sortingZtoA();
		Assert.assertTrue(pp.isSortZtoA());

	}

	// Sorting Low to High

	@Test
	public void tc_06_sortLowtoHigh() {

		productsPage pp = new productsPage(driver);

		pp.sortLowToHigh();
		Assert.assertTrue(pp.isSortLowToHigh());

	}

	// Sorting High to Low

	@Test
	public void tc_07_sortHightoLow() {

		productsPage pp = new productsPage(driver);

		pp.sortHighToLow();
		Assert.assertTrue(pp.isSortHighToLow());

	}

}
