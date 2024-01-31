package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class overViewPage extends basePage {

	public overViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.summary_info > div:nth-child(1)")
	WebElement overViewTitle;

	@FindBy(css = "#cancel")
	WebElement cancelBtn;

	@FindBy(css = "#finish")
	WebElement finishBtn;;

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// click cancel button

	public void cancelBtn() {

		click(cancelBtn);
	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// click finish button

	public void finishBtn() {

		click(finishBtn);
	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// enter to product page

	public void enterProductPage(String productName) {

		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
		for (WebElement el : list) {

			if (el.getText().equalsIgnoreCase(productName)) {

				el.click();

			}

		}

	}

///////////////////////
///////////////////////
//:)                 //
///////////////////////
///////////////////////

	// Validation

	// is overView page

	public boolean isOverViewPage() {

		if (overViewTitle.getText().equalsIgnoreCase("Payment Information")) {

			return true;

		}
		return false;

	}

}
