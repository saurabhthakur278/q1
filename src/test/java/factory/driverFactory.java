package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {
	static WebDriver driver=null;
	
	
	
	public static void initializebrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			 driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
	    driver= new FirefoxDriver();
		}
		
	}
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}
}
