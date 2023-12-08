package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement pageTitleLocator = $("#form");
    private SelenideElement signUpNameInput = $("[data-qa='signup-name']");
    private SelenideElement loginEmailInput = $("[data-qa='login-email']");
    private SelenideElement loginPasswordInput = $("[data-qa='login-password']");
    private SelenideElement loginButton = $("[data-qa='login-button']");
    private SelenideElement message = $("p");
    private SelenideElement signUpEmailInput = $("[data-qa='signup-email']");
    private SelenideElement signupButton = $("[data-qa='signup-button']");
    private SelenideElement signupPageLocator = $(".login-form");
    private SelenideElement loggedInAsIconLocator = $(".fa-user");
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
    public LoginPage setFieldData(SelenideElement fieldName, String data) {
        fieldName.sendKeys(data);
        return this;
    }
    public LoginPage loginAs(String email, String pass) {
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
