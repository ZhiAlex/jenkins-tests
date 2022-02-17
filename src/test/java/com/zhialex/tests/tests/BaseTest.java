package com.zhialex.tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zhialex.tests.model.PracticeFormViewModel;
import com.zhialex.tests.pages.AutomationPracticeFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.zhialex.tests.helpers.Attach.*;

public class BaseTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    PracticeFormViewModel form = new PracticeFormViewModel();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void addAttachments() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}
