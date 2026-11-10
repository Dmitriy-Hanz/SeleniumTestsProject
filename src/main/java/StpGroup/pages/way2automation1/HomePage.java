package StpGroup.pages.way2automation1;

import StpGroup.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By LOGIN_NAV_BUTTON = By.xpath("//div[contains(., 'Login')][@onclick=\"showSection('login')\"]");
    private static final By SIGNUP_NAV_BUTTON = By.xpath("//a[contains(., 'Signup')][@onclick=\"showSection('signup')\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginNavButton()
    {
        WebElement loginNavButton = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_NAV_BUTTON));
        loginNavButton.click();
    }
    public void clickSignupNavButton()
    {
        WebElement loginNavButton = wait.until(ExpectedConditions.elementToBeClickable(SIGNUP_NAV_BUTTON));
        loginNavButton.click();
    }
}
