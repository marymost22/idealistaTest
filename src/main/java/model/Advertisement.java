package model;

import java.util.ArrayList;

public abstract class Advertisement {

    private Integer id;
    private String description;
    private Integer score;
    private ArrayList<Photo> photos;

    public Advertisement(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.score = 0;
        photos = new ArrayList<>();
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
