package notebook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotebookList implements Iterable<Notebook> {

    private List<Notebook> list = new ArrayList<>();

    public static NotebookList createRandomNotebookList(Integer count) {
        NotebookList list = new NotebookList();
        String model = "note";
        for (int i = 0; i < count; i++) {
            list.add(new Notebook(String.format("%s%d", model, i + 1)));
        }
        return list;
    }

    public void add(Notebook notebook) {
        list.add(notebook);
    }

    public NotebookList filterByRAM(Integer minValue) {
        NotebookList result = new NotebookList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRAM() >= minValue) {
                result.add(list.get(i));
            }
        }
        return result;
    }
    
    public NotebookList filterByDiskCapacity(Integer minValue) {
        NotebookList result = new NotebookList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDiskCapacity() >= minValue) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public NotebookList filterByOS(String pattern) {
        NotebookList result = new NotebookList();
        pattern = ".*" + pattern + ".*";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOS().matches(pattern)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public NotebookList filterByColor(String pattern) {
        NotebookList result = new NotebookList();
        pattern = ".*" + pattern + ".*";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getColor().matches(pattern)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public Boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Notebook> iterator() {
        return this.list.iterator();
    }
}
