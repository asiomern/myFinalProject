package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class productsPage extends basePage {

	public productsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#root .title")
	WebElement title;

	@FindBy(css = ".inventory_item_name")
	WebElement proName;

	@FindBy(css = ".btn_small.btn_inventory ")
	WebElement addToCartBtn;

	@FindBy(css = ".inventory_item_name")
	WebElement productNameCart;

	@FindBy(css = "#remove-sauce-labs-onesie")
	WebElement removeBtn;

	@FindBy(css = ".product_sort_container")
	WebElement filterBtn;

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Enter to Product page

	public void enterProductpage(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equalsIgnoreCase(productName)) {

				list.get(i).click();
				break;
			}

		}

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Add Product to cart

	public void addToCart(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));

		for (WebElement el : list) {

			WebElement productTitle = el.findElement(By.cssSelector(".inventory_item_name"));
			if (productTitle.getText().equalsIgnoreCase(productName)) {

				el.findElement(By.cssSelector(".btn_small.btn_inventory")).click();

			}

		}

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////
	// Remove product from cart

	public void removeFromCart(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));

		for (WebElement el : list) {

			WebElement productTitle = el.findElement(By.cssSelector(".inventory_item_name"));
			if (productTitle.getText().equalsIgnoreCase(productName)) {

				el.findElement(By.cssSelector(".btn_small.btn_inventory")).click();

			}

		}

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Sorting

	// Sorting A to Z

	public void sortingAtoZ() {

		Select sortSelect = new Select(filterBtn);
		sleep(500);
		sortSelect.selectByValue("az");

	}

	// Sorting Z to A

	public void sortingZtoA() {

		Select sortSelect = new Select(filterBtn);
		sleep(500);
		sortSelect.selectByValue("za");

	}

	// Sorting Low to High

	public void sortLowToHigh() {

		Select sortSelect = new Select(filterBtn);
		sleep(500);
		sortSelect.selectByValue("lohi");

	}

	// Sorting High to Low

	public void sortHighToLow() {

		Select sortSelect = new Select(filterBtn);
		sleep(500);
		sortSelect.selectByValue("hilo");

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Validation
	// is Producats page

	public boolean isProductsPage() {

		if (title.getText().equalsIgnoreCase("products")) {

			return true;
		}
		return false;

	}
///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// if the product situated on cart

	public String productInCart() {

		return productNameCart.getText();

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// if the product was removed from cart

	public boolean removeProductValdiation(String product) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));

		for (WebElement el : list) {

			WebElement productTitle = el.findElement(By.cssSelector(".inventory_item_name"));

			if (productTitle.getText().equalsIgnoreCase(product)) {

				if (removeBtn.isDisplayed()) {
					return true;

				}

			}

		}
		return false;

	}
///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// is Sort A to Z

	public boolean isSortAtoZ() {

		if (proName.getText().equalsIgnoreCase("Sauce Labs Backpack")) {

			return true;

		}
		return false;

	}

	// is Sort Z to A

	public boolean isSortZtoA() {

		if (proName.getText().equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")) {

			return true;

		}
		return false;

	}

	// is Sorting Low to High

	public boolean isSortLowToHigh() {

		if (proName.getText().equalsIgnoreCase("Sauce Labs Onesie")) {

			return true;

		}
		return false;

	}

	// is Sorting High to Low

	public boolean isSortHighToLow() {

		if (proName.getText().equalsIgnoreCase("Sauce Labs Fleece Jacket")) {

			return true;

		}
		return false;

	}

}
