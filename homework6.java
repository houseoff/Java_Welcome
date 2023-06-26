import view.*;
import notebook.*;

public class homework6 {

    private static Integer choise      = null;
    private static String  sPattern    = null;
    private static Integer iPattern    = null;
    private static Boolean flag        = true;
    private static Boolean cls         = true;
    private static String  mismatchMsg = "Ошибка ввода. Введите пункт меню: ";

    public static void main(String[] args) {
        NotebookList notebooks = NotebookList.createRandomNotebookList(10);
        Form form = new Form();
        while (flag) {
            form.show("Меню\nВведите пункт меню и нажмите Enter", FormPatterns.getMainMenuFormat(), cls);
            choise = InputCheker.checkInput(FormPatterns.getMainMenuFormat(), mismatchMsg);
            cls    = true;
            switch (choise) {
                case 1:
                    form.show("Список всех ноутбуков", notebooks, cls);
                    cls    = false;
                    break;
                case 2:
                    while (true) {
                        form.show("Выберите критерий для фильтрации: ", FormPatterns.getFilterMenuFormat(), cls);
                        choise = InputCheker.checkInput(FormPatterns.getFilterMenuFormat(), mismatchMsg);
                        if (choise != 5) {
                            var filtred = new NotebookList();
                            form.show(String.format("Введите шаблон для поиска по полю \"%s\": ", FormPatterns.getFilterMenuFormat(choise)), cls);
                            if (choise == 1) {
                                iPattern = InputCheker.checkInput("Ошибка ввода. Повторите ввод: ");
                                filtred  = notebooks.filterByRAM(iPattern);
                            }
                            else if (choise == 2) {
                                iPattern = InputCheker.checkInput("Ошибка ввода. Повторите ввод: ");
                                filtred  = notebooks.filterByDiskCapacity(iPattern);
                            }
                            else if (choise == 3) {
                                sPattern = InputCheker.uncheckedInput();
                                filtred  = notebooks.filterByOS(sPattern);
                            }
                            else if (choise == 4) {
                                sPattern = InputCheker.uncheckedInput();
                                filtred  = notebooks.filterByColor(sPattern);
                            }

                            if (filtred.isEmpty()) {
                                form.show("Не найдено подходящих моделей", cls);
                            } else {
                                form.show("Найдены подходящие модели", filtred, cls);
                            }
                            break;
                        }
                        else break;
                    }
                    cls = false;
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}