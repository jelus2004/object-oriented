import static org.fest.assertions.api.Assertions.assertThat;

public class TimbreTest {

    @org.junit.Test
    public void nouveauTimbreZeroParams() {
        Timbre timbre = new Timbre();
        assertThat(timbre.getAnnee()).isEqualTo(Timbre.ANNEE_COURANTE);
        assertThat(timbre.getPays()).isEqualTo(Timbre.PAYS_DEFAUT);
        assertThat(timbre.getCode()).isEqualTo(Timbre.CODE_DEFAUT);
        assertThat(timbre.getValeurFaciale()).isEqualTo(Timbre.VALEUR_TIMBRE_DEFAUT
        );
    }
}