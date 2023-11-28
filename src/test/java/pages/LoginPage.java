package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement
        pageTitleLocator = $("#form"),
        signUpNameInput = $("[data-qa='signup-name']"),
            loginEmailInput = $("[data-qa='login-email']"),
            loginPasswordInput = $("[data-qa='login-password']"),
            loginButton = $("[data-qa='login-button']"),
            message = $("p"),
            signUpEmailInput = $("[data-qa='signup-email']"),
            signupButton = $("[data-qa='signup-button']"),
            signupPageLocator = $(".login-form"),
            loggedInAsIconLocator = $(".fa-user");
        private String loginPageTitle = "New User Signup!";

    public LoginPage openPageAndVerifyTitle() {
        open("/login");
        pageTitleLocator
                .shouldBe(visible)
                .shouldHave(text(loginPageTitle));
        return this;
    }
    public LoginPage signUp(String name, String email) {
        signUpNameInput.sendKeys(name);
        signUpEmailInput.sendKeys(email);
        signupButton.click();
        return this;
    }
    public LoginPage login(String email, String pass) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(pass);
        loginButton.click();
        return this;
    }
    public LoginPage verifyUserIsLoggedIn(String nickName) {
        loggedInAsIconLocator.parent().shouldHave(text(nickName));
        return this;
    }

    public void checkResult(String value) {
                signupPageLocator.shouldHave(text(value));
    }
    public void incorrectCredentialsMessageShouldAppear() {
        message.shouldHave(text("Your email or password is incorrect!"));
    }



}
