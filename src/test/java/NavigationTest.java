
import Util.driver.DriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pageObjects.DetailsPages;
import pageObjects.HomePages;
import pageObjects.ResultModel;
import pageObjects.ResultPages;

import java.util.List;

public class NavigationTest extends BaseWebTest {

    @Test
    @Description("navegando a mercado libre y probando el input de busqueda")
    public void searchToMercadoLibre()  {

       WebElement searchBox =  DriverManager.getDriver().findElement(By.id("cb1-edit"));
       searchBox.sendKeys("guitarra electrica");
       searchBox.sendKeys(Keys.ENTER);


       List<WebElement> results = DriverManager.getDriver().findElements(By.cssSelector("ol[class*='ui-search-layout'] li"));

       System.out.println("El número de resultados es: " + results.size());

        By priceBy = By.cssSelector("div[class*= 'ui-search-price__second-line'] span[class*= 'andes-money-amount__fraction']");
        By nameBy = By.cssSelector("h2");

        for(WebElement result : results){

            System.out.println("----------");
            System.out.println("El Precio es: " + result.findElement(priceBy).getText());
            System.out.println("El Nombre es: " + result.findElement(nameBy).getText());
            System.out.println("----------");

        }  }

    @Test
    @Description("navegando a mercado libre y probando el input de busqueda condigo más limpio y separado")
    public void searchToMercadoLibre2()  {


        //search
        HomePages homePages = new HomePages();
        homePages.searchFor("Guitarra electrica");

        //Result

        ResultPages resultPages = new ResultPages();
        ResultModel expectedResult = resultPages.clickOnRandomItem();

        //details

        DetailsPages detailsPages = new DetailsPages();
        ResultModel actualResultModel = detailsPages.getDetails();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResult.getPrice(), actualResultModel.getPrice(), "prices don't match"),
                () -> Assertions.assertEquals(expectedResult.getName(), actualResultModel.getName(), "product names don't match")
        );

        }

    @Test
    @Description("navegando a mercado libre y probando el input de busqueda en este caso con otro articulo")
    public void searchToMercadoLibre3()  {


        //search
        HomePages homePages = new HomePages();
        homePages.searchFor("iphone");

        //Result

        ResultPages resultPages = new ResultPages();
        ResultModel expectedResult = resultPages.clickOnRandomItem();

        //details

        DetailsPages detailsPages = new DetailsPages();
        ResultModel actualResultModel = detailsPages.getDetails();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResult.getPrice(), actualResultModel.getPrice(), "prices don't match"),
                () -> Assertions.assertEquals(expectedResult.getName(), actualResultModel.getName(), "product names don't match")
        );

    }

    /*@Test
    @Description("fallando el test")
    public void fail(){
        Assertions.assertTrue(false);
    }*/

    }

