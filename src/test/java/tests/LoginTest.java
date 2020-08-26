package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void correctLogin() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
    }

    @Test
    public void EmptyLogin() {
        loginPage.openPage();
        loginPage.login("", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void EmptyPassword() {
        loginPage.openPage();
        loginPage.login(USERNAME, "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void IncorrectCreds() {
        loginPage.openPage();
        loginPage.login("qwer", "123");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }


}


