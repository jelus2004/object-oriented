import com.jelus2004.test.InputOutputAsserts;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text.NEW_LINE;
import static org.fest.assertions.api.Assertions.assertThat;

public class BibliothequeTest {
    Auteur a1 = new Auteur("Victor Hugo", false);
    Auteur a2 = new Auteur("Alexandre Dumas", true);
    Auteur a3 = new Auteur("Raymond Queneau", true);

    Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
    Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
    Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
    Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
    Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

    Bibliotheque biblio;


    @Before
    public void setup() {
        biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);
    }

    @Test
    public void stocker() {
    }

    @Test
    public void devraitTrouverTousLesExemplaires() {
        ArrayList<Exemplaire> exemplaires = biblio.listerExemplaires();
        assertThat(exemplaires).hasSize(8);
    }

    @Test
    public void devraitTrouverTousLesExemplairesAvecPasDeLangue() {
        ArrayList<Exemplaire> exemplaires = biblio.listerExemplaires("");
        assertThat(exemplaires).hasSize(8);
    }

    @Test
    public void devraitTrouverLesExemplairesEnFrancais() {
        ArrayList<Exemplaire> exemplaires = biblio.listerExemplaires("francais");
        assertThat(exemplaires).hasSize(7);
    }

    @Test
    public void devraitTrouverLesExemplairesEnAnglais() {
        ArrayList<Exemplaire> exemplaires = biblio.listerExemplaires("anglais");
        assertThat(exemplaires).hasSize(1);
    }

    @Test
    public void devraitTrouverLeNombreDExemplairesPourO1() {
        assertThat(biblio.compterExemplaires(o1)).isEqualTo(2);
    }

    @Test
    public void devraitTrouverLeNombreDExemplairesPourO2() {
        assertThat(biblio.compterExemplaires(o2)).isEqualTo(1);
    }

    @Test
    public void devraitAfficherLesAuteursPrimes() {
        biblio.stocker(o4);
        InputOutputAsserts.assertOutput(() -> biblio.afficherAuteur())
                .hasOutput("Alexandre Dumas" + NEW_LINE + "Raymond Queneau" + NEW_LINE);
    }
}