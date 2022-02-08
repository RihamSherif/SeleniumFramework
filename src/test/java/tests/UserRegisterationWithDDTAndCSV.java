package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndCSV extends TestBase{

	HomePage homeObject;
	UserRegisterationPage regObject;
	LoginPage loginObject;

	CSVReader reader;
	
	@Test(priority = 1, alwaysRun = true)
	public void registerUser() throws CsvValidationException, IOException
	{
		//get CSV Path
		String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell = null;
		
		//while loop will be executed till last value in CSV file 
		while ((csvCell = reader.readNext()) != null)
		{
			String fname = csvCell[0];
			String lname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
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

}
