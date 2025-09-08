package dream.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dream.pageobjects.CartPage;
import dream.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "(//button[@routerlink='/dashboard/cart'])[1]")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForELementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(findBy)));

	}

	public void waitForWebELementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForELementToDisappear(WebElement spinner) throws InterruptedException {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(spinner));
		Thread.sleep(1000);

	}

	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);

		return cartpage;
	}

	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);

		return orderPage;
	}

}
