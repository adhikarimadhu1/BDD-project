package steps;

import functions.BookingPageFunctions;
import io.cucumber.java.en.Then;

public class BookingPage {
	BookingPageFunctions bookingPageFunction = new BookingPageFunctions(BaseTest.driver);

	@Then("The user select basic")
	public void the_user_select_basic() throws InterruptedException {
		bookingPageFunction.selectBasic();
	}
}
