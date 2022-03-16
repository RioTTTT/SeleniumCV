package SeleniumHabrTests;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;
public class MainPage extends BasePage {
    private final static String UNAUTH_PROFILE_BUTTON = "//div[@class='tm-dropdown']";
    private final static String AUTH_PROFILE_BUTTON = "//div[@data-test-id='menu-toggle-user']";
    private final static String LOGIN_BUTTON = "//a[@href='https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru']";
    private final static String LOGIN_BANNER = "//div[@class='tm-dropdown__body tm-dropdown__body_right']";
    private final static String USER_NAME = "//a[@class='tm-user-item__username']";
    private final static String RUVDS = "//a[@href='/ru/company/ruvds/blog/']";
    private final static String GET_FIRST_POST_TITLE = "//h2[@class='tm-article-snippet__title tm-article-snippet__title_h2']" +
            "/ancestor::div[@class='tm-articles-list']/article[1]/div/h2";
    private final static String CLICK_FIRST_POST = "//a[@class='tm-article-snippet__title-link'][1]";
    private final static String GET_ALL_POSTS = "//a[@class='tm-article-snippet__title-link']";
    private final static String YOUTUBE_LINK = "//a[@href='https://www.youtube.com/channel/UCd_sTwKqVrweTt4oAKY5y4w']";
    private final static String LOGOUT_BUTTON = "//a[@rel='nofollow']";
    private final static String CHECK_LOGOUT = "//a[@href='https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru']";
    private final static String HEADER_SEARCH_BUTTON = "//a[@class='tm-header-user-menu__item tm-header-user-menu__search']";
    private final static String SEARCH_PLACEHOLDER = "//input[@class='tm-input-text-decorated__input']";
    private final static String PLACEHOLDER_SEARCH_BUTTON = "//span[@class='tm-svg-icon__wrapper tm-search__icon']";
    private final static String POST_TITLE = "//h1[@class='tm-article-snippet__title tm-article-snippet__title_h1']";

    public static String searchTag = "Тестирование";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = UNAUTH_PROFILE_BUTTON)
    private WebElement unAuthProfileButton;

    @Step("Кликнуть на иконку неавторизованного профиля")
    public MainPage clickProfileButtonUnAuthed() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(UNAUTH_PROFILE_BUTTON)));
        unAuthProfileButton.click();
        return this;
    }
    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;


    @Step("Кликнуть на кнопку войти")
    public LoginPage clickLoginButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LOGIN_BANNER)));
        loginButton.click();
        return new LoginPage(driver);
    }
    @FindBy(xpath = AUTH_PROFILE_BUTTON)
    private WebElement authProfileButton;

    @Step("Кликнуть на иконку авторизованного профиля")
    public MainPage clickProfileButtonAuthed() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(UNAUTH_PROFILE_BUTTON)));
        authProfileButton.click();
        return this;
    }

    @Step("Проверить что пользователь авторизован")
    public MainPage checkAuth() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(USER_NAME)));
        MatcherAssert.assertThat(driver.findElement(By.xpath(USER_NAME)), hasText("@lol4444"));
        return this;
    }
    @FindBy(xpath = RUVDS)
    private WebElement ruvdsButton;

    @Step("Кликнуть на блог RUVDS")
    public FollowPage ruvdsClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(RUVDS)));
        ruvdsButton.click();
        return new FollowPage(driver);
    }
    @FindBy(xpath = GET_FIRST_POST_TITLE)
    private WebElement getTitle;

    @Step("Получить заголовок первого поста")
    public MainPage getFirstPostTitle(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GET_FIRST_POST_TITLE)));
        String title = String.valueOf(driver.findElement(By.xpath(GET_FIRST_POST_TITLE)));
        return this;
    }
    @FindBy(xpath = CLICK_FIRST_POST)
    private WebElement firstPostButton;

    @Step("Открыть первый пост")
    public PostPage firstPost() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CLICK_FIRST_POST)));
        firstPostButton.click();
        return new PostPage(driver);
    }
    @FindBy(xpath = YOUTUBE_LINK)
    private WebElement youtubeButton;

    @Step("Кликнуть на иконку Ютуба в подвале")
    public ExternalResources youtube() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(YOUTUBE_LINK)));
        youtubeButton.click();
        return new ExternalResources(driver);
    }
    @FindBy(xpath = LOGOUT_BUTTON)
    private WebElement logoutButton;

    @Step("Выйти из авторизованного аккаунта")
    public MainPage logout() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LOGOUT_BUTTON)));
        logoutButton.click();
        return new MainPage(driver);
    }
    @FindBy(xpath = CHECK_LOGOUT)
    private WebElement logoutMarker;

    @Step("Проверить что пользователь неавторизован")
    public MainPage logoutCheck() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CHECK_LOGOUT)));
        MatcherAssert.assertThat(driver.findElement(By.xpath(CHECK_LOGOUT)), hasText("Войти"));
        return new MainPage(driver);
    }
    @FindBy(xpath = HEADER_SEARCH_BUTTON)
    private WebElement headerSearchButton;

    @Step("Кликнуть на кнопку поиска в хедере")
    public MainPage headerSearchButtonClick(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HEADER_SEARCH_BUTTON)));
        headerSearchButton.click();
        return new MainPage(driver);
    }

    @FindBy(xpath = SEARCH_PLACEHOLDER)
    private WebElement searchPlaceholder;

    @Step("Кликнуть на плейсхолдер")
    public MainPage clickSearchPlaceholder(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SEARCH_PLACEHOLDER)));
        searchPlaceholder.click();
        return new MainPage(driver);
    }

    @Step("Вставить слово для поиска")
    public MainPage sendSearchTag(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SEARCH_PLACEHOLDER)));
        searchPlaceholder.sendKeys(searchTag);
        return new MainPage(driver);
    }

    @FindBy(xpath = PLACEHOLDER_SEARCH_BUTTON)
    private WebElement placeSearchButton;

    @Step("Кликнуть на кнопку поиска в плейсхолдере")
    public MainPage placeholderSearchButtonClick(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PLACEHOLDER_SEARCH_BUTTON)));
        placeSearchButton.click();
        return new MainPage(driver);
    }

    @FindBy(xpath = GET_ALL_POSTS)
    ArrayList<WebElement>  getAllPosts;

    @Step("Получить все посты")
    public void printAllTitles(){
        getAllPosts.forEach(e -> System.out.println(e.findElement(By.xpath(POST_TITLE)).getText()));

    }
//    @Step("Кликнуть на кнопку поиска в плейсхолдере")
//    public MainPage placeholderSearchButtonClick(){
//        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PLACEHOLDER_SEARCH_BUTTON)));
//        placeSearchButton.click();
//        return new MainPage(driver);
//    }
}