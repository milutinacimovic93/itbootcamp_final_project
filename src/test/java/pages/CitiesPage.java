package pages;

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

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(By.xpath("//*[@id=\"list-item-355\"]/div[2]"));
    }

    public WebElement getCreateItemBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span"));
    }

    public WebElement getSaveNewItemBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]"));
    }

    public WebElement getCreatNameInputField() {
        return getDriver().findElement(By.id("name"));
    }

    public WebElement getSuccesMsgBanner() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
    }
}
