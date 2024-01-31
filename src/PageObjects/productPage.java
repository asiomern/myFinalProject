package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends basePage {

	public productPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#back-to-products")
	WebElement backToProductsBtn;

	@FindBy(css = ".inventory_details_name.large_size")
	WebElement productTitle;

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// back to products page

	public void backToProductsPage() {

		click(backToProductsBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Add to cart

	public void addToCart(String productName) {
		driver.findElement(By.cssSelector("#add-to-cart-" + productName + "")).click();
		;

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// remove from cart

	public void removeFromCart(String productName) {

		driver.findElement(By.cssSelector("#remove-" + productName + "")).click();

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Valdiation

	// is a producat page

	public String isProductPage() {

		return productTitle.getText();

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// is product removed from cart

	public boolean isProductRemovedFromCart(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".cart_list #item_1_title_link"));

		for (WebElement el : list) {

			if (el.getText().equalsIgnoreCase(productName)) {

				return false;

			}

		}
		return true;

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// is product added to cart

	public boolean isProductAddedToCart(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".cart_list #item_1_title_link"));

		for (WebElement el : list) {

			if (el.getText().equalsIgnoreCase(productName)) {

				return true;

			}

		}
		return false;

	}

}
