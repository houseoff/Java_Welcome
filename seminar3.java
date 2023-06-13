import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class seminar3 {
    
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    // Задание 1. Заполнить список названиями планет Солнечной системы
    // в произвольном порядке с повторениями
    // Вывести название каждой планеты и кол-во его повторений в списке
    public static void task1() {
        Map<String, Integer> dict = new HashMap<>();
        ArrayList<String> list    = new ArrayList<>();
        list.add("Земля");
        list.add("Земля");
        list.add("Земля");
        list.add("Юпитер");

        for (String string : list) {
            if (dict.keySet().contains(string)) {
                dict.put(string, dict.get(string) + 1);
            } else {
                dict.put(string, 1);
            }
        }

        for (String key : dict.keySet()) {
            System.out.println(String.format("%s: %d", key, dict.get(key)));
        }

    }

    // Задание 2. Заполнить список десятью случайными числами
    // Отсортировать список методом sort() и вывести его на экран
    public static void task2() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(0, 100));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    // Задание 3. Создать список типа ArrayList
    // Поместить в него как строки, так и целые числа
    // Пройти по списку, найти и удалить целые числа
    public static void task3() {
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, "sa", "sa"));
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() instanceof Integer) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

}
