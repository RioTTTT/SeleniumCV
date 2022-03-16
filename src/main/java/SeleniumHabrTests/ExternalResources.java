package SeleniumHabrTests;

import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ExternalResources extends BasePage {
    private final static String YOUTUBE_LINK = "//a[@href='https://www.youtube.com/channel/UCd_sTwKqVrweTt4oAKY5y4w']";


    public ExternalResources(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка что открытый ресурс Ютуб")
    public ExternalResources checkYoutube() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String Url = driver.getCurrentUrl();
        Assertions.assertNotNull(Url, YOUTUBE_LINK);
        return this;
    }

}
