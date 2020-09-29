package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    public static final By OPEN_ITEM = By.cssSelector(".bm-burger-button");
    public static final By ALL_ITEMS = By.id("inventory_sidebar_link");
    public static final By ABOUT_ITEM = By.id("about_sidebar_link");
    public static final By LOGOUT_ITEM = By.id("logout_sidebar_link");
    public static final By RESET_ITEM = By.id("reset_sidebar_link");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALL_ITEMS));
        return this;
    }

    public BasePage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        openMenu();
        isPageOpened();
        return this;
    }

    public MenuPage openMenu() {
        driver.findElement(OPEN_ITEM).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALL_ITEMS));
        return this;
    }

    public MenuPage allItemsClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALL_ITEMS));
        driver.findElement(ALL_ITEMS).click();
        return this;
    }

    public MenuPage aboutClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_ITEM));
        driver.findElement(ABOUT_ITEM).click();
        return this;
    }

    public LoginPage logOutClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_ITEM));
        driver.findElement(LOGOUT_ITEM).click();
        return new LoginPage(driver);
    }

    public MenuPage resetClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_ITEM));
        driver.findElement(RESET_ITEM).click();
        return this;
    }
}