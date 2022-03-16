package CommonFiles;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class CustomLogger implements WebDriverListener {
    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
