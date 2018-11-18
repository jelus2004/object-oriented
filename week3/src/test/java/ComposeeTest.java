import org.junit.Test;

import static org.junit.Assert.*;

public class ComposeeTest {

    @Test
    public void construireSimple() {
        Composee composee = new Composee("porte", 3);
        composee.construire(new Simple("seuil"));
        composee.construire(new Simple("battant"));
    }

    @Test
    public void construireComposee() {

    }
}