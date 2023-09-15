package model.person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> phoneBook;

    public PersonIterator(List<Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public boolean hasNext() {
        return phoneBook.size() > index;
    }

    @Override
    public Person next() {
        return phoneBook.get(index++);
    }
}
