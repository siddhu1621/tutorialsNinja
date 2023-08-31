package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFeature {

	public WebDriver ldriver;
	
	public SearchFeature(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//input[contains(@class,'form-control')]")
	WebElement SearchField;
	
	@FindBy (xpath = "//button[contains(@class,'btn-default btn-lg')]")
	WebElement SearchBtn;
	
	public void SearchBox(String product) {
		SearchField.sendKeys(product);
	}
	
	public void ClickOnSearchBtn() {
		SearchBtn.click();
	}
	
}
