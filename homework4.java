import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class homework4 {

    static final int COUNT_ELEMENTS = 3;
    static final boolean IS_NEGATIVE = false;

    private static int convertDequeToInt(Deque<String> deque) {
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return Integer.parseInt(sb.toString());
    }

    public static void fillDeque(Deque<String> deque) {
        fillDeque(deque, COUNT_ELEMENTS, IS_NEGATIVE);
    }

    public static void fillDeque(Deque<String> deque, int count) {
        fillDeque(deque, count, IS_NEGATIVE);
    }

    public static void fillDeque(Deque<String> deque, boolean isNegative) {
        fillDeque(deque, COUNT_ELEMENTS, isNegative);
    }

    public static void fillDeque(Deque<String> deque, int count, boolean isNegative) {
        Random random = new Random();
        if (isNegative) deque.push("-");
        for (int i = 0; i < count; i++) {
            deque.push(String.valueOf(random.nextInt(0, 9)));
        }
    }

    public static LinkedList<String> multiply(Deque<String> num1, Deque<String> num2) {
        LinkedList<String> answer = new LinkedList<>();
        int n1 = convertDequeToInt(num1);
        int n2 = convertDequeToInt(num2);
        String result = String.valueOf(n1 * n2);
        for (char ch : result.toCharArray()) {
            answer.offer(String.valueOf(ch));
        }
        return answer;
    }

    public static LinkedList<String> sum(Deque<String> num1, Deque<String> num2) {
        LinkedList<String> answer = new LinkedList<>();

        int n1 = convertDequeToInt(num1);
        int n2 = convertDequeToInt(num2);

        String result = String.valueOf(n1 + n2);
        for (char ch : result.toCharArray()) {
            answer.offer(String.valueOf(ch));
        }
        return answer;
    }

    public static void main(String[] args) {
        Deque<String> num1 = new LinkedList<>();
        Deque<String> num2 = new LinkedList<>();

        fillDeque(num1, true);
        System.out.println("Очередь 1: " + num1);
        fillDeque(num2, false);
        System.out.println("Очередь 2: " + num2);
        System.out.println("Результат умножения: " + multiply(num1, num2));
        System.out.println("============================================");
        fillDeque(num1, true);
        System.out.println("Очередь 1: " + num1);
        fillDeque(num2, false);
        System.out.println("Очередь 2: " + num2);
        System.out.println("Результат сложения: "  + sum(num1, num2));
    }
}
