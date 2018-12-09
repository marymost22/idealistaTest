package model;

import java.util.ArrayList;

public class Flat extends Advertisement {
    private Integer houseSize;

    public Flat(Integer id, String description) {
        super(id, description);
    }

    @Override
    public Integer calculateCompleteAddScore() {
        if (!isComplete() && getDescription() != null &&
                getHouseSize() != null && getHouseSize() > 0 &&
                getPhotos() != null && getPhotos().size() > 0) {
            setComplete(true);
            return 40;
        }
        return 0;
    }

    @Override
    public Integer calculateDescriptionScore(ArrayList<String> specialWords) {
        Integer score = super.calculateDescriptionScore(specialWords);
        if (getDescription() != null) {
            score += 5;
            int desLength = getDescription().split("\\s+|\n").length;
            if (desLength >= 20 && desLength < 50) {
                score += 10;
            } else if (desLength >= 50) {
                score += 30;
            }
        }
        return score;
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    @Override
    public String toString() {
        return "Tipo: Flat \t ID:" + getId() + " \t Puntuación:" + getScore() + " \t Fotos: " + getPhotos() + " \t Tamaño casa: " + getHouseSize();
    }
}
