package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement emaiLogin;
	
	@FindBy(id = "Password")
	WebElement passwordLogin;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	
	
	public void UserLogin(String loginemail, String Pass) {
		insertText(emaiLogin, loginemail);
		insertText(passwordLogin, Pass);
		clickButton(loginBtn);
	}
	
	
	
}
