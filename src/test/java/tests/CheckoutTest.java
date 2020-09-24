package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {


    @Test
    @Description("Логин с корректными данными")
    public void correctData() {
        checkoutPage
                .openPage()
                .fillInformation(FIRSTNAME, LASTNAME, ZIP);
        checkoutStepTwoPage.isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле FirstName")
    public void EmptyFirstName() {
        checkoutPage
                .openPage()
                .fillIncorrrectData("", LASTNAME, PASSWORD)
                .getErrorMessageOnCheckoutPage("Error: First Name is required")
                .isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле LastName")
    public void EmptyLastName() {
        checkoutPage
                .openPage()
                .fillIncorrrectData(FIRSTNAME, "", ZIP)
                .getErrorMessageOnCheckoutPage("Error: Last Name is required")
                .isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле ZIP")
    public void EmptyZIP() {
        checkoutPage
                .openPage()
                .fillIncorrrectData(FIRSTNAME, LASTNAME, "")
                .getErrorMessageOnCheckoutPage("Error: Postal Code is required")
                .isPageOpened();
    }

    @Test
    @Description("Проверка кнопки CANCEL")
    public void checkCancelButton() {
        checkoutPage
                .openPage()
                .clickCancelButton()
                .compareURL("https://www.saucedemo.com/cart.html");
    }

    @Test
    @Description("Проверка кнопки Continue")
    public void checkContinueButton() {
        checkoutPage
                .openPage()
                .clickCancelButton()
                .compareURL("https://www.saucedemo.com/cart.html");
    }
}
