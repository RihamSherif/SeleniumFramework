package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_4")
	WebElement rating4RadioBtn;
	
	@FindBy(name = "add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement verifyNotification;
	
	
	public void addProductReview(String title, String reviewBody)
	{
		insertText(reviewTitleTxt, title);
		insertText(reviewTxt, reviewBody);
		clickButton(rating4RadioBtn);
		clickButton(submitReviewBtn);
	}
	
}
