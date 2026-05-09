package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigFileReader;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	
	@Test
	public void testValidLogin() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.enterUserName(ConfigFileReader.getProperty("username"));
		loginPage.enterPassword(ConfigFileReader.getProperty("password"));
		loginPage.clickLoginButton();
		Thread.sleep(60);
		System.out.println("Title of the page is - " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
}
