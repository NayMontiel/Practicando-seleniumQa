package pageObjects;

import Util.Photographer;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePages {
    private Photographer photographer;
    private WebDriver driver;
    private Wait wait;
    @FindBy(id = "cb1-edit")
    private WebElement searchBox;



    public HomePages(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        PageFactory.initElements(driver, this);
        photographer = new Photographer(driver);
    }
    @Step("buscando producto")
    public void searchFor(String item) {
        photographer.takePhoto();
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }


}
