package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	@Test
	public void verifyUserLoginDate() {
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password= ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		
		HomePage home=login.clickLogin();
		home.endTourClick();
		String actualDate= home.getLoginDate();
		String expectedDate= home.getCurrentDate();
		Assert.assertEquals(actualDate, expectedDate,Messages.DATE_MISMATCH);
		
	}
	@Test
	public void verifyUserManagementOptionsUsers() {
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password= ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		home.endTourClick();
	}
}
