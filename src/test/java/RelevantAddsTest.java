import model.Advertisement;
import model.Flat;
import model.Photo;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RelevantAddsTest {
    private ArrayList<Advertisement> testAdds;

    public RelevantAddsTest() throws MalformedURLException {
    }

    @Before
    private void setUp() throws MalformedURLException {
        ArrayList<Advertisement> arrayList = new ArrayList<>();

        Photo photoTest1 = new Photo(1, new URL("http://www.idealista.com/pictures/1"), "HD");
        Photo photoTest2 = new Photo(2, new URL("http://www.idealista.com/pictures/1"), "SD");


        Flat flatTestIrrelevant1 = new Flat(1, null);
        arrayList.add(flatTestIrrelevant1);
        Flat flatTestIrrelevant2 = new Flat(2, null);
        flatTestIrrelevant2.addPhoto(photoTest1);
        arrayList.add(flatTestIrrelevant2);

        Flat flatTestRelevant3 = new Flat(4, "Esta descripción de anuncio de piso es corta. Por ello tiene por al menos veinte palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático.");
        flatTestRelevant3.addPhoto(photoTest2);
        arrayList.add(flatTestRelevant3);

        Flat flatTestRelevant1 = new Flat(2, "Esta descripción de anuncio de piso es corta. Por ello tiene por al menos veinte palabras. " +
                "Entre ellas: Luminoso, Nuevo, Céntrico, Reformado, Ático.");
        flatTestRelevant1.addPhoto(photoTest1);
        flatTestRelevant1.addPhoto(photoTest2);
        arrayList.add(flatTestRelevant1);

        Flat flatTestRelevant4 = new Flat(5, "Esta descripción de anuncio de piso es corta. Por ello tiene por al menos veinte palabras. " +
                "Entre ellas: Luminoso, Nuevo.");
        flatTestRelevant4.addPhoto(photoTest2);
        arrayList.add(flatTestRelevant4);

        Flat flatTestRelevant2 = new Flat(3, "Esta descripción de anuncio de piso es corta. Tiene la palabra: Luminoso.");
        flatTestRelevant2.addPhoto(photoTest1);
        arrayList.add(flatTestRelevant2);

        this.testAdds = arrayList;
    }

    @Test
    public void getOnlyRelevantTests() {
        Manager manager = Manager.getInstance();
        ArrayList<Advertisement> relevants = manager.getRelevantAdds(this.testAdds);
        ArrayList<Advertisement> irrelevants = new ArrayList<>();
        for (Advertisement add : relevants) {
            if (add.getScore() < 40) {
                irrelevants.add(add);
            }
        }
        assertEquals(0, irrelevants.size());
    }

    @Test
    public void getSortedRelevantTests() {
        Manager manager = Manager.getInstance();
        ArrayList<Advertisement> relevants = manager.getRelevantAdds(this.testAdds);
        boolean sortFlag = true;
        for (int i = 0; i < relevants.size() - 1; i++) {
            Advertisement add1 = relevants.get(i);
            Advertisement add2 = relevants.get(i + 1);
            if (add1.getScore() < add2.getScore()) {
                sortFlag = false;
            }
        }
        assertTrue("Si todos los anuncios relevantes están ordenados, la flag será verdadera", sortFlag);
    }

    @Test
    public void getOnlyIrrelevantTests() {
        Manager manager = Manager.getInstance();
        ArrayList<Advertisement> irrelevants = manager.getIrrelevantAdds(this.testAdds);
        ArrayList<Advertisement> relevants = new ArrayList<>();
        for (Advertisement add : irrelevants) {
            if (add.getScore() >= 40) {
                relevants.add(add);
            }
        }
        assertEquals(0, relevants.size());
    }

    public void getQualityAvg() {
        Manager manager = Manager.getInstance();
        assertEquals("Con los anuncios que se incluyen la media deberia ser ", manager.getAvgScore(this.testAdds), 33);
    }
}
