package com.zhialex.tests.tests;

import com.codeborne.selenide.Configuration;
import com.zhialex.tests.model.PracticeFormViewModel;
import com.zhialex.tests.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    PracticeFormViewModel form = new PracticeFormViewModel();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }
}
