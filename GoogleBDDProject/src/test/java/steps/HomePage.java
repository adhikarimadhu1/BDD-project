package steps;

import java.io.IOException;
import java.time.Duration;

import Functions.HomePageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import library.PropertiesManager;

public class HomePage {
	HomePageFunctions homePageFunctions = new HomePageFunctions(BaseTest.driver);
	PropertiesManager pro = new PropertiesManager();

	@Given("The user launch the application")
	public void the_user_launches_the_application() throws IOException {
		BaseTest.driver.get(pro.getPropertyValue("url"));
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Then("The User Select Search Bar")
	public void The_User_Select_Search_Bar() {
		homePageFunctions.selectSearchBar();
	}
}
