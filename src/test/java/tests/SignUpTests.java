package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

public class SignUpTests extends BaseTest{

    private SignUpPage signUpPage;
    private HomePage homePage;
    private Faker faker;


    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    //Test #1: Visits the signup page
    //assert:
    //Verifikovati da se u url-u stranice javlja /signup ruta
    @Test(priority = 1)
    public void signUpPageTest() throws InterruptedException {
        Thread.sleep(1000);
        homePage.goToSignUpPage();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("signup"));
    }
}
