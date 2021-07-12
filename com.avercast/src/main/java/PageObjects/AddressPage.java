package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.JavaScreeptUtility;

public class AddressPage {
	public WebDriver driver;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement mobileno;

	@FindBy(xpath = "//input[@name='pincode']")
	private WebElement pinCode;

	@FindBy(xpath = "//input[@name='addressLine2']")
	private WebElement locality;

	@FindBy(xpath = "//textarea[@name='addressLine1']")
	private WebElement actualaddress;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath = "//select[@name='state']")
	private WebElement state;
	//input[@name='landmark']
	//input[@name='alternatePhone']
	
	@FindBy(xpath = "//input[@id='WORK']")
	private WebElement radioButton;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'Save and Deliver Here')]")
	private WebElement Save;

	public void addressFill(String s1, String s2, String s3, String s4, String s5,String s6) {
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
		name.sendKeys(s1);
		mobileno.sendKeys(s2);
		pinCode.sendKeys(s3);
		locality.sendKeys(s4);
		actualaddress.sendKeys(s5);
		actualaddress.click();
		city.click();
		Select slct=new Select(state);
		slct.selectByVisibleText(s6);
		
	}

	public void clicAndSave() {
		JavaScreeptUtility.scrollThePage(driver);

		JavaScreeptUtility.clickOperation(driver, radioButton);
		// JavaScreeptUtility.clickOperation(driver, Save);

		//radioButton.click();
		Save.click();

	}
		

	//}

	/*
	 * public void removeFromCart() { JavaScreeptUtility.clickOperation(driver,
	 * remove); // remove.click(); }
	 * 
	 * public void confirmRemove() { JavaScreeptUtility.clickOperation(driver,
	 * confirmremove); // confirmremove.click(); }
	 * 
	 * public void orderPlaced() { // JavaScreeptUtility.clickOperation(driver,
	 * Cart); placeorder.click(); }
	 */
}
