import model.Advertisement;
import model.Photo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private static Manager ourInstance = new Manager();
    private static List<String> specialWords = Arrays.asList("Luminoso", "Nuevo", "Céntrico", "Reformado", "Ático");
    private static Integer MIN_SCORE = 0;
    private static Integer MAX_SCORE = 100;
    private ArrayList<Photo> photosArray;
    private ArrayList<Advertisement> relevantAdds;
    private ArrayList<Advertisement> irrelevantAdds;


    private Manager() {
        this.relevantAdds = new ArrayList<>();
        this.irrelevantAdds = new ArrayList<>();
    }

    public static Manager getInstance() {
        return ourInstance;
    }

    public void setPhotosArray(ArrayList<Photo> photosArray) {
        this.photosArray = photosArray;
    }

    public ArrayList<Advertisement> getRelevantAdds() {
        relevantAdds.sort((o1, o2) -> {
            if (o1.getScore() > o2.getScore()) {
                return 1;
            } else if (o1.getScore() < o2.getScore()) {
                return -1;
            } else return 0;
        });
        return relevantAdds;
    }


    public ArrayList<Advertisement> getIrrelevantAdds() {
        irrelevantAdds.sort((o1, o2) -> {
            if (o1.getScore() > o2.getScore()) {
                return 1;
            } else if (o1.getScore() < o2.getScore()) {
                return -1;
            } else return 0;
        });
        return irrelevantAdds;
    }

    public double getAvgScore() {
        Double aux = 0.0;
        for (Advertisement advertisement : relevantAdds) {
            aux += advertisement.getScore();
        }

        for (Advertisement advertisement : irrelevantAdds) {
            aux += advertisement.getScore();
        }
        return aux / (relevantAdds.size() + irrelevantAdds.size());
    }

    public void calculateAddScore(ArrayList<Advertisement> advertisementArrayList) {
        for (Advertisement advertisement : advertisementArrayList) {
            calculateAddScore(advertisement);
        }

    }

    public void calculateAddScore(Advertisement advertisement) {
        Integer score = 0;
        score += advertisement.calculatePhotosScore(photosArray);
        score += advertisement.calculateDescriptionScore((ArrayList<String>) specialWords);
        score += advertisement.calculateCompleteAddScore();
        if (score < MIN_SCORE) {
            advertisement.setScore(MIN_SCORE);
        } else if (score > MAX_SCORE) {
            advertisement.setScore(MAX_SCORE);
        } else {
            advertisement.setScore(score);
        }
        if (score >= 40) {
            relevantAdds.add(advertisement);
        } else {
            irrelevantAdds.add(advertisement);
        }
    }
}
