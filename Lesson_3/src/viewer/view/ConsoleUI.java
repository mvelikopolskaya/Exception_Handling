package viewer.view;

import model.person.Person;
import presenter.Presenter;
import viewer.commands.PhoneBookMenu;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean flag;
    private PhoneBookMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new PhoneBookMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println(menu.menu());
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addPerson() {
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество");
        String middleName = scanner.nextLine();
        System.out.println("Введите номер телефона");
        Integer phoneNumber = inputPhoneNumber();
        System.out.println("Введите дату рождения");
        String birthDate = inputDate();
        System.out.println("Введите пол:");
        Character gender = inputGender();
        Person person = presenter.addPerson(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        presenter.saveFile(person);
    }

    public String inputDate () {
        boolean inputDate;
        LocalDate dateOfBirth = null;
        String birthDate;
        String day;
        String month;
        String year;
        do {
            System.out.println("Введите день:");
            day = scanner.nextLine();
            System.out.println("Введите месяц:");
            month = scanner.nextLine();
            System.out.println("Введите год:");
            year = scanner.nextLine();
            inputDate = true;
        if (day.length() == 1){
            day = "0" + day;
        }
        if (month.length() == 1){
            month = "0" + month;
        }
        birthDate = year + "-" + month + "-" + day;
            try {
                dateOfBirth = LocalDate.parse(birthDate);
            } catch(DateTimeParseException e) {
            inputDate = false;
            System.out.println("Неверные данные");
            }
            if(dateOfBirth.compareTo(LocalDate.now()) >= 0) {
                inputDate = false;
                System.out.println("Неверные данные");
            }
        } while(!inputDate);
        return day + "." + month + "." + year;
    }

    public Integer inputPhoneNumber() {
        boolean inputPhoneNumber;
        Integer phonenumber = null;
        do{
            String phoneNum = scanner.nextLine();
            inputPhoneNumber = true;
            try {
                phonenumber = Integer.parseInt(phoneNum);
            } catch (InputMismatchException e){
                inputPhoneNumber = false;
                System.out.println("Неверные данные\n" +
                                    "Повторите ввод");
            }
        } while (!inputPhoneNumber);
        return phonenumber;
    }

    public Character inputGender() {
        boolean inputGender = true;
        Character humanGender = null;
        do{
            String gender = scanner.nextLine();
            if(gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                humanGender = 'f';
                inputGender = true;
            }
            else if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")){
                humanGender = 'm';
                inputGender = true;
            } else {
                inputGender = false;
                System.out.println("Неверные данные\n" +
                                    "Повторите ввод");
            }
        } while (!inputGender);
        return humanGender;
    }

    public void findPersonByLastName() {
        System.out.println("Введите фамилию");
        String requiredPerson = scanner.nextLine();
        System.out.println(presenter.findByLastName(requiredPerson));
    }

    public void showPhoneBook() {
        presenter.showPhoneBook();
    }

    public void loadFile() {
        System.out.println("Введите имя файла");
        String reqiredLastname = scanner.nextLine();
        presenter.loadFile(reqiredLastname);
        presenter.showPhoneBook();
    }

    public void finish() {
        flag = false;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
