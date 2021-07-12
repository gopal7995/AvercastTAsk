package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	public Properties prop;
	public WebDriver driver;
	public FileInputStream fis;

	public WebDriver initialisation() throws IOException {

		// create object of properties class to fetch the data from properties file
		// using FileInputStream

		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Flipkart.properties");

		prop.load(fis);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
