package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Baseclass;

public class LoginPage extends Baseclass {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Enter Email')]")
	private WebElement loginId;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button//span[text()='Login']")
	private WebElement submit;

	public void loginSetUp(String s, String s2) {
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Enter Email')]")));
		Actions action = new Actions(driver);

		action.moveToElement(loginId).sendKeys(s).build().perform();
		password.sendKeys(s2);
		submit.click();

		

	}
}
