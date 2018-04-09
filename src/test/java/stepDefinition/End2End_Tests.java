package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import manager.PageObjectManager;
import manager.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.CheckOutPage;
import pageobjects.HomePage;
import pageobjects.ProductListingPage;

public class End2End_Tests {
	WebDriver driver;
	HomePage home;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		WebDriverManager webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		home = pageObjectManager.getPageInstance(HomePage.class);
		home.navigateTo_HomePage(driver);
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product) throws Throwable {
		home.perform_Search(product,driver);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		productListingPage = pageObjectManager.getPageInstance(ProductListingPage.class);
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		cartPage = pageObjectManager.getPageInstance(CartPage.class);
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		checkoutPage = pageObjectManager.getPageInstance(CheckOutPage.class);
		checkoutPage.fill_PersonalDetails();
	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
		checkoutPage.check_ShipToDifferentAddress(false);
	}

	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}

}
