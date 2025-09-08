package dream.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dream.abstractcomponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-container");

	public List<WebElement> getProductsList() {
		waitForELementToAppear(productsBy);
		return products;

	}

	public WebElement getProductByName(String name) {
		WebElement product = products.stream()
				.filter(pro -> pro.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(name))
				.findFirst().orElse(null);

		return product;

	}
	//
	public void addProductToCart(String product) throws InterruptedException {
		
		WebElement prod = getProductByName(product);
		prod.findElement(addToCart).click();
		waitForELementToAppear(toastMessage);
		waitForELementToDisappear(spinner);

	}

}
