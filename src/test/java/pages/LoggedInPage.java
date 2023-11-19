package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static pages.UserInputData.*;

public class LoggedInPage {
    private SelenideElement
            loggedInAsLocator = $(".nav .fa-user").parent(),
            deleteAccountButton = $("[href='/delete_account']");

    public LoggedInPage verifyLoggedInAsUser(String value) {
        loggedInAsLocator
                .shouldBe(Condition.visible)
                .shouldHave(text(nickName));
        return this;
    }
    public LoggedInPage deleteAccount() {
        deleteAccountButton.click();
        return this;
    }
   }

