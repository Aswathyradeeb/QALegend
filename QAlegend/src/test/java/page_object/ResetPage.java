package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;
	ResetPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	WebElement emailField;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement sendLinkButton;
	@FindBy(xpath="//span[@class='help-block']")
    WebElement validationMsg;
	public String getTitle() {
		return driver.getTitle();
	}
	public void sendLinkButtonClick() {
	   sendLinkButton.click();
	}
	public void getEmail(String email) {
		emailField.sendKeys(email);
		}
	public String getValidationMsg() {
		return validationMsg.getText();
	}
}
