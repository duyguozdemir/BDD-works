package All_Tests;

import Utils.HelperFunctions;
import Constant.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTest {

    HelperFunctions helper;
    public WebDriver driver;
    public WebDriver wait;


    @Given("Navigate to the website")
    public void navigateToWebsite() {
        driver = ChromeDriver.setUp();
        driver.manage().window().maximize();
        driver.get("https://www.zara.com/tr/");
        wait = (WebDriver) new WebDriverWait(driver, 1000);
    }
    @FindBy(xpath = "//span[.='GİRİŞ YAP']")
    public WebElement signPage;
    @When("Click the SignPage button")
    public void clickOnSignInPage(String userEmail, String password) {
        helper.clickElement(signPage);
    }
    @FindBy(xpath = "//input[@name='logonId']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passBox;

    @And("Login with username {string} and Password {string}")
    public void loginWithUsernameAndPassword(String userEmail, String password) {
        helper.sendKeysElement(emailBox, userEmail);
        helper.sendKeysElement(passBox, password);
        wait = (WebDriver) new WebDriverWait(driver, 1000);
    }

    @FindBy(css = ".form__footer > .button span")
    public WebElement signInButton;

    @And("Click the signIn button")
    public void clickSignInButton() {
        helper.clickElement(signInButton);
    }

    @FindBy(xpath = "//span[.='Sepet']")
    public WebElement successLoginMessage;

    @Then("Check and verify login result {string}")
    public void verifyLoginResult(String userInfo) {
        String successLogin = helper.getText(successLoginMessage);
        Assert.assertTrue(successLogin.contains(userInfo));
    }

    @FindBy(xpath ="//span[.='Geçerli bir e-posta adresi girin.']")
    public WebElement failedLoginMessage;

    @Then("Check and verify failed login result {string}")
    public void verifyFailedLoginResult(String failedInfo) {
        String failedLogin = helper.getText(failedLoginMessage);
        Assert.assertTrue(failedLogin.contains(failedInfo));
    }

}
