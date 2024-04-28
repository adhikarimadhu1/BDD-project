package com.automation.Google;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitImp {
	public static WebDriver driver;
	// launch the application
		public void launchApplication() {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); // maximize the window
			driver.get("https://www.delta.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
 
		public void tearDownBrowser() {
			driver.quit();
		}
		
		public void selectTrip() {
			WebElement oneway = driver.findElement(By.id("selectTripType-val"));
			oneway.click();
		}
		
		@Test
		public void buyATicket() {
			launchApplication();
			selectTrip();
			tearDownBrowser();
		}
		
		public void explitcitWait() {
			
			WebElement elm = driver.findElement(By.id(""));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
		}
		
		public void fluentWait() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
 
			WebElement clickseleniumlink =  wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id(""));
	}});
			
		}


}
