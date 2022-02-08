package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProduct_Test extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";

	@Test
	public void userCanSearchForProducts() 
	{
		SearchPage searchObject = new SearchPage(driver);
		ProductDetailsPage detailsObject  = new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
}