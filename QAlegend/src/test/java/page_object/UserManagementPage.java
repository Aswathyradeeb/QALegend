package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
	WebDriver driver;
	UserManagementPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href=\"https://qalegend.com/billing/public/users\"]")
	WebElement userField;
	@FindBy(xpath="//a[@href=\"https://qalegend.com/billing/public/roles\"]")
	WebElement rolesField;
	@FindBy(xpath="//a[@href=\"https://qalegend.com/billing/public/sales-commission-agents\"]")
	WebElement salesCommissionAgentsField;
	
	public boolean isEnabledUserField() {
		return userField.isEnabled();
	}
	public boolean isEnabledRolesField() {
		return rolesField.isEnabled();
	}
	public boolean isEnabledsalesCommissionAgentsField() {
		return salesCommissionAgentsField.isEnabled();
	}
}
