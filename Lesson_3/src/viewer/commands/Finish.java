package viewer.commands;

import viewer.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }
    @Override
    public void execute() {
        getConsole().finish();
    }
}
