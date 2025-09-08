package dream.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dream.abstractcomponent.AbstractComponent;

//Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.xpath("(//input[@placeholder='Select Country'])[1]")), "ind").build().perform();
//
////wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
////	ele.stream().filter(e -> e.getText().equalsIgnoreCase("india")).skip(1).findFirst().ifPresent(WebElement::click);
//driver.findElement(By.cssSelector(".action__submit")).click();
public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//input[@placeholder='Select Country'])[1]")
	WebElement country;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement selectCountry;

	@FindBy(css = ".action__submit")
	WebElement submitButton;


	By resultMessage = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForELementToAppear(resultMessage);
		selectCountry.click();
	}
	
	public ConfirmPage submitOrder() {
		submitButton.click();
		return new ConfirmPage(driver);
	}
	

}
