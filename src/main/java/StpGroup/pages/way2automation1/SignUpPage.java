package StpGroup.pages.way2automation1;

import StpGroup.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {

    private static final By NAME_INPUT = By.cssSelector("#reg-name");
    private static final By EMAIL_INPUT = By.cssSelector("#reg-email");
    private static final By PASSWORD_INPUT = By.cssSelector("#reg-password");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[text()='Create Account'][@type='submit']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void fillNameInput(String value)
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
        input.clear();
        input.sendKeys(value);
    }
    public void fillEmailInput(String value)
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
        input.clear();
        input.sendKeys(value);
    }
    public void fillPasswordInput(String value)
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        input.clear();
        input.sendKeys(value);
    }

    public void clickCreateAccountButton()
    {
        WebElement button = driver.findElement(CREATE_ACCOUNT_BUTTON);
        button.click();
    }

    public boolean isNameValid()
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
        return (boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].checkValidity();",input);
    }
    public boolean isEmailValid()
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
        return (boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].checkValidity();",input);
    }
    public boolean isPasswordValid()
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        return (boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].checkValidity();",input);
    }
}
