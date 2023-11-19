package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
     @BeforeAll
     static void beforeAll() {
         Configuration.browserSize = "1920x1080";
         Configuration.baseUrl = "https://automationexercise.com";
         Configuration.pageLoadStrategy = "eager";
         Configuration.holdBrowserOpen = true;
     }
     @AfterEach
     public void afterEach() {
            clearBrowserCookies();
            clearBrowserLocalStorage();
            closeWebDriver();
     }
}
