import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

public class homework2 {

    public static void main(String[] args) throws Exception {
        task2();
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

    // Задание 3. Дан JSON-файл.
    // Написать метод, который распартит JSON и, используя StringBuilder,
    // создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет]
    public static class Students {
        String name;
        String result;
        String discipline;
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

        List<Students> students = om.readValue(sb.toString(), new TypeReference<>(){});
        return students;
    }

    public static void task2() throws Exception {
        List<Students> list = toJsonArray("hw2.json");
        for (Students student : list) {
            System.out.println(student.discipline);
        }
    }
}

