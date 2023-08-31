package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Driver.DriverManager;
import MyHooks.Hooks;
import PageObject.LogInFeature;
import Utilities.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInSteps extends baseClass {

	@Before
	public void Setup() throws IOException {
		Configprop = new Properties();
		FileInputStream ConfigPropFile = new FileInputStream("config.properties");
		Configprop.load(ConfigPropFile);

		String br = Configprop.getProperty("browser");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@After
	public void teardown(Scenario sc) {
		String name = sc.getName().replaceAll(" ", "_");
		if (sc.isFailed()) {
			TakesScreenshot scrShot = (TakesScreenshot) driver;

			// to attach failed scenarios ss to report data type should be byte[]
			byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);

			// to directly attach to report
			sc.attach(SrcFile, "image/png", name);

		}

		driver.quit();
	}

	//////////////////// HOOKS ENDS/////////////////////////

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws InterruptedException {
		LogInFea = new LogInFeature(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(Configprop.getProperty("url"));
		Thread.sleep(2000);
		LogInFea.clickMyaccdrop();
		Thread.sleep(1000);
		LogInFea.loginOption();
		Thread.sleep(2000);
	}

//	@When("^User enters valid email address(.*) into email field$")
//	public void user_enters_valid_email_address_amotooricap1_gmail_com_into_email_field(String username)
//			throws InterruptedException {
//		LogInFea.enterEmail(username);
//		Thread.sleep(2000);
//	}

	
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String username) {
		LogInFea.enterEmail(username);
	}
	
	@When("^User enters valid password (.*) into password field$")
	public void user_enters_valid_password_into_password_field(String password) throws InterruptedException {
		LogInFea.enterPassword(password);
		Thread.sleep(2000);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		LogInFea.clickOnLogInBtn();
		Thread.sleep(15000);
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'Account')])[3]")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() throws InterruptedException {
		LogInFea.enterEmail(generateEmailId() + "#@^&@gmail.com");
		Thread.sleep(2000);
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String pwd) throws InterruptedException {
		LogInFea.enterPassword(pwd);
		Thread.sleep(2000);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() throws InterruptedException {
		Thread.sleep(2000);
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Given("User should get Forgotten Password link is available on loginpage")
	public void user_should_get_forgotten_password_link_is_available_on_loginpage() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'Forgotten')])[1]")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User clicks on Forgotten Password link")
	public void user_clicks_on_forgotten_password_link() throws InterruptedException {
		LogInFea.ClickOnFrgpwd();
		Thread.sleep(2000);
	}

	@Then("User should taken to Forgotten Password Page")
	public void user_should_taken_to_forgotten_password_page() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'Forgot Your Password?')]")).isDisplayed());
		Thread.sleep(2000);
	}

	@Then("user should get proper placeholders for E-Mail Address and Password text fields")
	public void user_should_get_proper_placeholders_for_e_mail_address_and_password_text_fields()
			throws InterruptedException {
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[contains(@placeholder,'E-Mail Address')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Password']")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User clicks on browser back button")
	public void user_clicks_on_browser_back_button() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@When("User clicks on browser forward button")
	public void user_clicks_on_browser_forward_button() throws InterruptedException {
		driver.navigate().forward();
		Thread.sleep(2000);
	}

	@When("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		LogInFea.ClickOnLogOutBtn();
		Thread.sleep(2000);
	}

	@Then("User should not get loggedin again")
	public void user_should_not_get_loggedin_again() throws InterruptedException {
		Assert.assertFalse(driver.findElement(By.xpath("//a[contains(.,'Edit your account')]")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User closes the browser without logging out his account")
	public void user_closes_the_browser_without_logging_out_his_account() throws InterruptedException {
		driver.close();
		Thread.sleep(2000);
	}

	@When("User again navigates to url")
	public void user_again_navigates_to_url() throws InterruptedException {
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(2000);
	}

	@When("User clicks on Phones module")
	public void user_clicks_on_phones_module() throws InterruptedException {
		LogInFea.ClickOnPhoneMdl();
		Thread.sleep(2000);
	}

	@Then("User should navigates to Phones page")
	public void user_should_navigates_to_phones_page() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Phones & PDAs']")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("User clicks on Register link")
	public void user_clicks_on_register_link() throws InterruptedException {
		LogInFea.ClickOnRegister();
		Thread.sleep(2000);
	}

	@Then("User should navigates to Register account page")
	public void user_should_navigates_to_register_account_page() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[.='Register Account']")).isDisplayed());
		Thread.sleep(2000);
	}

	@Then("User click on login page link")
	public void user_click_on_login_page_link() throws InterruptedException {
		LogInFea.ClickOnLogInPg();
		Thread.sleep(2000);
	}

	@Then("User should navigate to login page")
	public void user_should_navigate_to_login_page() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Returning Customer']")).isDisplayed());
		Thread.sleep(2000);
	}

}