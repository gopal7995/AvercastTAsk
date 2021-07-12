package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.JavaScreeptUtility;

public class AddToCartPage {
	public WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement Cart;

	@FindBy(xpath = "(//div[text()='Remove'])[2]")
	private WebElement remove;

	@FindBy(xpath = "//div[@class='row _1lPa3S']//div[text()='Remove']")
	private WebElement confirmremove;

	@FindBy(xpath = "//form[@method='post']//button//span[text()='Place Order']")
	private WebElement placeorder;

	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD TO CART']")));
		Cart.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void removeFromCart() {
		JavaScreeptUtility.clickOperation(driver, remove);
	}

	public void confirmRemove() {
		JavaScreeptUtility.clickOperation(driver, confirmremove);
	}

	public void orderPlaced() {
		placeorder.click();
	}
}
