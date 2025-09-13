package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.DriverManager;

public class ProductTest {
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        DriverManager.getDriver();
        productPage = new ProductPage(DriverManager.getDriver());
    }

    @Test
    public void testSearchProduct() {
        DriverManager.getDriver().get("https://www.tokopedia.com");
        productPage.handlePopup();
        productPage.searchProduct("Iphone 12 mini");
        productPage.verifyProductResults();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
