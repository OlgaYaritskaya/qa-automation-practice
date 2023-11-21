package data;

import com.github.javafaker.Faker;
import pages.RandomUtils;

import java.util.Locale;
import java.util.Optional;

import static pages.RandomUtils.*;

public class UserInputData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String
            nickName = faker.name().username(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = getRandomEmail(),
            dateOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1970, 2000)),
            country = faker.options().option("India","United States","Canada","Australia","New Zealand","Singapore"),
            state = faker.country().capital(),
            city = faker.address().city(),
            zipcode = faker.address().zipCode(),
            address = faker.address().streetAddress(),
            userMobile = String.valueOf(faker.phoneNumber()),
            password = faker.internet().password();
}
