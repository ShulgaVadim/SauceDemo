package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.CheckoutPage.CANCEL_BUTTON;

public class CheckoutTest extends BaseTest {


    @Test
    public void correctData() {
        checkoutPage.openPage();
        checkoutPage.fillInformation(FIRSTNAME, LASTNAME, ZIP);
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void EmptyFirstName() {
        checkoutPage.openPage();
        checkoutPage.fillInformation("", LASTNAME, ZIP);
        assertEquals(checkoutPage.getErrorMessageOnCheckoutPage(), "Error: First Name is required");
    }

    @Test
    public void EmptyLastName() {
        checkoutPage.openPage();
        checkoutPage.fillInformation(FIRSTNAME, "", ZIP);
        assertEquals(checkoutPage.getErrorMessageOnCheckoutPage(), "Error: Last Name is required");
    }

    @Test
    public void EmptyZIP() {
        checkoutPage.openPage();
        checkoutPage.fillInformation(FIRSTNAME, LASTNAME, "");
        assertEquals(checkoutPage.getErrorMessageOnCheckoutPage(), "Error: Postal Code is required");
    }

    //Проверка кнопки CANCEL
    @Test
    public void checkOfCancelledOrder() {
        checkoutPage.openPage();
        driver.findElement(CANCEL_BUTTON).click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

}
