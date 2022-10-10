package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest{

    private LoginPage loginPage;
    private BasePage basePage;
    private HomePage homePage;
    private Faker faker;


    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void loginTest() {
        homePage.goToLoginPage();
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
        loginPage.login("admin@admin.com", "12345");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }

    @Test
    public void checkInputTypesTest() {
        homePage.goToLoginPage();
        String actualEmail = loginPage.getEmailField().getAttribute("type");
        String actualPass = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");
        Assert.assertEquals(actualPass, "password");
    }

    @Test
    public void noUserErrorTest() {
        homePage.goToLoginPage();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        WebElement userDoesNotExist = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        loginPage.getWait().until(ExpectedConditions.visibilityOf(userDoesNotExist));
        Assert.assertTrue(userDoesNotExist.isDisplayed());
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }

    @Test
    public void wrongPasswordTest() {
        String password = faker.internet().password();
        homePage.goToLoginPage();
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginBtn().click();
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        loginPage.getWait().until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Wrong password"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }

    @Test
    public void logInTest() {
        homePage.goToLoginPage();
        loginPage.login("admin@admin.com", "12345");
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("home"));
    }

    @Test
    public void logOutTest() {
        homePage.getLogoutBtn().click();
        homePage.goToLoginPage();
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
        loginPage.login("admin@admin.com", "12345");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());
        loginPage.getWait().until(ExpectedConditions.visibilityOf(homePage.getLogoutBtn()));
        homePage.getLogoutBtn().click();
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
