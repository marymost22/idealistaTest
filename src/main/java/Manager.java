import model.Advertisement;

import java.util.Arrays;
import java.util.List;

public class Manager {
    private static Manager ourInstance = new Manager();
    private List<String> specialWords = Arrays.asList("Luminoso", "Nuevo", "Céntrico", "Reformado", "Ático");

    private Manager() {
    }

    public static Manager getInstance() {
        return ourInstance;
    }

    public int getAddScore(Advertisement add) {
        return 0;
    }

    public Boolean isAddComplete(Advertisement add) {
        return true;
    }

    public int getAddSpecialWordsScore(Advertisement add) {

        return 0;
    }


}
