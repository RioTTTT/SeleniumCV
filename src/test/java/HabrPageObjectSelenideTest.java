import SelenideHabrTests.LoginPageSelenide;
import SelenideHabrTests.MainPageSelenide;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HabrPageObjectSelenideTest {

    @DisplayName("Авторизация")
    @Test
    public void authorization(){
        Selenide.open("https://habr.com/ru/all/");
        new MainPageSelenide()
                .clickProfileButtonUnAuthed()
                .clickLoginButton()
                .beforeTests()
                .fillLogin(LoginPageSelenide.mail)
                .fillPassword(LoginPageSelenide.password)
                .clickLoginButton()
                .clickProfileButtonAuthed()
                .checkAuth();
    }
    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
