package com.zhialex.tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zhialex.tests.config.CredentialsConfig;
import com.zhialex.tests.helpers.Attach;
import com.zhialex.tests.model.PracticeFormViewModel;
import com.zhialex.tests.pages.AutomationPracticeFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    PracticeFormViewModel form = new PracticeFormViewModel();
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String[] browser = System.getProperty("browser").split("_");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
        Configuration.remote = String.format(
                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
                config.user(),
                config.password()
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
