package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import PageObject.SearchFeature;
import Utilities.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends baseClass {

	@Given("User opens the Application")
	public void user_opens_the_application() {
	   SearchFea = new SearchFeature(driver);
	   driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String prod) {
	    SearchFea.SearchBox(prod);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	  SearchFea.ClickOnSearchBtn();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	 Assert.assertTrue(driver.findElement(By.xpath("//a[.='HP LP3065']")).isDisplayed());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String prod1) {
	   SearchFea.SearchBox(prod1);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'There is no')]")).isDisplayed());
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	  
	}
	
}
