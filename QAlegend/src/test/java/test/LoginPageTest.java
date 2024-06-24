package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataProvider.DataProviders;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	@Test(dataProvider="InvalidDataCredentials",dataProviderClass=DataProviders.class)
	public void VerifyErrorMessageWhileLoginwithInvalidCredentials(String username,String password) {
		LoginPage login= new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickLogin();	
		String actualMsg= login.getValidationMsg();
		String expectedMsg= ExcelUtility.getStringData(1,0,"LoginPage");
		Assert.assertEquals(actualMsg, expectedMsg,"Failed: Invalid credentials");
	}
	
	
	@Test	
	public void VerifyLoginwithValidCredentials() throws IOException{
		LoginPage login= new LoginPage(driver);
		String UserName= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getIntData(0, 1, "LoginPage");
		login.enterUserName(UserName);
		login.enterPassword(password);
		HomePage home=login.clickLogin();
		String actualName= home.getUserName();
		String expectedName= ExcelUtility.getStringData(2, 0, "LoginPage");
		Assert.assertEquals(actualName, expectedName,"Failed: Invalid Login");
		
	}
	

}
