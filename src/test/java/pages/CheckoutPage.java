package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



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

    public void openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void fillInformation(String firstname, String lastname, String zip) {

        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        driver.findElement(ZIP_INPUT).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessageOnCheckoutPage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }




}
