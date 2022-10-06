package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class LocaleLanguageTests extends BaseTest{

    private HomePage homePage;
    @BeforeClass
    public void setup() {
        super.setup();
        homePage = new HomePage(driver, driverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void espLangTest() throws InterruptedException {
        homePage.getLanguageBtn().click();
        homePage.getSpainBtn().click();
        String expectedResult = "Página de aterrizaje";
        String actualResult = homePage.getPageHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void engLangTest() throws InterruptedException {
        homePage.getLanguageBtn().click();
        homePage.getEngBtn().click();
        String expectedResult = "Landing";
        String actualResult = homePage.getPageHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void fraLangTest() throws InterruptedException {
        homePage.getLanguageBtn().click();
        homePage.getFranBtn().click();
        String expectedResult = "Page d'atterrissage";
        String actualResult = homePage.getPageHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
