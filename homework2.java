import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

public class homework2 {
    public static Logger logger = Logger.getLogger(homework2.class.getName());

    public static void main(String[] args) throws Exception {
        startLogger();
        task2();
    }

    public static void startLogger() throws Exception {
        FileHandler fh = new FileHandler("log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.addHandler(fh);
    }

    // Задание 1. Дана строка запроса "select * from students WHERE"
    // Сформируйте часть WHERE этого запроса, используя StringBuilder
    // Данные для фильтрации приведены в виде JSON-строки
    // Если значение null, то параметр не должен попадать в запрос
    public static void task1() throws Exception {
        String string = "{\"name\": \"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        Student student = toJsonObj(string);
        Map<String, String> info = student.getProperties();

        System.out.println(getQuery(info));
    }

    public static class Student {
        public String name;
        public String country;
        public String city;
        public String age;
        private Map<String, String> properties = new HashMap<>();

        private Map<String, String> getProperties(Map<String, String> properties) {
            properties.put("name",    this.name);
            properties.put("country", this.country);
            properties.put("city",    this.city);
            properties.put("age",     this.age);
            return properties;
        }

        public Map<String, String> getProperties() {
            Map<String, String> result = getProperties(this.properties);
            return result;
        }
    }

    public static Student toJsonObj(String jsonString) throws JsonProcessingException, JsonMappingException {
        ObjectMapper om = new ObjectMapper();
        Student student = om.readValue(jsonString, Student.class);
        return student;
    }

    public static String getQuery(Map<String, String> properties) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        boolean whereFlag = true;
        String[] keys = new String[properties.size()];
        properties.keySet().toArray(keys);

        for (String key : keys) {
            if (properties.get(key).equals("null")) {
                properties.remove(key);
            }
        }

        sb.append("SELECT * FROM students");
        for (String key : properties.keySet()) {
            String part = " AND";
            if (counter == properties.size() - 1) {
                part = "";
            }
            if (whereFlag) {
                sb.append(String.format(" WHERE %s=%s%s", key, properties.get(key), part));
                whereFlag = false;
            } else {
                sb.append(String.format(" %s=%s%s", key, properties.get(key), part));
            }
            counter++;
        }

        sb.append(";");
        return sb.toString();
    }

    // Задание 2. Реализуйте алгоритм сортировки пузырьком
    // числового массива, результат после каждой итерации
    // запишите в лог-файл
    public static void bubbleSort(int[] array) throws Exception {
        boolean finish = true;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i + 1] = temp; 
                    finish = false;
                }
                logger.info("Current array: " + arrayToString(array));
            }
        }
        while(!finish);
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append(array[array.length - 1] + "]");
        return sb.toString();
    }

    public static void task2() throws Exception {
        int[] array = new int[] {9, 6, 7, 4, 8, 3, 5, 2, 10, 1};
        bubbleSort(array);
    }

    // Задание 3. Дан JSON-файл
    // Написать метод, который распартит JSON и, используя StringBuilder,
    // создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет]
    public static class Students {
        public String name;
        public String result;
        public String discipline;
        private Map<String, String> properties = new HashMap<>();

        private Map<String, String> getProperties(Map<String, String> properties) {
            properties.put("name",       this.name);
            properties.put("result",     this.result);
            properties.put("discipline", this.discipline);
            return properties;
        }

        public Map<String, String> getProperties() {
            Map<String, String> result = getProperties(this.properties);
            return result;
        }
    }

    public static List<Students> toJsonArray(String fileName) throws Exception {
        ObjectMapper om        = new ObjectMapper();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        StringBuilder sb       = new StringBuilder();

        String next;
        while ((next = bReader.readLine()) != null) {
            sb.append(next);
        }
        bReader.close();

        sb.delete(0, 1);
        String result           = sb.toString().replaceAll("фамилия", "name");
        result                  = result.replaceAll("оценка", "result");
        result                  = result.replaceAll("предмет", "discipline");
        List<Students> students = om.readValue(result, new TypeReference<>(){});
        return students;
    }

    public static void task3() throws Exception {
        List<Students> list = toJsonArray("hw2.json");

        for (Students student : list) {
            System.out.printf("Студент %s получил %s по предмету %s", student.name, student.result, student.discipline);
            System.out.println();
        }
    }

    // Задание 4. К калькулятору из предыдущего ДЗ добавить логирование
    // Логирование добавлено в файле homework1.java
}