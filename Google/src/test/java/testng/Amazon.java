package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	public static WebDriver driver;

	// launch the application
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.get("https:www.amazon.com");
	}

	public void tearDownBrowser() {
		driver.quit();
	}

//		public static void main(String[] args) {
//			Amazon amazon = new Amazon();
//			amazon.launchApplication();
//			amazon.tearDownBrowser();
//		}
	@Test
	public void searchItem(String item) {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(item);
		search.sendKeys(Keys.ENTER);

	}

	@Test
	public void buyAFirstProduct() {
		launchApplication();
		searchItem("Shoes");
		WebElement selectItem = driver.findElement(By.className("s-image"));
		selectItem.click();
		WebElement selectSize = driver.findElement(By.className("WebElement selectItem = driver.findElement(By.className(\"s-image\"));"));
		selectSize.click();
		WebElement clickSize = driver.findElement(By.className("WebElement selectSize = driver.findElement(By.id(\"WebElement selectItem = driver.findElement(By.className(\\\"s-image\\\"));\"));"));
		clickSize.click();
		WebElement addToCart = driver.findElement(By.className("submit.add-to-cart"));
		addToCart.click();
		tearDownBrowser();


	}

	
			

	@Test
	public void buyASecondProduct() {
		launchApplication();
		searchItem("Watch");
		tearDownBrowser();
	}

	@Test(groups = { "regression" })
	public void test10() {
		System.out.println("This is tenth test ............");
	}

}
