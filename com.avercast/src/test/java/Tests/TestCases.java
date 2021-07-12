package Tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AddToCartPage;
import PageObjects.AddressPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PaymentPage;
import Resources.Baseclass;
import Resources.DataFetch;

public class TestCases extends Baseclass {

	// Here Extending The BaseClass To Achieve The Inheritance By Using extends
	// Keyword For Reusability Of The Code

	LoginPage lp;
	HomePage hp;
	AddToCartPage ac;
	PaymentPage pp;
	AddressPage ap;

	String parentwindowid;
	String childwindowid;
	String product;
	String title;

	@BeforeClass
	public void setup() throws IOException {
		driver = initialisation();
	}

	@Test(priority = 1)
	public void login() {

		// Create An Object Of LoginPageClass To Call Its Methods

		lp = new LoginPage(driver);

		try {

			// Fetching The Data From ExcelSheet

			lp.loginSetUp(DataFetch.dataDriven("email/phone"),
					DataFetch.dataDriven("password"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void searchAndAddToCart() {

		// Store all the products in the String of Array

		String[] products = { "product 3", "product 4","product 1","product 2" };
		int i = 0;
		while (i < products.length) {
			try {
				product = DataFetch.dataDriven(products[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Create An Object Of HomePageClass To Call Its Methods

			hp = new HomePage(driver);
			hp.searchBox(product);
			String actualProduct = product.split("\\(")[0].trim();
			title = hp.clickOnSearchProduct(actualProduct);
			System.out.println(title);

			// Call The Method To Handeling Windows

			Set<String> handlingId = driver.getWindowHandles();
			Iterator<String> itr = handlingId.iterator();
			parentwindowid = itr.next();
			childwindowid = itr.next();
			driver.switchTo().window(childwindowid);

			// Create An Object Of AddToCartPage Class To Call Its Methods

			ac = new AddToCartPage(driver);

			ac.addToCart();
			driver.close();
			driver.switchTo().window(parentwindowid);
			i++;

		}

		// Doing remove product and place order opeartion and go to another payment page

		hp.cartBox();
		ac.removeFromCart();
		ac.confirmRemove();
		ac.orderPlaced();

	}

	@Test(priority = 3)
	public void address() {

		// Create An Object Of AddressPageClass To Call Its Methods

		ap = new AddressPage(driver);
		try {
			ap.addressFill(DataFetch.dataDriven("name"), DataFetch.dataDriven("mobileno"),
					DataFetch.dataDriven("pincode"), DataFetch.dataDriven("locality"), DataFetch.dataDriven("Address"),
					DataFetch.dataDriven("state"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		ap.clicAndSave();
	}

	@Test(priority = 4)
	public void getPayment() {

		// Create An Object Of PaymentPageClass To Call Its Methods

		pp = new PaymentPage(driver);
		pp.towardsPayment();
		pp.paymentMethod();

		try {
			pp.paymentDetails(DataFetch.dataDriven("cardno"), DataFetch.dataDriven("month"),
					DataFetch.dataDriven("year"), DataFetch.dataDriven("cvv"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		pp.confirmPayment();

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
