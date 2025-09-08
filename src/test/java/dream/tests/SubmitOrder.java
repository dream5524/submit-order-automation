package dream.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import dream.TestComponents.BaseTest;
import dream.pageobjects.CartPage;
import dream.pageobjects.CheckoutPage;
import dream.pageobjects.ConfirmPage;
import dream.pageobjects.OrderPage;
import dream.pageobjects.ProductCatalogue;
import junit.framework.Assert;

public class SubmitOrder extends BaseTest {

	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData", groups = {"Purchase"})
	public void SubmitOrderTest(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		// Find and Add to cart
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartpage = productCatalogue.goToCartPage();

		// verify in cart list and checkout

		Boolean match = cartpage.verifyProdctDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.checkoutProducts();

		// Place order
		checkoutpage.selectCountry("ind");
		ConfirmPage confirmPage = checkoutpage.submitOrder();

		// Check message
		String confirmationResult = "Thankyou for the order.";
		String expectedResult = confirmPage.verifyConfirmMessage();
		AssertJUnit.assertTrue(confirmationResult.equalsIgnoreCase(expectedResult));
	}

	@Test(dependsOnMethods = { "SubmitOrderTest" })
	public void OrderHistortTest() {

		ProductCatalogue productCatalogue = landingPage.loginApplication("mohuyen@gmail.com", "M@huyen524");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyProdctDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonToHashMap(System.getProperty("user.dir") + "//src//test//java//dream//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};

//		return new Object[][] { { "mohuyen11@gmail.com", "M@huyen524", "ZARA COAT 3" },
//				{ "mohuyen@gmail.com", "M@huyen524", "ZARA COAT 3" },
//				{ "mohuyen1122@gmail.com", "M@huyen1122", "ZARA COAT 3" } };

	}

}
