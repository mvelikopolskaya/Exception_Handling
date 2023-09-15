package viewer.commands;

public interface ICommand {
    String getCommandDescription();
    void execute();
}
