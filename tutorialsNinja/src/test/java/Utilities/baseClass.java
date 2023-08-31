package Utilities;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.LogInFeature;
import PageObject.RegisterFeature;
import PageObject.SearchFeature;

public class baseClass {

	public static WebDriver driver;
	public LogInFeature LogInFea;
	public RegisterFeature RegisterFea;
	public SearchFeature SearchFea;
	public Properties Configprop;
	
	
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
