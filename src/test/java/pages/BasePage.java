package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver = new FirefoxDriver();


    public BasePage() {

    }

    public void implicitWaitForElement (WebElement element) {
        WebDriverWait implicitWaitTime = new WebDriverWait(driver, 20);
        implicitWaitTime.until(ExpectedConditions.elementToBeClickable(element));
    }

}
