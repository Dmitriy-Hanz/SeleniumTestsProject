package StpGroup.pages.way2automation1;

import StpGroup.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FeaturedProductsPage extends BasePage {
    private static final By VISIBILITY_CHECK = By.cssSelector("section#products");

    public FeaturedProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean checkPageVisibility(){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(VISIBILITY_CHECK));
        }
        catch (TimeoutException e) {
            return false;
        }
        return true;
    };
}
