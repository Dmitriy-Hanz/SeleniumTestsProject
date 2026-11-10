package StpGroup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public abstract class BaseUiTest {
    public static final String WAY2AUTOMATION_URL = "https://www.way2automation.com/automationpracticesite1.html";

    protected WebDriver driver;

    @BeforeAll
    static void setupEncoding() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
    @BeforeAll
    static void setupDriverManager() {
        
        // Выполняется один раз для всего класса
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options); // Новый браузер для каждого теста
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) driver.quit();
    }
}

//САЙТЫ ДЛЯ ТЕСТИРОВАНИЯ:
//для логина - https://www.way2automation.com/automationpracticesite2.html
//             https://www.way2automation.com/automationpracticesite1.html
//форма регистрации - https://www.way2automation.com/way2auto_jquery/registration.php#load_box
//прочие штуки - https://qaplayground.com/
//               https://the-internet.herokuapp.com/




