package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public final static String USERNAME = "standard_user";
    public final static String PASSWORD = "secret_sauce";
    public final static String FIRSTNAME = "Vadim";
    public final static String LASTNAME = "Shulga";
    public final static String ZIP = "12345";

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CartPage cartPage;
    MenuPage menuPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        cartPage = new CartPage(driver);
        menuPage = new MenuPage(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }


}
