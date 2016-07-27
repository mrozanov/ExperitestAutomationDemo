package com.experitest.auto;

import org.junit.Test;

/**
*
*/
public class MyFirstTest extends TestBase {

	@Test
	public void testUntitled() {
		app.launch();
		app.login("company", "company");
		app.makePayment("123456", "guy", 10, "Greece");
		app.logout();
		
	}

	@Override
	public String getTestName() {

		return "MyFirstTest";
	}

}
