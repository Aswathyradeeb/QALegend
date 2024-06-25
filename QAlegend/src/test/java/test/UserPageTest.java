package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserPage;
import utilities.ExcelUtility;

public class UserPageTest extends Base {


	@Test

	public void VerifySearchUserPageTest() {
		
		//get the user from excel and search
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
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
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
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
