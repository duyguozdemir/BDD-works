package Utils;

import Constant.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HelperFunctions {

    private WebDriver driver = Driver.setUp();
    WebDriverWait wait = new WebDriverWait(driver, 1000);

    public void sendKeysElement(WebElement sendElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendElement));
        sendElement.sendKeys(value);
    }

    public void clickElement(WebElement sendElement) {
        wait.until(ExpectedConditions.visibilityOf(sendElement));
        wait.until(ExpectedConditions.elementToBeClickable(sendElement)).click();
    }
    public String getText(WebElement sendElement) {
        wait.until(ExpectedConditions.visibilityOf(sendElement));
        return sendElement.getText();
    }

}
