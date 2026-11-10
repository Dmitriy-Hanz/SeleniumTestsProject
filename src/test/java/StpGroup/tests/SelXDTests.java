package StpGroup.tests;

import StpGroup.BaseUiTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

//@SpringBootTest
public class SelXDTests extends BaseUiTest {

    @Test
    public void openWebsiteAndCheckTitle() {
        // Открываем сайт
        driver.get("https://www.selenium.dev");

        // Получаем заголовок страницы
        String pageTitle = driver.getTitle();
        System.out.println("Заголовок страницы: " + pageTitle);

        // Проверяем, что заголовок содержит ожидаемый текст
        assertTrue(pageTitle.contains("Selenium"), "Заголовок должен содержать 'Selenium'");
    }
}
