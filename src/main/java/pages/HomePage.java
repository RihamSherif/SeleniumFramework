package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(css = "a.ico-register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginBtn;

	@FindBy (linkText = "Contact us")
	WebElement openContactUsBtn;

	//Related to ChangeCurrency_Test
	@FindBy(id = "customerCurrency")
	WebElement currencyDDL;

	public void openRegisterPage()
	{
		//registerLink.click();
		clickButton(registerLink);
	}

	public void openLoginPage()
	{
		clickButton(loginBtn);
	}


	public void scrolltoContactUsLink()
	{
		scrollToBottom();
	}
	
	public void openContactUsLink()
	{
		clickButton(openContactUsBtn);
	}
	
	//Related to ChangeCurrency_Test
	public void changeCurrency()
	{
		select = new Select(currencyDDL);
		select.selectByVisibleText("Euro");
	}
}
