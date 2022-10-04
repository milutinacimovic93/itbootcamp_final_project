package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    }

}
