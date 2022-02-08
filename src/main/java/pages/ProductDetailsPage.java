package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	//Related to ChangeCurrency_Test
	@FindBy(css = "span.price-value-4")
	public WebElement productPriceLabelEuro;
	
	//Related to add review 
	@FindBy(linkText = "Add your review")
	WebElement addReviewBtn;
	
	
	public void openSendEmailtoFriend()
	{
		clickButton(emailFriendBtn);
	}

	public void openReviewPage()
	{
		clickButton(addReviewBtn);
	}
}
