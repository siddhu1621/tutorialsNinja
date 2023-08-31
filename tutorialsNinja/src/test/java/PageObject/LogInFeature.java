package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInFeature {

	public WebDriver ldriver;
	
	public LogInFeature(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id="input-email")
	WebElement email;
	
	@FindBy (id="input-password")
	WebElement password;
	
	@FindBy (xpath="//input[@value=\"Login\"]")
	WebElement LogInBtn;
	
	@FindBy (xpath = "(//a[contains(.,'Forgotten')])[1]")
	WebElement FrgPwd;
	
	@FindBy (xpath = "(//a[.='Logout'])[2]")
	WebElement LogOut;
	
	@FindBy (xpath = "//a[.='Phones & PDAs']")
	WebElement phone;
	
	@FindBy (xpath = "(//a[.='Register'])[2]")
	WebElement register;
	
	@FindBy (xpath = "//a[.='login page']")
	WebElement loginpg;
	
	
	////
	@FindBy (xpath = "(//a[@class='dropdown-toggle'])[1]")
	public WebElement myaccdrop;
	
	public void clickMyaccdrop() {
		myaccdrop.click();
	}
	
	@FindBy (xpath = "//a[.='Login']" )
	public WebElement loginOption;
	
	public void loginOption() {
		loginOption.click();
	}
	
	////
	
	public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLogInBtn() {
		LogInBtn.click();
	}
	
	public void ClickOnFrgpwd() {
		FrgPwd.click();
	}
	
	public void ClickOnLogOutBtn() {
		LogOut.click();
	}
	
	public void ClickOnPhoneMdl() {
		phone.click();
	}
	
	public void ClickOnRegister() {
		register.click();
	}
	
	public void ClickOnLogInPg() {
		loginpg.click();
	}
}
