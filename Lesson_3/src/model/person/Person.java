package model.person;

public class Person {
    private String firstName;
    private String lastName;
    private  String middleName;
    private String birthDate;
    private Integer phoneNumber;
    private Character gender;

    public Person(String firstName, String lastName, String middleName, String birthDate, Integer phoneNumber, Character gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonInfo() {
        return getLastName() + " " + getFirstName() + " " + getMiddleName() + " " + getBirthDate() + " " + getPhoneNumber() + " " + getGender();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Фамилия: ");
        stringBuilder.append(getLastName());
        stringBuilder.append(" ");
        stringBuilder.append("Имя: ");
        stringBuilder.append(getFirstName());
        stringBuilder.append(" ");
        stringBuilder.append("Отчество: ");
        stringBuilder.append(getMiddleName());
        stringBuilder.append(" ");
        stringBuilder.append("Дата рождения: ");
        stringBuilder.append(getBirthDate());
        stringBuilder.append(" ");
        stringBuilder.append("Пол: ");
        stringBuilder.append(getGender());
        stringBuilder.append(" ");
        stringBuilder.append("Номер телефона: ");
        stringBuilder.append(getPhoneNumber());
        return stringBuilder.toString();
    }
}
