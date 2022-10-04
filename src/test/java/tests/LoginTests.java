package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    private LoginPage loginPage;
    private BasePage basePage;
    private HomePage homePage;


    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        homePage.goToLoginPage();
        Thread.sleep(1000);
        loginPage.login();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }

    @Test(priority = 2)
    public void checkInputTypes() throws InterruptedException {
        homePage.goToLoginPage();
        Thread.sleep(1000);
        String actualEmail = loginPage.getEmailField().getAttribute("type");
        String actualPass = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");
        Assert.assertEquals(actualPass, "password");
    }

}
