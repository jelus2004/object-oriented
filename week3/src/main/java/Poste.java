// PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
class Poste {

    public static void main(String args[]) {
        //Cr'eation d'une boite-aux-lettres
        // 30  est la capacit'e maximale de la
        // boite aux lettres
        // (pas necessaire si vous dêcidez d'utiliser
        // un ArrayList).
        Boite boite = new Boite(30);

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

        Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, ""); // invalide

        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);


        System.out.println("Le montant total d'affranchissement est de " +
                boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courriersInvalides()
                + " courriers invalides");
    }
}

class Boite {
    private int capacite;

    public Boite(int capacite) {
        this.capacite = capacite;
    }

    public void ajouterCourrier(Courrier courrier) {

    }

    public double affranchir() {
        return 0;
    }

    public double affranchir(Lettre lettre) {
        return 0;
    }

    public double affranchir(Colis colis) {
        return 0;
    }

    public double affranchir(Publicite pub) {
        return 0;
    }

    public void afficher() {
        System.out.printf("");
    }

    public int courriersInvalides() {
        return 0;
    }
}

class Courrier {
    private int poids;
    private boolean modeExpedition;
    private String adresse;

    public Courrier(int poids, boolean modeExpedition, String adresse) {
        this.poids = poids;
        this.modeExpedition = modeExpedition;
        this.adresse = adresse;
    }
}

class Lettre extends Courrier {
    private String format;

    public Lettre(int poids, boolean modeExpedition, String adresse, String format) {
        super(poids, modeExpedition, adresse);
        this.format = format;
    }

}

class Colis extends Courrier {
    private int volume;

    public Colis(int poids, boolean modeExpedition, String adresse, int volume) {
        super(poids, modeExpedition, adresse);
        this.volume = volume;
    }
}

class Publicite extends Courrier {

    public Publicite(int poids, boolean modeExpedition, String adresse) {
        super(poids, modeExpedition, adresse);
    }
}