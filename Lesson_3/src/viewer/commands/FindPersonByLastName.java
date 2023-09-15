package viewer.commands;

import viewer.view.ConsoleUI;

public class FindPersonByLastName extends  Command{
    public FindPersonByLastName(ConsoleUI console) {
        super("Найти человека по фамилии", console);
    }
    @Override
    public void execute() {
        getConsole().findPersonByLastName();
    }
}
