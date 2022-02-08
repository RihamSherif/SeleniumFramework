package tests;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import testData.JsonDataReader;

public class UserRegisterationWithDDTAndJSON extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void registerUser() throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jReader = new JsonDataReader();
		jReader.jsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration(jReader.firstname, jReader.lastname, jReader.email, jReader.password);
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
		
		regObject.UserLogout();
		
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(jReader.email, jReader.password);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
		
		regObject.UserLogout();

	}

}
