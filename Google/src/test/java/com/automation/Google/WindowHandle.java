package com.automation.Google;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	public static WebDriver driver;

	// launch the application
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://demo.guru99.com/popup.php");
	}

	public void tearDownBrowser() {
		driver.quit();
	}

	public void clickClickhere() {
		WebElement clickHere = driver.findElement(By.linkText("Click Here"));
		clickHere.click();
	}

	public void handleWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);

				WebElement email = driver.findElement(By.name("emailid"));
				email.sendKeys("hello@gmail.com");
				WebElement submit = driver.findElement(By.name("btnLogin"));
				submit.click();
				driver.close();

			}
		}
		driver.switchTo().window(mainWindow);
	}

	public static void main(String[] args) {
		WindowHandle windowHandle = new WindowHandle();
		windowHandle.launchApplication();
		windowHandle.clickClickhere();
		windowHandle.handleWindow();
		windowHandle.tearDownBrowser();
	}

}
