package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.xpath("//input[@type='search']");
    By productList = By.cssSelector("div.css-1sn1xa2"); // card produk
    By popupClose = By.cssSelector("button[aria-label='X']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchProduct(String productName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(productName + Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Search box tidak muncul: " + e.getMessage());
        }
    }

    public void handlePopup() {
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(popupClose));
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("Popup tidak muncul");
        }
    }

    public void verifyProductResults() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
        List<WebElement> products = driver.findElements(productList);
        System.out.println("Jumlah produk ditemukan: " + products.size());
    }
}

