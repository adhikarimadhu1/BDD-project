package com.automation.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectImp {
	public static WebDriver driver;

	// launch the application
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://demo.guru99.com/test/newtours/register.php");
	}

	public void tearDownBrowser() {
		driver.quit();
	}

	public void enterContactInfo() {
		WebElement FirstName = driver.findElement(By.name("firstName"));
		FirstName.sendKeys("ABC");
		WebElement LastName = driver.findElement(By.name("lastName"));
		LastName.sendKeys("XYZ");
		WebElement PhoneNumber = driver.findElement(By.name("phone"));
		PhoneNumber.sendKeys("1348999657");

	}

	 public void Email() {
	 WebElement email = driver.findElement(By.name("userName"));
	 email.sendKeys("xyzbvhb@gmail.com");
	 }
	public void EnterMailingInformation() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement Address = driver.findElement(By.name("address1"));
		Address.sendKeys("133 tikkar");
		WebElement City = driver.findElement(By.name("city"));
		City.sendKeys("Butwal");
		WebElement State = driver.findElement(By.name("state"));
		State.sendKeys("VA");
		WebElement PostalCode = driver.findElement(By.name("postalCode"));
		PostalCode.sendKeys("1344224");

	}

	public void selectCountry(String countryName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement clickDropdown = driver.findElement(By.name("country"));
		Select select = new Select(clickDropdown);
		select.selectByValue(countryName);
	}

	public void UserInformation() {
		WebElement UserName = driver.findElement(By.name("email"));
		UserName.sendKeys("AMD");
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys("jhfkhg");
		WebElement ConfirmPassword = driver.findElement(By.name("confirmPassword"));
		ConfirmPassword.sendKeys("jhfkhg");

	}
	public void submit() {
		WebElement submit = driver.findElement(By.name("submit"));
				submit.click();
	}

	public static void main(String[] args) throws InterruptedException {
		SelectImp selectImp = new SelectImp();

		// first test
		selectImp.launchApplication();
		selectImp.enterContactInfo();
		 selectImp.Email();
		selectImp.EnterMailingInformation();
		selectImp.selectCountry("NEPAL");
		selectImp.UserInformation();
		selectImp.submit();
		Thread.sleep(3000);
		selectImp.tearDownBrowser();

		// second test
		// selectImp.launchApplication();
		// selectImp.selectCountry("NIGERIA");
		// Thread.sleep(3000);
		
		// selectImp.tearDownBrowser();

	}

}
