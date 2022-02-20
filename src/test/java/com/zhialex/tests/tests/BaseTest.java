package com.zhialex.tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zhialex.tests.helpers.Attach;
import com.zhialex.tests.model.PracticeFormViewModel;
import com.zhialex.tests.pages.AutomationPracticeFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    PracticeFormViewModel form = new PracticeFormViewModel();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", System.getProperty("browser").split("_")[0]);
        capabilities.setCapability("browserVersion", System.getProperty("browser").split("_")[1]);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = String.format(
                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
                System.getProperty("user"),
                System.getProperty("password")
        );
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
