package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverManager;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.open();
        loginPage.clickLogin();
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();

    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
