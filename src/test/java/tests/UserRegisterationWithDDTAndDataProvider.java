package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataProvider extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;
	
	//Creating Data provider to read from it the registeration Data
	@DataProvider(name = "TestData")
	public static Object[][] userData(){
		return new Object[][] {
			{"riham","sherif","testmail3@gmail.com","12345678"},
			{"salma","sherif","testmail4@gmail.com","12345678"}
		};
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "TestData")
	public void registerUser(String fname, String lname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
		regObject.UserLogout();
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
	//	Thread.sleep(2000);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
	}

/*	@Test(dependsOnMethods = {"registerUser"} )
	public void registeredUserLogout() throws InterruptedException {
		Thread.sleep(2000);
		regObject.UserLogout();
		System.out.println("am currently logged out");
		
	}*/
	
	

	/*@Test(dependsOnMethods = {"registeredUserLogout"} )
	public void registeredUserLogin() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.UserLogin("Test666@mail.com", "Test7878");
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
	}*/
}
