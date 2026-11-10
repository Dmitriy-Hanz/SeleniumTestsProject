package StpGroup.tests.way2automation1;

import StpGroup.BaseUiTest;
import StpGroup.pages.way2automation1.FeaturedProductsPage;
import StpGroup.pages.way2automation1.HomePage;
import StpGroup.pages.way2automation1.LoginPage;
import StpGroup.pages.way2automation1.SignUpPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.JavascriptExecutor;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpValidationFailTest extends BaseUiTest {

    @Test
    public void nameIsEmptyTest(){
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput("");
        sup.fillEmailInput("admin@gmail.com");
        sup.fillPasswordInput("admin");
        sup.clickCreateAccountButton();

        if (!sup.isNameValid())
        {
            return;
        }
        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful"))
        {
            throw new AssertionFailedError(
                    "Empty name validation check",
                    "sup.getActiveAlertText() == null",
                    "sup.getActiveAlertText() == " + txt
            );
        }
        return;
    }

    @Test
    public void nameIsSpaceTest(){
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput(" ");
        sup.fillEmailInput("admin@gmail.com");
        sup.fillPasswordInput("admin");
        sup.clickCreateAccountButton();

        if (!sup.isNameValid())
        {
            return;
        }
        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful"))
        {
            throw new AssertionFailedError(
                    "name is space validation check",
                    "sup.getActiveAlertText() == null",
                    "sup.getActiveAlertText() == " + txt
            );
        }
        return;
    }

    @Test
    public void passwordIsEmptyTest() {
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput("admin");
        sup.fillEmailInput("admin@gmail.com");
        sup.fillPasswordInput("");
        sup.clickCreateAccountButton();

        if (!sup.isPasswordValid())
        {
            return;
        }
        
        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful"))
        {
            throw new AssertionFailedError(
                    "Empty password validation check",
                    "sup.getActiveAlertText() == null",
                    "sup.getActiveAlertText() == " + txt
            );
        }
        return;
    }

    @Test
    public void passwordIsSpaceTest() {
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput("admin");
        sup.fillEmailInput("admin@gmail.com");
        sup.fillPasswordInput(" ");
        sup.clickCreateAccountButton();

        if (!sup.isPasswordValid())
        {
            return;
        }
        
        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful"))
        {
            throw new AssertionFailedError(
                    "password is space validation check",
                    "sup.getActiveAlertText() == null",
                    "sup.getActiveAlertText() == " + txt
            );
        }
        return;
    }

    static Stream<String> stringsFromFile() throws IOException {
        return Files.lines(Path.of("src/test/resources/testData/emailValidation.txt"));
    }

    @ParameterizedTest
    @MethodSource("stringsFromFile")
    public void emailValidationTest(String email) {
        driver.get(BaseUiTest.WAY2AUTOMATION_URL);
        HomePage hp = new HomePage(driver);
        SignUpPage sup = new SignUpPage(driver);

        hp.clickSignupNavButton();

        sup.fillNameInput("admin");
        sup.fillEmailInput(email);
        sup.fillPasswordInput("admin");
        sup.clickCreateAccountButton();

        if (!sup.isEmailValid())
        {
            return;
        }
        
        String txt = sup.getActiveAlertText();
        if (txt != null && txt.contains("Registration successful"))
        {
            throw new AssertionFailedError(
                    "email validation check, testing: " + email,
                    "sup.getActiveAlertText() == null",
                    "sup.getActiveAlertText() == " + txt
            );
        }
        return;
    }

}
