package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base {


	@Test

	public void VerifyProfile (){
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password= ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		String actualName= home.getUserName();
		String expectedName= ExcelUtility.getStringData(2, 0, Constants.LOGINPAGE);
		Assert.assertEquals(actualName, expectedName,Messages.LOGIN_FAILED);
		home.endTourClick();
		ProfilePage profilePage= home.profilePage();
		profilePage.enterLastname("Admin1");
		profilePage.profileUpdate();
		String updatedUserName= home.getUserName();
		Assert.assertEquals("Admin1", updatedUserName,Messages.PROFILE_NOT_UPDATED);
	}
	
}
