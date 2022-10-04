package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
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

    @Test(priority = 3)
    public void noUserError() throws InterruptedException {
        homePage.goToLoginPage();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginBtn().click();
        Thread.sleep(3000);
        WebElement userDoesNotExist = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        Assert.assertTrue(userDoesNotExist.isDisplayed());
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }

    //Test #4: Displays errors when password is wrong
    //Podaci: random email i password koristeći faker libarary
    //asssert:
    //Verifikovati da greska sadrzi poruku Wrong password
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 4)
    public void wrongPasswordTest() throws InterruptedException {
        String password = faker.internet().password();
        homePage.goToLoginPage();
        Thread.sleep(1000);
        loginPage.getEmailField().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().click();
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginBtn().click();
        Thread.sleep(2000);
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertTrue(errorMsg.getText().contains("Wrong password"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("login"));
    }


}
