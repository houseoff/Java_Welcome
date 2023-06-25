import java.util.HashMap;
import java.util.Random;

public class Notebook {

    private String  name;
    private Integer ram;
    private Integer diskCapacity;
    private String  diskType;
    private String  os;
    private String  color;

    public String getName() {
        return this.name;
    }

    public Integer getRAM() {
        return this.ram;
    }

    public Integer getDiskCapacity() {
        return this.diskCapacity;
    }

    public String getDiskType() {
        return this.diskType;
    }

    public String getOS() {
        return this.os;
    }

    public String getColor() {
        return this.color;
    }

    public Notebook(String name, Integer ram, Integer diskCapacity, String diskType, String os, String color) throws IllegalArgumentException {
        this.name = name;
        if (RAMCapacity.toList().contains(ram)) {
            throw new IllegalArgumentException(String.format("Значение \"%d\" не соответствует разрешенному набору", ram));
        }
        if (DisksCapacity.toList().contains(diskCapacity)) {
            throw new IllegalArgumentException(String.format("Значение \"%d\" не соответствует разрешенному набору", diskCapacity));
        }
        if (DiskType.toList().contains(diskType)) {
            throw new IllegalArgumentException(String.format("Значение \"%s\" не соответствует разрешенному набору", diskType));
        }
        if (OSVersions.toList().contains(os)) {
            throw new IllegalArgumentException(String.format("Значение \"%s\" не соответствует разрешенному набору", os));
        }
        if (Colors.toList().contains(color)) {
            throw new IllegalArgumentException(String.format("Значение \"%s\" не соответствует разрешенному набору", color));
        }

        this.ram = ram;
        this.diskCapacity = diskCapacity;
        this.diskType = diskType;
        this.os = os;
        this.color = color;
    }

    public Notebook(String name) {
        Random r          = new Random();
        this.os           = OSVersions.toList().get(r.nextInt(0, OSVersions.count()));
        this.ram          = RAMCapacity.toList().get(r.nextInt(0, RAMCapacity.count()));
        this.name         = name;
        this.color        = Colors.toList().get(r.nextInt(0, Colors.count()));
        this.diskType     = DiskType.toList().get(r.nextInt(0, DiskType.count()));
        this.diskCapacity = DisksCapacity.toList().get(r.nextInt(0, DisksCapacity.count()));
    }

    public HashMap<String, Object> getProperties() {
        HashMap<String, Object> m = new HashMap<>() {{
            put("name", getName());
            put("ram", getRAM());
            put("diskCapacity", getDiskCapacity());
            put("diskType", getDiskType());
            put("os", getOS());
            put("color", getColor());
        }};
        return m;
    }

    @Override
    public String toString() {
        String message = null;
        StringBuilder sb = new StringBuilder();
        for (var entry : getProperties().entrySet()) {
            if (entry.getValue() instanceof Integer) {
                if ((Integer) entry.getValue() > 500) {
                    message = String.format("%s: %d Тб\n", ViewFormatter.getOutputFormat(entry.getKey()), (Integer) entry.getValue() / 1024);
                } else {
                    message = String.format("%s: %d Гб\n", ViewFormatter.getOutputFormat(entry.getKey()), entry.getValue());
                }
            } else {
                message = String.format("%s: %s\n", ViewFormatter.getOutputFormat(entry.getKey()), entry.getValue());
            }
            sb.append(message);
        }
        return sb.toString();
    }
}
