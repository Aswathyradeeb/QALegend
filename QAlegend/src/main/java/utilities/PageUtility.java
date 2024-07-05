package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//----Drop down
	public static void selectByIndex(int index, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	public static void selectByText(WebElement element,String text) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(text);
	}
	//----Mouse Actions
	public static void clickAndHold(WebElement element,WebDriver driver) {
		new Actions(driver).clickAndHold(element).perform();
	}
	public static void clickAndRelease(WebElement element,WebDriver driver) {
		new Actions(driver).click(element).perform();
	}
	public static void rightButtonclick(WebElement element,WebDriver driver) {
		new Actions(driver).contextClick(element).perform();
	}
	public static void moveByOffset(WebDriver driver,int x, int y) {
		new Actions(driver).moveByOffset(x,y).perform();
	}
	public static void dragAndDrop(WebDriver driver,WebElement draggable, WebElement droppable) {
		new Actions(driver).dragAndDrop(draggable,droppable).perform();
	}
	
	//---File Upload
	public static void fileUpload(WebElement element,String path) {
		element.sendKeys(path);
	}
	
}
