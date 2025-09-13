package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // ✅ Lokator elemen login (contoh fiktif, ganti sesuai DOM Tokopedia)
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.tokopedia.com/");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(submitButton).click();
    }
}
