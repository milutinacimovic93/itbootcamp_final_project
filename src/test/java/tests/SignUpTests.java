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
        signUpPage = new SignUpPage(driver, driverWait);
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test(priority = 1)
    public void signUpPageTest() throws InterruptedException {
        Thread.sleep(1000);
        homePage.goToSignUpPage();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("signup"));
    }

    @Test(priority = 2)
    public void signUpFormInputTypesCheckTest() throws InterruptedException {
        homePage.goToSignUpPage();
        Thread.sleep(1000);
        String actualEmail = signUpPage.getEmail().getAttribute("type");
        String actualPass = signUpPage.getPasswordField().getAttribute("type");
        String actualPassConfirm = signUpPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(actualEmail, "email");
        Assert.assertEquals(actualPass, "password");
        Assert.assertEquals(actualPassConfirm, "password");
    }
}
