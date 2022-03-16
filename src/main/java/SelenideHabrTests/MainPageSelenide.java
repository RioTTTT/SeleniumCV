package SelenideHabrTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class MainPageSelenide {
    private final static String UNAUTH_PROFILE_BUTTON = "//div[@class='tm-dropdown']";
    private final static String AUTH_PROFILE_BUTTON = "//div[@data-test-id='menu-toggle-user']";
    private final static String LOGIN_BUTTON = "//a[@href='https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru']";
    private final static String USER_NAME = "//a[@class='tm-user-item__username']";

    private SelenideElement unAuthProfileButton = $(By.xpath(UNAUTH_PROFILE_BUTTON));

    @Step("Кликнуть на иконку неавторизованного профиля")
    public MainPageSelenide clickProfileButtonUnAuthed() {
        unAuthProfileButton.click();
        return this;
    }

    private SelenideElement loginButton = $(By.xpath(LOGIN_BUTTON));


    @Step("Кликнуть на кнопку войти")
    public LoginPageSelenide clickLoginButton() {
        loginButton.click();
        return page(LoginPageSelenide.class);
    }

    private SelenideElement authProfileButton = $(By.xpath(AUTH_PROFILE_BUTTON));

    @Step("Кликнуть на иконку авторизованного профиля")
    public MainPageSelenide clickProfileButtonAuthed() {
        authProfileButton.click();
        return this;
    }

    private SelenideElement userName = $(By.xpath(USER_NAME));

    @Step("Проверить что пользователь авторизован")
    public MainPageSelenide checkAuth() {
        userName.shouldBe(Condition.visible, Duration.ofSeconds(5));
        assertThat(userName,hasText("@lol4444"));
        return this;
    }
}