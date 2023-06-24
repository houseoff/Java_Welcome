import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример:
// Иванов 1231234
// Иванов 3456345
// Иванов 5676585
// Петров 12345
// Петров 82332

public class homework5 {
    static final HashMap<String, ArrayList<Long>> CONTACTS = new HashMap<>();
    static final Scanner SCANNER = new Scanner(System.in, "cp1251");

    public static void main(String[] args) {
        Boolean flag = true;
        while (flag) flag = showMenu();
    }

    private static Boolean showMenu() {
        System.out.println("Меню программы");
        System.out.println("1 - Показать список контактов");
        System.out.println("2 - Добавить контакт");
        System.out.println("3 - Выйти из программы");
        System.out.print("Ввод: ");
        String input = null;
        while (true) {
            input = input(SCANNER);
            if (input.equals("1")) {
                getContacts();
                return true;
            } else if (input.equals("2")) {
                addContact();
                return true;
            } else if (input.equals("3")) {
                SCANNER.close();
                System.out.println("Работа программы завершена");
                return false;
            } else {
                if (!input.equals("")) {
                    System.out.print("Ошибка ввода. Повторите попытку: ");
                }
            }
        }
    }

    private static void getContacts() {
        List<Map.Entry<String, ArrayList<Long>>> list = new ArrayList<>(CONTACTS.entrySet());

        list.sort(new Comparator<Map.Entry<String, ArrayList<Long>>>() {
            @Override
            public int compare(Entry<String, ArrayList<Long>> o1, Entry<String, ArrayList<Long>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        System.out.println("Список всех контактов");
        for (Map.Entry<String, ArrayList<Long>> entry : list) {
            for (Long element : entry.getValue()) {
                System.out.printf("%s %d\n", entry.getKey(), element);
            }
        }
    }

    private static void addContact() {
        System.out.println("Добавление контакта");
        System.out.print("Введите фамилию и номер телефона через пробел: ");
        String input  = null;
        String[] data = null;
        Boolean flag  = true;
        while (flag) {
            input = input(SCANNER);
            data  = input.split(" ");
            if (data.length != 2) {
                System.out.println("Ошибка ввода. Неверные формат данных. Повторите ввод: ");
                flag = false;
            } else if (!data[0].matches("^[а-яА-Я]+||[a-zA-Z]+$")) {
                System.out.print("Ошибка ввода. Фамилия должна состоять только из букв либо русского, либо английского алфавита. Повторите ввод: ");
                flag = false;
            } else if (!data[1].matches("^\\d+$")) {
                System.out.print("Ошибка ввода. Номер телефона должен состоять только из цифр. Повторите ввод: ");
                flag = false;
            }

            if (flag) {
                if (!CONTACTS.containsKey(data[0])) {
                    CONTACTS.put(data[0], new ArrayList<>());
                    CONTACTS.get(data[0]).add(Long.parseLong(data[1]));
                    System.out.printf("Контакт \"%s\" успешно создан\n", data[0]);
                    return;
                }

                if (CONTACTS.get(data[0]).contains(Long.parseLong(data[1]))) {
                    System.out.printf("Номер телефона \"%s\" контакту \"%s\" уже добавлен. Повторите ввод: ", data[1], data[0]);
                } else {
                    CONTACTS.get(data[0]).add(Long.parseLong(data[1]));
                    System.out.printf("Номер телефона \"%s\" у контакта \"%s\" успешно добавлен\n", data[0], data[1]);
                    return;
                }
            }
            flag = true;
        }
    }

    private static String input(Scanner sc) {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("")) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else {
                return input;
            }
        }
    }
}
