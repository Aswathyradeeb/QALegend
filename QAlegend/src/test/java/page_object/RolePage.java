package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class RolePage {
	WebDriver driver;
	public RolePage(WebDriver driver){
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
	@FindBy(id="roles_table")
	WebElement rolesTable;
	@FindBy(xpath="//input[@type=\"search\"]")
	WebElement searchField;
	@FindBy(xpath="//*[@id=\"roles_table\"]/tbody/tr/td[1]")
	WebElement row;
	@FindBy(xpath="//*[@id=\"roles_table\"]/tbody/tr/td[2]/button")
	WebElement deleteSearchedUser;
	public void enterSearch(String search) {
		WaitUtility.waitForElementVisiblity(driver,rolesTable);
		searchField.sendKeys(search);
	}
	
	public String getSearchRole() {
		return row.getText();
	}

	public void deleteSearchedUser() {
		deleteSearchedUser.click();
	}
}
