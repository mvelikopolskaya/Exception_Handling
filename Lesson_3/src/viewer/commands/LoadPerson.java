package viewer.commands;

import viewer.view.ConsoleUI;

public class LoadPerson extends Command{
    public LoadPerson(ConsoleUI console) {
        super("Загрузить список однофамильцев", console);
    }
    @Override
    public void execute() {
        getConsole().loadFile();
    }
}
