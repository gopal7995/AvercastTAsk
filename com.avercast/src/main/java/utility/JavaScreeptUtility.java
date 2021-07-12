package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScreeptUtility {
	
	public static JavascriptExecutor js;
public static void clickOperation(WebDriver driver,WebElement element) {
	
	 js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", element);
}

public static void scrollThePage(WebDriver driver) {
	 js=(JavascriptExecutor)driver;

    js.executeScript("window.scrollBy(0,500)");
}
public static void sendKeys(WebDriver driver,String key,WebElement element) {
     js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].value='"+key+"';",element );
}
}
