import Util.TestResultLoggerExtension;
import Util.driver.DriverFactory;
import Util.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

@ExtendWith(TestResultLoggerExtension.class)
public abstract class BaseWebTest {

    private static final String DEFAULT_BROWSER = "chrome";

    @BeforeEach
    public void Setup() {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = DriverFactory.valueOf(DEFAULT_BROWSER.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get("https://www.mercadolibre.cl");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }
    @AfterEach
    public void TearDown() {
        DriverManager.getDriver().quit();
    }

}
