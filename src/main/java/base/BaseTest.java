package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigFileReader;

public class BaseTest {
	protected WebDriver driver; // protected is because the driver can be used in package and in the sub-classes
	protected static final Logger log = LogManager.getLogger(BaseTest.class);
	@BeforeMethod
	public void setUp() {
		try {
			log.info("Set Up method Starts...");
			String URL = ConfigFileReader.getProperty("url");
			String browser = System.getProperty("browser");

			if (browser.equalsIgnoreCase("chrome")) {
				log.info("Set Up chrome browser...");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				driver.get(URL);
			}
			if (browser.equalsIgnoreCase("firefox")) {
				log.info("Set Up Firefox browser...");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				driver.get(URL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		log.info("Exection Stops...");
	}
}
