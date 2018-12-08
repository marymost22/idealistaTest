import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import model.*;

import java.io.Reader;
import java.util.ArrayList;

public class JSONParser {

    public ArrayList<Advertisement> parseJsonAdds(Reader jsonLine) {
        ArrayList<Advertisement> advertisements = new ArrayList<>();

        JsonArray arr = new JsonParser().parse(jsonLine).getAsJsonArray();
        Gson g = new Gson();
        for (int i = 0; i < arr.size(); i++) {
            String typology = arr.get(i).getAsJsonObject().get("typology").getAsString();
            switch (typology) {
                case "CHALET":
                    Chalet addChalet = g.fromJson(arr.get(i), Chalet.class);
                    advertisements.add(addChalet);
                    break;
                case "FLAT":
                    Flat addFlat = g.fromJson(arr.get(i), Flat.class);
                    advertisements.add(addFlat);
                    break;
                case "GARAGE":
                    Garage addGarage = g.fromJson(arr.get(i), Garage.class);
                    advertisements.add(addGarage);
                    break;
            }
        }
        return advertisements;
    }


    public ArrayList<Photo> parseJsonPhotos(Reader jsonLine) {

        ArrayList<Photo> photos = new ArrayList<>();
        JsonArray arr = new JsonParser().parse(jsonLine).getAsJsonArray();
        Gson g = new Gson();
        for (int i = 0; i < arr.size(); i++) {
            Photo photo = g.fromJson(arr.get(i), Photo.class);
            photos.add(photo);
        }
        return photos;
    }
}
