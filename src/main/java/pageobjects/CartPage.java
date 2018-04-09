package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;

	public void clickOn_Cart() {
		btn_Cart.click();
	}

	public void clickOn_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}