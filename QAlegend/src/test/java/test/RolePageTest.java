package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.RolePage;
import utilities.ExcelUtility;

public class RolePageTest extends Base {


	@Test
	public void VerifySearchUserPageTest() {
	
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		RolePage rolePage= home.rolePage();
		String searchRole= ExcelUtility.getStringData(0, 0, Constants.ROLESPAGE);
		rolePage.enterSearch(searchRole);
		String searchResult= rolePage.getSearchRole();
		Assert.assertEquals(searchRole, searchResult,Messages.ROLE_NOT_PRESENT);
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
		RolePage rolePage= home.rolePage();
		String searchRole= ExcelUtility.getStringData(0, 0, Constants.ROLESPAGE);
		rolePage.enterSearch(searchRole);
		rolePage.deleteSearchedUser();
		rolePage.enterSearch(searchRole);
		String searchResult= rolePage.getSearchRole();
		Assert.assertEquals(searchRole, searchResult,Messages.ROLE_NOT_PRESENT);
	}
	
}
