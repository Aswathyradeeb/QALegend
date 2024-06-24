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
	List<WebElement> roleDrp;
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
	
	public void addUser(String surname,String first_name,String last_name,String email,String username,String password,String cmmsn_percent) {
		surnameField.sendKeys(surname);
		first_nameField.sendKeys(first_name);
		surnameField.sendKeys(surname);
		last_nameField.sendKeys(last_name);
		emailField.sendKeys(email);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		confirm_passwordField.sendKeys(password);
		cmmsn_percentField.sendKeys(cmmsn_percent);
		
		submit_user_buttonField.click();
		//Assert using search
	}
	
	public void signOut() {
		//call the wait utility
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signoutBtn)).click();
	}
}
