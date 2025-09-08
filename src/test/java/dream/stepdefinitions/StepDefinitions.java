package dream.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import dream.TestComponents.BaseTest;
import dream.pageobjects.CartPage;
import dream.pageobjects.CheckoutPage;
import dream.pageobjects.ConfirmPage;
import dream.pageobjects.LandingPage;
import dream.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

public class StepDefinitions extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmPage confirmPage;
    @Given("I launched on Ecommerce Website")
    public void i_launched_on_ecommerce_website() throws IOException {
    	landingPage = launchApp();
        // Code mở browser + navigate tới trang web
    }

    @Given("^Login with email(.+) and password (.+)$")
    public void login_with_email_and_password(String email, String password) {
	 productCatalogue = landingPage.loginApplication(email, password);

    }

    @When("^Added product (.+) to Cart Page$")
    public void added_product_to_cart_page(String productName) throws InterruptedException {
    	List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
    }
    @And("^Checkout (.+) and submit order$")
    public void checkout_product_and_submit_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
    	Boolean match = cartPage.verifyProdctDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.checkoutProducts();
		checkoutPage.selectCountry("ind");
		confirmPage = checkoutPage.submitOrder();
    }

    
    @Then("{string} message is displayed on Confirmation Page")
    public void message_is_displayed(String string) {
    	String confirmMessage = confirmPage.verifyConfirmMessage();
    	System.out.print(confirmMessage);
    	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }
    
    @Then("{string} error message is displayed")
    public void error_message_is_displayed(String string) {
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }

}
