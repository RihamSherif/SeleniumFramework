package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs_Test extends TestBase {

	HomePage home;
	ContactUsPage contactPage;
	
	String fullName = "Riham Sherif";
	String email = "riham@test.com";
	String enquiry = "Hello Admin";
	
	
	@Test
	public void userCanUseContactUs()
	{
		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		home.scrolltoContactUsLink();
		home.openContactUsLink();
		contactPage.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMsg.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
	}
	
}
