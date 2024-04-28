package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFunctions {
	WebDriver driver;

	public HomePageFunctions(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.id("APjFqb");

	public void selectSearchBar() {
		WebElement clickSearch = driver.findElement(search);
		clickSearch.sendKeys("Where is nepal located");
		clickSearch.sendKeys(Keys.ENTER);

	}

}
