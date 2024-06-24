package page_object;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement userNameField;
	@FindBy(id="password")
	WebElement passwordField;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginButton;
	// explicit wait - to wait for the span button to be click-able
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	@FindBy(xpath="//span[@class='help-block']")
	WebElement validationMsg;
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(driver);
	}
	
	public String getValidationMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='help-block']")));
		return validationMsg.getText();
	}
	
}
