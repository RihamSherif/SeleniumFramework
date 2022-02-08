package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriend_Test extends TestBase 
{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	EmailFriendPage emailObject;

	// 1. Register User
	@Test(priority = 1, alwaysRun = true)
	public void registerUser()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration("Riham", "Sherif", "Test666@mail.com", "Test7878");
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
	}
	// * 2. SearchProduct
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

	//* 3. Email to friend

	@Test(priority = 3)
	public void registeredUserSendProductToFriend()
	{
		detailsObject.openSendEmailtoFriend();
		emailObject = new EmailFriendPage(driver);
		emailObject.sendEmailToFriend("aaa@test.com", "Hello Friend, Check this product!");
		Assert.assertTrue(emailObject.successMsg.getText().contains("Your message has been sent."));
	}

	//4. Logout
	@Test(priority = 4)
	public void registeredUserLogout() throws InterruptedException {
		Thread.sleep(2000);
		regObject.UserLogout();
		System.out.println("am currently logged out");
	}

}
