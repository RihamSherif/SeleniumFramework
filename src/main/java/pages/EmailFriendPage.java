package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "FriendEmail")
	WebElement emailFriendTxt;

	@FindBy (id = "PersonalMessage")
	WebElement personalMessageTxt;

	@FindBy (name = "send-email")
	WebElement sendMailBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void sendEmailToFriend(String email, String personalMessage)
	{
		insertText(emailFriendTxt, email);
		insertText(personalMessageTxt, personalMessage);
		clickButton(sendMailBtn);
	}

}
