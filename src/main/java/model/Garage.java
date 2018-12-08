package model;

public class Garage extends Advertisement {


    public Garage(Integer id) {
        super(id, null);
        //Como no es necesario que tengan descripción, contamos con que ese requisito está cumplido.
        setScore(getScore() + 5);
    }
}
