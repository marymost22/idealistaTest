package model;

import java.util.ArrayList;
import java.util.Objects;

public class Chalet extends Advertisement {

    private Integer houseSize;
    private Integer gardenSize;

    public Chalet(Integer id, String description) {
        super(id, description);
    }

    public Integer getHouseSize() {
        if (houseSize != null) {
            return houseSize;
        } else {
            return 0;
        }
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public Integer getGardenSize() {
        if (gardenSize != null) {
            return gardenSize;
        } else {
            return 0;
        }
    }

    public void setGardenSize(Integer gardenSize) {
        this.gardenSize = gardenSize;
    }

    @Override
    public Integer calculateCompleteAddScore() {
        if (!isComplete() && !Objects.equals(getDescription(), "") &&
                getHouseSize() != null && getHouseSize() > 0 &&
                getGardenSize() != null && getGardenSize() > 0 &&
                getPhotos() != null && getPhotos().size() != 0) {
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

    @Override
    public String toString() {
        return "Tipo: Chalet \n" +
                "Puntuación:" + getScore() + " \n" +
                "ID:" + getId() + " \n" +
                "Fecha de creación: " + getCreationDate() + " \n" +
                "Descripción: " + getDescription() + " \n" +
                "Tamaño casa: " + getHouseSize() + " \n" +
                "Tamaño jardín: " + getGardenSize() + " \n" +
                "Fotos: " + getPhotos();
    }

}
