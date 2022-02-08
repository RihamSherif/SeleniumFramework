package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithJavaFaker extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1, alwaysRun = true)
	public void registerUser()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration(firstname, lastname, email,password);
		System.out.println("User Data is: " + firstname + " " + lastname + " "+ email + " " + password);
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
		loginObject.UserLogin(email, password);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
	}
}
