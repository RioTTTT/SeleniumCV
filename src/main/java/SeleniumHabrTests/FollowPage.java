package SeleniumHabrTests;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class FollowPage extends BasePage{
    private final static String FOLLOW_BUTTON_UNACTIVE = "//button[@class='tm-button-follow__button tm-button-follow__button_big']";
    private final static String FOLLOW_BUTTON_ACTIVE = "//button[@class='tm-button-follow__button tm-button-follow__button_big " +
            "tm-button-follow__button_is-active']";

    public FollowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = FOLLOW_BUTTON_UNACTIVE)
    private WebElement followUnactive;

    @Step("Клик на кнопку подписаться")
    public FollowPage activateFollow(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(FOLLOW_BUTTON_UNACTIVE)));
        followUnactive.click();
        return this;
    }
    @Step("Проверка подписки на блог")
    public FollowPage chekFollow(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(FOLLOW_BUTTON_ACTIVE)));
        MatcherAssert.assertThat(driver.findElement(By.xpath(FOLLOW_BUTTON_ACTIVE)), hasText("Подписан"));
        return this;
    }

    @FindBy(xpath = FOLLOW_BUTTON_ACTIVE)
    private WebElement followActive;

    @Step("Проверка отписки на блог")
    public FollowPage unFollow(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(FOLLOW_BUTTON_ACTIVE)));
        followActive.click();
        return this;
    }

}