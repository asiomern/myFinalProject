package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.loginPage;
import PageObjects.productsPage;

public class TestLogin extends baseTest {

	// Login with a blank User name field
	@Test
	public void tc_01_blankUserNameField() {

		loginPage lp = new loginPage(driver);
		lp.login("","secret_sauce");
		String actual = lp.blankLoginFields();
		String expected = "Epic sadface: Username is required";
		Assert.assertEquals(actual, expected);
		driver.navigate().refresh();
		
		
	}

	
	// Login with a blank password field 
		@Test
		public void tc_02_blankPasswordField()  {

			loginPage lp = new loginPage(driver);
			lp.login("standard_user","");
			String actual = lp.blankLoginFields();
			String expected = "Epic sadface: Password is required";
			Assert.assertEquals(actual, expected);

		}

	
	// Login with a valid User name and wrong Password

	@Test
	public void tc_03_wrongPassLogin() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauc");
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.wrongUserNameOrPassError();
		Assert.assertEquals(actual, expected);

	}

	// Login with a wrong User name and a valid Password
	@Test
	public void tc_04_wrongUserNameLogin() {

		loginPage lp = new loginPage(driver);
		lp.login("Asi", "secret_sauce");
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String actual = lp.wrongUserNameOrPassError();
		Assert.assertEquals(actual, expected);

	}
	
	//Login with a capital letters on User name and password 
	
	@Test
	public void tc_06_capitalLettersLogin() {
		
	loginPage lp= new loginPage(driver);
	lp.login("STANDARD_USER", "SECRET_SAUCE");
	String actual = lp.wrongUserNameOrPassError();
	String expected = "Epic sadface: Username and password do not match any user in this service";
	Assert.assertEquals(actual, expected);
		
	}

	// Login with a wrong User name and wrong Password

	@Test
	public void tc_05_wrongPassAndUserName() {

		loginPage lp = new loginPage(driver);
		lp.login("Asi", "1234");
		String actual = lp.wrongUserNameOrPassError();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual, expected);

	}

	// Login with a valid User name and Password

	@Test
	public void tc_07_validLogin() {
		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		productsPage pp = new productsPage(driver);
		Assert.assertTrue(pp.isProductsPage());

	}
	
	
	


}
