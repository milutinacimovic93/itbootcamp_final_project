package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
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

}
