package viewer.commands;

import viewer.view.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookMenu {
    private List<Command> commandsList;

    public PhoneBookMenu(ConsoleUI console) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddPerson(console));
        commandsList.add(new FindPersonByLastName(console));
        commandsList.add(new LoadPerson(console));
        commandsList.add(new ShowPhoneBook(console));
        commandsList.add(new Finish(console));

    }

    public String menu() {
        StringBuilder strbuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            strbuilder.append(i + 1);
            strbuilder.append(". ");
            strbuilder.append(commandsList.get(i).getCommandDescription());
            strbuilder.append("\n");
        }
        return strbuilder.toString();
    }

    public void execute(int act) {
        Command command = commandsList.get(act - 1);
        command.execute();
    }

    public int listSize() {
        return commandsList.size();
    }
}