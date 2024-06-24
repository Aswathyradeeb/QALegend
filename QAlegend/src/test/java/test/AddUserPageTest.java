package test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.AddUserPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base {


	@Test

	public void VerifyAddUserPageTest() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		AddUserPage addUserPage = home.addUserPage();

		// explicit wait - to wait for the span button to be click-able
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		// WebElement span=driver.findElement(By.xpath("/(//span)[2]"));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span)[2]")));
		// span.click();

		// add form
		String passwordField = RandomDataUtility.getPassword();
		Select dropdownRole = new Select(driver.findElement(By.id("role")));
		dropdownRole.selectByIndex(2);
		addUserPage.addUser(RandomDataUtility.getPrefix(), RandomDataUtility.getFirstName(),
				RandomDataUtility.getLastName(), RandomDataUtility.getEmail(), RandomDataUtility.getUserName(),
				passwordField, "90");

	}

	@Test

	public void VerifyUserLoginWithNewlyAddedUser() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		AddUserPage addUserPage = home.addUserPage();
		// add form
		String passwordField = RandomDataUtility.getPassword();
		String userNameFied = RandomDataUtility.getUserName();
		Select dropdownRole = new Select(driver.findElement(By.id("role")));
		dropdownRole.selectByIndex(2);
		addUserPage.addUser(RandomDataUtility.getPrefix(), RandomDataUtility.getFirstName(),
				RandomDataUtility.getLastName(), RandomDataUtility.getEmail(), userNameFied, passwordField, "90");
		addUserPage.signOut();
		login.enterUserName(UserName);
		login.enterPassword(password);
		home = login.clickLogin();
	}
}
