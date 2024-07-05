package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserPage;
import utilities.ExcelUtility;

public class UserPageTest extends Base {


	@Test

	public void VerifySearchUserPageTest() {
	
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		String actualName= home.getUserName();
		String expectedName= ExcelUtility.getStringData(2, 0, Constants.LOGINPAGE);
		Assert.assertEquals(actualName, expectedName,Messages.LOGIN_FAILED);
		home.endTourClick();
		UserPage userPage = home.userPage();
		String user=userPage.getName();
		userPage.enterSearchItem(user);
		String searchResult=userPage.getName();
		Assert.assertEquals(user, searchResult,"Failed: Searched user Not Found");
	}
	
	@Test

	public void VerifyEditUserPageTest() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		UserPage userPage = home.userPage();
		String email=userPage.getEmail();
		userPage.enterSearchItem(email);
		String searchResult=userPage.getName();
		Assert.assertEquals(email, searchResult,"Failed: Searched user Not Found");
	}
}
