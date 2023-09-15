package viewer.commands;

import viewer.view.ConsoleUI;

public class AddPerson extends Command{
    public AddPerson(ConsoleUI console) {
        super("Добавить человека в телефонную книгу", console);
    }
    @Override
    public void execute() {
        getConsole().addPerson();
    }
}
