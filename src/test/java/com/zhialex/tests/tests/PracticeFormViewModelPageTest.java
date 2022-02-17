package com.zhialex.tests.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormViewModelPageTest extends BaseTest {

    @Test
    public void fillAutomationPracticeFormPage() {

        automationPracticeFormPage.openPage();

        automationPracticeFormPage.setValues(form);

        automationPracticeFormPage
                .checkResultFields("Student Name", form.fName + " " + form.lName)
                .checkResultFields("Student Email", form.email)
                .checkResultFields("Gender", form.gender)
                .checkResultFields("Mobile", form.phone)
                .checkResultFields("Date of Birth", form.birthday)
                .checkResultFields("Subjects", form.subjects.get(0) + ", " +
                        form.subjects.get(1) + ", " + form.subjects.get(2))
                .checkResultFields("Hobbies", form.hobbies)
                .checkResultFields("Picture", "cat.png")
                .checkResultFields("Address", form.address)
                .checkResultFields("State and City", form.states.get(0) + " " + form.cities.get(0));
    }
}
