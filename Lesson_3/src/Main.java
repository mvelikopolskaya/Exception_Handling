import viewer.view.ConsoleUI;
import viewer.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}