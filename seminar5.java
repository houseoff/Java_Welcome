import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class seminar5 {

    // Создать структуру для хранения номеров паспортов и фамилий сотрудников организации
    // 123456 Иванов
    // 321456 Васильев
    // 234561 Петрова
    // 234432 Иванов
    // 654321 Петрова
    // 345678 Иванов
    // Вывести данные по сотрудникам с фамилией "Иванов"
    public static void task1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(123456, "Иванов");
        map.put(321456, "Васильев");
        map.put(234561, "Петрова");
        map.put(234432, "Иванов");
        map.put(654321, "Петрова");
        map.put(345678, "Иванов");
        for (var item : map.entrySet()) {
            if (item.getValue().matches("^Иванов$")) System.out.println(item);
        }
    }

    // Даны 2 строки. Написать метод, который вернет true, если эти строки изоморфны
    // Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове
    // при этом повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования (add - egg)
    // a - e, d - q => true
    // Так же буква может не меняться, а остаться прежней (note - code)
    // n - c, o - o, t - d, e - e => true
    public static void task2() {
        Scanner sc = new Scanner(System.in, "ch866");
        System.out.print("Введите первое слово: ");
        String word1 = sc.nextLine();
        System.out.print("Введите второе слово: ");
        String word2 = sc.nextLine();
        sc.close();

        if (word1.length() != word2.length()) {
            System.out.println("Слова имеют разную длину!");
            return;
        }

        Map<Character, Character> map = new HashMap<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Boolean flag = true;

        for (int i = 0; i < chars2.length; i++) {
            if (!map.containsKey(chars1[i])) map.put(chars1[i], chars2[i]);
            else {
                if (map.get(chars1[i]) != chars2[i]) flag = false;
            }
        }
        
        System.out.printf("Первое слово: %s\n", word1);
        System.out.printf("Второе слово: %s\n", word2);
        if (flag) System.out.println("Слова изоморфны");
        else      System.out.println("Слова не изоморфны");

    }


    // Написать программу, определяющую правильность расстановки скобок в выражении
    public static void task3() {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Введите выражение: ");
        String expr = sc.nextLine();
        sc.close();

        Map<Character, Character> staples = new HashMap<>() {{
            put('>', '<');
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Boolean flag  = true;
        String answer = null;

        Stack<Character> stack = new Stack<>();
        String sStaples = expr.replaceAll("[^\\<\\{\\[\\(\\>\\}\\]\\)]", "");

        if (sStaples.length() % 2 == 0) {
            for (char ch : sStaples.toCharArray()) {
                if (staples.containsValue(ch)) stack.push(ch);
                else {
                    if (stack.empty() || !stack.contains(staples.get(ch))) {
                        flag = false;
                        break;
                    }
                    else stack.remove(Character.valueOf(staples.get(ch)));
                }
                System.out.println(stack);
            }
        }

        if (flag) answer = "верно";
        else      answer = "не верно";
        System.out.printf("В выражении \"%s\" скобки расставлены %s", expr, answer);
    }
    public static void main(String[] args) {
        task3();
    }
}
