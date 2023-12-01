package tests;

import data.UserInputData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountIsDeletedPage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.SignupPage;

public class RegisterUserTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация и удаление аккаунта")
    public void successfullLoginTest() {

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
                .setDateOfBirth(userData.dayOfBirth, userData.monthOfBirth, userData.yearOfBirth)
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setAddress(userData.address)
                .setCountry(userData.country)
                .setState(userData.state)
                .setCity(userData.city)
                .setZipcode(userData.zipcode)
                .setMobile(userData.userMobile)
                .submit();
        var loggedInPage =
        signupPage
                .verifyAccountIsCreated()
                .clickContinue();

var accountIsDeletedPage =
        loggedInPage
                .verifyLoggedInAsUser(userData.nickName)
                .deleteAccount();

        accountIsDeletedPage
                .verifyTitle()
                .clickContinue();
    }
}
