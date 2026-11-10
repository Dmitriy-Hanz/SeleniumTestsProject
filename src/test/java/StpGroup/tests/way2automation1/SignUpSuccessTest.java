package StpGroup.tests.way2automation1;

import StpGroup.BaseUiTest;
import StpGroup.pages.way2automation1.HomePage;
import StpGroup.pages.way2automation1.SignUpPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class SignUpSuccessTest extends BaseUiTest {

    @Test
    public void signUpSuccessTest() {
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput("admin");
        sup.fillEmailInput("admin@gmail.com");
        sup.fillPasswordInput("admin");
        sup.clickCreateAccountButton();

        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful")){
            return;
        }
        fail("Successful sign up test");
    }
}
