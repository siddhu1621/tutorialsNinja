package StepDefinitions;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import PageObject.RegisterFeature;
import Utilities.baseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends baseClass {

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		RegisterFea = new RegisterFeature(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		RegisterFea.EnterFirstName(dataMap.get("firstName"));
		RegisterFea.EnterLastName(dataMap.get("lastName"));
		RegisterFea.EnterEmailAdd(dataMap.get(generateEmailId()));
		RegisterFea.EnterTelephone(dataMap.get("telephone"));
		RegisterFea.EnterPassword(dataMap.get("password"));
		RegisterFea.EnterCnfPwd(dataMap.get("password"));
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		RegisterFea.PrivacyCheckBox();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		RegisterFea.ClickOnContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[.='Success']")).isDisplayed());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		RegisterFea.N_Yes();
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		RegisterFea.EnterFirstName(dataMap.get("firstName"));
		RegisterFea.EnterLastName(dataMap.get("lastName"));
		RegisterFea.EnterEmailAdd(dataMap.get("email"));
		RegisterFea.EnterTelephone(dataMap.get("telephone"));
		RegisterFea.EnterPassword(dataMap.get("password"));
		RegisterFea.EnterCnfPwd(dataMap.get("password"));
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {

	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
	}

}