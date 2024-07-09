package page_object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UserPage {
	WebDriver driver;
	public UserPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="users_table")
	WebElement userTable;
	@FindBy(xpath="//input[@type=\"search\"]")
	WebElement searchField;
	@FindBy(xpath="//a[@class=\"btn btn-block btn-primary\"]")
	WebElement addUserButton;
	@FindBy(tagName="tr")
	List<WebElement> tableRows;
	@FindBy(xpath="//table[@id='users_table']//tr[1]//td[2]")
	WebElement tableColumnName;
	@FindBy(xpath="//table[@id='users_table']//tr[1]//td[4]")
	WebElement tableColumnEmail;
	public AddUserPage addUser() {
		addUserButton.click();
		return new AddUserPage(driver); 
	}
	
	public String getName() {
		WaitUtility.waitForElementVisiblity(driver,userTable);
		String cell = tableColumnName.getText();
		return cell;
	}
	
	public String getEmail() {
		WaitUtility.waitForElementVisiblity(driver,userTable);
		String cell = tableColumnEmail.getText();
		return cell;
	}
	
	
	public void enterSearchItem(String search) {
		WaitUtility.waitForElementVisiblity(driver,userTable);
		searchField.sendKeys(search);
	}
	

}
