import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Form {
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

    public Integer show(String startMsg, HashMap<Integer, String> hashMap, Boolean verifyOutputMenu) {
        String msg = "Ошибка ввода. Введите номер пункта меню: ";
        System.out.println(startMsg);
        for (var entry : hashMap.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), entry.getValue());
        }
        System.out.print("Ввод: ");
        while (true) {
            try {
                Integer input = Integer.parseInt(input());
                if (verifyOutputMenu) {
                    if (hashMap.containsKey(input)) {
                        return input;
                    } else {
                        System.out.print(msg);
                    }
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.print(msg);
            }
        }
    }

    public String show(String startMsg, HashMap<Integer, Object> menu) {
        System.out.println(startMsg);
        for (var entry : menu.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), entry.getValue());
        }
        System.out.print("Ввод: ");
        return input();
    }

    public String show(String startMsg) {
        System.out.println(startMsg);
        System.out.print("Ввод: ");
        return input();
    }

    public Integer show(String startMsg, Boolean verifyOutput) {
        System.out.println(startMsg);
        System.out.print("Ввод: ");
        return Integer.parseInt(input());
    }

    public void show(String startMsg, List<Notebook> data) {
        System.out.println(startMsg);
        System.out.println("============================");
        for (var note : data) {
            System.out.println(note.toString());
            System.out.println("============================");
        }
    }
}
