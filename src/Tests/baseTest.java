package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseTest {

	WebDriver driver;

	@BeforeClass
	public void setup()  {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		

	}

	@AfterClass
	
	public void thirDown() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();

	}
	
	
	
	

}
