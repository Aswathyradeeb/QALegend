package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserPage;
import page_object.AddUserPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base {


	@Test

	public void VerifyAddUserPage() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		UserPage userPage = home.userPage();
        AddUserPage addUserPage=userPage.addUser();
		
		// add form
        String firstName= RandomDataUtility.getFirstName();
        String lastName= RandomDataUtility.getLastName();
        String UserPassword= firstName+lastName;
        String email= firstName+lastName+Constants.GMAIL_EXTENTION;       
        addUserPage.getSurname(RandomDataUtility.getPrefix());
        addUserPage.getFirstname(firstName);
        addUserPage.getLastname(lastName);
        addUserPage.getEmail(email);
        addUserPage.getPassword(UserPassword);
        addUserPage.getCmmsnpercent(Integer.toString(RandomDataUtility.getNumber()));
		addUserPage.getSelectRole();
		addUserPage.submitUser();
        userPage.enterSearchItem(email);
        String searchResult=userPage.getEmail();
		Assert.assertEquals(email, searchResult,Messages.USER_NOT_REGISTERED);
	}

	@Test

	public void VerifyUserLoginWithNewlyAddedUser() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getIntData(0, 1, Constants.LOGINPAGE);
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home = login.clickLogin();
		home.endTourClick();
		UserPage userPage = home.userPage();
        AddUserPage addUserPage=userPage.addUser();
		
		// add form
        String firstName= RandomDataUtility.getFirstName();
        String lastName= RandomDataUtility.getLastName();
        String UserPassword= firstName+lastName;
        String email= firstName+lastName+Constants.GMAIL_EXTENTION;       
        addUserPage.getSurname(RandomDataUtility.getPrefix());
        addUserPage.getFirstname(firstName);
        addUserPage.getLastname(lastName);
        addUserPage.getEmail(email);
        addUserPage.getPassword(UserPassword);
        addUserPage.getCmmsnpercent(Integer.toString(RandomDataUtility.getNumber()));
		addUserPage.getSelectRole();
		addUserPage.submitUser();
		addUserPage.signOut();
		login.enterUserName(UserName);
		login.enterPassword(password);
		home = login.clickLogin();
		String actualTitle = driver.getTitle();
		String expectedTitle = ExcelUtility.getStringData(0, 0, Constants.HOMEPAGE);
		Assert.assertEquals(actualTitle, expectedTitle, Messages.LOGIN_FAILED_ADDED_USER);
	}
}
