import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LocatorsSauceDemo {

    WebDriver browser;

    @Test
    public void searchOfLocators() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        browser.get("https://www.saucedemo.com/index.html");

        WebElement username = browser.findElement(By.id("user-name"));
        WebElement password = browser.findElement(By.id("password"));
        WebElement loginButton = browser.findElement(By.id("password"));

        //Логинимся
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.submit();

        //Находим все товары в каталоге
        browser.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")); //Sauce Labs Backpack
        browser.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")); //Sauce Labs Bolt T-Shirt
        browser.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")); //Sauce Labs Onesie
        browser.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")); //Sauce Labs Bike Light
        browser.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")); //Sauce Labs Fleece Jacket
        browser.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")); //Test.allTheThings() T-Shirt (Red)

        //Или находим сразу все элементы
        browser.findElements(By.cssSelector("inventory_item_name"));

        //Работа с корзиной
        browser.findElements(By.xpath("//button[text()='ADD TO CART']")).get(0).click(); //ADD TO CART 1st product
        browser.findElements(By.xpath("//button[text()='ADD TO CART']")).get(3).click(); //ADD TO CART 4st product
        browser.findElement(By.id("shopping_cart_container")).click();//CART
        browser.findElements(By.xpath("//button[text()='REMOVE']")).get(0).click(); //REMOVE 1st product
        browser.findElement(By.cssSelector(".btn_secondary"));//CONTINUE SHOPPING button
        browser.findElement(By.cssSelector(".btn_action")).click();//CHECKOUT button
        browser.findElement(By.id("first-name")); //FirstName field
        browser.findElement(By.id("last-name")); //LastName field
        browser.findElement(By.id("postal-code")); // ZIP field
        browser.findElement(By.cssSelector(".cart_cancel_link")); //CANCEL button
        browser.findElement(By.cssSelector(".btn_primary")); //CONTINUE button
        browser.get("https://www.saucedemo.com/checkout-step-two.html");
        browser.findElement(By.cssSelector("[class='btn_action cart_button']")).click(); //FINISH button

        browser.get("https://www.saucedemo.com/inventory.html");
        browser.findElement(By.cssSelector(".product_sort_container")); //Sort
        browser.findElement(By.cssSelector(".bm-burger-button")).click(); //Menu button
        browser.findElement(By.id("inventory_sidebar_link")); //All items
        browser.findElement(By.id("about_sidebar_link")); // About
        browser.findElement(By.id("logout_sidebar_link")); // Logout
        browser.findElement(By.id("reset_sidebar_link")); //Reset App State
        browser.findElements(By.cssSelector(".bm-cross-button")); //Close menu
        browser.quit();
    }

    //Вывод на экран всех товаров с ценами
    @Test
    public void printCatalog() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        browser.get("https://www.saucedemo.com/inventory.html");

        for (int i = 0; i < 6; i++) {

            String product = browser.findElements(By.cssSelector(".inventory_item_name")).get(i).getText();
            System.out.print(product);
            String price = browser.findElement(By.cssSelector(".inventory_item_price")).getText();
            System.out.println(" - " + price);
        }
        browser.quit();
    }


}


