package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bus_And_Seat_Reservation_Page_Object {
	
	public WebDriver driver;

  private By bus_list = By.cssSelector("div#content > div > div.layout.container > div#ContentPlaceHolder1_divResult > div > div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr");
	
  private By proceed_button = By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td:nth-Child(2) > input[value='Proceed']");
	
  
  
  public Bus_And_Seat_Reservation_Page_Object(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  this.driver = driver;
}


public void getBusSelect(String busFare) {
		//select bus
		List<WebElement> busList = driver.findElements(bus_list);
		for(int i=0; i<busList.size();i++) {
			String busListVal = busList.get(i).getText();
			if(busListVal.contains(busFare)) {
				int rowIndex = busList.size() - 13;
				driver.findElement(By.cssSelector("div#content > div > div.layout.container > div#ContentPlaceHolder1_divResult > div > div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child("+rowIndex+") > td:nth-Child(6) > a.btn.btn-orange.selectseatbutton")).click();
			}
			break;
		}
  }
  

 public void get_select_bus_seat() {
		List<WebElement> busSeatList = driver.findElements(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr"));
	  	
		for(int i=0; i < busSeatList.size();i++) {
	        String seatNumberText1 = busSeatList.get(i).getText();
	        if(seatNumberText1.contains("21")) {
	        	int rowIndex1 = busSeatList.size()-4;
	            driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex1+") > td:nth-Child(2) > div")).click();
	        }
	  	 }
	  	
	  	for(int j=0; j < busSeatList.size();j++) {
	  		String seatNumberText2 = busSeatList.get(j).getText();
	  		if(seatNumberText2.contains("24")) {
	  			int rowIndex2 = busSeatList.size()-4;
	  			driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex2+") > td:nth-Child(3) > div")).click();
	  		}
	  	}
	  	
	  	for(int k=0; k < busSeatList.size();k++) {
	  		String seatNumberText3 = busSeatList.get(k).getText();
	  		if(seatNumberText3.contains("27")) {
	  			int rowIndex3 = busSeatList.size()-4;
	  			driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex3+") > td:nth-Child(4) > div")).click();
	  		}
	  	}
	  	
	  	
		for(int l=0; l< busSeatList.size();l++) {
	  		String seatNumberText4 = busSeatList.get(l).getText();
	  		if(seatNumberText4.contains("11")) {
	  		   int rowIndex4 = busSeatList.size()-3;	
	  		   driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex4+") > td:nth-Child(4) > div")).click();
	  		}
	  	}
	  	
	  	for(int m=0; m< busSeatList.size();m++) {
	  		String seatNumberText5 = busSeatList.get(m).getText();
	  		if(seatNumberText5.contains("14")) {
	  		   int rowIndex5 = busSeatList.size()-3;
	  		   driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex5+") > td:nth-Child(5) > div")).click();
	  		}
	  	}
	  	
	  	for(int n=0; n< busSeatList.size();n++) {
	       String seatNumberText6 = busSeatList.get(n).getText();
	       if(seatNumberText6.contains("17")) {
	    	   int rowIndex6 = busSeatList.size()-3;
	    	   driver.findElement(By.cssSelector("div#divDesktopView > div > div#divdepart > div.tab-content > div > table > tbody > tr:nth-Child(2) > td > div.businnerdiv > table > tbody > tr > td > div > table > tbody > tr:nth-Child("+rowIndex6+") > td:nth-Child(6) > div")).click();
	       }
	    }
	  	
 }

  public WebElement get_proceed_with_payment() {
  	return driver.findElement(proceed_button);
  }
	
}
