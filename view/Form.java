package view;
import java.util.HashMap;
import notebook.*;

public class Form {

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке консоли: " + e.getMessage());
        }
    }

    public void show(String startMsg, HashMap<Integer, String> formPattern, Boolean clearConsole) {
        if (clearConsole) clearConsole();
        System.out.println(startMsg);
        for (var entry : formPattern.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), entry.getValue());
        }
    }

    public void show(String startMsg, Boolean clearConsole) {
        if (clearConsole) clearConsole();
        System.out.println(startMsg);
    }

    public void show(String startMsg, NotebookList data, Boolean clearConsole) {
        if (clearConsole) clearConsole();
        System.out.println(startMsg);
        System.out.println("============================");
        for (var note : data) {
            System.out.println(note.toString());
            System.out.println("============================");
        }
    }
}
