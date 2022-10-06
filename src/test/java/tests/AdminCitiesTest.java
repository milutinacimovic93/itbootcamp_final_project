package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CitiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

public class AdminCitiesTest extends BaseTest {

    private SignUpPage signUpPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private CitiesPage citiesPage;
    private Faker faker;


    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver,driverWait);
        citiesPage = new CitiesPage(driver,driverWait);
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    //Test #1: Visits the admin cities page and list cities
    //Podaci:
    //admin email: admin@admin.com
    //admin password: 12345
    //assert:
    //Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //Verifikovati postojanje logut dugmeta

    @Test(priority = 1)
    public void adminCitiesRoutTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(2000);
        homePage.getAdminBtn().click();
        Thread.sleep(2000);
        homePage.getCitiesBtn().click();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());
    }

    @Test(priority = 2)
    public void addNewCityTest() {

    }
}
