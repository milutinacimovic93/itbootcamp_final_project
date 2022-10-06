package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.time.Duration;

public class AuthRoutesTest extends BaseTest{

    private HomePage homePage;
    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    @Test(priority = 1)
    public void verifyGuestCantReachHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 1)
    public void verifyGuestCantReachProfilePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 3)
    public void verifyGuestCantReachAdminCitiesPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 4)
    public void verifyGuestCantReachAdminUsersPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
