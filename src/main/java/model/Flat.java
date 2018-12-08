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
}
