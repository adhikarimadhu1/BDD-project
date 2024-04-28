package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
	public static WebDriver driver;
	 
	@Before
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
 
	}
 
	@After
	public void tearDownBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
