package Excteption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exteption_2 {
    
    public static void main(String[] args) {
        Math Maths = new Math();
        Math.Met();

    }
}
class Math {

    public static void Met() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите дробное число");
        try {
            float x = (float) iScanner.nextFloat();
            print(x);
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не дробное число");
            Met();
        }
    }
    public static void print(float c){
        System.out.println(c);
    }
}
