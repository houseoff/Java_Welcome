package notebook;
import java.util.ArrayList;
import java.util.List;

public enum Colors {

    GREEN  ("Зеленый"),
    BLUE   ("Синий"),
    RED    ("Красный"),
    YELLOW ("Желтый"),
    WHITE  ("Белый"),
    BLACK  ("Черный"),
    PURPLE ("Фиолетовый"),
    ORANGE ("Оранжевый"),
    PINK   ("Розовый");

    private String value;

    Colors(String title) {
        this.value = title;
    }

    public String getValue() {
        return this.value;
    }

    public static List<String> toList() {
        List<String> list = new ArrayList<>();
        for (Colors color : Colors.values()) {
            list.add(color.value);
        }
        return list;
    }

    public static Integer count() {
        return Colors.values().length;
    }
}