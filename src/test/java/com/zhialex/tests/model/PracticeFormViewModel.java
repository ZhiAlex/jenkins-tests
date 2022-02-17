package com.zhialex.tests.model;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PracticeFormViewModel {

    private Faker faker = new Faker();
    private SimpleDateFormat format = new SimpleDateFormat("dd MMMMM,yyyy", Locale.US);

    public final String fName;
    public final String lName;
    public final String email;
    public final String gender;
    public final String phone;
    public final String birthday;
    public final List<String> subjects;
    public final String hobbies;
    public final String filepath;
    public final String address;
    public final List<String> states;
    public final List<String> cities;

    public PracticeFormViewModel() {
        this.fName = faker.name().firstName();
        this.lName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.gender = "Male";
        this.phone = faker.numerify("##########");
        this.birthday = format.format(new Date());
        this.subjects = List.of("English", "Physics", "Maths");
        this.filepath = "src/test/resources/files/cat.png";
        this.address = faker.address().fullAddress();
        this.states = List.of("NCR", "Haryana");
        this.cities = List.of("Delhi", "Gurgaon", "Noida");
        this.hobbies = "Reading";
    }
}
