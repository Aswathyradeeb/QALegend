package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;
import utilities.WaitUtility;

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
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[1]/a/span")
	WebElement homePage;
	
	@FindBy(xpath="//span[@class='title' and text()='User Management']")
	WebElement userManagement;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement usersOption;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a/span")
	WebElement rolesOption;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement dateField;
	
	public String getUserName() {
		String str= userNameField.getText();
		String[] splitStr = str.trim().split("\\s+");
		return splitStr[0];
	}
	public String getLastName() {
		String str= userNameField.getText();
		String[] splitStr = str.trim().split("\\s+");
		return splitStr[1];
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
		userManagement.click();
		usersOption.click();
		WaitUtility.waitUsingimplicitWait(driver);
		return new UserPage(driver);
		
	}
	public UserManagementPage userOptions() {
		userManagement.click();
		return new UserManagementPage(driver);
	}
	public ProfilePage profilePage() {
		userNameField.click();
		profileButton.click();
		return new ProfilePage(driver);
	}
	
	public RolePage rolePage() {
		homePage.click();
		userManagement.click();
		rolesOption.click();
		return new RolePage(driver);
	}
}
