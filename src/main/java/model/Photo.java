package model;

import java.net.URL;

public class Photo {

    private Integer id;
    private URL url;
    private String quality;

    public Photo(Integer id, URL url, String quality) {
        this.id = id;
        this.url = url;
        this.quality = quality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getQuality() {
        return quality;
    }


    @Override
    public String toString() {
        return "ID: " + getId() + " \t " + "Quality: " + getQuality();
    }
}
