package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy (id = "ui-id-1")
	List<WebElement>  productList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String productName)
	{
		insertText(searchTxtBox, productName);
		clickButton(searchBtn);
		
	}
	
	public void openProductDetailsPage()
	{
		clickButton(productTitle);
	}
	
	public void productSearchUsingAutoSuggest(String searchTxt)
	{
		insertText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productList.get(0).click();
	}
}
