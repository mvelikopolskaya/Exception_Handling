package viewer.commands;

import viewer.view.ConsoleUI;

public class ShowPhoneBook extends Command{
    public ShowPhoneBook(ConsoleUI console) {
        super("Показать телефонную книгу", console);
    }
    @Override
    public void execute() {
        getConsole().showPhoneBook();
    }
}
