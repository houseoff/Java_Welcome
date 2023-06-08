package Java_Welcome;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework1 {
    
    public static void main(String[] args) {
        findNumbers();
    }

    // Задание 1. Вычислить сумму арифметической прогрессии
    // (Вычислить n-ое треугольного число (сумма чисел от 1 до n))
    public static int sumOfArithmeticProgression(int a1, int n, int d) {
        return ((2 * a1 + d * (n - 1)) * n) / 2;
    }

    // Задание 1. Вычислить факториал n
    public static long factorial(int n) {
        if (n < 0)            return 0;
        if (n == 0 || n == 1) return 1;
        if (n == 2)           return 2;

        return n * factorial(n - 1);
    }

    // Задание 2. Вывести все простые числа от 1 до 1000
    public static List<Integer> findSimpleNumbers(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            
            if (simple) result.add(i);
        }

        return result;
    }

    // Задание 3. Реализовать простой калькулятор
    public static void simpleCalc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-ое число: ");
        Integer first = scanner.nextInt();
        System.out.print("Введите 2-ое число: ");
        Integer second = scanner.nextInt();
        System.out.print("Введите действие: ");
        String action = scanner.next();
        action = action.trim();
        int result = 0;

        if      (action.matches("^\\+$")) result = first + second;
        else if (action.matches("^-$"))   result = first - second;
        else if (action.matches("^\\*$")) result = first * second;
        else if (action.matches("^/$"))   result = first / second;

        System.out.println("Результат " + first + " " + action + " " + second + ": " + result);
        scanner.close();
    }

    // Задание 4. Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства.
    // Знаки вопроса - одинаковые цифры.
    // Предложить хотя бы одно решение или сообщить, что его нет
    public static void findNumbers() {
        List<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String[] splitted = scanner.nextLine().split("\\+|\\=");
        boolean is_question = false;

        if (splitted.length > 3) {
            System.out.println("Неверное выражение!");
            return;
        }

        for (int i = 0; i < splitted.length; i++) {
            splitted[i] = splitted[i].trim();
        }

        for (int i = 0; i < 2; i++) {
            StringBuilder firstDigit = new StringBuilder();
            if (splitted[i].length() > 2) {
                System.out.println("Слагаемые должны быть максимум двузначными!");
                return;
            }

            if (splitted[i].matches("^[1-9]\\?$")) {
                firstDigit.append(splitted[i].charAt(0));
                list.add(Integer.parseInt(firstDigit.toString()) * 10);
                is_question = true;
            }
            else if (splitted[i].matches("^\\?[1-9]$")) {
                firstDigit.append(splitted[i].charAt(1));
                list.add(Integer.parseInt(firstDigit.toString()));
                is_question = true;
            }
            else if (splitted[i].matches("^\\?\\?$")) {
                list.add(10);
                is_question = true;
            }
            else if (splitted[i].matches("^\\d+$")) {
                list.add(Integer.parseInt(splitted[i]));
            }
            else {
                System.out.println("Неверное выражение!");
                return;
            }

        }

        StringBuilder sb     = new StringBuilder();
        int firstNum         = list.get(0);
        int secondNum        = list.get(1);
        int firstMultiplier  = (firstNum < 10) ? 10: 1;
        int secondMultiplier = (secondNum < 10) ? 10: 1;
        int result           = Integer.parseInt(splitted[2]);

        if (is_question) {
            for (int i = 1; i < 9; i++) {
                int expValue = firstNum + (i * firstMultiplier) + secondNum + (i * secondMultiplier);
                if (expValue == result) {
                    sb.append(firstNum + (i * firstMultiplier));
                    sb.append(" + ");
                    sb.append(secondNum + (i * secondMultiplier));
                    sb.append(" = ");
                    sb.append(result);
                    System.out.println("Найдено решение: " + sb.toString());
                    return;
                }
            }

            System.out.println("Нет решений");
            return;
        }
        else {
            if (firstNum + secondNum != result) {
                System.out.println("Нет решений");
                return;
            }
            else {
                sb.append(firstNum);
                sb.append(" + ");
                sb.append(secondNum);
                sb.append(" = ");
                sb.append(result);
                System.out.println("Найдено решение: " + sb.toString());
            }
        }
    }
}


