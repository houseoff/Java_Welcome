package notebook;
import java.util.ArrayList;
import java.util.List;

public enum DisksCapacity {

    QUARTGB (256),
    HALFGB  (500),
    ONETB   (1024),
    TWOTB   (2048),
    FOURTB  (4096);

    private Integer value;

    DisksCapacity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        for (DisksCapacity disk : DisksCapacity.values()) {
            list.add(disk.value);
        }
        return list;
    }

    public static Integer count() {
        return DisksCapacity.values().length;
    }
}
