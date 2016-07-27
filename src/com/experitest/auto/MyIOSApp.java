package com.experitest.auto;

import com.experitest.client.Client;

public class MyIOSApp implements MyApp {
	private Client client;
	public MyIOSApp(Client client) {
		this.client = client;
	}
	@Override
	public void launch() {
		client.startStepsGroup("launch");
		client.launch("com.experitest.ExperiBank", true, true);
	}

	@Override
	public void login(String username, String password) {
		client.startStepsGroup("login " + username);
		client.elementSendText("NATIVE", "placeholder=Username", 0, username);
		client.elementSendText("NATIVE", "placeholder=Password", 0, password);
		client.click("NATIVE", "text=Login", 0, 1);
		
	}

	@Override
	public void makePayment(String phone, String username, int amount, String country) {
		client.startStepsGroup("make payment");
		client.click("NATIVE", "text=Make Payment", 0, 1);
		client.elementSendText("NATIVE", "placeholder=Phone", 0, phone);
		client.elementSendText("NATIVE", "placeholder=Name", 0, username);
		client.elementSendText("NATIVE", "placeholder=Amount", 0, "" + amount);
		client.click("NATIVE", "text=Select", 0, 1);
		client.click("NATIVE", "text=" + country, 0, 1);
		client.click("NATIVE", "text=Send Payment", 0, 1);
		client.click("NATIVE", "text=Yes", 0, 1);
		
	}

	@Override
	public void logout() {
		client.startStepsGroup("logout");
		client.click("NATIVE", "text=Logout", 0, 1);

	}

}
