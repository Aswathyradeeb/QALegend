package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base {


	@Test

	public void VerifyProfile (){
		//change to last name
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		home.endTourClick();
		ProfilePage profilePage= home.profilePage();
		profilePage.enterFirstname("Admin1");
		profilePage.profileUpdate();
		String updatedUserName= home.getUserName();
		Assert.assertEquals("Admin1", updatedUserName,"Failed: Profile not updated");
	}
	
}
