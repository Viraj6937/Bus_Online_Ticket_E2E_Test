package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing_Page_Object {

	public WebDriver driver;
	
	private By fromField = By.cssSelector("div#content > div > div.general-search-wrapper > div.container > div.new-search > div.d-flex.date-selection-group > div > div.input-group > input#txtOriginGeneral");
	
	private By destinationField = By.cssSelector("div#content > div > div.general-search-wrapper > div.container > div.new-search > div.d-flex.date-selection-group > div > div.input-group > input#txtDestinationGeneral");
	
	private By departureDate = By.cssSelector("div#content > div > div.general-search-wrapper > div.container > div.new-search > div.d-flex.date-selection-group > div > div.input-group > input#txtDepartDateBooking");
	
	private By calenderYear_And_Month = By.cssSelector("div#ui-datepicker-div > div");
	
	private By search_bus_submit = By.cssSelector("div#content > div > div.general-search-wrapper > div.container > div.new-search > div.form-group > input#btnBusSearchNewGeneral");

    public Landing_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	this.driver = driver;
	}

	public void get_source_field(String source) {
		
	  driver.findElement(fromField).click();
   
	   List<WebElement> sourceType = driver.findElements(By.cssSelector("div#divFromList > ul > li"));
		for(int i=0; i< sourceType.size();i++) {
			String sourceTypeVal = sourceType.get(i).getText();
			if(sourceTypeVal.contains("Popular")) {
				int rowIndex1= sourceType.size() - 18;
				List<WebElement> popularSource = driver.findElements(By.cssSelector("div#divFromList > ul > li:nth-Child("+rowIndex1+") > ul > li"));
				for(int j=0; j<popularSource.size();j++) {
					String popularSourceVal = popularSource.get(j).getText();
					if(popularSourceVal.contains(source)) {
						int rowIndex2 = popularSource.size()-5;
						driver.findElement(By.cssSelector("div#divFromList > ul > li:nth-Child("+rowIndex1+") > ul > li:nth-Child("+rowIndex2+") > div")).click();
					}
					break;
				}
			}
			break;
		}
    }
 
	
    public void get_destination_field(String destination) {
    	  
    	List<WebElement> destinationType = driver.findElements(By.cssSelector("div#divToList > ul > li"));
  		for(int i=0; i< destinationType.size();i++) {
  			String sourceTypeVal = destinationType.get(i).getText();
  			if(sourceTypeVal.contains("Popular")) {
  				int rowIndex1= destinationType.size() - 9;
  				List<WebElement> popularDestination = driver.findElements(By.cssSelector("div#divToList > ul > li:nth-Child("+rowIndex1+") > ul > li"));
  				for(int j=0; j<popularDestination.size();j++) {
  					String popularSourceVal = popularDestination.get(j).getText();
  					if(popularSourceVal.contains(destination)) {
  						int rowIndex2 = popularDestination.size()-1;
  						driver.findElement(By.cssSelector("div#divToList > ul > li:nth-Child("+rowIndex1+") > ul > li:nth-Child("+rowIndex2+") > div")).click();
  					}
  					
  					break;
  				}
  			}
  			break;
  		}
    }
    
    public WebElement get_departure_date_field() {
    	return driver.findElement(departureDate);
    }
    
    public void get_select_date(String month_year) {
    	
     String dateVal = driver.findElement(calenderYear_And_Month).getText();
     if(dateVal.contains("August 2022")) {
        driver.findElement(By.cssSelector("div#ui-datepicker-div > div > a[data-handler='next']")).click();
        List<WebElement> rowList = driver.findElements(By.cssSelector("div#ui-datepicker-div > table > tbody > tr"));
        for(int i=0; i<rowList.size();i++) {
        	String day = rowList.get(i).getText();
        	if(day.contains("20")) {
        		int rowIndex = rowList.size() - 1;
        		driver.findElement(By.cssSelector("div#ui-datepicker-div > table > tbody > tr:nth-Child("+rowIndex+") > td:nth-Child(3) > a")).click();
        	}
        }
     }
   }
    
    public WebElement get_search_bus_submit_button() {
    	return driver.findElement(search_bus_submit);
    }
    
}

