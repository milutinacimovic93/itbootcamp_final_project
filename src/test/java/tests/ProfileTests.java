package tests;

import com.github.javafaker.Faker;
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

    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    @Test
    public void editProfileTest() throws InterruptedException {
        Faker faker = new Faker();
        String name = String.valueOf(faker.funnyName());
        String phone = String.valueOf(faker.phoneNumber());
        String twitter = "http://" + faker.internet().url();
        String linkedin = "http://" + faker.internet().url();
        homePage.goToLoginPage();
        Thread.sleep(2000);
        loginPage.login("admin@admin.com", "12345");
        homePage.goToProfilePage();
        Thread.sleep(2000);
        profilePage.editProfile(name, phone, twitter, linkedin);
        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualLinkedin = profilePage.getGithub().getAttribute("value");
        Thread.sleep(2000);
        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualLinkedin, linkedin);
        Thread.sleep(2000);
        profilePage.getSaveBtn().click();
        Thread.sleep(2000);
        Assert.assertTrue(profilePage.getSavedMsg().getText().contains("Profile saved successfuly"));
    }
}
