import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat {
    private String name;
    private Integer age;
    private Boolean isVaccinated;
    private List<String> medicalHistory = new ArrayList<>();

    private String ConvertBoolToString(Boolean value) {
        String s = null;
        if (value) s = "Да";
        else s = "Нет";
        return s;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getVaccinatedInfo() {
        return ConvertBoolToString(this.isVaccinated);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }

    public void setVaccinatedInfo(Boolean newValue) {
        this.isVaccinated = newValue;
    }

    public Cat(String name, Integer age, Boolean isVaccinated) {
        this.name = name;
        this.age  = age;
        this.isVaccinated = isVaccinated;
    }

    public Cat(String name, Integer age) {
        this(name, age, false);
    }

    public void sayMeow() {
        Random r = new Random();
        System.out.printf("Кот мяукнул %d раз(а)", r.nextInt(1, 10));
    }

    public void isVaccinated() {
        String m = null;
        if (this.isVaccinated) m = "Кот уже вакцинирован";
        else                   m = "Кот ещё не вакцинирован";
        System.out.println(m);
    }

    public void addMedicalHistory(String disease) {
        this.medicalHistory.add(disease);
    }

    public void showMedicalHistory() {
        if (this.medicalHistory.isEmpty()) {
            System.out.println("История болезней пуста");
        } else {
            System.out.println("Список болезней");
            for (String s : medicalHistory) {
                System.out.println(s);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Возраст: %d, Привит: %s", this.name, this.age, ConvertBoolToString(this.isVaccinated));
    }
}
