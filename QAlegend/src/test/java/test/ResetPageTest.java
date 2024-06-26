package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import dataProvider.DataProviders;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ResetPageTest extends Base {

	@Test
	public void VerifyResetPageOnForgotPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		ResetPage resetPage= login.forgotPasswordButtonClick();
		String actualTitle = resetPage.getTitle();
		String expectedTitle = ExcelUtility.getStringData(0, 0, Constants.FORGOTPASSWORDPAGE);
		Assert.assertEquals(actualTitle, expectedTitle, Messages.TITLE_MISMATCH);
	}

	@Test(dataProvider = "verifyUserEmailData", dataProviderClass = DataProviders.class)
	public void VerifyErrorMsgWithInvalidMailId(String email) {
		LoginPage login = new LoginPage(driver);
		ResetPage resetPage= login.forgotPasswordButtonClick();
		resetPage.getEmail(email);
		resetPage.sendLinkButtonClick();
		String actualMsg =resetPage.getValidationMsg();
		String expectedMsg = ExcelUtility.getStringData(1, 0, Constants.FORGOTPASSWORDPAGE);
		Assert.assertEquals(actualMsg, expectedMsg, Messages.EMAIL_VALIDATION_FAILED);
	}

	@Test
	public void verifyMsgWithNotRegisteredValidEmailId() {
		LoginPage login = new LoginPage(driver);
		ResetPage resetPage= login.forgotPasswordButtonClick();
		resetPage.getEmail(RandomDataUtility.getEmail());
		resetPage.sendLinkButtonClick();
		String actualMsg =resetPage.getValidationMsg();
		String expectedMsg = ExcelUtility.getStringData(2, 0, Constants.FORGOTPASSWORDPAGE);
		Assert.assertEquals(actualMsg, expectedMsg, Messages.EMAIL_VALIDATION_FAILED);
	}
}
