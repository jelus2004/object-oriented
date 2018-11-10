import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Article {
    private String article;
    private double prix;
    private boolean action;

    public Article(String article, double prix, boolean action) {
        this.article = article;
        this.prix = prix;
        this.action = action;
    }
    public double getPrix() {
        return prix;
    }
    public String getArticle() {
        return article;
    }
    public boolean estEnAction() {
        return action;
    }
}

class Achat {
    private Article article;
    private int quantite;
    public Achat(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }
    public double getPrix() {
        double rabais = 1.0;
        if (article.estEnAction()) {
            rabais = 0.5;
        }
        return quantite * article.getPrix() * rabais;
    }
    public void affiche() {
        String nom = article.getArticle();
        double prixUnite = article.getPrix();
        double prixTotal = getPrix();
        String rabais = "";
        if (article.estEnAction()) {
            rabais = " (1/2 prix)";
        }
        System.out.println(nom + " : " + prixUnite + " x " + quantite + " = " + prixTotal + " Frs" + rabais);
    }
}

class Caddie {
    private ArrayList<Achat> listeAchats;
    public Caddie() {
        this.listeAchats = new ArrayList<Achat>();
    }
    public void remplir(Article article, int quantite) {
        Achat achat = new Achat(article, quantite);
        listeAchats.add(achat);
    }
    public Achat getAchat(int index) {
        return listeAchats.get(index);
    }
    public int getNbAchats() {
        return listeAchats.size();
    }
}

class Caisse {
    private int numero;
    private double total;
    public Caisse(int numero, double total) {
        this.numero = numero;
        this.total = total;
    }
    public void totalCaisse() {
        System.out.printf("La caisse numero %c a encaisse %.2f Frs aujourd'hui%n" , numero, total);
    }
    public void scanner(Caddie caddie) {
        Date dateCourante = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
        System.out.println(formatDate.format(dateCourante));
        System.out.println("Caisse numéro " + numero);
        System.out.println();
        int nbAchat = caddie.getNbAchats();
        double montantTotal = 0;
        for (int i = 0; i < nbAchat; i++) {
            Achat achat = caddie.getAchat(i);
            double prix = achat.getPrix();
            achat.affiche();
            montantTotal += prix;
            total += prix;
        }
        System.out.println();
        System.out.println("Montant a payer : " + montantTotal + " Frs");

    }
}

public class Supermarche {

    public static void main(String[] args) {
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        // Les caddies du supermarché
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Les caisses du supermarché
        // le premier argument est le numero de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à une quantité

        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        // Les clients passent à la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);

        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}
