package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;
	ProfilePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="last_name")
	WebElement lastNameField;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement profileUpdate;
	public void enterLastname(String lname) {
		lastNameField.clear();
		lastNameField.sendKeys(lname);
	}
	
	
	public void profileUpdate() {
		profileUpdate.click();
	}
}
