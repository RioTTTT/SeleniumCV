package SelenideHabrTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePageSelenide {
    protected static Properties properties = new Properties();

    public static void getProperties() {
        try (InputStream output = new FileInputStream("src/main/resources/Login.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
