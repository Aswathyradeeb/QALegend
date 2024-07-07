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
		home.endTourClick();
		UserPage userPage = home.userPage();
		userPage.loadUserTable();
		String user=userPage.getName();
		userPage.enterSearchItem(user);
		String searchResult=userPage.getName();
		Assert.assertEquals(user, searchResult,Messages.USER_SEARCH_FAILED);
	}
	
	
}
