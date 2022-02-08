package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrency_Test extends TestBase{


	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}

	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPriceLabelEuro.getText().contains("€"));
			System.out.println(detailsObject.productPriceLabelEuro.getText());
		} catch (Exception e)
		{
			System.out.println("Error occured! "+e.getMessage());
		}

	}
}
