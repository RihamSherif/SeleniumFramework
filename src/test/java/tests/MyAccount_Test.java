package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccount_Test extends TestBase {
	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "Test7878";
	String newPassword = "12345678";
	String email = "Test33@gmail.com";

	@Test(priority = 1)
	public void registerUser()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration("Riham", "Sherif", email , oldPassword);
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
	}

	@Test(priority = 2)
	public void changePasswordOfRegisteredUser() 
	{
		myAccountObject = new MyAccountPage(driver);
		regObject.openMyAccountPage();
		myAccountObject.openChangePassLink();
		myAccountObject.changePassword(oldPassword, newPassword);
		//Assert.assertTrue(myAccountObject.resultLabel.getText().equals("Password was changed"));
		System.out.println("Password was changed");
	}
	
	@Test(priority = 3 )
	public void registeredUserLogout(){
		regObject.UserLogout();
		System.out.println("am currently logged out");
	}

	@Test(priority = 4 )
	public void registeredUserLogin() 
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
	}
}
