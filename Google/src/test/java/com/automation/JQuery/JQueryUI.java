package com.automation.JQuery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryUI {
public static WebDriver driver;
	
	// launch the application
		public void launchApplication() {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); // maximize the window
			driver.get("https://jqueryui.com/");
		}
 
		public void tearDownBrowser() {
			driver.quit();
		}
		

		public void dragAndDropElmenet() throws InterruptedException {
			Actions actions = new Actions(driver);
			WebElement droppable = driver.findElement(By.xpath("(//div[@id='sidebar']//ul/li[2]/a)[1]"));
			droppable.click();
			driver.switchTo().frame(0); // it goes to the first iframe
			WebElement draggable = driver.findElement(By.id("draggable"));
			WebElement droppableElm = driver.findElement(By.id("droppable"));
			actions.dragAndDrop(draggable, droppableElm).build().perform();
			Thread.sleep(5000);
			driver.switchTo().defaultContent(); // it comes out of iframe
			
			//update the web element
			//actions.clickAndHold(droppable).build().perform();
			//actions.contextClick(droppableElm).build().perform();
			//actions.doubleClick(draggable).build().perform();
			//actions.dragAndDropBy(droppableElm, 100, 250).build().perform();
		}
		
		public void handleCheckbox(String location) throws InterruptedException {
			Actions actions = new Actions(driver);
			WebElement checkbox = driver.findElement(By.xpath("(//div[@id='sidebar']//ul)[2]/li[4]/a"));
			checkbox.click();
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			List<WebElement> clickButton = driver.findElements(By.xpath("//div/fieldset[1]/label"));
			for(int i = 0; i< clickButton.size(); i++) {
				if(clickButton.get(i).getText().equals(location)) {
					actions.click(clickButton.get(i)).build().perform();
					break;
				}
				
			}
		
			
			Thread.sleep(2000);
			
			
			
		}
		public void resize() {
			Actions actions = new Actions(driver);
			WebElement clickResizable = driver.findElement(By.xpath("(//div[@id='sidebar']//ul/li[3]/a)[1]"));
			clickResizable.click();
			driver.switchTo().frame(0);
			WebElement arrow = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
			actions.clickAndHold(arrow).moveByOffset(50, 50).release().build().perform();
	 
		}
		
		
		public static void main(String[] args) throws InterruptedException {
			JQueryUI jQueryUI = new JQueryUI();
			
			//first test
			//jQueryUI.launchApplication();
			//jQueryUI.dragAndDropElmenet();
			//jQueryUI.tearDownBrowser();
			
			//second test
			//jQueryUI.launchApplication();
			//jQueryUI.handleCheckbox("Paris");
			//jQueryUI.tearDownBrowser();
			
			//second test
			jQueryUI.launchApplication();
			jQueryUI.resize();
			Thread.sleep(2000);
			jQueryUI.tearDownBrowser();
		}	

}
