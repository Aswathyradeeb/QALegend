package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

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
	
	
	@FindBy(xpath="//span[@class='title' and text()='User Management']")
	WebElement userManagementClick;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement userClick;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement dateField;
	
	public String getUserName() {
		return userNameField.getText();
	}
	
	
	public void endTourClick() {
		endTourButton.click();
	}
    public String getLoginDate() {
    	return dateField.getText();   	
    }
    public String getCurrentDate() {
    	return DateUtility.getUserLoginDate("dd-MM-YYYY");
    }
	public UserPage userPage() {
		userManagementClick.click();
		userClick.click();
		return new UserPage(driver);
	}
	public UserManagementPage userOptions() {
		userManagementClick.click();
		return new UserManagementPage(driver);
	}
	public ProfilePage profilePage() {
		userNameField.click();
		profileButton.click();
		return new ProfilePage(driver);
	}
}
