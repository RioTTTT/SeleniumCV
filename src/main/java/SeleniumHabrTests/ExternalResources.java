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
    private final static String FACEBOOK_LINK = "//a[@href='https://www.facebook.com/habrahabr.ru']";
    private final static String VK_LINK = "//a[@href='https://vk.com/habr']";

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

    @Step("Проверка что открытый ресурс Фейсбук")
    public ExternalResources checkFacebook() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String Url = driver.getCurrentUrl();
        Assertions.assertNotNull(Url, YOUTUBE_LINK);
        return this;
    }

    @Step("Проверка что открытый ресурс ВК")
    public ExternalResources checkVk() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String Url = driver.getCurrentUrl();
        Assertions.assertNotNull(Url, VK_LINK);
        return this;
    }
}
