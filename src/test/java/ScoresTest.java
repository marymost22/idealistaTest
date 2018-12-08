import model.Chalet;
import model.Flat;
import model.Garage;
import model.Photo;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ScoresTest {


    @Test
    public void checkNoPhotoAddScore() {
        Flat flatTest = new Flat(1, null);
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio sin foto debe tener 0 puntos", 0, manager.getAddScore(flatTest));
    }

    @Test
    public void checkHDPhotoInAddScore() throws MalformedURLException {
        Flat flatTest = new Flat(1, null);
        Photo photoTest = new Photo(1, new URL("url.prueba.test"), "HD");
        flatTest.addPhoto(photoTest);

        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con foto HD debe tener 20 puntos", 20, manager.getAddScore(flatTest));
    }

    @Test
    public void checkSDPhotoInAddScore() throws MalformedURLException {
        Flat flatTest = new Flat(1, null);
        Photo photoTest = new Photo(1, new URL("url.prueba.test"), "SD");
        flatTest.addPhoto(photoTest);

        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con foto SD debe tener 10 puntos", 10, manager.getAddScore(flatTest));
    }


    @Test
    public void checkFlatAddMinDescriptionScore() {
        Flat flatTest = new Flat(1, "Esta descripción es mínima. Por ello tiene menos de veinte palabras");

        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con foto descripcion mínima debe tener 5 puntos", 5, manager.getAddScore(flatTest));
    }

    @Test
    public void checkFlatAddShortDescriptionScore() {
        Flat flatTest = new Flat(1, "Esta descripción de anuncio de piso es corta. Por ello tiene por al menos veinte palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con descripción corta debe tener 15 puntos", 15, manager.getAddScore(flatTest));
    }


    @Test
    public void checkFlatAddLongDescriptionScore() {
        Flat flatTest = new Flat(1, "Esta descripción de anuncio de piso es larga. Por ello tiene por al más de cincuenta palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. ");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con descripción larga debe tener 35 puntos", 35, manager.getAddScore(flatTest));
    }

    @Test
    public void checkChaletDescriptionScore() {
        Chalet chaletTest = new Chalet(1, "Esta descripción de anuncio de chalet es larga. Por ello tiene por al más de cincuenta palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. ");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con descripción larga debe tener 25 puntos", 25, manager.getAddScore(chaletTest));

    }

    @Test
    public void checkNoSpecialWordsInAddScore() {
        Flat flatTest = new Flat(1, "Esta descripción de anuncio de piso es muy corta. Ninguna palabra es especial.");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio sin palabras especiales debe tener 5 puntos", 5, manager.getAddScore(flatTest));
    }

    @Test
    public void checkOneSpecialWordsInAddScore() {
        Flat flatTest = new Flat(1, "Esta descripción de anuncio de piso es muy corta. Solo con una palabra especial: Nuevo");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con una palabra especial debe tener 10 puntos", 10, manager.getAddScore(flatTest));
    }

    @Test
    public void checkAllSpecialWordsInAddScore() {
        Flat flatTest = new Flat(1, "Esta descripción de anuncio de piso es corta. Por ello tiene por al menos veinte palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático.");
        Manager manager = Manager.getInstance();
        assertEquals("Un anuncio con todas las palabras especiales debe tener 40 puntos", 40, manager.getAddScore(flatTest));

    }

    @Test
    public void checkCompleteFlatScore() throws MalformedURLException {
        Flat flatTest = new Flat(1, "Esta descripción es mínima. Por ello tiene menos de veinte palabras");
        Photo photoTest = new Photo(1, new URL("url.prueba.test"), "SD");
        flatTest.addPhoto(photoTest);
        flatTest.setHouseSize(300);

        Manager manager = Manager.getInstance();
        assertTrue("Si un anuncio de piso tiene foto, descripción y tamaño, está completo", manager.isAddComplete(flatTest));
    }

    @Test
    public void checkCompleteChaletScore() throws MalformedURLException {
        Chalet chaletTest = new Chalet(1, "Esta descripción es mínima. Por ello tiene menos de veinte palabras");
        Photo photoTest = new Photo(1, new URL("url.prueba.test"), "SD");
        chaletTest.addPhoto(photoTest);
        chaletTest.setHouseSize(300);

        Manager manager = Manager.getInstance();
        assertTrue("Si un anuncio de chalet tiene foto, descripción y tamaño de casa y jardín, está completo", manager.isAddComplete(chaletTest));
    }


    @Test
    public void checkCompleteGarageScore() throws MalformedURLException {
        Garage garageTest = new Garage(1);
        Photo photoTest = new Photo(1, new URL("url.prueba.test"), "SD");
        garageTest.addPhoto(photoTest);

        Manager manager = Manager.getInstance();
        assertTrue("Si un anuncio de garage tiene foto, está completo", manager.isAddComplete(garageTest));

    }


}
