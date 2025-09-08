package dream.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		//Login
		driver.findElement(By.id("userEmail")).sendKeys("mohuyen@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("M@huyen524");
		driver.findElement(By.id("login")).click();
		
		//Add to cart
		String productName = "ZARA COAT 3";
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("(//button[@routerlink='/dashboard/cart'])[1]")).click();
		
		//verìy in cart list and checkout
		List<WebElement> titleProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean anyMatch = titleProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(anyMatch);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//Place order
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("(//input[@placeholder='Select Country'])[1]")), "ind").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	//	ele.stream().filter(e -> e.getText().equalsIgnoreCase("india")).skip(1).findFirst().ifPresent(WebElement::click);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmationResult = "Thankyou for the order.";
		String expectedResult = driver.findElement(By.className("hero-primary")).getText();
		Assert.assertTrue(confirmationResult.equalsIgnoreCase(expectedResult));
		

		
	}

}
