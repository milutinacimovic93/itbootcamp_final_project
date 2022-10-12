package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class ProfileTests extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private Faker faker;

    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        faker = new Faker();
    }


    @Test
    public void editProfileTest() {


        String name = String.valueOf(faker.funnyName());
        String phone = String.valueOf(faker.phoneNumber());

        String twitter = "http://" + faker.internet().url();
        String linkedin = "http://" + faker.internet().url();

        homePage.goToLoginPage();
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
        loginPage.login("admin@admin.com", "12345");
        homePage.goToProfilePage();
        loginPage.getWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/profile"));
        profilePage.editProfile(name, phone, twitter, linkedin);

        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualGithub = profilePage.getGithub().getAttribute("value");

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualGithub, linkedin);

        loginPage.getWait().until(ExpectedConditions.visibilityOf(profilePage.getSaveBtn()));
        profilePage.getSaveBtn().click();

        Assert.assertTrue(profilePage.getSavedMsg().getText().contains("Profile saved successfuly"));
    }
}
