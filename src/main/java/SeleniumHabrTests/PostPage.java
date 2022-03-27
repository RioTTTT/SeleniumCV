package SeleniumHabrTests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;

public class PostPage extends BasePage{
    private final static String POST_TITLE = "//h1[@class='tm-article-snippet__title tm-article-snippet__title_h1']";
    public PostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = POST_TITLE)
    private WebElement postTitle;

    @Step("Проверить заголовок открытого поста")
    public PostPage checkTitle(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(POST_TITLE)));
        postTitle.click();
        return this;
    }
    @Step("Получить текущий url")
    public PostPage getCurrentUrl() throws IOException {
        String postUrl = driver.getCurrentUrl();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(POST_TITLE)));
        String title = driver.findElement(By.xpath(POST_TITLE)).getText();
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/posturls.csv",true),"utf-8"));
        writer.write (postUrl + " - " + title + ";" + "\n");
        writer.close();
        return this;
    }

}