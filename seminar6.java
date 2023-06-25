import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class seminar6 {

    // Напишите метод, который заполнит массив из 100 элементов случайными цифрами от 0 до 50
    // Создайте метод, в который передайте заполненный выше массив и с помощью Set
    // вычислите процент уникальных значений в данном массиве и верните его в ваиде числа с плавающей точкой
    public static ArrayList<Integer> getRandomArray(int length, int start, int end) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array.add(random.nextInt(start, end));
        }
        return array;
    }

    public static float getPercentOfUnique(ArrayList<Integer> array) {
        HashSet<Integer> set = new HashSet<>(array);
        return (float) set.size() / (float) array.size() * 100;
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Васька", 5);
        System.out.println(cat);
        cat.setVaccinatedInfo(true);
        System.out.println(cat);
        cat.addMedicalHistory("Бешенство");
        cat.showMedicalHistory();

    }


}
