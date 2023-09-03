//Если необходимо, исправьте данный код

//try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//        }

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        int[] intArray = new int[] {1, 5, 6, 3, 9, 8, 4, 2, 2};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите делимое (индекс элемента массива)");
            int divisible = intArray[scanner.nextInt() - 1];
            System.out.println("Введите делитель");
            int d = scanner.nextInt();
            double catchedRes1 = (double) divisible / d;
            System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
