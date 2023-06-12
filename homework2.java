import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class homework2 {
    public static void main(String[] args) {
        try {
            File file = new File("hw2.json");
            FileReader fr = new FileReader(file);
            char[] data = new char[(int) file.length()];
            StringBuilder sb = new StringBuilder();
            fr.read(data);
            for (char c : data) {
                sb.append(c);
            }

            Object obj = new JSONParser().parse(sb.toString());
            JSONArray array = (JSONArray) obj;

            for (Object object : array) {
                
            }
        }
        catch (Exception e) {

        }
    }
}
