package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.JavaScreeptUtility;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//input[contains(@title,'Search for products')]")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cartBox;

	public void searchBox(String s) {
		searchBox.clear();
		searchBox.sendKeys(s);
		JavaScreeptUtility.clickOperation(driver, searchBtn);
	}

	public String clickOnSearchProduct(String product) {
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt,'" + product + "')]")));

		JavaScreeptUtility.clickOperation(driver,
				driver.findElement(By.xpath("//img[contains(@alt,'" + product + "')]")));
		return driver.getTitle();

	}

	public void cartBox() {

		cartBox.click();
	}
}
