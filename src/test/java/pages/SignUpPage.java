package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{

    private WebElement name;
    private WebElement email;
    private WebElement passwordField;
    private WebElement confirmPasswordField;

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getName() {
        return getDriver().findElement(By.id("name"));
    }

    public WebElement getEmail() {
        return getDriver().findElement(By.id("email"));
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(By.id("confirmPassword"));
    }
}
