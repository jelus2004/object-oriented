import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class Sejour extends OptionVoyage {
    private int nbNuits;
    private double prixParNuit;
    private double prixSejour;

    public Sejour(String nom, double prixForfaitaire, int nbNuits, double prixParNuit) {
        super(nom, prixForfaitaire);
        this.nbNuits = nbNuits;
        this.prixParNuit = prixParNuit;
        this.prixSejour = nbNuits * prixParNuit + prixForfaitaire;
    }

    @Override
    public double prix() {
        return prixSejour;
    }

    @Override
    public String toString() {
        return String.format("%s ->  %s CHF", getNom(), prixSejour);
    }
}

class Transport extends OptionVoyage {
    public final double TARIF_LONG = 1500.0;
    public final double TARIF_BASE = 200.0;
    private double tarif;
    private boolean longTrajet;

    public Transport(String nom, double prixForfaitaire, boolean longTrajet) {
        super(nom, prixForfaitaire);
        this.longTrajet = longTrajet;
        if (longTrajet) {
            tarif = TARIF_LONG;
        } else {
            tarif = TARIF_BASE;
        }
    }

    public Transport(String nom, double prixForfaitaire) {
        super(nom, prixForfaitaire);
        longTrajet = false;
        tarif = TARIF_BASE;
    }

    @Override
    public double prix() {
        return super.prix() + tarif;
    }

    @Override
    public String toString() {
        return String.format("%s ->  %s CHF", getNom(), prix());
    }
}

class OptionVoyage {
    private String nom;
    private double prixForfaitaire;

    public OptionVoyage(String nom, double prixForfaitaire) {
        this.nom = nom;
        this.prixForfaitaire = prixForfaitaire;
    }

    public String getNom() {
        return nom;
    }

    public double prix() {
        return prixForfaitaire;
    }

    @Override
    public String toString() {
        return String.format("%s ->  %s CHF", nom, prixForfaitaire);
    }
}

class KitVoyage {
    private ArrayList<OptionVoyage> kitVoyage = new ArrayList<>();
    private String depart;
    private String destination;

    public KitVoyage(String depart, String destination) {
        this.depart = depart;
        this.destination = destination;
    }

    public void annuler() {
        kitVoyage.clear();
    }

    public int getNbOptions() {
        return kitVoyage.size();
    }

    public void ajouterOption(OptionVoyage option) {
        if (option != null) {
            kitVoyage.add(option);
        }
    }

    public double prix() {
        double prix = 0.0;

        for (OptionVoyage optionVoyage : kitVoyage) {
            prix += optionVoyage.prix();
        }

        return prix;
    }

    @Override
    public String toString() {
        String toReturn = String.format("Voyage de %S à %s, avec pour options :\n", depart, destination);

        for (OptionVoyage optionVoyage : kitVoyage) {
            toReturn += String.format("- %s\n", optionVoyage.toString());
        }
        toReturn += String.format("Prix total : %s CHF ", prix());

        return toReturn;
    }
}

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}
