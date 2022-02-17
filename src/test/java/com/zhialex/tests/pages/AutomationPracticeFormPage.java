package com.zhialex.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.zhialex.tests.model.PracticeFormViewModel;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {

    SelenideElement
            firstname = $("#firstName"),
            lastname = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            resultTable = $(".table-responsive");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void setFName(String fName) {
        firstname.setValue(fName);
    }

    public void setLName(String lName) {
        lastname.setValue(lName);
    }

    public void setEmail(String email) {
        userEmail.setValue(email);
    }

    public void setGender(String gender) {
        String xpath = String.format("//label[text()='%s']", gender);
        $(By.xpath(xpath)).click();
    }

    public void setMobilePhone(String phone) {
        userNumber.setValue(phone);
    }

    public void setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void checkHobbiesCheckbox(String value) {
        String xpath = String.format("//div[@id='hobbiesWrapper']//label[text()='%s']", value);
        $(By.xpath(xpath)).parent().click();
    }

    public void loadFile(String filepath) {
        uploadPicture.uploadFile(new File(filepath));
    }

    public void setAddress(String address) {
        currentAddress.setValue(address);
    }

    public void setState(String state) {
        stateInput.setValue(state).pressEnter();
    }

    public void setCity(String city) {
        cityInput.setValue(city).pressEnter();
    }

    public void clickSubmitButton() {
        submitButton.scrollTo().click();
    }

    public void setValues(PracticeFormViewModel form) {
        setFName(form.fName);
        setLName(form.lName);
        setEmail(form.email);
        setGender(form.gender);
        setMobilePhone(form.phone);
        setSubject(form.subjects.get(0));
        setSubject(form.subjects.get(1));
        setSubject(form.subjects.get(2));
        checkHobbiesCheckbox(form.hobbies);
        loadFile(form.filepath);
        setAddress(form.address);
        setState(form.states.get(0));
        setCity(form.cities.get(0));
        clickSubmitButton();
    }

    public AutomationPracticeFormPage checkResultFields(String label, String value) {
        resultTable.$(byText(label))
                .parent().shouldHave(text(value));
        return this;
    }
}
