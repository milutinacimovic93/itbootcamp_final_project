package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{

    private WebElement searchField;

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(By.xpath("//*[@id=\"list-item-355\"]/div[2]"));
    }
}
