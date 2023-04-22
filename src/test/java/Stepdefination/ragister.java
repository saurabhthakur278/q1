package Stepdefination;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ragister {
WebDriver driver;

@Given("User navigates to Register Account page")
public void user_navigates_to_register_account_page() {
	driver=driverFactory.getDriver();
	 driver.findElement(By.xpath("//span[text()='My Account']")).click();
	  driver.findElement(By.linkText("Register")).click();

	
}

@When("User enters the details into below fields")
public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

	driver.findElement(By.cssSelector("#input-firstname")).sendKeys(dataMap.get("firstName"));
	driver.findElement(By.cssSelector("#input-lastname")).sendKeys(dataMap.get("lastName"));
	driver.findElement(By.cssSelector("#input-email")).sendKeys(dataMap.get("email"));
	driver.findElement(By.cssSelector("#input-telephone")).sendKeys(dataMap.get("telephone"));
	driver.findElement(By.cssSelector("#input-password")).sendKeys(dataMap.get("password"));
     driver.findElement(By.cssSelector("input-confirm")).sendKeys(dataMap.get("password"));
	
}

@When("User selects Privacy Policy")
public void user_selects_privacy_policy() {

driver.findElement(By.cssSelector("[name='agree']")).click();
	
}

@When("User clicks on Continue button")
public void user_clicks_on_continue_button() {


	driver.findElement(By.cssSelector("[value='Continue']")).click();
	
}

@Then("User account should get created successfully")
public void user_account_should_get_created_successfully() {

Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.cssSelector("#content h1")).getText());
}

@When("User selects Yes for Newsletter")
public void user_selects_yes_for_newsletter() {

driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]")).click();
	
}

@When("User enters the details into below fields with duplicate email")
public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

	driver.findElement(By.cssSelector("#input-firstname")).sendKeys(dataMap.get("firstName"));
	driver.findElement(By.cssSelector("#input-lastname")).sendKeys(dataMap.get("lastName"));
	driver.findElement(By.cssSelector("#input-email")).sendKeys(dataMap.get("email"));
	driver.findElement(By.cssSelector("#input-telephone")).sendKeys(dataMap.get("telephone"));
	driver.findElement(By.cssSelector("#input-password")).sendKeys(dataMap.get("password"));
     driver.findElement(By.cssSelector("input-confirm")).sendKeys(dataMap.get("password"));
	

	
}

@Then("User should get a proper warning about duplicate email")
public void user_should_get_a_proper_warning_about_duplicate_email() {

	Assert.assertTrue(driver.findElement(By.cssSelector(".alert-dismissible")).getText().contains("Warning: E-Mail Address is already registered!"));

	
}

@When("User dont enter any details into fields")
public void user_dont_enter_any_details_into_fields() {


	
}

@Then("User should get proper warning messages for every mandatory field")
public void user_should_get_proper_warning_messages_for_every_mandatory_field() {

Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("(//div[@class='text-danger'])[1]")).getText());

Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("(//div[@class='text-danger'])[2]")).getText());

Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("(//div[@class='text-danger'])[3]")).getText());

Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("(//div[@class='text-danger'])[4]")).getText());


Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("(//div[@class='text-danger'])[5]")).getText());




	
}


	
	
	
}
