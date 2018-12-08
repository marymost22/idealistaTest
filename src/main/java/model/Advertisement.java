package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Advertisement {

    private Integer id;
    private String description;
    private Integer score;
    private ArrayList<Photo> photos;
    private Date creationDate; //Esta información deberia obtenerse cuando se crea el anunció. Ahora obtendremos como fecha el momento en el que se crea el objeto.


    public Advertisement(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.score = 0;
        photos = new ArrayList<>();
        creationDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
}
