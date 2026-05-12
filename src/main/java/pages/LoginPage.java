package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage {
	
	protected static final Logger log = LogManager.getLogger(LoginPage.class);
//	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement textBox_Login;

	@FindBy(name = "password")
	WebElement textBox_Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_Login;


	public void enterUserName(String userName) {

		textBox_Login.clear();
		log.info("Clear Value");
		textBox_Login.sendKeys(userName);
		log.info("Enter UserName - " + userName);

	}

	public void enterPassword(String password) {

		textBox_Password.clear();
		log.info("Clear Value");
		textBox_Password.sendKeys(password);
		log.info("Enter Password - " + password);
	}

	public void clickLoginButton() {
		btn_Login.click();
		log.info("Login Button Clicked...");

	}

}
