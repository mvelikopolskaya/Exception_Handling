//Разработайте программу, которая выбросит Exception,
//когда пользователь вводит пустую строку.
//Пользователю должно показаться сообщение,
//что пустые строки вводить нельзя.

import java.util.EmptyStackException;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        noEmptyStrings();
    }

    public static void noEmptyStrings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String line = scanner.nextLine();
        if (line.isEmpty()){
            System.out.println("Нельзя вводить пустые строки");
            throw new EmptyStackException();
        }
    }
}
