package steps;

import java.io.IOException;
import java.time.Duration;

import functions.HomePageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import library.PropertiesManager;

public class HomePage {
	
HomePageFunctions homePageFunctions = new HomePageFunctions(BaseTest.driver);
PropertiesManager pro = new PropertiesManager ();
	
	@Given("The user launch the application")
	public void the_user_launches_the_application() throws IOException {
		BaseTest.driver.get(pro.getPropertyValue("url"));
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	@Then("The user select trip type {string}")
	public void the_user_select_trip_type(String trip) {
		homePageFunctions.selectTrip(trip);
		
	

}
	@Then("The user {string} select origin {string} and destination {string}")
	public void the_user_select_origin_and_destination(String key, String org, String dest) throws Exception {
		homePageFunctions.selectOriginDestination(key, org, dest);
 
	}
   @Then("The user select passenger {string}")
    public void the_user_select_passenger(String passenger) {
	   homePageFunctions.selectPassenger(passenger);
   }
   @Then("The user select date")
   public void the_user_select_date() {
	   homePageFunctions.selectDate();
   }
   @Then("The user select search")
   public void the_user_select_search() {
	   homePageFunctions.selectSearch();
   }
}