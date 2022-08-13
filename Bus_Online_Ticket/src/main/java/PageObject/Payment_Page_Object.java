package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Payment_Page_Object {

	public WebDriver driver;
	
	private By proceedToPaymentSubmitButton = By.cssSelector("div.payment-section > div.enterdetailscenter > input[value='Proceed to Payment']");
	
	private By alertWindowText = By.cssSelector("div.offer-trip-overlay > div.offer-trip-wrapper > div > div.text-semibold");
	
	private By alertWindowOk = By.cssSelector("div.offer-trip-overlay > div.offer-trip-wrapper > div > div.cta-buttons > a#btn-alert-okay");
	
	
	public Payment_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getProceedToPaymentButton() {
		return driver.findElement(proceedToPaymentSubmitButton);
	}
	
	public WebElement getAlertWindowText() {
		return driver.findElement(alertWindowText);
	}
	
	public WebElement getAlertWindowOK() {
		return driver.findElement(alertWindowOk);
	}
}
