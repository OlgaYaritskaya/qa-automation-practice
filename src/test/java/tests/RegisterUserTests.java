package tests;

import data.UserInputData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountIsDeletedPage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.SignupPage;

public class RegisterUserTests extends BaseTest {

    @Test
    @DisplayName("Аккаунт создается и удаляется")
    public void successfullSignUpAndAccountDeletionTest() {

        LoginPage loginPage = new LoginPage();
        UserInputData userData = new UserInputData();
        loginPage
                .openPageAndVerifyTitle()
                .signUp(userData.nickName, userData.email);
        loginPage
                .checkResult("ENTER ACCOUNT INFORMATION");

        SignupPage signupPage = new SignupPage();
        signupPage
                .setGenderTitle()
                .setPassword(userData.password)
                .setDateOfBirth(userData.yearOfBirth, userData.monthOfBirth, userData.dateOfBirth)
                .signUpForNewsletter(true)
                .signUpForSpecialOffers(true)
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setAddress(userData.address)
                .setCountry(userData.country)
                .setState(userData.state)
                .setCity(userData.city)
                .setZipcode(userData.zipcode)
                .setMobile(userData.userMobile)
                .submit();
        signupPage
                .verifyAccountIsCreated()
                .clickContinue();

        LoggedInPage loggedInPage = new LoggedInPage();
        loggedInPage
                .verifyLoggedInAsUser(userData.nickName)
                .deleteAccount();

        AccountIsDeletedPage accountIsDeletedPage = new AccountIsDeletedPage();
        accountIsDeletedPage
                .verifyTitle()
                .clickContinue();
    }
    @Test
    @DisplayName("Авторизация с несуществующим логином или паролем")
    public void loginWithNonExistingEmailOrPassword() {
        LoginPage loginPage = new LoginPage();
        UserInputData userData = new UserInputData();

        loginPage
                .openPageAndVerifyTitle()
                .login(userData.email, userData.password);
        loginPage
                .incorrectCredentialsMessageShouldAppear();

    }
}
