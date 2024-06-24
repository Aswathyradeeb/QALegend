package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import dataProvider.DataProviders;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ResetPageTest extends Base {

	@Test
	public void VerifyResetPageOnForgotPassword() throws IOException {
		driver.get("https://qalegend.com/billing/public/password/reset");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = ExcelUtility.getStringData(0, 0, "ForgotPassword");
		Assert.assertEquals(actualTitle, expectedTitle, "Failed: Title mismatch");

	}

	@Test(dataProvider = "verifyUserEmailData", dataProviderClass = DataProviders.class)
	public void VerifyErrorMsgWithInvalidMailId(String email) {
		driver.get("https://qalegend.com/billing/public/password/reset");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@class='help-block']"));
		String errorMsg = msg.getText();
		String actualMsg = ExcelUtility.getStringData(1, 0, "ForgotPassword");
		Assert.assertEquals(errorMsg, actualMsg, "Failed: Email validation failed");
	}

	@Test
	public void verifyMsgWithValidEmailId() {
		driver.get("https://qalegend.com/billing/public/password/reset");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(RandomDataUtility.getEmail());
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@class='help-block']"));
		String errorMsg = msg.getText();
		String actualMsg = ExcelUtility.getStringData(2, 0, "ForgotPassword");
		Assert.assertEquals(errorMsg, actualMsg, "Failed: Email validation failed");
	}
}
