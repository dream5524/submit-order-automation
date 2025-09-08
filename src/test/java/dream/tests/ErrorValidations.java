package dream.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import dream.TestComponents.BaseTest;
import dream.pageobjects.CartPage;
import dream.pageobjects.ProductCatalogue;
import junit.framework.Assert;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorValidation"})
	public void LoginErrorValidation() throws InterruptedException, IOException {

		landingPage.loginApplication("mohuyen@gmail.com", "M@huyen524add");
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginApplication("mohuyen@gmail.com", "M@huyen524");

		// Find and Add to cart
		String productName = "ZARA COAT 3";
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
		CartPage cartpage = productCatalogue.goToCartPage();

		// verify in cart list and checkout

		Boolean match = cartpage.verifyProdctDisplay("AO MUA");
		Assert.assertFalse(match);

	}

}
