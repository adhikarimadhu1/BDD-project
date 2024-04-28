package com.automation.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunction {
	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://www.google.com"); // hit the url

		WebElement searchBar = driver.findElement(By.id("APjFqb"));
		searchBar.sendKeys("where is mount everest located");
		searchBar.sendKeys(Keys.ENTER);
		// WebElement playVideo = driver.findElement(By.linkText("Mount Everest -
		// National Geographic Society"));
		// playVideo.click();

		driver.navigate().back();
		WebElement about = driver.findElement(By.className("MV3Tnb"));
		System.out.println(about.getText());
		about.click();
		driver.navigate().back();
		WebElement store = driver.findElement(By.linkText("Store"));
		store.click();
		driver.navigate().back();
		WebElement gmail = driver.findElement(By.className("gb_H"));
		gmail.click();
		driver.navigate().back();

		Thread.sleep(5000);

		driver.quit(); // close/quit the browser/session
		// /html/body/div[1]/div[1]/a[1]
		// /html/body/div[1]/div[1]/a[1]

//		/html/bodydiv[1]/div[6]/div[1]/div[1]/a[3] -- absolute xpath
		// //div[1]/div[1]/a[3] -- relative xpath
		// (//a[@class='pHiOh'])[1]
		// (//a[contains(@class,'pHi')])[1]
////a[contains(text(),'Advertising')]
	}

}
