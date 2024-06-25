package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	@Test
	public void verifyUserManagementOptionsUsers() {
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		home.endTourClick();
	}
}
