package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public void addNewCityTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(2000);
        homePage.goToCitiesPage();
        Thread.sleep(2000);
        citiesPage.addNewCity();
        Thread.sleep(3000);
        Assert.assertTrue(citiesPage.getSuccesMsgBanner().getText().contains("Saved successfully"));
    }

    @Test(priority = 3)
    public void editCityTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(2000);
        homePage.goToCitiesPage();
        Thread.sleep(2000);
        citiesPage.editCity();
        Thread.sleep(2000);
        Assert.assertTrue(citiesPage.getSuccesMsgBanner().getText().contains("Saved successfully"));
    }

    @Test(priority = 4)
    public void searchCityTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(2000);
        homePage.goToCitiesPage();
        Thread.sleep(2000);
        citiesPage.searchCity();
        Thread.sleep(10000);
        Assert.assertEquals(citiesPage.getFirstCityText().getText(), citiesPage.getSearchedText().getText());
    }



}
