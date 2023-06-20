import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class seminar4 {
    public static void main(String[] args) {
        int[] array = {2, 3, 34, 123};
        System.out.println(task4(array));
    }

    // Замерить время добавления 100000 элементов в LinkedList
    // Замерить время добавления 100000 элементов в ArrayList
    public static void timeToFillLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        System.out.println("Начало заполнения двусвязного списка");
        for (int i = 0; i < 100000; i++) {
            list.add(0, 0);
        }
        System.out.println("Конец заполнения двусвязного списка");
        System.out.println("Затрачено времени: " + (System.currentTimeMillis() - start) + " мс.");
    }

    public static void timeToFillArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        System.out.println("Начало заполнения списка ");
        for (int i = 0; i < 100000; i++) {
            list.add(0, 0);
        }
        System.out.println("Конец заполнения списка");
        System.out.println("Затрачено времени: " + (System.currentTimeMillis() - start) + " мс.");
    }

    // Программа ждет на вход строку от пользователя
    // Получая строку, программа добавляет её в связный список
    // Если строка содержит "print~номер", то элемент выводится и удаляется из списка
    // Если вводится "exit", то программа завершает свою работу
    public static void task2() {
        try (Scanner sc = new Scanner(System.in, "cp866")) {
            LinkedList<String> list = new LinkedList<>();
            String text = "";
            while (true) {
                System.out.print("Введите строку: ");
                text = sc.nextLine();
                if (text.matches("^exit$")) {
                    break;
                } else if (list.size() == 0 && text.matches("^print~\\d+$")) {
                    System.out.println("Список пуст!");
                } else if (text.matches("^print~\\d+$")) {
                    int index = Integer.parseInt(text.replaceAll("print~", ""));
                    if (index >= list.size()) {
                        System.out.printf("Элемента с индексом %s не существует!\n", index);
                    } else {
                        System.out.println("Элемент \"" + list.remove(index) + "\" удалён");
                    }
                }
                else {
                    list.add(text.trim());
                }
                System.out.println("Текущий список: " + list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Программа принимает на вход строки от пользователя
    // Если введено "print", то выводятся строки так, что
    // Последняя введенная строка была первой в выводе, а первая - последней
    // После вывод очищается
    public static void task3() {
        try (Scanner sc = new Scanner(System.in, "cp866")) {
            Stack<String> stack = new Stack<>();
            String text = "";
            while (true) {
                System.out.print("Введите строку: ");
                text = sc.nextLine();
                if (text.matches("^exit$")) {
                    break;
                } else if (stack.size() == 0 && text.matches("^print$")) {
                    System.out.println("Стек пуст!");
                } else if (stack.size() != 0 && text.matches("^print$")) {
                    while (!stack.empty()) System.out.print(stack.pop() + " ");
                    System.out.println();
                } else {
                    stack.push(text.trim());
                }
                System.out.println("Текущий стек: " + stack);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Создать метод, который принимает на вход массив элементов
    // На выходе метод должени вернуть очередь
    public static Queue<Integer> task4(int[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Integer el : array) {
            queue.add(el);
        }
        return queue;
    }
}
