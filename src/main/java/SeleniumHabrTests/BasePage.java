package SeleniumHabrTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    protected static Properties properties = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public static void getProperties() {
        try (InputStream output = new FileInputStream("src/main/resources/Login.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}