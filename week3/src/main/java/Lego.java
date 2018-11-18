import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Construction {
    final private ArrayList<Piece> composants;

    public Construction(int nbPieces) {
        composants = new ArrayList<>(nbPieces);
    }

    public void ajouterComposant(Piece piece, int quantite) {
        composants.add(piece);
    }
}

class Composant{
    private int quantite;
    private Piece piece;

    public Composant(int quantite, Piece piece) {
        this.quantite = quantite;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getQuantite() {
        return quantite;
    }
}

class Piece {
    private String nom;

    public Piece(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return nom;
    }
}

class Simple extends Piece {
    private String orientation;

    public Simple(String nom, String orientation) {
        super(nom);
        if (orientation.isEmpty()) {
            this.orientation = "aucune";
        } else {
            this.orientation = orientation;
        }
    }

    public Simple(String nom) {
        super(nom);
        orientation = "aucune";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("[%s]", orientation);
    }
}

class Composee extends Piece {
    final private ArrayList<Piece> pieces;

    public Composee(String nom, int nbMaxPieces) {
        super(nom);
        pieces = new ArrayList<>(nbMaxPieces);
    }

    public void construire(Simple simple) {
        pieces.add(simple);
    }

    @Override
    public String toString() {
        String toreturn;
        toreturn = getNom() + " (";
        for (int i = 0; i < pieces.size(); i++) {
            if (i < pieces.size() - 1) {
                toreturn = pieces.get(i).getNom() + ", ";
            } else {
                toreturn = pieces.get(i).getNom() + ") ";
            }
        }
        return toreturn;
    }
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // dÃ©clare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}