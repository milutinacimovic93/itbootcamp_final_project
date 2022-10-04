package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginBtn;
    private WebElement forgotPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getEmailField() {
        return getDriver().findElement(By.id("email"));
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(By.id("password"));
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span"));
    }

    public void setLoginBtn(WebElement loginBtn) {
        this.loginBtn = loginBtn;
    }

    public WebElement getForgotPassword() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[4]/a/span"));
    }

    public void setForgotPassword(WebElement forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public void login() {
        getEmailField().click();
        getEmailField().sendKeys("admin@admin.com");
        getPasswordField().click();
        getPasswordField().sendKeys("12345");
        getLoginBtn().click();
    }


}
