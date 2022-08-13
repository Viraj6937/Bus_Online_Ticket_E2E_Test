package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Passenger_Details_Page_Object {

	public WebDriver driver;
	
	private By fullNameField = By.cssSelector("div#content > div > section > div > div.content-wrapper > div > div.form-group > input.payment_textName");
	
	private By phoneField = By.cssSelector("div#content > div > section > div > div.content-wrapper > div > div.flex-xs-column > div.payment_phoneLogin > div > input.payment_txtPhoneLogin");
	
	private By emailField = By.cssSelector("div#content > div > section > div > div.content-wrapper > div > div.flex-xs-column > div.pl-2.p-xs-0.flex-grow-1.w-100 > div > input.payment_txtEmail");
	
	private By nextButton = By.cssSelector("div#content > div > section > div > div.text-center.mt-4.mb-3 > a#btnNext");
	
	
	public Passenger_Details_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getFullNameField() {
		return driver.findElement(fullNameField);
	}
	
	public WebElement get_phone_Field() {
		return driver.findElement(phoneField);
	}
	
	public WebElement get_email_Field() {
		return driver.findElement(emailField);
	}
	
	public WebElement get_next_Button() {
		return driver.findElement(nextButton);
	}
	
	public void get_passenger_payment_details(String fullname, String phone, String email) {
		
		this.getFullNameField().clear();
		this.getFullNameField().sendKeys(fullname);
		this.get_phone_Field().clear();
		this.get_phone_Field().sendKeys(phone);
		this.get_email_Field().clear();
		this.get_email_Field().sendKeys(email);
		this.get_next_Button().click();
	}
	
}
