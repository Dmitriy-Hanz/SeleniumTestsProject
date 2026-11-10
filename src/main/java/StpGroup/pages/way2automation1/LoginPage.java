package StpGroup.pages.way2automation1;

import StpGroup.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.cssSelector("#login-username");
    private static final By PASSWORD_INPUT = By.cssSelector("#login-password");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsernameInput(String value)
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        input.clear();
        input.sendKeys(value);
    }
    public void fillPasswordInput(String value)
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        input.clear();
        input.sendKeys(value);
    }

    public void clickLoginButton()
    {
        WebElement button = driver.findElement(LOGIN_BUTTON);
        button.click();
    }

}
