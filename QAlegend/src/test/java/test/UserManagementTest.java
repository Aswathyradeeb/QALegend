package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.ExcelUtility;

public class UserManagementTest extends Base {


	@Test

	public void verifyUserManagementOptionsUsers (){
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		UserManagementPage userManagementPage= home.userOptions();
		boolean isEnabledRoles= userManagementPage.isEnabledRolesField();
		boolean isEnabledsalesCommissionAgent= userManagementPage.isEnabledsalesCommissionAgentsField();
		boolean isEnabledUser= userManagementPage.isEnabledUserField();
		Assert.assertTrue(isEnabledUser, "Failed: Not Present");
	}
	
}
