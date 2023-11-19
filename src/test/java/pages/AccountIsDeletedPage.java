package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountIsDeletedPage {
    private SelenideElement
            pageTitleLocator = $("[data-qa='account-deleted']"),
            continueButton = $("[data-qa='continue-button']");
private String expectedTitle = "ACCOUNT DELETED!";
    public AccountIsDeletedPage verifyTitle() {
        pageTitleLocator.shouldBe(Condition.visible)
                .shouldHave(text(expectedTitle));
        return this;
    }
    public AccountIsDeletedPage clickContinue() {
        continueButton.click();
        return this;
    }
}