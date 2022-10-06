package tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        WebElement cityButton = driver.findElement(By.xpath("//*[@id=\"list-item-117\"]"));
        cityButton.click();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());
        loginPage.logout();
    }

    @Test(priority = 2)
    public void addNewCityTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(3000);
        homePage.goToCitiesPage();
        Thread.sleep(2000);
        citiesPage.addNewCity();
        Thread.sleep(3000);
        Assert.assertTrue(citiesPage.getSuccesMsgBanner().getText().contains("Saved successfully"));
        loginPage.logout();
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
        loginPage.logout();
    }

    @Test(priority = 4)
    public void searchCityTest() throws InterruptedException {
        homePage.goToLoginPage();
        loginPage.login();
        Thread.sleep(2000);
        homePage.goToCitiesPage();
        Thread.sleep(2000);
        citiesPage.searchCity();
        Thread.sleep(2000);
        Assert.assertEquals(citiesPage.getFirstCityText().getText(), citiesPage.getSearchedText().getText());
        loginPage.logout();
    }

    @Test(priority = 5)
    public void deleteCity() throws InterruptedException {
        homePage.goToLoginPage();
        Thread.sleep(2000);
        loginPage.login();
        Thread.sleep(2000);
        homePage.goToCitiesPage();
        citiesPage.deleteCity();
        Thread.sleep(2000);
        Assert.assertTrue(citiesPage.getSuccesDelMsg().getText().contains("Deleted successfully"));
    }

}
