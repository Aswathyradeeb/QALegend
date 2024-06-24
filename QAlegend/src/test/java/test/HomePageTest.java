package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base{

	@Test	
	public void VerifyProfile (){
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		home.endTourClick();
		home.profileButtonClick();
		home.enterFirstname("Admin1");
		home.profileUpdate();
		String updatedUserName= home.getUserName();
		Assert.assertEquals("Admin1", updatedUserName,"Failed: Profile not updated");
	}
}
