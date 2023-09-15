package model.phonebook;


import model.person.Person;
import model.person.PersonIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Phonebook implements Iterable<Person> {
    private List phoneBook;

    public Phonebook() {
        phoneBook = new ArrayList<>();
    }

    public void addPerson(Person person) {
        phoneBook.add(person);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(phoneBook);
    }
}
