package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {


    @Test
    @Description("Проверка добавления товара в корзину")
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Bike Light");
        cartPage.openPage()
                .productShouldBeIntheList("Sauce Labs Bike Light");
    }

    @Test
    @Description("Проверка удаления товара из корзины")
    public void productShouldBeRemovedFromTheCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Backpack");
        cartPage.openPage()
                .removeProduct("Sauce Labs Bike Light");
        assertEquals(driver.findElements(By.cssSelector(".inventory_item_name")).size(), 1);

    }

    @Test
    @Description("Проверка кнопки CHECKOUT")
    public void checkCheckoutButton() {
        cartPage
                .openPage()
                .clickCheckoutButton()
                .compareURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test
    @Description("Проверка кнопки CONTINUE SHOPPING")
    public void checkContinueShoppingButton() {
        cartPage
                .openPage()
                .clickContinueShoppingButton()
                .compareURL("https://www.saucedemo.com/inventory.html");
    }

}
