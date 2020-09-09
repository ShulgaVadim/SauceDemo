package tests;

import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {


    @Test
    public void correctData() {
        checkoutPage
                .openPage()
                .fillInformation(FIRSTNAME, LASTNAME, ZIP);
        checkoutStepTwoPage.isPageOpened();
    }

    @Test
    public void EmptyFirstName() {
        checkoutPage
                .openPage()
                .fillIncorrrectData("", LASTNAME, PASSWORD)
                .getErrorMessageOnCheckoutPage("Error: First Name is required")
                .isPageOpened();
    }

    @Test
    public void EmptyLastName() {
        checkoutPage
                .openPage()
                .fillIncorrrectData(FIRSTNAME, "", ZIP)
                .getErrorMessageOnCheckoutPage("Error: Last Name is required")
                .isPageOpened();
    }

    @Test
    public void EmptyZIP() {
        checkoutPage
                .openPage()
                .fillIncorrrectData(FIRSTNAME, LASTNAME, "")
                .getErrorMessageOnCheckoutPage("Error: Postal Code is required")
                .isPageOpened();
    }

    //Проверка кнопки CANCEL
    @Test
    public void checkCancelButton() {
        checkoutPage
                .openPage()
                .clickCancelButton()
                .compareURL("https://www.saucedemo.com/cart.html");
    }

    //Проверка кнопки CONTINUE
    @Test
    public void checkContinueButton() {
        checkoutPage
                .openPage()
                .clickCancelButton()
                .compareURL("https://www.saucedemo.com/cart.html");
    }
}
