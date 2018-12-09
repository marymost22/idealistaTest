import model.Advertisement;
import model.Photo;

import java.util.ArrayList;

public class Manager {
    private static Manager ourInstance = new Manager();
    private ArrayList<String> specialWords = new ArrayList<>();
    private static Integer MIN_SCORE = 0;
    private static Integer MAX_SCORE = 100;
    private ArrayList<Photo> photosArray;
    private ArrayList<Advertisement> relevantAdds;
    private ArrayList<Advertisement> irrelevantAdds;


    private Manager() {
        this.relevantAdds = new ArrayList<>();
        this.irrelevantAdds = new ArrayList<>();
        specialWords.add("luminoso");
        specialWords.add("nuevo");
        specialWords.add("céntrico");
        specialWords.add("reformado");
        specialWords.add("ático");
    }

    public static Manager getInstance() {
        return ourInstance;
    }

    public void setPhotosArray(ArrayList<Photo> photosArray) {
        this.photosArray = photosArray;
    }

    public void setPhotosArray(Photo photo) {
        if (this.photosArray == null) {
            this.photosArray = new ArrayList<>();
        }
        if (!this.photosArray.contains(photo)) {
            this.photosArray.add(photo);
        }

    }

    public ArrayList<Advertisement> getRelevantAdds() {
        return relevantAdds;
    }

    private void sortArray(ArrayList<Advertisement> advertisementArrayList) {
        advertisementArrayList.sort((o1, o2) -> {
            if (o1.getScore() < o2.getScore()) {
                return 1;
            } else if (o1.getScore() > o2.getScore()) {
                return -1;
            } else return 0;
        });
    }

    public ArrayList<Advertisement> getIrrelevantAdds() {
        return irrelevantAdds;
    }

    public Double getAvgScore() {
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
        sortArray(relevantAdds);
        sortArray(irrelevantAdds);

    }

    public void calculateAddScore(Advertisement advertisement) {
        Integer score = 0;
        score += advertisement.calculatePhotosScore(photosArray);
        score += advertisement.calculateDescriptionScore(specialWords);
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

    public String getRelevantAddsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Advertisement advertisement : getRelevantAdds()) {
            stringBuilder.append(advertisement.toString())
                    .append("\n-------\n");
        }
        return stringBuilder.toString();
    }

    public String getIrrelevantAddsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Advertisement advertisement : getIrrelevantAdds()) {
            stringBuilder.append(advertisement.toString())
                    .append("\n-------\n");
        }
        return stringBuilder.toString();
    }
}
