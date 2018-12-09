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
            manager.calculateAddScore(advertisements);

            System.out.println("~~~~~~~~~~~Lista del usuario de idealista~~~~~~~~~~~");
            System.out.println(manager.getRelevantAddsString());
            System.out.println("~~~~~~~~~~Lista del responsable de calidad~~~~~~~~~~");
            System.out.println(manager.getIrrelevantAddsString());
            System.out.println("~~~~~~~~~~Puntuación de todos los anuncios~~~~~~~~~~");
            System.out.println(manager.getRelevantAddsString());
            System.out.println(manager.getIrrelevantAddsString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
