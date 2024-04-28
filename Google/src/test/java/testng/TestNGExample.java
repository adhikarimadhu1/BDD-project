package testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGExample {
	@Test(priority = 2)
	public void test1() {
		System.out.println("This is my first test.........");
	}

	@Test(priority = 1)
	public void test2() {
		System.out.println("This is my second test........");
	}

	@Test(priority = 0)

	public void test4() {
		System.out.println("This is my fourth test.........");
	}

	@Test(groups = { "smoke" })
	public void test5() {
		System.out.println("This is my fifth test.........");
	}

	@Test(groups = { "regression" })
	public void test6() {
		System.out.println("This is my sixth test.........");
	}

	@Test(groups = { "smoke" })
	public void test7() {
		System.out.println("This is my seventh test.........");
	}

	@Test(groups = { "regression" })
	public void test8() {
		System.out.println("This is my eighth test.........");
	}

	@Test(groups = { "regression" })
	public void test9() {
		System.out.println("This is my ninth test.........");
	}

	@Parameters({ "url" })
	@Test
	public void usingParam(String url) {
		System.out.println(url);
		//if(url.equals("https//www.amazon.com")) {
		//	Reporter.log("the url matched.......");
		//}else {
			//Reporter.log("the url did not match.......");
			//Assert.assertTrue(false);
		//}
		Assert.assertEquals("https://www.google.com", url);

	}

	@Parameters({ "url", "username" })
	@Test
	public void usingParamSecond(String url, String userName) {
		System.out.println(url);
		System.out.println(userName);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstUserName";
		data[0][1] = "firstPassword";
		data[1][0] = "secondUserName";
		data[1][1] = "secondPassword";
		data[2][0] = "thirdUserName";
		data[2][1] = "thirdPassword";
		return data;
	}

	@Test(dataProvider = "getData")
	public void readData(String username, String password) {
		System.out.println(username);
		System.out.println(password);

	}
	

}
