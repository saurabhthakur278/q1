package hooks;


import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Myhooks {
	

	WebDriver driver;
	
	
	@Before
	public void setup() {
		driverFactory.initializebrowser("Chrome");
		driver=driverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("http://www.tutorialsninja.com/demo/");
		
	}
	@After
	public void teardown() {
		driver.close();
	}
}
