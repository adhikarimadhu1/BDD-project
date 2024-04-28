package com.automation.Google;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertImp {
	public static WebDriver driver;
	// launch the application
		public void launchApplication() {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); // maximize the window
			driver.get("https://demo.guru99.com/test/delete_customer.php");
		}
 
		public void tearDownBrowser() {
			driver.quit();
		}
		
		public void handleAlert() {
			WebElement custId = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));
			custId.sendKeys("1234");
			WebElement submit = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/input[1]"));
			submit.click();
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
			
			
		}
		
		public void takeScreenshot() throws IOException {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("resources/screenshot.png"));
 
		}
		
		public static void main(String[] args) throws InterruptedException, IOException {
			AlertImp alertImp = new AlertImp();
			alertImp.launchApplication();
			alertImp.handleAlert();
			alertImp.takeScreenshot();
			Thread.sleep(3000);
			alertImp.tearDownBrowser();
		}

}
