package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserPage;
import page_object.AddUserPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base {


	@Test

	public void VerifyAddUserPageTest() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
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
        String email= firstName+lastName+"@gmail.com";       
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
		Assert.assertEquals(email, searchResult,"Failed: User Not Registered");
	}

	@Test

	public void VerifyUserLoginWithNewlyAddedUser() {
		LoginPage login = new LoginPage(driver);
		String UserName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getIntData(0, 1, "LoginPage");
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
        String email= firstName+lastName+"@gmail.com";       
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
		String expectedTitle = ExcelUtility.getStringData(0, 0, "HomePage");
		Assert.assertEquals(actualTitle, expectedTitle, "Failed: Not able to Login with the newely added User");
	}
}
