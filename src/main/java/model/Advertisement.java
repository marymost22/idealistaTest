package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Advertisement {

    private Integer id;
    private String description;
    private Integer score;
    private ArrayList<Integer> pictures;
    private Date creationDate; //Esta información deberia obtenerse cuando se crea el anunció. Ahora obtendremos como fecha el momento en el que se crea el objeto.


    public Advertisement(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.score = 0;
        pictures = new ArrayList<>();
        creationDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void addPhoto(Photo photo) {
        this.pictures.add(photo.getId());
    }

    public ArrayList<Integer> getPhotos() {
        return pictures;
    }
}
