package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReview_Test extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	ProductReviewPage reviewObject;
	

	@Test(priority = 1)
	public void registerUser()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration("Riham", "Sherif", "Test623646@mail.com", "Test7878");
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
	}
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);

		} catch (Exception e)
		{
			System.out.println("Error occured! "+e.getMessage());
		}

	}
	
	@Test(priority = 3)
	public void addReview()
	{
		detailsObject.openReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.addProductReview("Review Title", "Nice product");
		Assert.assertTrue(reviewObject.verifyNotification.getText().equals("Product review is successfully added."));
	}
}
