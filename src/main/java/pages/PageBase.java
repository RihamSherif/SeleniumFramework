package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	//Related to ChangeCurrency_Test
	public Select select;
	
	//Create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected void clickButton(WebElement button)
	{
		button.click();
	}
	
	protected void insertText(WebElement txtbox, String txt)
	{
		txtbox.sendKeys(txt);
	}
	
	public void scrollToBottom()
	{
		jse.executeScript("scrollBy(0,2500)");
	}
}
