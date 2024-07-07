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
import utilities.RandomDataUtility;

public class ProfilePageTest extends Base {


	@Test

	public void VerifyProfile (){
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password= ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		home.endTourClick();
		ProfilePage profilePage= home.profilePage();
		String actualLastName=RandomDataUtility.getLastName();
		profilePage.enterLastname(actualLastName);
		profilePage.profileUpdate();
		String expectedLastName= home.getLastName();
		Assert.assertEquals(actualLastName, expectedLastName,Messages.PROFILE_NOT_UPDATED);
	}
	
}
