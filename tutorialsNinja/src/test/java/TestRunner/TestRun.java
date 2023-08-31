package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".//Features//LogIn.feature",
		glue = "StepDefinitions",
		dryRun = false,
		monochrome = true,
		tags = "@smoke",
		plugin = {"pretty","html:target/cucumber.reports.html"}
		
		)

public class TestRun {

}
