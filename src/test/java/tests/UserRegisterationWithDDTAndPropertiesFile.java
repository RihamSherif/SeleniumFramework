package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import testData.LoadProperties;

public class UserRegisterationWithDDTAndPropertiesFile extends TestBase{
// when using properties file
// you have to create the file you will read from which is userdata.properties exists under src/main/java
// then you have to load these data from the file into ur TC
// and this can be done through the LoadProeperties.java file 
//
//
	
	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String pass = LoadProperties.userData.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void registerUser()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration(fn, ln, email, pass);
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
		loginObject.UserLogin(email, pass);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
	}
}
