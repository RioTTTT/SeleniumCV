package SelenideHabrTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageSelenide extends BasePageSelenide {
    public static String mail;
    public static String password;
    private final static String MAIL_PLACEHOLDER = "//input[@type='email']";
    private final static String PASSWORD_PLACEHOLDER  = "//input[@type='password']";
    private final static String SUBMIT_BUTTON = "//button[@type='submit']";


    @Step("Получить логин и пароль из файла")
    public LoginPageSelenide beforeTests() {
        getProperties();
        mail = properties.getProperty("mail");
        password = properties.getProperty("password");
        return this;
    }

    private SelenideElement mailInput = $(By.xpath(MAIL_PLACEHOLDER));
    private SelenideElement passwordInput = $(By.xpath(PASSWORD_PLACEHOLDER));
    private SelenideElement submitButton = $(By.xpath(SUBMIT_BUTTON));

    @Step("Заполнить плейсхолдер E-mail")
    public LoginPageSelenide fillLogin(String mail){
        mailInput.sendKeys(mail);
        return this;
    }

    @Step("Заполнить плейсхолдер Password")
    public LoginPageSelenide fillPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Кликнуть на кнопку войти")
    public MainPageSelenide clickLoginButton(){
        submitButton.click();
        return page(MainPageSelenide.class);
    }
}
