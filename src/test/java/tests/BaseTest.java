package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait driverWait;

    //Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
    //baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
    //beforeClass - gde se podesava drajver sa implicitnim cekanjem i
    //cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za
    //testiranje
    //aftterClass - gde se gasi stranica
    //beforeMethod - gde se pre svakog testa ucitava baseUrl stranica

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ROG//IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
