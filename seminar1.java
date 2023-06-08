package Java_Welcome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class seminar1 {
    
    public static void main(String[] args) {
        System.out.println(reversePhrase("Добро пожаловать на курс по языку Java"));
    }

    // Написать метод, который запросит пользователя ввести имя в консоли,
    // получит введенную строку и выведет в консоль сообщение "Привет, Имя!"
    public static void sayHello() {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.print("Введите Ваше имя: ");
        String name = scanner.nextLine();
        System.out.printf("Привет, " + name + "!");
        scanner.close();
    }

    // Написать метод для поиска наибольшего числа подряд идущих единиц в массиве, состоящем из нулей и единиц
    public static int maxNumbersOfConsecutive(boolean[] array) {
        int count = 0;
        int max = 0;
        for (boolean item: array) {
            if (item) count++;
            else {
                max = (count > max) ? count: max;
                count = 0;
            }
        }

        if (count > max) return count;
        else return max;
    }

    // Написать метод перемещения чисел в конец массива, равных заданному
    public static int[] moveElements(int[] array, int number) {
        List<Integer> list = new ArrayList<>();
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] != number) list.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) list.add(array[i]);
        }

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = list.get(i);
        }
        
        return newArray;
    }

    // Написать метод перестановки фразы в обратном порядке
    public static String reversePhrase(String string) {
        String[] splitted = string.split("\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = splitted.length - 1; i >= 0; i--) {
            sb.append(splitted[i] + " ");
        }

        return sb.toString();
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
    }

}
