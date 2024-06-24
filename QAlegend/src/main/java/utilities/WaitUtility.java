package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitUtility {

	//implicit wait, paramter duration of sec and web element as static final
	public static final long IMPLICIT_WAIT=10;
	public static final long EXPLICIT_WAIT=20;
	
	public void waitUsingimplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	public void waitFoeElement(WebDriver driver, WebElement element) {
		
	}
	
	//Add method for fluent wait.
}
