package model;

import java.util.ArrayList;

public class Garage extends Advertisement {


    public Garage(Integer id) {
        super(id, null);
    }

    @Override
    public String toString() {
        return "Tipo: Garage \t ID:" + getId() + " \t Fotos: " + getPhotos() + " \t Puntuación:" + getScore();
    }

    @Override
    public int calculateCompleteAddScore() {
        if (!isComplete() && getDescription() != null) {
            setComplete(true);
            return 40;
        }
        return 0;
    }

    @Override
    public Integer calculateDescriptionScore(ArrayList<String> specialWords) {
        Integer score = super.calculateDescriptionScore(specialWords);
        //Como no es necesario que tenga descripción, contamos con esos 5 puntos.
        return score + 5;
    }

}
