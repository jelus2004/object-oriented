import java.util.ArrayList;

class Magic {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);

        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creature(6, "Golem", 4, 6));
        maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
                "La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));

        System.out.println("Là, j'ai en stock :");
        maMain.afficher();
        maMain.joue();
    }
}

class Jeu {
    private final ArrayList<Carte> cartes;
    private int nbCartesMax;

    public Jeu(int nbCartes) {
        cartes = new ArrayList<>(nbCartes);
        nbCartesMax = nbCartes;
        System.out.println("On change de main");
    }

    public void piocher(Carte carte) {
        if (cartes.size() + 1 > nbCartesMax) {
            System.out.println("Trop de cartes ! Impossible d'en rajouter plus !");
        } else {
            cartes.add(carte);
        }
    }

    public void afficher() {
        for (Carte carte : cartes) {
            carte.afficher();
        }
    }

    public void joue() {
        System.out.println("Les cartes jouées sont :");
        for (Carte carte : cartes) {
            carte.afficher();
            cartes.clear();
        }
    }
}

abstract class Carte {
    private int cout;

    public Carte(int cout) {
        this.cout = cout;
    }

    public int getCout() {
        return cout;
    }

    public abstract void afficher();
}

class Terrain extends Carte {
    private String couleur;

    public Terrain(char couleur) {
        super(0);
        if (couleur == 'B') {
            this.couleur = "blanc";
            System.out.println("Un nouveau terrain !");
        } else if (couleur == 'b') {
            this.couleur = "bleu";
            System.out.println("Un nouveau terrain !");
        } else if (couleur == 'n') {
            this.couleur = "noir";
            System.out.println("Un nouveau terrain !");
        } else if (couleur == 'r') {
            this.couleur = "rouge";
            System.out.println("Un nouveau terrain !");
        } else if (couleur == 'v') {
            this.couleur = "vert";
            System.out.println("Un nouveau terrain !");
        } else {
            System.out.println("Couleur invalide !");
        }
    }

    public void afficher() {
        System.out.println("Un terrain " + couleur);
    }
}

class Creature extends Carte {
    private String nom;
    private int ptsDegats;
    private int ptsVie;

    public Creature(int cout, String nom, int ptsDegats, int ptsVie) {
        super(cout);
        this.nom = nom;
        this.ptsDegats = ptsDegats;
        this.ptsVie = ptsVie;
        System.out.println("Une nouvelle créature !");
    }

    public void afficher() {
        System.out.printf("Une créature %s %s(pts de dégats) / %s (pts de vie)\n", nom, ptsDegats, ptsVie);
    }
}

class Sortilege extends Carte {
    private String nom;
    private String explication;

    public Sortilege(int cout, String nom, String explication) {
        super(cout);
        this.nom = nom;
        this.explication = explication;
        System.out.println("Un sortilège de plus !");
    }

    public void afficher() {
        System.out.printf("Un sortilège %s qui octroie : %s\n", nom, explication);
    }
}