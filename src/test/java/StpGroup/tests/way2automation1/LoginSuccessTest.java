package StpGroup.tests.way2automation1;

import StpGroup.BaseUiTest;
import StpGroup.pages.way2automation1.HomePage;
import StpGroup.pages.way2automation1.LoginPage;
import StpGroup.pages.way2automation1.FeaturedProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSuccessTest extends BaseUiTest {
    @Test
    public void loginSuccessTest() throws InterruptedException {
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        FeaturedProductsPage fpp = new FeaturedProductsPage(driver);

        hp.clickLoginNavButton();

        lp.fillUsernameInput("admin");
        lp.fillPasswordInput("admin");
        lp.clickLoginButton();

        assertTrue(fpp.checkPageVisibility(), "Страница Featured Products не открыта");
    }
}
