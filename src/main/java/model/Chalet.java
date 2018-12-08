package model;

import java.util.ArrayList;

public class Chalet extends Advertisement {

    private Integer houseSize;
    private Integer gardenSize;

    public Chalet(Integer id, String description) {
        super(id, description);
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public Integer getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(Integer gardenSize) {
        this.gardenSize = gardenSize;
    }

    @Override
    public String toString() {
        return "Tipo: Chalet \t ID:" + getId() + " \t Puntuación:" + getScore() + " \t Fotos: " + getPhotos() + " \t Tamaño casa: " + getHouseSize() + " \t Tamaño jardín: " + getGardenSize();
    }

    @Override
    public int calculateCompleteAddScore() {
        if (!isComplete() && getDescription() != null && getHouseSize() > 0 && getGardenSize() > 0 && getPhotos().size() != 0) {
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
            if (desLength > 50) {
                score += 20;
            }
        }
        return score;
    }


}
