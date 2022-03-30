package SeleniumHabrTests;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class LoginPage extends BasePage{
    public static String mail;
    public static String password;
    private final static String MAIL_PLACEHOLDER = "//input[@type='email']";
    private final static String PASSWORD_PLACEHOLDER  = "//input[@type='password']";
    private final static String SUBMIT_BUTTON = "//button[@type='submit']";
    private final static String EMAIL_ERROR_MESSAGE = "//div[@class ='s-error']";
    private final static String PASSWORD_ERROR_MESSAGE = "//div[@class ='notice__text']";
    private final static String LOGIN_ERROR_MESSAGE = "//div[@class ='notice__text']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить логин и пароль из файла")
    public LoginPage beforeTests() {
        getProperties();
        mail = properties.getProperty("mail");
        password = properties.getProperty("password");
        return new LoginPage(driver);
    }

    @FindBy(xpath = MAIL_PLACEHOLDER)
    private WebElement mailInput;
    @FindBy(xpath = PASSWORD_PLACEHOLDER)
    private WebElement passwordInput;
    @FindBy(xpath = SUBMIT_BUTTON)
    private WebElement submitButton;

    @Step("Заполнить плейсхолдер валидным E-mail")
    public LoginPage fillLogin(String mail){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MAIL_PLACEHOLDER)));
        mailInput.sendKeys(mail);
        return this;
    }

    @Step("Заполнить плейсхолдер валидным Password")
    public LoginPage fillPassword(String password){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PASSWORD_PLACEHOLDER)));
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Кликнуть на кнопку войти позитивный сценарий")
    public MainPage clickLoginButtonPositive(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SUBMIT_BUTTON)));
        submitButton.click();
        return new MainPage(driver);
    }

    @Step("Кликнуть на кнопку войти негативный сценарий")
    public LoginPage clickLoginButtonNegative(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SUBMIT_BUTTON)));
        submitButton.click();
        return this;
    }

    @Step("Сообщение об ошибке при авторизации(набор символов в поле E-mail)")
    public LoginPage loginErrorEmail() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EMAIL_ERROR_MESSAGE)));
        MatcherAssert.assertThat(driver.findElement(By.xpath(EMAIL_ERROR_MESSAGE)), hasText("Введите корректный e-mail"));
        return this;
    }
    @Step("Сообщение об ошибке при авторизации")
    public LoginPage loginError() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PASSWORD_ERROR_MESSAGE)));
        MatcherAssert.assertThat(driver.findElement(By.xpath(PASSWORD_ERROR_MESSAGE)), hasText("Пользователь с такой электронной почтой или паролем не найден"));
        return this;
    }
}
