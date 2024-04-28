package com.automation.Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunctionality {
	public static WebDriver driver;

	// launch the application
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.get("https://www.google.com");
	}

	public void tearDownBrowser() {
		driver.quit();
	}

	public void search(String searchValue, String text) throws InterruptedException {
		WebElement searchBar = driver.findElement(By.id("APjFqb"));
		searchBar.sendKeys(searchValue);
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> clickLink = driver.findElements(By.xpath("//div[@class='yuRUbf']/div/span/a/h3"));
		for (int i = 0; i < clickLink.size(); i++) {
			if (clickLink.get(i).getText().equals(text)) {
				clickLink.get(i).click();
				System.out.println("The expected link is clicked........");
				break;

			}
			// driver.navigate().back();
		}
	}

	public void about() {
		WebElement about = driver.findElement(By.className("MV3Tnb"));
		about.click();
		driver.navigate().back();
	}

	public void store() {
		WebElement store = driver.findElement(By.xpath("//div[@class='o3j99 n1xJcf Ne6nSd']//a[2]"));
		store.click();
		driver.navigate().back();
	}

	public void gmail() {
		WebElement gmail = driver.findElement(By.className("gb_H"));
		gmail.click();
		driver.navigate().back();
	}

	public void images() {
		WebElement images = driver.findElement(By.xpath("//div[@class='gb_Id gb_J gb_3f gb_Tf']//div[2]//a[1]"));
		images.click();
		driver.navigate().back();
	}

	public static void main(String[] args) throws InterruptedException {
		// first test
		SearchFunctionality searchFunctions = new SearchFunctionality();
		searchFunctions.launchApplication();
		searchFunctions.search("Where is mount everest located",
				"Mount Everest | Height, Location, Map, Facts, Climbers, & ...");
		driver.navigate().back();
		driver.navigate().back();
		searchFunctions.about();

		// searchFunctions.store();

		// searchFunctions.gmail();

		// searchFunctions.images();

		searchFunctions.tearDownBrowser();

		// second test
		// searchFunctions.launchApplication();
		// searchFunctions.search("Where is mount everest located", "Mount Everest -
		// National Geographic Society");
		// searchFunctions.tearDownBrowser();

	}

}
