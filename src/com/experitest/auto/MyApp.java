package com.experitest.auto;

public interface MyApp {

	void launch();

	void login(String username, String password);

	void makePayment(String phone, String username, int amount, String country);

	void logout();

}
