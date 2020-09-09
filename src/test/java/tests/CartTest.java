package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {

    //Проверка добавления товара в корзину
    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct(System.getProperty("product"));
        cartPage.openPage()
                .productShouldBeIntheList(System.getProperty("product"));
    }

    //Удаление товара из корзины
    @Test
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

    //Проверка кнопки CHECKOUT
    @Test
    public void checkCheckoutButton() {
        cartPage
                .openPage()
                .clickCheckoutButton()
                .compareURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    //Проверка кнопки CONTINUE SHOPPING
    @Test
    public void checkContinueShoppingButton() {
        cartPage
                .openPage()
                .clickContinueShoppingButton()
                .compareURL("https://www.saucedemo.com/inventory.html");
    }

}
