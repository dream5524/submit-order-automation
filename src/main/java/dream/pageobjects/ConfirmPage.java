package dream.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dream.abstractcomponent.AbstractComponent;

public class ConfirmPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "hero-primary")
	WebElement expectedResult;


	public String verifyConfirmMessage() {
		return  expectedResult.getText();
	}
}
