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
    public LoginPage login(String name, String email) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        signupButton.click();
        return this;
    }

    public void checkResult(String value) {
        signupPageLocator.shouldHave(text(value));
    }
}
