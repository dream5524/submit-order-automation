package dream.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dream.abstractcomponent.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;


	public Boolean verifyProdctDisplay(String productName) {

		Boolean isMatch = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return isMatch;
	}

}
