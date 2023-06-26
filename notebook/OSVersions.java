package notebook;
import java.util.ArrayList;
import java.util.List;

public enum OSVersions {
    WIN10 ("Windows 10"),
    WIN11 ("Windows 11"),
    LINUX ("Linux");

    private String value;

    OSVersions(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static List<String> toList() {
        List<String> list = new ArrayList<>();
        for (OSVersions os: OSVersions.values()) {
            list.add(os.value);
        }
        return list;
    }

    public static Integer count() {
        return OSVersions.values().length;
    }
}
