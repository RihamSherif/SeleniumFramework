package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement gender;

	@FindBy(id = "FirstName")
	WebElement fName;

	@FindBy(id = "LastName")
	WebElement lName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	@FindBy (partialLinkText = "out")
	public WebElement logoutBtn;

	@FindBy(linkText = "My account11")
	WebElement myAccountBtn;

	public void userRegisteration(String f, String l, String e, String p)
	{
		//gender.click();
		clickButton(gender);
		//fName.sendKeys(f);
		insertText(fName, f);
		//lName.sendKeys(l);
		insertText(lName, l);
		//email.sendKeys(e);
		insertText(email, e);
		//password.sendKeys(p);
		insertText(password, p);
		//confirmPassword.sendKeys(p);
		insertText(confirmPassword, p);
		//registerButton.click();
		clickButton(registerButton);
	}

	public void UserLogout()
	{
		clickButton(logoutBtn);
	}

	public void openMyAccountPage()
	{
		clickButton(myAccountBtn);
	}

}
