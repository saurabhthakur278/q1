package Stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;

public class search {
	WebDriver driver;

@Given("User opens the Application")
public void user_opens_the_application() {
   driver= driverFactory.getDriver();
	
}

@When("User enters valid product {string} into Search box field")
public void user_enters_valid_product_into_search_box_field(String productname) {
driver.findElement(By.cssSelector(".form-control")).sendKeys(productname);
	
}

@When("User clicks on Search button")
public void user_clicks_on_search_button() {
    driver.findElement(By.cssSelector(".btn-default")).click();
}

@Then("User should get valid product displayed in search results")
public void user_should_get_valid_product_displayed_in_search_results() {
Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
}

@When("User enters invalid product {string} into Search box field")
public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
    
	driver.findElement(By.cssSelector(".form-control")).sendKeys(invalidproduct);
	
}

@Then("User should get a message about no product matching")
public void user_should_get_a_message_about_no_product_matching() {

Assert.assertEquals("There is no product that matches the search criteria.", "//p[contains(text(),'There is no product that matches the search criter')]");
}

@When("User dont enter any product name into Search box field")
public void user_dont_enter_any_product_name_into_search_box_field() {

}


}
