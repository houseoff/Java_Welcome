import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class homework3 {
    public static ArrayList<Integer> list;
    public static void main(String[] args) {
        fillList();
        System.out.println(String.format("Min: %d", min()));
        System.out.println(String.format("Max: %d", max()));
        System.out.println(String.format("Average: %s", average()));
        removeEvenNumbers();
        System.out.println("The list after deleting even numbers: " + list);
    }

    private static void fillList() {
        list = new ArrayList<>(Arrays.asList(1, 3, 6, 8, 23, 76, 22, 11, 9));
    }

    public static void removeEvenNumbers() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public static Integer min() {
        Integer min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) min = list.get(i);
        }
        return min;
    }

    public static Integer max() {
        Integer max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) max = list.get(i);
        }
        return max;
    }

    public static double average() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }

}
