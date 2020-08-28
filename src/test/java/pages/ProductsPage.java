package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends BasePage {

    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    public static final By SORTING_BUTTON = By.cssSelector(".product_sort_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void addProduct(String productName) {
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
    }


    public boolean isPageOpened() {
        return driver.findElement(SORTING_BUTTON).isDisplayed();
    }

}
