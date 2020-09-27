package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Step("Login")
    @Test(description = "Tect на логин")
    @Description("Логин использует стандартные креды")
    public void correctLogin() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле Username")
    public void EmptyLogin() {
        loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage("Epic sadface: Username is required")
                .isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при пустом поле Password")
    public void EmptyPassword() {
        loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "")
                .getErrorMessage("Epic sadface: Password is required")
                .isPageOpened();
    }

    @Test
    @Description("Проверка сообщения об ошибке при вводе некорректных данных")
    public void IncorrectCreds() {
        loginPage
                .openPage()
                .loginWithoutRedirect("qwer", "123")
                .getErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .isPageOpened();
    }
}


