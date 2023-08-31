package MyHooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;

	@Before
	public void setup() {
		DriverManager.initializeBrowser("chorme"); 
		driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
}
