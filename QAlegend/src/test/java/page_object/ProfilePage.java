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
	@FindBy(id="first_name")
	WebElement firstNameField;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement profileUpdate;
	public void enterFirstname(String fname) {
		firstNameField.clear();
		firstNameField.sendKeys(fname);
	}
	
	
	public void profileUpdate() {
		profileUpdate.click();
	}
}
