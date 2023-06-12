import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class seminar2 {
    public static void main(String[] args) {
        readFile("text.txt");
    }

    // Задание 1. Дано число N > 0 и символы c1 и с2.
    // Написать метод, который вернет строку длины N, которая состоит из чередующихся символов с1 и с2
    // Например: вход: 6, выход: ababab
    public static String getSequience(Integer count) {
        if (count < 0) return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            if (i % 2 == 0) sb.append('b');
            else sb.append('a');
        }

        return sb.toString();
    }

    // Задание 2. Напишите метод, который сжимает строку
    public static String zippedString(String string) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (dict.keySet().contains(chars[i])) {
                dict.put(chars[i], dict.get(chars[i]) + 1);
            } else {
                dict.put(chars[i], 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : dict.keySet()) {
            if (dict.get(c) == 1) sb.append(c);
            else {
                sb.append(c);
                sb.append(dict.get(c));
            }
        }

        return sb.toString();
    }

    // Задание 3. Записать слово TEST в файл 10 раз
    private static void writeFile(String fileName, String string, Integer count) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                fw.write(string + "\n");
            }
            System.out.println("Запись прошла успешно");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }

    // Задание 4. Чтение из файла
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);

            char[] arr = new char[(int) file.length()];
            fr.read(arr);
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println("\n" + "Чтение прошло успешно");
            fr.close();
        }
        catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
