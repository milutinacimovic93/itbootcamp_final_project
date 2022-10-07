package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private WebElement name;
    private WebElement phone;
    private WebElement clearPhoneBtn;
    private WebElement city;
    private WebElement clearCityBtn;
    private WebElement country;
    private WebElement twitter;
    private WebElement github;
    private WebElement saveBtn;
    private Faker faker;


    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getName() {
        return getDriver().findElement(By.id("name"));
    }

    public WebElement getPhone() {
        return getDriver().findElement(By.id("phone"));
    }

    public WebElement getCity() {
        return getDriver().findElement(By.id("city"));
    }

    public WebElement getCountry() {
        return getDriver().findElement(By.id("country"));
    }

    public WebElement getTwitter() {
        return getDriver().findElement(By.id("urlTwitter"));
    }

    public WebElement getGithub() {
        return getDriver().findElement(By.id("urlGitHub"));
    }

    public WebElement getClearPhoneBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button"));
    }

    public WebElement getClearCityBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button"));
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span"));
    }

    public WebElement getSavedMsg() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
    }

    public void editProfile(String name, String phone, String twitter, String linkedin) {
        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(name);
        getClearPhoneBtn().click();
        getPhone().click();
        getPhone().sendKeys(phone);
        getClearCityBtn().click();
        getCity().click();
        getDriver().findElement(By.xpath("//*[@id=\"list-item-163-0\"]/div")).click();
        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getTwitter().sendKeys(twitter);
        getGithub().click();
        getGithub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getGithub().sendKeys(linkedin);
    }

}
