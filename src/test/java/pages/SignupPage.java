package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.UserInputData.*;

public class SignupPage {
   private SelenideElement
        titleMrsRadioButton = $(".radio [value='Mrs']"),
        passwordInput = $("[data-qa='password']"),
        dayPicker = $("#days"),
        monthPicker = $("#months"),
        yearPicker = $("#years"),
        signUpForNewsletterCheckbox= $("#newsletter"),
        signUpForSpecialOffersCheckbox = $("#optin"),
        firstNameInput = $("[data-qa='first_name']"),
        lastNameInput = $("[data-qa='last_name']"),
        address1Input = $("#address1"),
        countryInput = $("#country"),
        stateInput = $("#state"),
        cityInput = $("#city"),
        zipcodeInput = $("#zipcode"),
        mobileInput = $("#mobile_number"),
        createAccountButton = $("[data-qa='create-account']"),
        createdAccountLocator = $("[data-qa='account-created']"),
        continueButton = $("[data-qa='continue-button']");

        public SignupPage setGenderTitle() {
           titleMrsRadioButton.click();
           return this;
       }
       public SignupPage setPassword(String value) {
           passwordInput.sendKeys(value);
           return this;
       }
       public SignupPage setDateOfBirth(String day, String month, String year) {
           dayPicker.selectOption(day);
           monthPicker.selectOption(month);
           yearPicker.selectOption(year);
           return this;
       }
       public SignupPage signUpForNewsletter(boolean value) {
           if(value) {
               signUpForNewsletterCheckbox.click();
           }
           return this;
       }
       public SignupPage signUpForSpecialOffers(boolean value) {
           if(value) {
               signUpForSpecialOffersCheckbox.click();
           }
           return this;
       }
       public SignupPage setFirstName(String value) {
            firstNameInput.sendKeys(value);
            return this;
       }
       public SignupPage setLastName(String value) {
            lastNameInput.sendKeys(value);
            return this;
       }
       public SignupPage setAddress(String value) {
            address1Input.sendKeys(value);
            return this;
       }
       public SignupPage setCountry(String value) {
            countryInput.selectOption(value);
            return this;
       }
       public SignupPage setCity(String value) {
            cityInput.sendKeys(value);
            return this;
        }
        public SignupPage setZipcode(String value) {
            zipcodeInput.sendKeys(value);
            return this;
        }
        public SignupPage setMobile(String value) {
            mobileInput.sendKeys(value);
            return this;
        }
        public SignupPage setState(String value) {
            stateInput.sendKeys(value);
            return this;
        }
        public SignupPage submit() {
            createAccountButton.click();
            return this;
        }
        public SignupPage verifyAccountIsCreated() {
            createdAccountLocator.shouldHave(text("ACCOUNT CREATED!"));
            return this;
       }
       public LoggedInPage clickContinue() {
            continueButton.click();
            return new LoggedInPage();
       }
       //создать коллекцию полей и их локаторов
         // метод для заполнения полей
    // содать пользователя ерез апи
}
