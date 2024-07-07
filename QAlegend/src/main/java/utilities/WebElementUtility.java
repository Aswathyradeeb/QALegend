package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
		}
	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
		}
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
		}
}
