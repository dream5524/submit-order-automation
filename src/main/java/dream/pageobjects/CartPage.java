package dream.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dream.abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> titleProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;


	public Boolean verifyProdctDisplay(String productName) {

		Boolean isMatch = titleProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(anyMatch);
		return isMatch;
	}

	public CheckoutPage checkoutProducts() {
		checkoutElement.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
		
	}
}
