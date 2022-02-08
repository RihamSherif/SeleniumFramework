package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase
{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	
	@Test
	public void userCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);

		} catch (Exception e)
		{
			System.out.println("Error occured! "+e.getMessage());
		}

	}
}
