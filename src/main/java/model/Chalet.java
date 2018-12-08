package model;

public class Chalet extends Advertisement {

    private Integer houseSize;
    private Integer gardenSize;

    public Chalet(Integer id, String description) {
        super(id, description);
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public Integer getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(Integer gardenSize) {
        this.gardenSize = gardenSize;
    }

    @Override
    public String toString() {
        return "Tipo: Chalet \t ID:" + getId() + " \t Puntuación:" + getScore() + " \t Fotos: " + getPhotos() + " \t Tamaño casa: " + getHouseSize() + " \t Tamaño jardín: " + getGardenSize();
    }
}
