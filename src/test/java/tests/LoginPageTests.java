package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void successfullLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage
                .openPageAndVerifyTitle()
                .setName("Sveta")
                .setEmail("sveta@mail.ru")
                .signup();

        loginPage
                .checkResult("ENTER ACCOUNT INFORMATION");

    }
}
