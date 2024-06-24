package page_object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver driver;
	public UserPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="users_table")
	WebElement userTable;
	@FindBy(xpath= ".//tr")
	WebElement tableRows;
	@FindBy(xpath="//input[@type=\"search\"]")
	WebElement searchField;
	
	public String getName() {
		List<WebElement> rows = userTable.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		String cell = cols.get(1).getText();
		return cell;
	}
	
	public String getEmail() {
		List<WebElement> rows = userTable.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(3).findElements(By.tagName("td"));
		String cell = cols.get(1).getText();
		return cell;
	}
	
	public void editClick() {
		List<WebElement> rows = userTable.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(4).findElements(By.tagName("td"));
		cols.get(1).getText();
	}
	public void enterSearchItem(String search) {
		searchField.sendKeys(search);
	}
	
}
