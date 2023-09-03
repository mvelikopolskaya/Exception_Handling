//Реализуйте метод, который запрашивает у пользователя ввод дробного числа
//(типа float), и возвращает введенное значение.
//Ввод текста вместо числа не должно приводить к падению приложения,
//вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        floatInput();
    }

    public static Float floatInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число");
        Float num = null;
        try{
            num = scanner.nextFloat();
            System.out.println(num);
        } catch (InputMismatchException e){
            System.out.println("Неверный тип данных\nВведите дробное число");
        }
        return num;
    }
}
