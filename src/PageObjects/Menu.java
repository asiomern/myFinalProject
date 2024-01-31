package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends basePage {

	public Menu(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "#react-burger-menu-btn")
	WebElement burgerBtn;

	@FindBy(css = "#about_sidebar_link")
	WebElement aboutOption;

	@FindBy(css = "div.MuiStack-root.css-1mvsri7 > div > div:nth-child(1) > h3")
	WebElement aboutTitle;

	@FindBy(css = "#logout_sidebar_link")
	WebElement logOut;

	@FindBy(css = "#inventory_sidebar_link")
	WebElement allItemsOption;

	@FindBy(css = ".shopping_cart_link")
	WebElement cartBtn;

	@FindBy(css = ".cart_desc_label")
	WebElement cartPageTitle;

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Burger Menu options

	// About option

	public void aboutoption() {

		click(burgerBtn);
		sleep(500);
		click(aboutOption);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Logout option

	public void logOut() {

		click(burgerBtn);
		sleep(500);
		click(logOut);

	}

///////////////////////
///////////////////////
//	    :)           //
///////////////////////
///////////////////////

	// All items option

	public void allItemsOption() {
		click(burgerBtn);
		sleep(500);
		click(allItemsOption);

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

	// Cart symbol

	// Enter to cart page

	// enter to cart

	public void enterCart() {

		click(cartBtn);

	}

	// Validation

	// is About page

	public String aboutValidation() {

		return aboutTitle.getText();

	}

///////////////////////
///////////////////////
//:)           //
///////////////////////
///////////////////////

// is Cart page

	public String isCartPage() {

		return cartPageTitle.getText();

	}

}
