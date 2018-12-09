package model;

import java.util.ArrayList;

public class Garage extends Advertisement {


    public Garage(Integer id) {
        super(id, null);
    }

    @Override
    public Integer calculateCompleteAddScore() {
        if (!isComplete() && getPhotos() != null && getPhotos().size() > 0) {
            setComplete(true);
            return 40;
        }
        return 0;
    }

    @Override
    public Integer calculateDescriptionScore(ArrayList<String> specialWords) {
        Integer score = super.calculateDescriptionScore(specialWords);
        return score;
    }

    @Override
    public String toString() {
        return "Tipo: Garage \n" +
                "Puntuación:" + getScore() + " \n" +
                "ID:" + getId() + " \n" +
                "Fecha de creación: " + getCreationDate() + " \n" +
                "Descripción: " + getDescription() + " \n" +
                "Fotos: " + getPhotos();
    }

}
