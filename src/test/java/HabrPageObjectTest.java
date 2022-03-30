import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumHabrTests.MainPage;
import CommonFiles.Endpoints;
import SeleniumHabrTests.LoginPage;
import CommonFiles.CustomLogger;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.IOException;


public class HabrPageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.manage().window().maximize();
        driver.get(Endpoints.COMMON_URL_HABR);
    }

    @DisplayName("Авторизация")
    @Test
    void authorization(){
        new MainPage(driver)
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin(LoginPage.mail)
                .fillPassword(LoginPage.password)
                .clickLoginButtonPositive()
                .clickProfileButtonAuthed()
                .checkAuth();
    }

    @DisplayName("Авторизация неправильный Email")
    @Test
    void authorizationIncorrectLogin(){
        new MainPage(driver)
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin("mail")
                .fillPassword(LoginPage.password)
                .clickLoginButtonNegative()
                .loginErrorEmail();
    }

    @DisplayName("Авторизация неправильный пароль")
    @Test
    void authorizationIncorrectPassword(){
        new MainPage(driver)
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin(LoginPage.mail)
                .fillPassword("password")
                .clickLoginButtonNegative()
                .loginError();
    }

    @DisplayName("Добавление поста в избранное")
    @Test
    public void addToFavorite(){
        new MainPage(driver)
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin(LoginPage.mail)
                .fillPassword(LoginPage.password)
                .clickLoginButtonPositive()
                .ruvdsClick()
                .activateFollow()
                .chekFollow()
                .unFollow();
    }

    @DisplayName("Открыть пост не авторизованная зона")
    @Test
    public void openNewPost() {
        new MainPage(driver)
                .getFirstPostTitle()
                .firstPost()
                .checkTitle();
    }

    @DisplayName("Переход на канал Habr на фейсбуке не авторизованная зона")
    @Test
    public void openFacebook() {
        new MainPage(driver)
                .facebook()
                .checkFacebook();
    }

    @DisplayName("Переход на канал Habr во вконтакте не авторизованная зона")
    @Test
    public void openVk() {
        new MainPage(driver)
                .vk()
                .checkVk();
    }

    @DisplayName("Переход на канал Habr на ютубе не авторизованная зона")
    @Test
    public void openYoutube() {
        new MainPage(driver)
                .youtube()
                .checkYoutube();
    }

    @DisplayName("Выход с аккаунта")
    @Test
    public void logout() {
        new MainPage(driver)
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin(LoginPage.mail)
                .fillPassword(LoginPage.password)
                .clickLoginButtonPositive()
                .clickProfileButtonAuthed()
                .logout()
                .clickProfileButtonUnAuthed()
                .logoutCheck();
    }

    @DisplayName("Копирование ссылки поста")
    @Test
    public void copyLink() throws IOException {
        new MainPage(driver)
                .headerSearchButtonClick()
                .clickSearchPlaceholder()
                .sendSearchTag()
                .placeholderSearchButtonClick()
                .getFirstPostTitle()
                .firstPost()
                .getCurrentUrl();
    }

    @DisplayName("Копирование ссылки поста")
    @Test
    public void copyAllLink(){
        new MainPage(driver)
                .headerSearchButtonClick()
                .clickSearchPlaceholder()
                .sendSearchTag()
                .placeholderSearchButtonClick()
                .printAllTitles();
    }



    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
