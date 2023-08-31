package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	
	public static WebDriver driver=null;

	public static void initializeBrowser(String browserName){
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
