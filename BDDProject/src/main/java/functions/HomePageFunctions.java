package functions;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import jdk.javadoc.doclet.Reporter;
import library.YamlHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageFunctions extends CommonFunctions {
	// WebDriver driver;

	public HomePageFunctions(WebDriver driver) {
		super(driver);
	}

	YamlHelper yamlHelper = new YamlHelper();
	CommonFunctions commonFunctions = new CommonFunctions(driver);
	private By trip = By.id("selectTripType-val");
	private By tripType = By.xpath("//ul[@id='selectTripType-desc']/li");
	private By fromAirport = By.id("fromAirportName");
	private By orig = By.id("search_input");
	private By toAirport = By.id("toAirportName");
	private By passenger = By.id("passengers-val");
	private By numOfPassenger = By.xpath("//ul[@id = 'passengers-desc']/li");
	private By date = By.id("calDepartLabelCont");
	private By departDate = By.xpath("(//table)[2]/tbody/tr[4]/td[2]");
	private By returnDate = By.xpath("(//table)[2]/tbody/tr[4]/td[5]");
	private By done = By.className("donebutton");
	private By search = By.id("btn-book-submit");
	private By selectAirport = By.xpath("//div[@class='search-result-container']/div/ul/li/a");

	public void selectTrip(String trips) {
		try {
			WebElement clicktripType = driver.findElement(trip);
			clicktripType.click();
			List<WebElement> selectTrip = driver.findElements(tripType);
			for (int i = 0; i < selectTrip.size(); i++) {
				String tripTypeText = selectTrip.get(i).getText();
				// System.out.println(tripTypeText);
				if (tripTypeText.equals(trips)) {
					// System.out.println("after condition" + tripTypeText);

					selectTrip.get(i).click();
					// System.out.println("Clicked.......");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	public void selectOriginDestination(String key, String origin, String dest)
			throws FileNotFoundException, InterruptedException {
		WebElement fromAir = driver.findElement(fromAirport);
		fromAir.click();

		WebElement org = driver.findElement(orig);
		org.clear();
		commonFunctions.waitForElement(org);
		String oriData = yamlHelper.getFinalData(Integer.valueOf(key)).get(origin);
		org.sendKeys(oriData);
		//org.sendKeys(Keys.RETURN);
		WebElement clickAirport = driver.findElement(selectAirport);
		clickAirport.click();

		WebElement toAir = driver.findElement(toAirport);
		// toAir.click();
		commonFunctions.clickElement(toAir);
		WebElement desti = driver.findElement(orig);
		commonFunctions.waitForElement(desti);
		desti.clear();
		String destData = yamlHelper.getFinalData(Integer.valueOf(key)).get(dest);
		desti.sendKeys(destData);
		WebElement clickAirportTo = driver.findElement(selectAirport);
		clickAirportTo.click();
		// desti.sendKeys(Keys.RETURN);

	}

	public void selectPassenger(String passengers) {
		try {
			WebElement selectPassengerType = driver.findElement(passenger);
			commonFunctions.clickElement(selectPassengerType);
			List<WebElement> selectPassenger = driver.findElements(numOfPassenger);
			for (int i = 0; i < selectPassenger.size(); i++) {
				String tripTypeText = selectPassenger.get(i).getText();
				if (tripTypeText.equals(passengers)) {
					commonFunctions.clickElement(selectPassenger.get(i));
					break;
				}
			}
			String passengerText = selectPassengerType.getText();
			//if(!passengers.equals(passengerText)) {
			//	Assert.assertTrue(false);
			//}
			Assert.assertEquals(passengerText, passengers);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}
//	public void handleCalendar(String dueMonth) {
//		   try {
//		      String currentMonth;
//		      //homePage.depart.click(); //WebElement depart = driver.findElement()
//		      //homePage.clearDate.click();
//		      //homePage.depart.click();
//		      while (true) {
//		         currentMonth = homePage.currentMonth.getText();
//		         if (currentMonth.equals(dueMonth)) {
//		            break;
//		         } else {
//		            executor("arguments[0].click()", homePage.nextMonthArrow);
//		            Thread.sleep(1000);
//		         }
//		      }
//		      currentDay();
//		   } catch (Exception e) {
//		      e.printStackTrace();
//		      Assert.assertTrue(false);
//		   }
//		}
//		public void handleDayCalendar(String dueDay) {
//		   try {
//		      if (homePage.day(dueDay).isDisplayed()) {
//		         homePage.day(dueDay).click();
//		         Reporter.log("Current day is selected", MessageTypes.Pass);
//		      } else {
//		         Reporter.log("Current day is not selected", MessageTypes.Fail);
//		         Assert.assertTrue(false);
//		      }
//		   } catch (Exception e) {
//		      e.printStackTrace();
//		      Assert.assertTrue(false);
//		   }
//		}
//		@QAFTestStep(description = "User select due date from calendar")
//		public void selectDueDate() {
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
//		   LocalDate month = LocalDate.now().plusDays(10);
//		   handleCalendar(dtf.format(month));
//		}
//		public void currentDay() {
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d");
//		   LocalDate day = LocalDate.now().plusDays(120);
//		   handleDayCalendar(dtf.format(day));
//		}
//		 
	public void selectDate() {
		WebElement clickDate = driver.findElement(date);
		clickDate.click();
		// click the arrow if we want to move to another month
 
		WebElement selectDepartDate = driver.findElement(departDate);
		selectDepartDate.click();
		WebElement selectReturnDate = driver.findElement(returnDate);
		selectReturnDate.click();
		WebElement clickDone = driver.findElement(done);
		commonFunctions.clickElement(clickDone);

 
	}
	public void selectSearch() {
		WebElement clickSearch = driver.findElement(search);
		commonFunctions.clickElement(clickSearch);
	}
}
