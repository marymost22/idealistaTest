package model;

public class Flat extends Advertisement {
    private Integer houseSize;

    public Flat(Integer id, String description) {
        super(id, description);
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    @Override
    public String toString() {
        return "Tipo: Flat \t ID:" + getId() + " \t Puntuación:" + getScore() + " \t Fotos: " + getPhotos() + " \t Tamaño casa: " + getHouseSize();
    }
}
