package view;
import java.util.HashMap;

public class FormPatterns {

    private static HashMap<Integer, String> mainMenu = new HashMap<>() {{
        put(1, "Просмотр всех товаров");
        put(2, "Поиск с помощью фильтра");
        put(3, "Выход");
    }};

    private static HashMap<Integer, String> propertiesMap = new HashMap<>() {{
        put(1, "ram");
        put(2, "diskCapacity");
        put(3, "os");
        put(4, "color");
    }};

    private static HashMap<String, String> outputMap = new HashMap<>() {{
        put("name",         "Модель");
        put("ram",          "Объём ОЗУ");
        put("diskCapacity", "Объём накопителя");
        put("diskType",     "Тип накопителя");
        put("os",           "ОС");
        put("color",        "Цвет");
    }};

    private static HashMap<Integer, String> filterMenuMap = new HashMap<>() {{
        put(1, outputMap.get(propertiesMap.get(1)));
        put(2, outputMap.get(propertiesMap.get(2)));
        put(3, outputMap.get(propertiesMap.get(3)));
        put(4, outputMap.get(propertiesMap.get(4)));
        put(5, "Назад");
    }};

    public static HashMap<Integer, String> getMainMenuFormat() {
        return mainMenu;
    }

    public static HashMap<String, String> getOutputFormat() {
        return outputMap;
    }

    public static HashMap<Integer, String> getFilterMenuFormat() {
        return filterMenuMap;
    }

    public static String getOutputFormat(String property) {
        return outputMap.get(property);
    }

    public static String getFilterMenuFormat(Integer number) {
        return filterMenuMap.get(number);
    }

    public static String getProperty(Integer num) {
        return propertiesMap.get(num);
    }
}
