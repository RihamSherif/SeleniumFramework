package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisteration_Test extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;

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

	@Test(dependsOnMethods = {"registerUser"} )
	public void registeredUserLogout() throws InterruptedException {
		Thread.sleep(2000);
		regObject.UserLogout();
		System.out.println("am currently logged out");
	}

	@Test(dependsOnMethods = {"registeredUserLogout"} )
	public void registeredUserLogin() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.UserLogin("Test666@mail.com", "Test7878");
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
	}
}
