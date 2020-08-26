package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.CartPage.CHECKOUT_BUTTON;
import static pages.CartPage.CONTINUE_SHOPPING_BUTTON;

public class CartTest extends BaseTest {

    //Проверка добавления товара в корзину
    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        cartPage.openPage();
        cartPage.productShouldBeIntheList("Sauce Labs Bike Light");
    }

    //Удаление товара из корзины!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void productShouldBeRemovedFromTheCart() {
        productShouldBeAddedIntoCart();
        cartPage.removeProduct("Sauce Labs Bike Light");

    }

    //Проверка кнопки CHECKOUT
    @Test
    public void checkCheckoutButton() {
        cartPage.openPage();
        driver.findElement(CHECKOUT_BUTTON).click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    //Проверка кнопки CONTINUE SHOPPING
    @Test
    public void checkContinueShoppingButton() {
        cartPage.openPage();
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

}
