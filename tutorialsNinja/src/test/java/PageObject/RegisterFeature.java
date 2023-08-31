package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterFeature {

	public WebDriver ldriver;
	
	public RegisterFeature (WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy (id="input-firstname")
	WebElement firstname;
	
	@FindBy (id="input-lastname")
	WebElement lastname;
	
	@FindBy (id="input-email")
	WebElement emailAdd;
	
	@FindBy (id="input-telephone")
	WebElement telephone;
	
	@FindBy (id="input-password")
	WebElement password;
	
	@FindBy (id="input-confirm")
	WebElement confirmpwd;
	
	@FindBy (xpath = "(//input[@name='newsletter'])[1]")
	WebElement NLYes;
	
	@FindBy (xpath = "(//input[@name='newsletter'])[2]")
	WebElement NLNo;
	
	@FindBy (xpath = "//input[@name='agree']")
	WebElement checkBox;
	
	@FindBy (xpath = "//input[contains(@class,'btn-primary')]")
	WebElement continueBtn;
	
	public void EnterFirstName(String firstName) {
		firstname.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName) {
		lastname.sendKeys(lastName);
	}
	
	public void EnterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void EnterTelephone(String number) {
		telephone.sendKeys(number);
	}
	
	public void EnterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void EnterCnfPwd(String cnfpwd) {
		confirmpwd.sendKeys(cnfpwd);
	}
	
	public void N_Yes() {
		NLYes.click();
	}
	
	public void N_NO() {
		NLNo.click();
	}
	
	public void PrivacyCheckBox() {
		checkBox.click();
	}
	
	public void ClickOnContinueBtn() {
		continueBtn.click();
	}
}
