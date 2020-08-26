package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//a[contains(text(), 'Continue Shopping')]");
    public static final By CHECKOUT_BUTTON = By.xpath("//a[contains(text(), 'CHECKOUT')]");
    String removeButtonLocator = "//div[contains(text(), '%s')]/ancestor::div//*[text()='REMOVE']";
    String productLocator = "//div[contains(text(), '%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void productShouldBeIntheList(String productName) {
        System.out.println(driver.findElement(By.xpath(String.format(productLocator, productName))).isDisplayed());
    }


    public void removeProduct(String productName) {
        driver.findElement(By.xpath(String.format(removeButtonLocator, productName))).click();
    }

}
