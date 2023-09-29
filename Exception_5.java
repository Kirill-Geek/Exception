package Excteption;

import java.util.Scanner;

public class Exception_5 {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mystr();
    }

    public static String mystr() {
        System.out.println("Введите строку");
        String x = iScanner.next();
        if (x.length() == 0) {
            throw new NullPointerException("Пустые строки вводить нельзя");
        }
        return x;
    }
}
