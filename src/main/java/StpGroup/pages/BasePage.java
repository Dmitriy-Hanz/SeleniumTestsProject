package StpGroup.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait wait3Sec;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3Sec = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean checkPageVisibility(){
        return true;
    };

    public boolean hasActiveAlert()
    {
        try {
            wait3Sec.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (NoAlertPresentException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getActiveAlertText()
    {
        if (!hasActiveAlert())
        {
            return null;
        }
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
