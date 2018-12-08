package model;

public class Garage extends Advertisement {


    public Garage(Integer id) {
        super(id, null);
        //Como no es necesario que tengan descripción, contamos con que ese requisito está cumplido.
        setScore(getScore() + 5);
    }

    @Override
    public String toString() {
        return "Tipo: Garage \t ID:" + getId() + " \t Fotos: " + getPhotos() + " \t Puntuación:" + getScore();
    }
}
