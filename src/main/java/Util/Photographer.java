package Util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photographer {
    private final WebDriver driver;

    public Photographer(WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takePhoto() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
