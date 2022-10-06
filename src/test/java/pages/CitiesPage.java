package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{

    private WebElement searchField;
    private WebElement createItemBtn;
    private WebElement creatNameInputField;
    private WebElement saveNewItemBtn;
    private WebElement succesMsgBanner;
    private WebElement editItemBtn;
    private WebElement editNameInputField;
    private WebElement searchInputField;
    private WebElement searchedText;
    private WebElement delete1st;
    private WebElement deleteBtn;
    private WebElement succesDelMsg;
    private Faker faker;
    private HomePage homePage;


    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div"));
    }

    public WebElement getCreateItemBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span"));
    }

    public WebElement getSaveNewItemBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button[2]/span"));
    }

    public WebElement getCreatNameInputField() {
        return getDriver().findElement(By.id("name"));
    }

    public WebElement getSuccesMsgBanner() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
    }

    public WebElement getEditItemBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"edit\"]/span/i"));
    }

    public WebElement getEditNameInputField() {
        return getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
    }

    public WebElement getSearchInputField() {
        return getDriver().findElement(By.xpath("//*[@id=\"search\"]"));
    }

    public WebElement getFirstCityText() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
    }

    public WebElement getSearchedText() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
    }

    public WebElement getDelete1st() {
        return getDriver().findElement(By.xpath("//*[@id=\"delete\"]/span/i"));
    }

    public WebElement getDeleteBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"));
    }

    public WebElement getSuccesDelMsg() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"));
    }

    public void addNewCity() throws InterruptedException {
        faker = new Faker();
        String city = faker.address().city();
        getCreateItemBtn().click();
        getCreatNameInputField().click();
        getCreatNameInputField().sendKeys(city);
        Thread.sleep(1000);
        getSaveNewItemBtn().click();
    }

    public void editCity() {
        faker = new Faker();
        String city = faker.address().city();
        getEditItemBtn().click();
        getEditNameInputField().click();
        getEditNameInputField().clear();
        getEditNameInputField().sendKeys(city);
        getSaveNewItemBtn().click();
    }

    public void searchCity() throws InterruptedException {
        getSearchField().click();
        Thread.sleep(2000);
        String city = getFirstCityText().getText();
        getSearchInputField().sendKeys(city);
        Thread.sleep(2000);
    }

    public void deleteCity() throws InterruptedException {
        getDelete1st().click();
        Thread.sleep(1000);
        getDeleteBtn().click();
    }
}
