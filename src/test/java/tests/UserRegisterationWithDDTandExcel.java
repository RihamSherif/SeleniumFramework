package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import testData.ExcelReader;

public class UserRegisterationWithDDTandExcel extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;


	@DataProvider(name = "ExcelData")
	public Object[][] registerationData() throws IOException
	{
		//read data from ExcelReader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}


	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void registerUser(String fname, String lname,String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		loginObject = new LoginPage(driver);
		regObject = new UserRegisterationPage(driver);
		regObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(regObject.successMessage.getText().equals("Your registration completed")); ;
		//System.out.println(regObject.successMessage.getText());
		//Logout
		regObject.UserLogout();
		// Login with the registered User
		
		homeObject.openLoginPage();
		loginObject.UserLogin(email, password);
		Assert.assertTrue(regObject.logoutBtn.getText().contains("out"));
		System.out.println("am currently logged in");
		
		//logout again so the next user can login
		regObject.UserLogout();

	}
}
