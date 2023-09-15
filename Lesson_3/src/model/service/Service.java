package model.service;

import model.person.Person;
import model.phonebook.Phonebook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Service {
    public Phonebook phonebook;
    public String filePath;

    public Service() {
        this.phonebook = new Phonebook();
        this.filePath = "src/";
    }

    public Person addPerson(String firstName, String lastName, String middleName, String birthDate, int phoneNumber, Character gender) {
        Person person = new Person(firstName, lastName, middleName, birthDate, phoneNumber, gender);
        phonebook.addPerson(person);
        return person;
    }

    public Person findPersonByLastName(String requiredPerson) {
        Person result = null;
        for (Person person : phonebook) {
            if (requiredPerson.equalsIgnoreCase(person.getLastName())) {
                result = person;
            }
        }
        return result;
    }

    public void saveFile(Person person) {
        try(FileWriter writer = new FileWriter(filePath + person.getLastName() + ".txt", true)){
            writer.append(person.getPersonInfo());
            writer.write("\n");
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadFile(String fileName) {
        File file = new File(filePath + fileName + ".txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()){
                personFromFile(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void personFromFile(String textPerson){
        String[] personData = textPerson.split(" ");
        try {
            if(personData.length == 6){
                addPerson(personData[0],
                        personData[1],
                        personData[2],
                        personData[3],
                        Integer.parseInt(personData[4]),
                        personData[5].charAt(0));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public String showPhoneBook() {
        StringBuilder strBuilder = new StringBuilder();
        try {
            strBuilder.append("Телефонная книга:");
            strBuilder.append("\n");
            for (Person person : phonebook) {
                strBuilder.append(person);
                strBuilder.append("\n");
            }
        } catch (NullPointerException e) {
        }
        return strBuilder.toString();
   }
}
