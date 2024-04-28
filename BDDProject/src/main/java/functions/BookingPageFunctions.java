package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPageFunctions extends CommonFunctions  {
	public BookingPageFunctions(WebDriver driver) {
		super(driver);
	}
	private By basic = By.xpath("//div[@id='grid-row-0-fare-cell-desktop-BE']/div/div[2]");
	
    public void selectBasic() throws InterruptedException {
    	Thread.sleep(10000);
    	WebElement clickBasic = driver.findElement(basic);
    	waitForElement(clickBasic);
    	clickBasic.click();
    }
}
