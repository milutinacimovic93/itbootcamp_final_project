package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Test(priority = 3)
    public void signUpUserThatAlreadyExists() throws InterruptedException {
        homePage.goToSignUpPage();
        Thread.sleep(1000);
        signUpPage.getName().click();
        signUpPage.getName().sendKeys("Test Test");
        signUpPage.getEmail().click();
        signUpPage.getEmail().sendKeys("admin@admin.com");
        signUpPage.getPasswordField().click();
        signUpPage.getPasswordField().sendKeys("12345");
        signUpPage.getConfirmPasswordField().click();
        signUpPage.getConfirmPasswordField().sendKeys("12345");
        signUpPage.getSignMeUpBtn().click();
        Thread.sleep(1000);
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]"));
        String errorMsgTxt = errorMsg.getText();
        Assert.assertTrue(errorMsgTxt.contains("E-mail already exists"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }
    @Test(priority = 4)
    public void signUpTest() throws InterruptedException {
        homePage.goToSignUpPage();
        Thread.sleep(1000);
        signUpPage.getName().click();
        signUpPage.getName().sendKeys("Milutin Acimovic");
        signUpPage.getEmail().click();
        signUpPage.getEmail().sendKeys("milutinn.acimovicc@itbootcamp.rs");
        signUpPage.getPasswordField().click();
        signUpPage.getPasswordField().sendKeys("12345");
        signUpPage.getConfirmPasswordField().click();
        signUpPage.getConfirmPasswordField().sendKeys("12345");
        signUpPage.getSignMeUpBtn().click();
        Thread.sleep(1000);
        WebElement verifyMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div"));
        String verifyMsgTxt = verifyMsg.getText();
        Assert.assertTrue(verifyMsgTxt.contains("Verify your account"));
        Thread.sleep(5000);
    }
}
