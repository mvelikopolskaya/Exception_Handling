package presenter;

import model.person.Person;
import model.service.Service;
import viewer.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Person addPerson(String firstName, String lastName, String middleName, String birthDate, int phoneNumber, Character gender) {
        return service.addPerson(firstName,lastName, middleName, birthDate, phoneNumber, gender);
    }

    public void showPhoneBook() {
        view.printText(service.showPhoneBook());
    }

    public Person findByLastName(String requiredPerson) {
        return service.findPersonByLastName(requiredPerson);
    }

    public Integer findByPhoneNumber(Integer requiredphoneNumber) {
        return service.findByPhoneNumber(requiredphoneNumber);
    }

    public void saveFile(Person person) {
        service.saveFile(person);
    }
    public String loadFile(String fileName) {
        return service.loadFile(fileName);
    }
}
