package SeleniumHabrTests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public static String mail;
    public static String password;
    private final static String MAIL_PLACEHOLDER = "//input[@type='email']";
    private final static String PASSWORD_PLACEHOLDER  = "//input[@type='password']";
    private final static String SUBMIT_BUTTON = "//button[@type='submit']";

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

    @Step("Заполнить плейсхолдер E-mail")
    public LoginPage fillLogin(String mail){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MAIL_PLACEHOLDER)));
        mailInput.sendKeys(mail);
        return this;
    }

    @Step("Заполнить плейсхолдер Password")
    public LoginPage fillPassword(String password){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PASSWORD_PLACEHOLDER)));
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Кликнуть на кнопку войти")
    public MainPage clickLoginButton(){
        submitButton.click();
        return new MainPage(driver);
    }
}
