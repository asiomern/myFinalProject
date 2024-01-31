package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class basePage {

	WebDriver driver;

	public basePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//Selenium Actions

// Click

	public void click(WebElement el) {

		el.click();

	}

	// Filling text

	public void fillText(WebElement el, String text) {

		
		el.clear();
		el.sendKeys(text);

	}

	public void sleep(long time) {

		try {
			Thread.sleep(time);

		} catch (Exception e) {
		}
	}

}
