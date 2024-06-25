package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public static void selectByIndex(int index, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	public static void selectByText(WebElement element,String text) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(text);
	}
}
