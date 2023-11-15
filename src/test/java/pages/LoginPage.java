package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement
        signUpFormLocator = $(".signup-form"),
        nameInput = $("[data-qa='signup-name']"),
        emailInput = $("[data-qa='signup-email']"),
        signupButton = $("[data-qa='signup-button']");

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
}
