package Stepdefination;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;

public class login {
	
	WebDriver driver;
	


	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=driverFactory.getDriver();
	  driver.findElement(By.xpath("//span[text()='My Account']")).click();
	  driver.findElement(By.linkText("Logi")).click();
		
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailtext) {

driver.findElement(By.cssSelector("#input-email")).sendKeys(emailtext);
		
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passtext) {
		driver.findElement(By.cssSelector("#input-password")).sendKeys(passtext);


		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {

driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

   Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidemail) {

		driver.findElement(By.cssSelector("#input-email")).sendKeys(invalidemail);
		
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidtpass) {

		driver.findElement(By.cssSelector("#input-password")).sendKeys(invalidtpass);

		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {


		
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {

		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-dismissible")).getText().contains("  Warning: No match for E-Mail Address and/or Password."));

		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		driver.findElement(By.cssSelector("#input-email")).sendKeys("");
		
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		driver.findElement(By.cssSelector("#input-password")).sendKeys("");


		
	}

	
	
}
