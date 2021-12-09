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

public class SearchboxTest {

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

        @FindBy(css = ".layout-header-search-bar__text > span")
        public WebElement searchBox;

        @When(" Click the searchBox button")
        public void clickSearchBox() {
            helper.clickElement(searchBox);
        }

        @FindBy(css = "#search-products-form-combo-input")
        public WebElement searcherOn;

        @And("Click and sendKeys as {string} on searcher")
        public void sendKEysTheSearchBoxButton(String productName) {
            helper.sendKeysElement(searcherOn, productName);
            wait = (WebDriver) new WebDriverWait(driver, 1000);
        }

        @FindBy(xpath = "//div[@class='search-products-view__results-count']/span[.='Sonuçlar']")
        public WebElement productResults;

        @Then("Check and verify search result {string}")
        public void checkListedProducts(String productName) {
            String productsFoundText = helper.getText(productResults);
            Assert.assertTrue(productsFoundText.contains(productName));
        }

        @FindBy(xpath ="//span[.='Aramada sonuç bulunamadı']")
        public WebElement failedSearchResult;

        @Then("Check and verify failed login result {string}")
        public void verifyFailedLoginResult(String noFound) {
            String noFoundText = helper.getText(failedSearchResult);
            Assert.assertTrue(noFoundText.contains(noFound));
    }

    }