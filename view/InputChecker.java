package view;

import java.util.HashMap;
import java.util.Scanner;

public class InputChecker {
    private final static Scanner SC = new Scanner(System.in, "cp1251");

    private static String input() {
        while (true) {
            String input = SC.nextLine().trim();
            if (input.equals("")) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else {
                return input;
            }
        }
    }

    public static Integer checkInput(HashMap<Integer, String> pattern, String mismatchMsg) {
        System.out.print("Ввод: ");
        while (true) {
            try {
                Integer input = Integer.parseInt(input());
                if (pattern.containsKey(input)) return input;
                else System.out.print(mismatchMsg);
            } catch (NumberFormatException e) {
                System.out.print(mismatchMsg);
            }
        }
    }

    public static Integer checkInput(String mismatchMsg) {
        System.out.print("Ввод: ");
        while (true) {
            try {
                Integer input = Integer.parseInt(input());
                return input;
            } catch (NumberFormatException e) {
                System.out.print(mismatchMsg);
            }
        }
    }

    public static String uncheckedInput() {
        System.out.print("Ввод: ");
        return input();
    }

}
