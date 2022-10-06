package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private WebElement loginBtn;
    private WebElement aboutBtn;
    private WebElement signUpbtn;
    private WebElement darkTheme;
    private WebElement language;
    private WebElement logoutBtn;
    private WebElement homePageBtn;
    private WebElement adminBtn;
    private WebElement citiesBtn;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span"));
    }

    public WebElement getAboutBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]/span"));
    }

    public WebElement getSignUpbtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span"));
    }

    public WebElement getDarkTheme() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]"));
    }

    public WebElement getLanguage() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button/span/i"));
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
    }

    public WebElement getHomePageBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]"));
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span"));
    }

    public WebElement getCitiesBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"list-item-117\"]"));
    }

    public void goToLoginPage() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/");
        getLoginBtn().click();
    }
    public void goToSignUpPage() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/");
        getSignUpbtn().click();
    }




}
