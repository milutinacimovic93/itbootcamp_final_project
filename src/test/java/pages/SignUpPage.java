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
    private WebElement signMeUpBtn;

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

    public WebElement getSignMeUpBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"));
    }

    public void signUp(String name, String email, String password, String confirmPassword) {
        getName().click();
        getName().sendKeys(name);
        getEmail().click();
        getEmail().sendKeys(email);
        getPasswordField().click();
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().click();
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpBtn().click();
    }
}
