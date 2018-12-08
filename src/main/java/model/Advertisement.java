package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Advertisement {

    private Integer id;
    private String description;
    private Integer score;
    private ArrayList<Integer> pictures;
    private Date creationDate; //Esta información deberia obtenerse cuando se crea el anunció. Ahora obtendremos como fecha el momento en el que se crea el objeto.
    private Boolean complete;

    public Advertisement(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.score = 0;
        this.pictures = new ArrayList<>();
        this.creationDate = new Date();
        this.complete = false;
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

    public void addScore(Integer score) {
        this.score += score;
    }

    public void addPhoto(Photo photo) {
        this.pictures.add(photo.getId());
    }

    public ArrayList<Integer> getPhotos() {
        return pictures;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public abstract int calculateCompleteAddScore();

    public Integer calculatePhotosScore(ArrayList<Photo> photoArrayList) {
        Integer score = 0;
        if (getPhotos().size() == 0) {
            score -= 10;
        }
        for (Integer index : getPhotos()) {
            if (Objects.equals(photoArrayList.get(index).getQuality(), "HD")) {
                score += 20;
            } else if (Objects.equals(photoArrayList.get(index).getQuality(), "SD")) {
                score += 10;
            }
        }
        return score;
    }

    public Integer calculateDescriptionScore(ArrayList<String> specialWords) {
        Integer score = 0;
        for (String word : specialWords) {
            if (description.contains(word)) {
                score += 5;
            }
        }
        return score;
    }

}
