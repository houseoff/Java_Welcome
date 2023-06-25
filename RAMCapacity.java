import java.util.ArrayList;
import java.util.List;

public enum RAMCapacity {

    IVGB    (4),
    VIGB    (6),
    VIIIGB  (8),
    XVIGB   (16),
    XXXIIGB (32),
    LXIVGB  (64);

    private Integer value;

    RAMCapacity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        for (RAMCapacity ram : RAMCapacity.values()) {
            list.add(ram.value);
        }
        return list;
    }

    public static Integer count() {
        return RAMCapacity.values().length;
    }
}
