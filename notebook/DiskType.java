package notebook;
import java.util.ArrayList;
import java.util.List;

public enum DiskType {
    HDD,
    SSD,
    NVME;

    public static List<String> toList() {
        List<String> list = new ArrayList<>();
        for (DiskType disk : DiskType.values()) {
            list.add(disk.toString());
        }
        return list;
    }

    public static Integer count() {
        return DiskType.values().length;
    }
}
