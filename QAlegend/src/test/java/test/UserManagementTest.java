package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
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
		String actualName= home.getUserName();
		String expectedName= ExcelUtility.getStringData(2, 0, Constants.LOGINPAGE);
		Assert.assertEquals(actualName, expectedName,Messages.LOGIN_FAILED);
		home.endTourClick();
		UserManagementPage userManagementPage= home.userOptions();
		boolean isEnabledRoles= userManagementPage.isEnabledRolesField();
		boolean isEnabledsalesCommissionAgent= userManagementPage.isEnabledsalesCommissionAgentsField();
		boolean isEnabledUser= userManagementPage.isEnabledUserField();
		Assert.assertTrue(isEnabledUser, Messages.USER_OPTION_NOT_PRESENT);
		Assert.assertTrue(isEnabledRoles, Messages.ROLE_OPTION_NOT_PRESENT);
		Assert.assertTrue(isEnabledsalesCommissionAgent, Messages.SALES_OPTION_NOT_PRESENT);
	}
	
}
