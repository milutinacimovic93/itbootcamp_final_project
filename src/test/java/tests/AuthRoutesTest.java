package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthRoutesTest extends BaseTest{

    @BeforeClass
    public void setup() {
        super.setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void verifyGuestCantReachHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyGuestCantReachProfilePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyGuestCantReachAdminCitiesPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyGuestCantReachAdminUsersPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
