package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	HomePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement userNameField;
	@FindBy(xpath="//a[@class='btn btn-default btn-flat' and text()='Profile']")
	WebElement profileButton;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endTourButton;
	@FindBy(id="first_name")
	WebElement firstNameField;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement profileUpdate;
	@FindBy(xpath="//span[@class='title' and text()='User Management']")
	WebElement userManagementClick;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement userClick;
	@FindBy(xpath="//a[@class=\"btn btn-block btn-primary\"]")
	WebElement addUserButton;
	public String getUserName() {
		return userNameField.getText();
	}
	
	public void profileButtonClick() {
		userNameField.click();
		profileButton.click();
	}
	
	public void endTourClick() {
		endTourButton.click();
	}
	
	public void enterFirstname(String fname) {
		firstNameField.clear();
		firstNameField.sendKeys(fname);
	}
	public void profileUpdate() {
		profileUpdate.click();
	}

	public  AddUserPage addUserPage() {
		userManagementClick.click();
		userClick.click();
		addUserButton.click();
		return new AddUserPage(driver); 
	}
	public UserPage userPage() {
		userManagementClick.click();
		userClick.click();
		return new UserPage(driver);
	}
}
