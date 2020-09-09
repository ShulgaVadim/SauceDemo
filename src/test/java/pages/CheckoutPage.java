package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class CheckoutPage extends BasePage {

    public static final By FIRSTNAME_INPUT = By.id("first-name");
    public static final By LASTNAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.xpath("//input[@class='btn_primary cart_button']");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRSTNAME_INPUT));
        return this;
    }

    public CheckoutPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        isPageOpened();
        return this;
    }

    public CheckoutStepTwoPage fillInformation(String firstname, String lastname, String zip) {
        fillIncorrrectData(firstname, lastname, zip);
        return new CheckoutStepTwoPage(driver);

    }

    public CheckoutPage fillIncorrrectData(String firstname, String lastname, String zip) {

        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIP_INPUT).sendKeys(zip);
        clickContinueButon();
        return this;
    }

    public CheckoutPage getErrorMessageOnCheckoutPage(String errorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_MESSAGE).getText(), errorMessage);
        return this;
    }

    public CheckoutStepTwoPage clickContinueButon() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutStepTwoPage(driver);
    }


    public CartPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }

}
