package page_object;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="surname")
	WebElement surnameField;
	@FindBy(id="first_name")
	WebElement first_nameField;
	@FindBy(id="last_name")
	WebElement last_nameField;
	@FindBy(id="email")
	WebElement emailField;
	@FindBy(id="role")
	WebElement roleDrp;
	@FindBy(id="username")
	WebElement usernameField;
	@FindBy(id="password")
	WebElement passwordField;
	@FindBy(id="confirm_password")
	WebElement confirm_passwordField;
	@FindBy(id="cmmsn_percent")
	WebElement cmmsn_percentField;
	@FindBy(id="submit_user_button")
	WebElement submit_user_buttonField;
	@FindBy(xpath="//a[@class=\"dropdown-toggle\"]")
	WebElement profile;
	@FindBy(xpath="//a[@class=\"btn btn-default btn-flat\" and text()=\"Sign Out\"]")
	WebElement signoutBtn;
	
	
	public void getSurname(String surname){
		surnameField.sendKeys(surname);
	}
	public void getFirstname(String first_name){
		first_nameField.sendKeys(first_name);
	}
	public void getLastname(String last_name){
		last_nameField.sendKeys(last_name);
	}
	public void getEmail(String email){
		emailField.sendKeys(email);
	}
	public void getUsername(String username){
		usernameField.sendKeys(username);
	}
	public void getPassword(String password){
		passwordField.sendKeys(password);
		confirm_passwordField.sendKeys(password);
	}
	public void getCmmsnpercent(String cmmsn_percent){
		cmmsn_percentField.sendKeys(cmmsn_percent);
	}
	public void getSelectRole() {
		PageUtility.selectByIndex(2, roleDrp);		
	}
	public void submitUser() {
		PageUtility.selectByIndex(2, roleDrp);	
		submit_user_buttonField.click();
	}
	public void signOut() {
		//call the wait utility
		WaitUtility.waitForElementClick(driver,profile);
		WaitUtility.waitForElementClick(driver,signoutBtn);
	}
}
