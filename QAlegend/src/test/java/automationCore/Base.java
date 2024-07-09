package automationCore;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;

public class Base {
	protected WebDriver driver;
	public Properties prop;
	public FileInputStream file;

	public void initialiseBrowser(String browser) {
		try {
			prop = new Properties();
			file = new FileInputStream(Constants.CONFIG_FILE);
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browserName) {
		initialiseBrowser(browserName);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(result);
		}
		driver.close();
	}

	public void takeScreenShot(ITestResult result) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File screenshot = takeScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshot/" + result.getName() + ".png"));
	}
}
