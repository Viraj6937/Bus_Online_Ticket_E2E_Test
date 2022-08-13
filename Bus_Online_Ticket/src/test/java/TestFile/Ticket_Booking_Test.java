package TestFile;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObject.Bus_And_Seat_Reservation_Page_Object;
import PageObject.Landing_Page_Object;
import PageObject.Passenger_Details_Page_Object;
import PageObject.Payment_Page_Object;
import Resources.Base;

public class Ticket_Booking_Test extends Base {

	Landing_Page_Object lpo;
	Bus_And_Seat_Reservation_Page_Object bsp;
	Passenger_Details_Page_Object ppo;
	Payment_Page_Object po;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	/*
	 * 1. Hit the mentioned url
	 * 2. Select source as Cameron Highlands and destination as Kaula Lumpur 
	 * 3. Select date as 20th of next month
	 * 4. Search for a bus 
	 * 5. Select the seats for the bus with least adult cost (Do not use the sort button) and Select max of 6
          seats or all seats if less than 6 in the layout
	 * 6. Click on Proceed 
	 * 7. Enter Personal Details 
	 * 8. Click on proceed to payment (Do not choose any payment type) and Assert for the Alert pop up
          and print the alert message.
	 * 	  
	 */
	
	
	@BeforeMethod
	public void navigateUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
        driver.manage().deleteAllCookies();
		log.info("all cookies have deleted");
		
        driver.get(prop.getProperty("url"));
        log.info("redirected to site url");
        
        driver.manage().window().maximize();
        log.info("browser window is been maximized");
	}
	
	@Test(dataProvider="busdetails")
	public void assessment(String source, String destination, String departureDate,String busFare, String fullname, String phone, String email) throws InterruptedException {

	     lpo = new Landing_Page_Object(driver);
	     bsp = new Bus_And_Seat_Reservation_Page_Object(driver);	
	     ppo = new Passenger_Details_Page_Object(driver);
	     po = new Payment_Page_Object(driver);
	     
	     
		try {
			
			//select source
			lpo.get_source_field(source);
			log.info("source is selected as "+source);
			
			//select destination
			lpo.get_destination_field(destination);
			log.info("destination is selected as "+destination);
			
			//select departure date
			lpo.get_select_date(departureDate);	
			log.info("departure date is selected as "+departureDate);
			
		}
		catch(Exception e) {
			
			//click search submit
			lpo.get_search_bus_submit_button().click();
			log.info("search submit button is been clicked");
		}
		
		//select bus
         bsp.getBusSelect(busFare);
		 log.info("bus is selected, the bus fare amount is atleast "+busFare);
         
		//select seat, will throw an error if seats are less than 6
        bsp.get_select_bus_seat();
        log.info("bus seat is selected");
		
		//proceed to payment
		  bsp.get_proceed_with_payment().click();
	      log.info("user is proceed to payment page");
	      
		//add passenger details
		ppo.get_passenger_payment_details(fullname,phone,email);
		log.info("passenger details entered are "+"fullname: "+fullname+" phone: "+phone+" email: "+email);
		
		//with entering payment type click on proceed to pay, Assert for the Alert pop up and print the alert message.
		  
		po.getProceedToPaymentButton().click();
		log.info("proceed to payment submit button is been clicked");
		
		String alertText = po.getAlertWindowText().getText();
		System.out.println(alertText);
		Assert.assertEquals(alertText,"Please select a payment method");
		log.info("alert text is displayed as: "+alertText);
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quite");
	}
	

	@DataProvider(name="busdetails")
	public Object[][] getData(){
		Object[][] data = new Object[1][7];
		data[0][0] = "Cameron Highlands";
	    data[0][1] = "Kuala Lumpur"; 
		data[0][2] = "August 2022";
		data[0][3] = "RM 35.00";
		data[0][4] = "Viraj D. Utekar";
		data[0][5] = "9292929292";
		data[0][6] = "utekar29viraj@gmail.com";
		return data;
	}
	
}
