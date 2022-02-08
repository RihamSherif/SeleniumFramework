package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy (id = "OldPassword")
	WebElement oldPassword;

	@FindBy (id = "NewPassword")
	WebElement newPassword;

	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmPassword;
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordBtn;
	
	@FindBy(linkText = "Password was changed")
	public WebElement resultLabel;
	
	
	//Click on the Change password link in the side menu
	public void openChangePassLink()
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPass, String newPass)
	{
		insertText(oldPassword, oldPass);
		insertText(newPassword, newPass);
		insertText(confirmPassword, newPass);
		clickButton(changePasswordBtn);
	}
}
