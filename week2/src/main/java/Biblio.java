import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
    private String nom;
    private boolean prix;

    public Auteur(String nom, boolean prix) {
        this.prix = prix;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public boolean getPrix() {
        return prix;
    }
}

class Oeuvre {
    // Completer la classe Oeuvre ici
    private String titre;
    private Auteur a;
    private String langue;

    public Oeuvre(String titre, Auteur a) {
        this.titre = titre;
        this.a = a;
        langue = "francais";
    }
    public Oeuvre(String titre, Auteur a, String langue) {
        this.titre = titre;
        this.a = a;
        this.langue = langue;
    }
    public String getTitre() {
        return titre;
    }
    public Auteur getA() {
        return a;
    }
    public String getLangue() {
        return langue;
    }
    public void afficher() {
        System.out.println(titre + ", " + a.getNom() + ", en " + langue);
    }
}

// completer les autres classes ici

class Exemplaire {
    public Exemplaire() {
        System.out.println("Nouvel exemplaire -> ");
    }
    public void afficher() {

    }
}

class Bibliotheque {

}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

/*
        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
*/
    }
}
