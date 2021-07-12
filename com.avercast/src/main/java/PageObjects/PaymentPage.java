package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.JavaScreeptUtility;

public class PaymentPage {
	public WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='to-payment']/button")
	private WebElement towardsPayment;

	@FindBy(xpath = "//div[contains(text(),'Credit / Debit / ATM Card')]")
	private WebElement atmCreditcardlink;

	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement cardno;

	@FindBy(xpath = "//select[@name='month']")
	private WebElement months;

	@FindBy(xpath = "//select[@name='year']")
	private WebElement years;

	@FindBy(xpath = "//input[@type='password']//following-sibling::label[@for='cvv']")
	private WebElement cvv;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'PAY')]")
	private WebElement confirmPay;

	public void towardsPayment() {
		towardsPayment.click();
	}

	public void paymentMethod() {
		JavaScreeptUtility.clickOperation(driver, atmCreditcardlink);
	}

	public void paymentDetails(String s1, String s2, String s3, String s4) {

		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cardNumber']")));
		cardno.sendKeys(s1);
		Select smonth = new Select(months);
		smonth.selectByVisibleText(s2);
		Select syear = new Select(years);
		syear.selectByVisibleText(s3);

		// Element is not interactable thats why actions class is used

		Actions act = new Actions(driver);

		act.sendKeys(cvv, s4).build().perform();

	}

	public void confirmPayment() {
		confirmPay.click();

	}

}
