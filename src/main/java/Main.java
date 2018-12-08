import model.Advertisement;
import model.Photo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();

        try {
            Manager manager = Manager.getInstance();
            ArrayList<Advertisement> advertisements = jsonParser.parseJsonAdds(new FileReader("C:/Users/Mary Luz/Documents/idealista/idealistaTest/adds.json"));
            ArrayList<Photo> photos = jsonParser.parseJsonPhotos(new FileReader("C:/Users/Mary Luz/Documents/idealista/idealistaTest/photos.json"));
            manager.setPhotosArray(photos);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
