package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement
        pageTitleLocator = $("#form"),
        nameInput = $("[data-qa='signup-name']"),
        emailInput = $("[data-qa='signup-email']"),
        signupButton = $("[data-qa='signup-button']"),
        signupPageLocator = $(".login-form");
        private String loginPageTitle = "New User Signup!";

    public LoginPage openPageAndVerifyTitle() {
        open("/login");
        pageTitleLocator
                .shouldBe(visible)
                .shouldHave(text(loginPageTitle));
        return this;
    }
    public LoginPage setName(String value) {
        nameInput.sendKeys(value);
        return this;
    }
    public LoginPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }
    public void signup() {
        signupButton.click();
    }
    public void checkResult(String value) {
        signupPageLocator.shouldHave(text(value));
    }
}
