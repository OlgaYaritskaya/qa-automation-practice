package tests;

import org.junit.jupiter.api.Test;
import pages.AccountIsDeletedPage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.SignupPage;

import static pages.UserInputData.*;

public class RegisterUserTests extends BaseTest {

    @Test
    public void successfullLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPageAndVerifyTitle()
                .login(nickName, email);
        loginPage
                .checkResult("ENTER ACCOUNT INFORMATION");

        SignupPage signupPage = new SignupPage();
        signupPage
                .setGenderTitle()
                .setPassword(password)
                .setDateOfBirth()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setCountry(country)
                .setState(state)
                .setCity(city)
                .setZipcode(zipcode)
                .setMobile(userMobile)
                .submit();
        signupPage
                .verifyAccountIsCreated()
                .clickContinue();

        LoggedInPage loggedInPage = new LoggedInPage();
        loggedInPage
                .verifyLoggedInAsUser(nickName)
                .deleteAccount();

        AccountIsDeletedPage accountIsDeletedPage = new AccountIsDeletedPage();
        accountIsDeletedPage
                .verifyTitle()
                .clickContinue();
    }
}
