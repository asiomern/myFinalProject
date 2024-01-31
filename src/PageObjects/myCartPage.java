package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myCartPage extends basePage {

	public myCartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".cart_desc_label")
	WebElement cartPageTitle;

	@FindBy(css = "#checkout")
	WebElement checkoutBtn;

	@FindBy(css = "#continue-shopping")
	WebElement continueBtn;

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// checkOut button

	public void checkOut() {

		click(checkoutBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// continue shopping

	public void continueShopping() {

		click(continueBtn);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// enter to product page

	public void enterProductPage(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));

		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(productName)) {

				el.click();
				break;

			}
			

		}

	}
///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Remove product

	public void removeProduct(String productname) {

		driver.findElement(By.cssSelector("[name='remove-" + productname + "']")).click();

	}

	// Validation

	// is cart page

	public String isCartPage() {

		return cartPageTitle.getText();

	}

}
