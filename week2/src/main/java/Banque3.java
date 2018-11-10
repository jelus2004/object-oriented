class Client3 {
    private String nom;
    private String ville;
    private Compte3 cptePrive;
    private Compte3 cpteEpargne;
    private double soldePrive;
    private double soldeEpargne;
    private boolean masculin;

    public Client3(String nom, String ville, double soldePrive, double tauxPrive, double soldeEpargne, double tauxEpargne, boolean masculin) {
        this.nom = nom;
        this.ville = ville;
        this.soldePrive = soldePrive;
        this.soldeEpargne = soldeEpargne;
        this.masculin = masculin;
        cptePrive = new Compte3(tauxPrive, soldePrive);
        cpteEpargne = new Compte3(tauxEpargne, soldeEpargne);

    }

    public void afficherClient() {
        afficher(nom, ville, soldePrive, soldeEpargne);
    }

    public void afficher(String nom, String ville, double soldePrive, double soldeEpargne) {
        if (masculin) {
            System.out.print("  Client ");
        } else {
            System.out.print("  Cliente ");
        }
        System.out.println(nom + " de " + ville);
        System.out.println("        Compte prive:     " + soldePrive + " francs");
        System.out.println("        Compte d'epargne: " + soldeEpargne + " francs");
    }

    public void bouclerCompte() {
        cptePrive.bouclerCompte();
        cpteEpargne.bouclerCompte();
        soldePrive = cptePrive.getSolde();
        soldeEpargne = cpteEpargne.getSolde();
    }
}

class Compte3 {
    private double taux;
    private double solde;

    public Compte3(double taux, double solde){
        this.taux = taux;
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void bouclerCompte() {
        double interets = taux * solde;
        solde = solde + interets;
    }
}

class Banque3 {

    public static void main(String[] args) {
        double tauxPrive = 0.01;
        double tauxEpargne = 0.02;

        Client3 client1 = new Client3("Pedro", "Genève", 1000.0, tauxPrive, 2000.0, tauxEpargne, true);
        Client3 client2 = new Client3("Alexandra", "Lausanne", 3000.0, tauxPrive, 4000.0, tauxEpargne, false);

        System.out.println("Donnees avant le bouclement des comptes:");

        client1.afficherClient();
        client2.afficherClient();

        System.out.println("Donnees apres le bouclement des comptes:");

        client1.bouclerCompte();
        client2.bouclerCompte();

        client1.afficherClient();
        client2.afficherClient();

    }
}
