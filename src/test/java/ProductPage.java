import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;
    private By addToCart = By.cssSelector("[name=add-to-cart]");
    private By goToCart = By.cssSelector(".woocommerce-message>.button");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage go(String productSlug) {
        String baseURL = "http://vps-dd8db6de.vps.ovh.net:8080";
        driver.get(baseURL + "/product/" + productSlug);
        return this;
    }

    public ProductPage addToCart() {
        driver.findElement(addToCart).click();
        return this;
    }

    public CartPage goToCart() {
        driver.findElement(goToCart).click();
        return new CartPage(driver);
    }
}
