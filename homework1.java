import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class homework1 {
    public static Logger logger = Logger.getLogger(homework1.class.getName());
    public static void main(String[] args) throws Exception {
        startLogger("log_calc.log");
        simpleCalc();
    }

    public static void startLogger(String fileName) throws Exception {
        FileHandler fh = new FileHandler(fileName, true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.addHandler(fh);
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
        logger.info("START CALC");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-ое число: ");
        Integer first = scanner.nextInt();
        logger.info(String.format("getting number 1: %d", first));
        System.out.print("Введите 2-ое число: ");
        Integer second = scanner.nextInt();
        logger.info(String.format("getting number 2: %d", second));
        System.out.print("Введите действие: ");
        String action = scanner.next();
        action = action.trim();
        logger.info(String.format("getting action: %s", action));
        int result = 0;

        if      (action.matches("^\\+$")) result = first + second;
        else if (action.matches("^-$"))   result = first - second;
        else if (action.matches("^\\*$")) result = first * second;
        else if (action.matches("^/$"))   result = first / second;

        System.out.println("Результат " + first + " " + action + " " + second + ": " + result);
        logger.info(String.format("getting result: %d", result));
        scanner.close();
    }

    // Задание 4. Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства.
    // Знаки вопроса - одинаковые цифры.
    // Предложить хотя бы одно решение или сообщить, что его нет
    private static class SpecialNumber {
        int value;
        int multiplier;
        int countQuestions;

        public SpecialNumber(int value, int multiplier, int countQuestions) {
            this.value = value;
            this.multiplier = multiplier;
            this.countQuestions = countQuestions;
        }
    }

    private static SpecialNumber getSpecialNumber(String digit) {
        SpecialNumber sNumber = new SpecialNumber(0, 0, 0);
        if (digit.matches("^[1-9]\\?$")) {
            Character ch = digit.charAt(0);
            sNumber.value = Integer.parseInt(ch.toString()) * 10;
            sNumber.countQuestions = 1;
            sNumber.multiplier = 1;
        } else if (digit.matches("^\\?[1-9]$")) {
            Character ch = digit.charAt(1);
            sNumber.value = Integer.parseInt(ch.toString());
            sNumber.countQuestions = 1;
            sNumber.multiplier = 10;
        } else if (digit.matches("^\\?\\?$")) {
            sNumber.value = 11;
            sNumber.countQuestions = 2;
            sNumber.multiplier = 1;
        } else if (digit.matches("^\\d+$")) {
            sNumber.value = Integer.parseInt(digit);
            sNumber.countQuestions = 0;
            sNumber.multiplier = 1;
        }
        return sNumber;
    }

    private static void getResult(SpecialNumber first, SpecialNumber second, int result) {
        if (first.countQuestions == 0 && second.countQuestions == 0) {
            int exprValue = first.value + second.value;
            if (exprValue == result) {
                System.out.printf("Найдено решение: %d + %d = %d", first.value, second.value, result);
                return;
            }
        } else {
            for (int i = 1; i < 10; i++) {
                int firstNum;
                int secondNum;
                if (first.countQuestions == 2 && second.countQuestions == 2) {
                    firstNum  = first.value  * i;
                    secondNum = second.value * i;
                } else if (first.countQuestions == 2 && second.countQuestions == 1) {
                    firstNum  = first.value  * i;
                    secondNum = second.value + (i * second.multiplier);
                } else if (first.countQuestions == 1 && second.countQuestions == 2) {
                    firstNum  = first.value  + (i * first.multiplier);
                    secondNum = second.value * i;
                } else if (first.countQuestions == 1 && second.countQuestions == 1) {
                    firstNum  = first.value  + (i * first.multiplier);
                    secondNum = second.value + (i * second.multiplier);
                } else {
                    firstNum  = 0;
                    secondNum = 0;
                }

                if (firstNum + secondNum == result) {
                    System.out.printf("Найдено решение: %d + %d = %d", firstNum, secondNum, result);
                    return;
                }
            }
        }

        System.out.printf("Нет решения");
        return;
    }

    public static void findNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String[] splitted = scanner.nextLine().split("\\+|\\=");
        scanner.close();

        if (splitted.length > 3) {
            System.out.println("Неверное выражение!");
            return;
        }

        for (int i = 0; i < splitted.length; i++) {
            splitted[i] = splitted[i].trim();
        }

        for (int i = 0; i < 2; i++) {
            if (splitted[i].length() > 2) {
                System.out.println("Слагаемые должны быть максимум двузначными!");
                return;
            }
        }

        SpecialNumber firstNum  = getSpecialNumber(splitted[0]);
        SpecialNumber secondNum = getSpecialNumber(splitted[1]);
        int result              = Integer.parseInt(splitted[2]);

        getResult(firstNum, secondNum, result);
    }
}


