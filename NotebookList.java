import java.util.ArrayList;
import java.util.List;

public class NotebookList {
    private List<Notebook> list = new ArrayList<>();

    public void add(Notebook notebook) {
        list.add(notebook);
    }

    public List<Notebook> filterBy(String property, Integer minValue) {
        List<Notebook> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            var map = list.get(i).getProperties();
            if (map.get(property) instanceof Integer) {
                if ((Integer) map.get(property) >= minValue) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }

    public List<Notebook> filterBy(String property, String pattern) {
        List<Notebook> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            var map = list.get(i).getProperties();
            if (map.get(property) instanceof String) {
                if (String.valueOf(map.get(property)).matches(pattern)) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }
}
