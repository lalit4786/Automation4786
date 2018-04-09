package pageobjects;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;

public class HomePage {

	ConfigFileReader configFileReader = new ConfigFileReader();

	public void perform_Search(String search, WebDriver driver) {
		driver.navigate().to(configFileReader.getApplicationUrl() +"?s=" + search + "&post_type=product");
	}

	public void navigateTo_HomePage(WebDriver driver) {
		driver.get(configFileReader.getApplicationUrl());
	}
}
